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
        if (!phoneBook.containsKey(person)) {
            l.add(tel);
            phoneBook.put(person, l);
        } else {
            phoneBook.get(person).add(tel);
        }
    }

    public List find(String lName, String fName, String sName) {
        List<String> listNumbers = new ArrayList<>();
        String person = lName + fName + sName;
        if (phoneBook.containsKey(person)) {
            listNumbers = phoneBook.get(person);
        }
        return listNumbers;
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
