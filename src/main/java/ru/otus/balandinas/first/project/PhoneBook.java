package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lName, String fName, String sName, String tel) {
        String person = lName + fName + sName;
        ArrayList<String> l = new ArrayList<>();
        List<String> listNumbers;
        if (phoneBook.containsKey(person)) {
            listNumbers = phoneBook.get(person);
            for (String number : listNumbers) {
                l.add(number);
            }
        }
        l.add(tel);
        phoneBook.put(person, l);
    }

    public void find(String lName, String fName, String sName) {
        List<String> listNumbers;
        String person = lName + fName + sName;
        if (phoneBook.containsKey(person)) {
            listNumbers = phoneBook.get(person);
            for (String number : listNumbers) {
                System.out.println("Номер : " + number );
            }
        } else {
            System.out.println("Запись не найдена");
        }
    }

    public boolean containsPhoneNumber(String tel) {
        for (List li : phoneBook.values()) {
            if (li.contains(tel)) {
                return true;
            }
        }
        return false;
    }
}
