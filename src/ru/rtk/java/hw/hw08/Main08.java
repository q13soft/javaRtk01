package ru.rtk.java.hw.hw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        System.out.println("ДЗ8, задание 2");
        obj.checkAnagramsInfo("Бейсбол","бобслей");
        obj.checkAnagramsInfo("Героин  ","регион");
        obj.checkAnagramsInfo("Клоака  ","околка");

        System.out.println("ДЗ8, задание 3");
        PowerfulSet obj3 = new PowerfulSet(); 

        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(0, 1, 2, 4));
        System.out.println("1 множество: " +  s1);
        System.out.println("2 множество: " +  s2);      
        System.out.println("Пересечение: " +  obj3.intersection(s1,s2));
        System.out.println("Объединение: " +  obj3.union(s1,s2));
        System.out.println("Элементы 1 набора без элементов 2 набора: " +  obj3.relativeComplement(s1,s2));

}

}
