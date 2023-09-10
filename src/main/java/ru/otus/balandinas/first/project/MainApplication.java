package ru.otus.balandinas.first.project;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        // (1)
        //Реализуйте метод, принимающий в качестве аргументов целое число и строку,
        // и печатающий в консоль строку указанное количество раз

        System.out.println("----------(1)-----------");
        int a = 7;
        String str = "строка";
        printNRepeatStr(a, str);
        System.out.println();

        // (2)
        //Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
        //значение которых больше 5, и печатающий полученную сумму в консоль
        System.out.println("----------(2)-----------");
        int[] arr1 = {1, 2, 7, 2, 8};
        printSumElMore5(arr1);
        System.out.println();

        // (3)
        // -Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // метод должен заполниться каждую ячейку массива указанным числом.
        System.out.println("----------(3)-----------");
        int[] arr2 = new int[8];
        int d = 27;
        fillArr(arr2, d);
        System.out.println("Массив: " + Arrays.toString(arr2));
        System.out.println();

        // (4)
        //-Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // увеличивающий каждый элемент которого на указанное число.
        System.out.println("----------(4)-----------");
        int[] arr3 = {1, 2, 7, 2, 8};
        int d1 = 7;
        PlusEveryElArr(arr3, d1);
        System.out.println("Массив after: " + Arrays.toString(arr3));
        System.out.println();

        // (5)
        //Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
        // и печатающий в консоль сумма элементов какой из половин массива больше.
        System.out.println("----------(5)-----------");
        int[] arr4 = {7, 5, 7, 8, 8, 5, 8};
        whatPartArrMoreSum(arr4);

    }

    public static void printNRepeatStr(int n, String str) {
        System.out.println("Число : " + n);
        System.out.println("Строка : " + str);
        for (int i = 0; i < n; i++) {
            System.out.print(str + " ");
        }
    }

    public static void printSumElMore5(int[] arr) {
        int sum = 0;
        System.out.println("Массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("Сумма чисел > 5 равна " + sum);

    }

    public static void fillArr(int[] arr, int d) {
        System.out.println("Заполняем : " + d);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = d;
        }

    }

    public static void PlusEveryElArr(int[] arr, int d) {
        System.out.println("Массив before: " + Arrays.toString(arr));
        System.out.println(" + : " + d);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += d;
        }

    }

    public static void whatPartArrMoreSum(int[] arr) {
        int p1 = arr.length / 2;
        int sum1 = 0;
        int sum2 = 0;
        boolean fl = false;
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("кол-во элементов " + arr.length);
        if (arr.length == (p1 * 2)) {
            fl = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i == p1) && (!fl)) {
                continue;
            }
            if (p1 > i) {
                sum1 += arr[i];
            } else {
                sum2 += arr[i];
            }

        }
        if (sum1 > sum2) {
            System.out.println("первая часть >, сумма: " + sum1);
        } else if (sum1 < sum2) {
            System.out.println("вторая часть >, сумма: " + sum2);
        } else {
            System.out.println("суммы частей равны");
        }

    }


}
