package Lesson3;

import java.util.HashMap;

public class Lesson3 {
    public static void main(String[] args) {
    doTask1();
    doTask1_1();
    doTask2();
    }

    public static String[] createArrayString(){
        String[] strings = {"Дарья", "Варвара", "Эльза", "Анна", "Людмила", "Ибрагим", "Вазген", "Каземир", "Дарья", "Варвара", "Эльза", "Вазген", "Каземир", "Эльза", "СабЗиро", "Скорпион", "ЛюКан", "Штурмовик", "ДартВейдер", "Штурмовик"};
        return strings;
    }

    public static void doTask1(){
        HashMap<String,Integer> map = new HashMap<>();
        String[] strings = createArrayString();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        System.out.println(map);
    }

    public static void doTask1_1(){
        HashMap<String,Integer> map = new HashMap<>();
        String[] strings = createArrayString();
        for (String string : strings) {
            map.put(string,(map.getOrDefault(string,0)+1));
        }
        System.out.println(map);
    }

    public static void doTask2() throws NullPointerException{
        PhoneBook testBook = new PhoneBook();
        testBook.add("Бибиков","+79262101212");
        testBook.add("Бибиков","+79261234567");
        testBook.add("Бибиков","+79262101212");
        testBook.add("Бибиков"," +79261234567 ");
        //testBook.get("Бибиков");
        testBook.info();
        System.out.println("------------------");
        PhoneBook testBook1 = new PhoneBook();
        testBook1.add("Леди Гага","03");
        testBook1.add("Миллер","04");
        testBook.info();


    }

}
