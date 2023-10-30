package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.Arrays;
public class MainApplication {
    public static void main(String[] args){
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("--------add---------");
        ArrayList<String> li = new ArrayList<>(Arrays.asList(new String("9999999"), new String("9999998")));
        phoneBook.add("fa","im","ot",li);
        ArrayList<String> li1 = new ArrayList<>(Arrays.asList(new String("9989999"), new String("9999998")));
        phoneBook.add("fa","im","ot2",li1);
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
