package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.Arrays;
public class MainApplication {
    public static void main(String[] args){
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("--------add---------");
        phoneBook.add("fa","im","ot","9999999");
        phoneBook.add("fa","im","ot","9999998");
        phoneBook.add("fa","im","ot2","9989999");
        phoneBook.add("fa","im","ot2","9999998");
        System.out.println("--------find---------");
        phoneBook.find("fa","im","ot");
        System.out.println("--------find---------");
        phoneBook.find("fa","im","ot1");
        System.out.println("--------containsPhoneNumber---------");
        if (phoneBook.containsPhoneNumber("9999999")){
            System.out.println("Найден");
        } else {
            System.out.println("Не найден");
        }
        System.out.println("--------containsPhoneNumber---------");
        if (phoneBook.containsPhoneNumber("9989999")){
            System.out.println("Найден");
        } else {
            System.out.println("Не найден");
        }
    }

}
