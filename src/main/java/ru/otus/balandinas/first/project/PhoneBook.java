package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private Person person;
    private ArrayList<String> l;
    private HashMap<Person, List<String>> hashMap;

    public PhoneBook() {
        hashMap = new HashMap<>();
    }

    public void add(String lName, String fName, String sName, ArrayList<String> tel) {
        person = new Person(lName, fName, sName);
        l = new ArrayList<>();
        for (String number : tel) {
            l.add(number);
        }
        hashMap.put(person, l);
    }

    public void find(String lName, String fName, String sName) {
        List<String> listNumbers;
        person = new Person(lName, fName, sName);
        if (hashMap.containsKey(person)) {
            listNumbers = hashMap.get(person);
            for (String number : listNumbers) {
                System.out.println(person.toString() + " : " + number);
            }
        } else {
            System.out.println("Запись не найдена");
        }
    }

    public boolean containsPhoneNumber(String tel) {
        for (List li : hashMap.values()) {
            if (li.contains(tel)) {
                return true;
            }
        }
        return false;
    }
}
