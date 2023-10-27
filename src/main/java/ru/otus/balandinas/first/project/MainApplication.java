package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        /*
           Реализуйте метод, принимающий в качестве аргументов числа min и max,
            и возвращающий ArrayList с набором последовательных значений
            в указанном диапазоне (min и max включительно, шаг - 1);
        */
        System.out.println(listForMinToMax(34, 47));
        /*
        Реализуйте метод, принимающий в качестве аргумента список целых чисел,
        суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
        */
        System.out.println("Сумма = " + listSumForElemMore5(
                new ArrayList<>(
                        Arrays.asList(
                                new Integer[]{0, 4, -7, 8, 10}
                        ))));
        /*
        Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
        метод должен переписать каждую заполненную ячейку списка указанным числом;
        */
        ArrayList<Integer> li = new ArrayList<>(
                Arrays.asList(
                        new Integer[]{0, 4, -7, 8, 10}
                ));

        setNInEverylistItem(5, li);
        System.out.println(li);
        /*
       Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
       увеличивающий каждый элемент списка на указанное число;
        */
        ArrayList<Integer> li1 = new ArrayList<>(
                Arrays.asList(
                        new Integer[]{0, 4, -7, 8, 10}
                ));
        System.out.println("Before " + li1);
        incEverylistItemOnN(5, li1);
        System.out.println("After " + li1);
        /*
          Создайте класс Сотрудник с полями: имя, возраст;
            Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;

            Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
              и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;

            Реализуйте метод, принимающий в качестве аргумента список сотрудников
              и минимальный средний возраст,
              и проверяющий что средний возраст сотрудников превышает указанный аргумент;

            Реализуйте метод, принимающий в качестве аргумента список сотрудников,
              и возвращающий ссылку на самого молодого сотрудника.
        */
        ArrayList<Employees> emp = new ArrayList<>(Arrays.asList(
                new Employees[]{
                        new Employees("emp1", 50)
                        , new Employees("emp2", 43)
                        , new Employees("emp3", 23)
                        , new Employees("emp4", 34)
                }
        ));
        System.out.println("---------------- listNamesByListEmp ----------------");
        System.out.println(listNamesByListEmp(emp));
        System.out.println("---------------- listEmpOfAgeMoreOrEqualN ----------------");
        System.out.println(listEmpOfAgeMoreOrEqualN(34, emp));

        System.out.println("---------------- listEmpOfMinAVGAgeMoreOrEqualN ----------------");
        listEmpOfMinAVGAgeMoreOrEqualN(30, emp);
        System.out.println("---------------- listEmpOfMinAge ----------------");
        System.out.println(listEmpOfMinAge(emp));
    }

    public static ArrayList<Integer> listForMinToMax(int min, int max) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            al.add(i);
        }
        return al;
    }

    public static int listSumForElemMore5(ArrayList<Integer> li) {
        int sum = 0;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i) > 5) {
                sum += li.get(i);
            }
        }
        return sum;
    }

    public static void setNInEverylistItem(int n, ArrayList<Integer> li) {

        for (int i = 0; i < li.size(); i++) {
            li.set(i, n);
        }
    }

    public static void incEverylistItemOnN(int n, ArrayList<Integer> li) {

        for (int i = 0; i < li.size(); i++) {
            li.set(i, li.get(i) + n);
        }
    }

    public static ArrayList<String> listNamesByListEmp(ArrayList<Employees> li) {
        //Employees emp;
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            // emp = li.get(i);
            names.add(li.get(i).getName());//emp.getName());
        }
        return names;
    }

    public static ArrayList<Employees> listEmpOfAgeMoreOrEqualN(int n, ArrayList<Employees> li) {
        Employees emp;
        ArrayList<Employees> out = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            emp = li.get(i);
            if (emp.getAge() >= n) {
                out.add(emp);
            }
        }
        return out;
    }

    public static void listEmpOfMinAVGAgeMoreOrEqualN(int n, ArrayList<Employees> li) {
        System.out.println("n : " + n);
        int ageAVG = 0;
        for (int i = 0; i < li.size(); i++) {
            ageAVG += li.get(i).getAge();
        }
        ageAVG = ageAVG / li.size();
        System.out.println("Средний возраст сотрудников : " + ageAVG);
            if (ageAVG > n) {
                System.out.println("Средний возраст сотрудников больше заданного");
            } else {
                System.out.println("Средний возраст сотрудников меньше заданного");
            }
    }

    public static Employees listEmpOfMinAge(ArrayList<Employees> li) {
        Employees emp, empMin = li.get(0);
        ArrayList<Employees> out = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            emp = li.get(i);
            if (empMin.getAge() > emp.getAge()) {
                empMin = emp;
            }
        }
        return empMin;
    }
}
