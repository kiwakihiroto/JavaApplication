package weekday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilTest {

    @Test
    void countWorkingDays() throws Exception {
        assertEquals(4, DateUtil.countWorkingDays("2023/05/22","2023/05/25"));
        assertEquals(7, DateUtil.countWorkingDays("2023/05/22","2023/05/30"));
        assertEquals(8, DateUtil.countWorkingDays("2023/05/22","2023/05/31"));
        assertEquals(0, DateUtil.countWorkingDays("2023/05/27","2023/05/28"));
        assertEquals(1, DateUtil.countWorkingDays("2023/05/22","2023/05/22"));
        assertEquals(2, DateUtil.countWorkingDays("2023/05/22","2023/05/23"));
        assertEquals(20, DateUtil.countWorkingDays("2023/05/22","2023/06/16"));
    }

    @Test
    void getNextWeekDayOf() {
        assertEquals("2023/05/25", DateUtil.getNextWeekDayOf("2023/05/24"));
        assertEquals("2023/05/29", DateUtil.getNextWeekDayOf("2023/05/26"));
        assertEquals("2023/05/29", DateUtil.getNextWeekDayOf("2023/05/27"));
        assertEquals("2023/05/29", DateUtil.getNextWeekDayOf("2023/05/28"));
        assertEquals("2023/06/01", DateUtil.getNextWeekDayOf("2023/05/31"));
        assertEquals("2023/10/02", DateUtil.getNextWeekDayOf("2023/09/29"));
    }
}