package weekday;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import getdate.AddDate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    //演習8   日付を計算
    public static List<String> getLastMonthDates(String inputDate) throws ParseException {
        ArrayList<String> dates = new ArrayList<>();
        dates.add(inputDate);
        String[] dateParts = inputDate.split("/");
        int year = Integer.parseInt(dateParts[0]);
        //注意：例えば"2023/03/04"がinputDateであれば、2023/02/05までの日付のリストを返したいから、何日まであるのかを見る月は3-1=2で2月にする必要がある。
        int month = Integer.parseInt(dateParts[1]) - 1;
        int howManyDays = DateUtil.getHowManyDaysOf(year, month);
        for(int i = -1; i > -1 * howManyDays - 1; i --) {
            Date date = DateUtil.addDaysToDate(weekday.AddDate.validateAndParseDate(inputDate),i);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String formattedDate = sdf.format(date);
            dates.add(formattedDate);
        }
        return dates;
    }
    private static boolean isLeapYear(int year) {
        if(year % 4 == 0) return true;
        else return false;
    }

    private static int getHowManyDaysOf(int year, int month) {
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 || month == 0) {
            return 31;
        } else if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            if(isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    //演習10  2日間の日付を返す
    public static int getDaysBetweenDates(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        return (int) ( difference / (24 * 60 * 60 * 1000));
    }

    //演習12  与えられた日付が平日か
    public static boolean isWeekDay(String yyyymmdd) throws ParseException {
        final Calendar calendar = getCalendarFor(yyyymmdd);
        final int TUESDAY_CODE = 2;
        final int FRIDAY_CODE = 6;
        final int dayOfWeekCode = calendar.get(Calendar.DAY_OF_WEEK);
        if(TUESDAY_CODE <= dayOfWeekCode && dayOfWeekCode <= FRIDAY_CODE ) {
            return true;
        } else {
            return false;
        }
    }

    //演習13  与えられた日付が土日か
    public static boolean isSaturdayOrSunday(String yyyymmdd) throws Exception{
        return !isWeekDay(yyyymmdd);
    }

    //演習14  APIを利用して年を利用して祝日の配列を取得
    public static String[] getNationalHoliday(int yyyy) throws Exception {
        final String responseBody = getResponseBodyTo("https://holidays-jp.github.io/api/v1/" + yyyy + "/date.json");
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonNode jsonNode = objectMapper.readTree(responseBody);
        return getKeyStringArr(jsonNode);
    }

    private static String[] getKeyStringArr(JsonNode jsonNode) {
        final int size = jsonNode.size();
        final String[] arr = new String[size];
        final Iterator<String> iterator = jsonNode.fieldNames();
        for (int i = 0; iterator.hasNext(); i++) {
            arr[i] = iterator.next().replace("-", "/");
        }
        return arr;
    }

    public static String getResponseBodyTo(String url) throws Exception {
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    //演習15  与えられた日付が祝日か
    public static boolean isNationalHoliday(String yyyymmdd) throws Exception {
        final int year = getYearOf(yyyymmdd);
        final String[] nationalHolidays = getNationalHoliday(year);
        final ArrayList<String> arrDates = new ArrayList<>(Arrays.asList(nationalHolidays));
        return arrDates.contains(yyyymmdd);
    }

    private static int getYearOf(String yyyymmdd) {
        return Integer.parseInt(yyyymmdd.substring(0, 4));
    }
    //演習16  与えられた日付が休日か
    public static boolean isHoliday(String yyyymmdd) throws Exception {
        return isNationalHoliday(yyyymmdd) || isSaturdayOrSunday(yyyymmdd);
    }

    //演習問題17    ある期間内の平日の数をカウントする
    private static Calendar getCalendarFor(String yyyymmdd) throws ParseException {
        final Date date = AddDate.validateAndParseDate(yyyymmdd);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static int countWorkingDays(String from, String to) throws URISyntaxException, IOException, InterruptedException, ParseException {
        String[] daysStrings = getDaysStrBetween(from, to);
        int count = 0;
        for (int i = 0; i < daysStrings.length; i++) {
            if(!MyDate.isSaturdayOrSunday(daysStrings[i]))
                count++;
        }
        return count;
    }


    public static String[] getDaysStrBetween(String from, String to) throws ParseException{
        Calendar fromC = getCalendarFor(from);
        Calendar toC = getCalendarFor(to);
        int howManyDays = DateUtil.countDaysBetween(fromC.getTime(), toC.getTime()) + 1;
        String[] strings = new String[howManyDays];
        int n = 0;
        while (n != howManyDays) {
            Calendar tmp = (Calendar) fromC.clone();
            tmp.add(Calendar.DAY_OF_MONTH, n);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String formattedDate = sdf.format(tmp.getTime());
            strings[n] = formattedDate;
            n++;
        }
        return strings;
    }

    public static int countDaysBetween(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        return (int) (difference / (24 * 60 * 60 * 1000));
    }

    //演習問題18    指定した日付の次の平日を計算
    public static String getNextWeekDayOf(String yyyymmdd){

        try {

            Date date = AddDate.validateAndParseDate(yyyymmdd);
            Date addDate = addDaysToDate(date, 1);
            String strDate = new SimpleDateFormat("yyyy/MM/dd").format(addDate);
            int count = 1;

            if (!MyDate.isSaturdayOrSunday(strDate)){
                return strDate;

            }else{
                while (MyDate.isSaturdayOrSunday(strDate)){
                    addDate = addDaysToDate(date, count);
                    count++;
                    strDate = new SimpleDateFormat("yyyy/MM/dd").format(addDate);
                }

                return strDate;
            }


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static String toYYYYMMDD(Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String yyyymmdd = sdf.format(c.getTime());
        return yyyymmdd;
    }
}
