package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> numbers = new ArrayList<>(phonebook.get(name));
            numbers.add(phoneNumber);
            phonebook.put(name, numbers);
//        } else if (!phonebook.containsKey(name)) {
        } else {
            List<String> num = new ArrayList<>();
            num.add(phoneNumber);
            phonebook.put(name, num);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String num : phoneNumbers) {
            add(name, num);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
//        return null;
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
//        return null;
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
//        return null;
        for (String key : phonebook.keySet()) {
            List<String> ghostRider = phonebook.get(key);
            if (ghostRider.contains(phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
//        return null;
        List<String> thomas = new ArrayList<>(phonebook.keySet());
//        Collections.sort(thomas);
//        Collections.reverse(thomas);
        return thomas;
    }

    public Map<String, List<String>> getMap() {
//        return null;
        return phonebook;
    }
}
