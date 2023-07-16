package ru.otus.balandinas.first.project;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // (1)
        System.out.println("----------(1)-----------");
        greetings();
        // (2)
        System.out.println("----------(2)-----------");
        checkSign();
        // (3)
        System.out.println("----------(3)-----------");
        selectColor();
        // (4)
        System.out.println("----------(4)-----------");
        compareNumbers();
        // (5)
        System.out.println("----------(5)-----------");
        System.out.println("Введите число initValue");
        int initValue = scanner.nextInt();
        System.out.println("Введите число delta");
        int delta = scanner.nextInt();
        char increment;
        System.out.println("Введите значение increment: f(false) или t(true)");
        do {
            increment = scanner.next().charAt(0);
            if (increment != 'f' && increment != 't') {
                System.out.println("Нужно ввести t или f");
            } else if (increment == 'f') {
                addOrSubtractAndPrint(initValue, delta, false);
            } else {
                addOrSubtractAndPrint(initValue, delta, true);
            }
        } while (increment != 'f' && increment != 't');
        System.out.println("----------(*)-----------");
        int choice;
        do {
            System.out.println("Введите число 1 до 5");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 5);
        if (choice == 1) {
            greetings();
        } else if (choice == 2) {
            checkSign();
        } else if (choice == 3) {
            selectColor();
        } else if (choice == 4) {
            compareNumbers();
        } else {
            int trueOrFalse = (int) (Math.random() * 0.5);
            //System.out.println("сейчас" + trueOrFalse);
            if (trueOrFalse == 1) {
                addOrSubtractAndPrint(
                        (int) (Math.random() * 100),
                        (int) (Math.random() * 100),
                        true);
            } else {
                addOrSubtractAndPrint(
                        (int) (Math.random() * 100),
                        (int) (Math.random() * 100),
                        false);
            }
        }

    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a");
        int a = scanner.nextInt();
        System.out.println("Введите число b");
        int b = scanner.nextInt();
        System.out.println("Введите число c");
        int c = scanner.nextInt();
        int total = a + b + c;
        if (total >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    public static void selectColor() {
        int data = (int) (Math.random() * 100);
        //System.out.println("Число" + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20 && data >= 10) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        //System.out.println("Число a=" + a = " b=" + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int total;
        if (increment) {
            total = initValue + delta;
        } else {
            total = initValue - delta;
        }
        System.out.println("Результат:" + total);
    }
}