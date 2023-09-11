package ru.otus.balandinas.first.project;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        // (1)
        //Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента
        // целочисленный двумерный массив, метод должен посчитать и
        // вернуть сумму всех элементов массива, которые больше 0;
        System.out.println("----------(1)-----------");
        int[][] arr1 = {{1, -2}, {-7, 2}, {8, 0}};
        sumOfPositiveElements(arr1);
        // (2)
        //Реализовать метод, который принимает
        // в качестве аргумента int size и печатает в консоль
        // квадрат из символов * со сторонами соответствующей длины;
        System.out.println("----------(2)-----------");
        drawSquare(5);
        // (3)
        //Реализовать метод, принимающий в качестве
        // аргумента двумерный целочисленный массив,
        // и зануляющий его диагональные элементы
        // (можете выбрать любую из диагоналей, или занулить обе);
        System.out.println("----------(3)-----------");
        int[][] arr2 = {
                {-7, 2, -5, -1},
                {8, 3, -8, 4},
                {5, 3, 9, 3},
                {1, 4, 7, 2}
        };
        diagArrToZero(arr2);
        // (4)
        //Реализовать метод findMax(int[][] array)
        // который должен найти и вернуть максимальный элемент массива;
        System.out.println("----------(4)-----------");
        System.out.println("Максимальный элемент " + maxElemOfArr(arr2));
        // (5)
        //РРеализуйте метод, который считает сумму элементов
        // второй строки двумерного массива, если второй строки не существует,
        // то в качестве результата необходимо вернуть -1
        System.out.println("----------(5)-----------");
        int[][] arr3 = {
                {-7, 2, -5, -1},
                {},
                {5, 3, 9, 3},
                {1, 4, 7, 2}
        };
        System.out.println("Сумма второй строки = " + sumLine2(arr3));
    }

    public static void sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        System.out.println("Массив: " + Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Сумма элементов > 0 равна " + sum);

    }

    public static void drawSquare(int d) {
        System.out.println("Размерность квадрата : " + d);
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void diagArrToZero(int[][] arr) {
        int sum = 0;
        System.out.println("Массив до:");
        // before
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println("Массив после:");
        //to zero
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((j == i)) {
                    arr[i][j] = 0;
                    arr[i][arr.length - j - 1] = 0;
                    arr[arr.length - i - 1][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int maxElemOfArr(int[][] arr) {
        int maxElem = 0;
        System.out.println("Массив:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxElem) {
                    maxElem = arr[i][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return maxElem;

    }

    public static int sumLine2(int[][] arr) {
        int sum = 0;
        boolean fl = false;
        System.out.println("Массив:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 1) {
                    sum += arr[i][j];
                    fl = true;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        if (fl) {
            return sum;
        } else {
            return -1;
        }

    }
}
