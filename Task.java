package weekday;

import getdate.AddDate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
    String name;
    String deadLineDate;
    int[] actualTime;

    public Task(String name , String deadLineDate, int[] actualTime){
        this.name = name;
        this.deadLineDate = deadLineDate;
        this.actualTime = actualTime;
    }

    //演習問題21
    public boolean isExpired(){
        try{
            Date date = AddDate.validateAndParseDate(this.deadLineDate);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);

            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String str = sdf.format(calendar2.getTime());
            Date nowDate = sdf.parse(str);

            int def = DateUtil.getDaysBetweenDates(date, nowDate);

            // System.out.println(def);

            if(def >= 0){
                return true;
            }else{
                return false;
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //演習問題22
    public boolean onDeadLine(){
        try {
            Date date = AddDate.validateAndParseDate(this.deadLineDate);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);

            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String str = sdf.format(calendar2.getTime());
            Date nowDate = sdf.parse(str);

            int def = DateUtil.getDaysBetweenDates(date, nowDate);

            if (def == 0){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    //演習問題23
    public int countRemainingDays(){
        try {
            Date date = AddDate.validateAndParseDate(this.deadLineDate);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);

            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String str = sdf.format(calendar2.getTime());
            Date nowDate = sdf.parse(str);

            int def = DateUtil.getDaysBetweenDates(nowDate, date);

            return def;

        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    //演習問題24

//    public int countToDeadLineDate() throws Exception {
//        //現在の日付
//        Calendar todayC = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        String str = sdf.format(todayC.getTime());
//        Date nowDate = sdf.parse(str);
//        String strNowDate = new SimpleDateFormat("yyyy/MM/dd").format(nowDate);
//
//        //対象の日付
//        Date date = AddDate.validateAndParseDate(this.deadLineDate);
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(date);
//        String strDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
//
//        int workindDays = DateUtil.countWorkingDays(strDate ,strNowDate);
//        System.out.println(workindDays);
//
//        return workindDays;
//    }

    //演習問題24
    public int countToDeadLineDate() throws ParseException, URISyntaxException, IOException, InterruptedException {
        Calendar todayC = Calendar.getInstance();
        if(todayC.getTime().after(AddDate.validateAndParseDate(this.deadLineDate))) {
            return -1 * DateUtil.countWorkingDays(this.deadLineDate, DateUtil.toYYYYMMDD(todayC));
        } else {
            return DateUtil.countWorkingDays(DateUtil.toYYYYMMDD(todayC), this.deadLineDate);
        }
    }

    //演習25
    public static int sum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //演習問題26
    public int getSumOfActualTime(){
        return sum(this.actualTime);
    }

    //演習問題27
//    public int getSumOfActualTimeForStream(){
//        int sum = this.actualTime.stream()
//                .mapToInt(intValue -> intValue).sum();
//        return sum;
//    }
}
