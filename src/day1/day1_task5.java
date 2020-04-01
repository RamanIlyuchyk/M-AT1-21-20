package day1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Циклически сдвинуть все элементы вправо на 2 позиции (1-й элемент станет 3-м, 2-й станет 4-м и т.д.)
 */

public class day1_task5 {
    public static void main(String[] args) {
        int size = sizeOfArray();
        int[] array = arrayOfRandomNumbers(size);
        System.out.print("Массив из случайных чисел (числа только из промежутка [0;100]):");
        Arrays.stream(array).boxed().collect(Collectors.toList()).forEach(x -> System.out.print(" " + x));
        int[] arrayWithShift = new int[size];
        System.arraycopy(array, 0, arrayWithShift, 2, size - 2);
        System.arraycopy(array, size - 2, arrayWithShift, 0, 2);
        System.out.print("\nМассив, где все элементы циклически сдвинуты вправо на 2 позиции:");
        Arrays.stream(arrayWithShift).boxed().collect(Collectors.toList()).forEach(x -> System.out.print(" " + x));
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
            array[i] = (int) (Math.random() * 101); //значение элемента в промежутке [0;100]
        }
        return array;
    }
}