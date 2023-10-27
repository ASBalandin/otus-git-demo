package ru.otus.balandinas.first.project;

public class MainApplication {

    static String[][] arr = {
            {"1", "-2", "3", "4"}
            , {"-7", "2", "3", "4"}
            , {"8", "0", "3", "5"}
            , {"8", "0", "3", "4"}
    };
    static int result, i, j;
    static String s;

    public static void main(String[] args) {
        try {
            toIntAndSum(arr);
            System.out.println("Результат : " + result);
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении : " + e);
        }

    }

    public static int toIntAndSum(String[][] array) {
        int total = 0;

        try {
            if (array.length != 4) {
                throw new ArrayIndexOutOfBoundsException();
            }
            for (j = 0; j < array.length; j++) {
                if (array[j].length != 4) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    s = arr[i][j];
                    total += Integer.parseInt(arr[i][j]);
                }
            }
            result = total;
            return total;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new AppArraySizeException("Некорректная размерность массива, ожидаем 4х4, текущая "
                    + arr.length + "x" + arr[j].length);
        } catch (NumberFormatException ex1) {
            throw new AppArrayDataException("Ошибка преобразования элемента array[" + i + "][" + j + "] = " + s);
        }
    }

}
