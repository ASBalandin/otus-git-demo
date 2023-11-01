package ru.otus.balandinas.first.project;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args){
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("--------add---------");
        phoneBook.add("fa","im","ot","9999999");
        phoneBook.add("fa","im","ot","9999998");
        phoneBook.add("fa","im","ot2","9989999");
        phoneBook.add("fa","im","ot2","9999998");
        System.out.println("--------find---------");
        List<String> listNumbers = phoneBook.find("fa","im","ot");
        for (String number : listNumbers) {
            System.out.println("Номер : " + number );
        }
        System.out.println("--------find---------");
        listNumbers = phoneBook.find("fa","im","ot2");
        for (String number : listNumbers) {
            System.out.println("Номер : " + number );
        }
        listNumbers = phoneBook.find("fa","im","ot1");
        for (String number : listNumbers) {
            System.out.println("Номер : " + number );
        }
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
