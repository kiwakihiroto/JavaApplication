package weekday;

import getdate.AddDate;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class MyDate {
    public static boolean isWeekDay(String yyyymmdd){   //演習課題12
        //boolean isWeekday = false;

        try{
            Date date = AddDate.validateAndParseDate(yyyymmdd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            //曜日の取得（1：月 ～　7：日）
            int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);

            switch (dayOfWeek){
                case Calendar.SUNDAY:
                    return false;
                case Calendar.MONDAY:
                    return true;
                case Calendar.TUESDAY:
                    return true;
                case Calendar.WEDNESDAY:
                    return true;
                case Calendar.THURSDAY:
                    return true;
                case Calendar.FRIDAY:
                    return true;
                case Calendar.SATURDAY:
                    return false;
                default:
                    return false;
            }

        }catch (ParseException e){
            //例外処理
            return false;
        }
    }

    public static boolean isSaturdayOrSunday(String yyyymmdd){   //演習課題13
        try{
            Date date = AddDate.validateAndParseDate(yyyymmdd);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            //曜日の取得（1：月 ～　7：日）
            int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);

            switch (dayOfWeek){
                case Calendar.SUNDAY:
                    return true;
                case Calendar.MONDAY:
                    return false;
                case Calendar.TUESDAY:
                    return false;
                case Calendar.WEDNESDAY:
                    return false;
                case Calendar.THURSDAY:
                    return false;
                case Calendar.FRIDAY:
                    return false;
                case Calendar.SATURDAY:
                    return true;
                default:
                    return false;
            }

        }catch (ParseException e){
            //例外処理
            return false;
        }
    }

//    public static String[] getNationalHoliday(int yyyy){
//        String responseBody = getResponseBodyTo("https://holidays-jp.github.io/api/v1/" +yyyy+ "/date.json");
//        ObjectMapper objectMapper = new objectMapper();
//        JsonNode jsonNode = objectMapper.readTree(responseBody);
//
//    }
}
