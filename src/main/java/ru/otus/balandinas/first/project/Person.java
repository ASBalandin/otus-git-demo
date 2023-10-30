package ru.otus.balandinas.first.project;

import java.util.Objects;

public class Person {
    private String LName;
    private String FName;
    private String SName;

    public Person(String LName, String FName, String SName) {
        this.LName = LName;
        this.FName = FName;
        this.SName = SName;
    }

    @Override
    public String toString() {
        return LName + ' ' +
                FName + ' ' +
                SName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(LName, person.LName) && Objects.equals(FName, person.FName) && Objects.equals(SName, person.SName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LName, FName, SName);
    }
}
