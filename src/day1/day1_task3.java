package day1;

/**
 * Используя for вывести каждое четное число от 2 до 20 включительно и больше 10.
 */

public class day1_task3 {
    public static void main(String[] args) {
        System.out.print("Каждое четное число от 2 до 20 включительно и больше 10:");
        for (int i = 12; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(" " + i++);
            }
        }
    }
}