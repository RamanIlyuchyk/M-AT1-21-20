package day1;

/**
 * Используя while вывести все числа от 0 до 25 в одну строку через пробел.
 */

public class day1_task2 {
    public static void main(String[] args) {
        System.out.print("Все числа от 0 до 25 в одну строку через пробел:");
        int i = 0;
        while (i < 25) {
            System.out.print(" " + i++);
        }
    }
}