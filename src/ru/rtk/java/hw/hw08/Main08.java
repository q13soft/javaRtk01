package ru.rtk.java.hw.hw08;

import java.util.ArrayList;
import java.util.List;

public class Main08 {

    public static void main(String[] args) {
        Hw08 obj = new Hw08();    
        System.out.println("ДЗ8, задание 1");
        ArrayList<String> strList = new ArrayList<>();
        strList.add("манго");
        strList.add("ананас");
        strList.add("кокос");
        strList.add("ананас");
        strList.add("дуриан");
        strList.add("дуриан");

        List<String> uniqueStr = obj.getUniqueElem(strList);
        System.out.println("Уникальные элементы (строки): " + uniqueStr);

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(13);
        intList.add(13);
        intList.add(18);
        intList.add(1);
        intList.add(18);
        intList.add(13);

        List<Integer> uniqueInt = obj.getUniqueElem(intList);
        System.out.println("Уникальные элементы (числа): " + uniqueInt);

    

}

}
