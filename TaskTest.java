package weekday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @Test
    void isExpired() {

//        //期限切れ
//        Task task1 = new Task("タスク1", "2023/05/30");
//        assertTrue(task1.isExpired());
//
//        //期限内
//        Task task2 = new Task("タスク2", "2023/06/30");
//        assertFalse(task2.isExpired());

    }

    @Test
    void onDeadLine() {
//        //当日でない
//        Task task1 = new Task("タスク1", "2023/05/30");
//        assertFalse(task1.onDeadLine());
//
//        //当日
//        Task task2 = new Task("タスク2", "2023/06/07");
//        assertTrue(task2.onDeadLine());
    }

    @Test
    void countRemainingDays() {
//        Task task1 = new Task("タスク1", "2023/06/05");
//        assertEquals(-2, task1.countRemainingDays());
//
//        Task task2 = new Task("タスク2", "2023/06/07");
//        assertEquals(0, task2.countRemainingDays());
//
//        Task task3 = new Task("タスク3", "2023/06/14");
//        assertEquals(7, task3.countRemainingDays());
//
//        Task task4 = new Task("タスク4", "2024/06/06");
//        assertEquals(365, task4.countRemainingDays());

    }

    @Test
    void countToDeadLineDate() throws Exception {
//        Task task1 = new Task("タスク1", "2023/06/13");
//        assertEquals(5, task1.countToDeadLineDate());
//
//        Task task2 = new Task("タスク2", "2023/06/14");
//        assertEquals(6, task2.countToDeadLineDate());
//
//        Task task3 = new Task("タスク3", "2023/06/19");
//        assertEquals(9, task3.countToDeadLineDate());
    }


    @Test
    void sum() {
        int[] arr1 = {10,20,30};
        assertEquals(60, Task.sum(arr1));
        int[] arr2 = {0,10,20,35};
        assertEquals(65, Task.sum(arr2));
        int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(55, Task.sum(arr3));
    }

    @Test
    void getSumOfActualTime() {
        int[] actualTime1 = {30,60,90};
        Task task1 = new Task("タスク1", "2023/06/12",actualTime1);
        assertEquals(180, task1.getSumOfActualTime());

        int[] actualTime2 = {1,2,3,4,5,6,7,8,9,10};
        Task task2 = new Task("タスク2", "2023/06/12",actualTime2);
        assertEquals(55, task2.getSumOfActualTime());

        int[] actualTime3 = {45,45,15,15};
        Task task3 = new Task("タスク3", "2023/06/12",actualTime3);
        assertEquals(120, task3.getSumOfActualTime());
    }

//    @Test
//    void getSumOfActualTimeForStream() {
//        int[] actualTime1 = {30,60,90};
//        Task task1 = new Task("タスク1", "2023/06/12",actualTime1);
//        assertEquals(180, task1.getSumOfActualTimeForStream());
//
//        int[] actualTime2 = {1,2,3,4,5,6,7,8,9,10};
//        Task task2 = new Task("タスク2", "2023/06/12",actualTime2);
//        assertEquals(55, task2.getSumOfActualTimeForStream());
//
//        int[] actualTime3 = {45,45,15,15};
//        Task task3 = new Task("タスク3", "2023/06/12",actualTime3);
//        assertEquals(120, task3.getSumOfActualTimeForStream());
//    }
}