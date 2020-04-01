package day1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Используя Collection и Stream создать из массива коллекцию,
 * отфильтровать оставив только четные числа,
 * и вывести каждое число от 2 до 20 включительно и больше 10 в порядке по возрастанию.
 */

public class day1_task6 {
    public static void main(String[] args) {
        int size = sizeOfArray();
        int[] array = arrayOfRandomNumbers(size);
        System.out.print("Массив из случайных чисел (числа только из промежутка [0;25]):");
        Arrays.stream(array).boxed().collect(Collectors.toList()).forEach(x -> System.out.print(" " + x));
        System.out.print("\nКаждое четное число от 2 до 20 включительно и больше 10 в порядке по возрастанию:");
        Arrays.stream(array).boxed().filter(x -> x % 2 == 0 && x > 10 && x <= 20).sorted().collect(Collectors.toList()).forEach(x -> System.out.print(" " + x));
    }

    private static int sizeOfArray() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int size;
        do {
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не число, попробуйте ещё раз: ");
                in.next();
            }
            size = in.nextInt();
            if (size < 1) {
                System.out.print("Вы ввели количество меньше 1, попробуйте ещё раз: ");
            }
        }
        while (size < 1);
        return size;
    }

    private static int[] arrayOfRandomNumbers(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 26); //значение элемента в промежутке [0;25]
        }
        return array;
    }
}