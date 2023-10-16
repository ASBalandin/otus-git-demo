package ru.otus.balandinas.first.project;

public class User {
    // Поля
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;

    private int birthYear;
    // getters

    public int getBirthYear() {
        return birthYear;
    }

    // Конструктор
    public User(String lName, String fName, String sName, int bYear, String email) {
        this.lastName = lName;
        this.firstName = fName;
        this.middleName = sName;
        this.birthYear = bYear;
        this.email = email;

    }

    // Методы
    public void Info() {
        System.out.println(String.format("ФИО : %s %s %s",lastName, firstName, middleName));
        System.out.println(String.format("Год рождения : %d",birthYear));
        System.out.println(String.format("email : %s", email));
    }
}
