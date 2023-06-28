package weekday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDateTest {

    @Test
    void isWeekDay() {
        assertEquals(false, MyDate.isWeekDay("2023/05/14"));
        assertEquals(true, MyDate.isWeekDay("2023/05/15"));
        assertEquals(true, MyDate.isWeekDay("2023/05/16"));
        assertEquals(true, MyDate.isWeekDay("2023/05/17"));
        assertEquals(true, MyDate.isWeekDay("2023/05/18"));
        assertEquals(true, MyDate.isWeekDay("2023/05/19"));
        assertEquals(false, MyDate.isWeekDay("2023/05/20"));
        assertEquals(false, MyDate.isWeekDay("2023/05/21"));
        assertEquals(true, MyDate.isWeekDay("2023/05/22"));
        assertEquals(true, MyDate.isWeekDay("2023/05/23"));
        assertEquals(false, MyDate.isWeekDay("2023/05/27"));
        assertEquals(false, MyDate.isWeekDay("2023/05/28"));
    }

    @Test
    void isSaturdayOrSunday() {
        assertEquals(false, MyDate.isWeekDay("2023/05/14"));
        assertEquals(true, MyDate.isWeekDay("2023/05/15"));
        assertEquals(true, MyDate.isWeekDay("2023/05/16"));
        assertEquals(true, MyDate.isWeekDay("2023/05/17"));
        assertEquals(true, MyDate.isWeekDay("2023/05/18"));
        assertEquals(true, MyDate.isWeekDay("2023/05/19"));
        assertEquals(false, MyDate.isWeekDay("2023/05/20"));
        assertEquals(false, MyDate.isWeekDay("2023/05/21"));
        assertEquals(true, MyDate.isWeekDay("2023/05/22"));
        assertEquals(true, MyDate.isWeekDay("2023/05/23"));
        assertEquals(false, MyDate.isWeekDay("2023/05/27"));
        assertEquals(false, MyDate.isWeekDay("2023/05/28"));
    }

//    @Test
//    void getNationalHoliday() {
//        String[] expected = {
//                "2023/01/01",
//                "2023/01/02",
//                "2023/01/09",
//                "2023/02/11",
//                "2023/02/23",
//                "2023/03/21",
//                "2023/04/29",
//                "2023/05/03",
//                "2023/05/04",
//                "2023/05/05",
//                "2023/07/17",
//                "2023/08/11",
//                "2023/09/18",
//                "2023/09/23",
//                "2023/10/09",
//                "2023/11/03",
//                "2023/11/23"
//        };
//
//        assertEquals(expected, MyDate.getNationalHoliday(2023));
//    }

}