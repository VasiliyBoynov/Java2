package Lesson3;

import java.util.HashMap;
import java.util.HashSet;


public class PhoneBook {
    private static HashMap<String, HashSet<String>> phoneBook; //В телеграм переписке договорились сделать одну телефонную книгу, вне зависимости от создоваемых обьектов (по принципу singltone)

    public void add(String surname, String phone){

        if (phoneBook==null){
            phoneBook = new HashMap<>();
        }

        if (!phoneBook.containsKey(surname)){
           HashSet<String> phones = new HashSet<>();
           phones.add(phone.trim());
           phoneBook.put(surname,phones);
        } else {
            phoneBook.get(surname).add(phone.trim());
        }
    }

    public void get(String surname) throws NullPointerException{
        if (phoneBook==null){
            throw new NullPointerException();
        }
        System.out.println(surname + " : " + phoneBook.get(surname));

    }

    public void info() throws NullPointerException {
        if (phoneBook==null){
            throw new NullPointerException();
        }
        for (String s : phoneBook.keySet()) {
            get(s);
            
        }
    }




}
