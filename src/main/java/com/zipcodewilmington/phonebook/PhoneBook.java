package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        map.put(name, new ArrayList<>(Collections.singletonList(phoneNumber)));
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name){
        for(HashMap.Entry<String, List<String>> entry : map.entrySet()){
            if (entry.getValue().contains(name)){
                return true;
            }
        }
        return map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(HashMap.Entry<String, List<String>> entry : map.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
