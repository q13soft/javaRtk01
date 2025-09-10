package ru.rtk.java.hw.hw08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hw08 {

     /**
      * Реализовать  метод, который на вход принимает ArrayList<T>, 
      * а возвращает набор уникальных элементов этого массива. 
      * Решить, используя коллекции 
      * @param <T>
      * @param list
      * @return
      */
  public <T> List<T> getUniqueElem(ArrayList<T> list) {
        // удаляем дубликаты
        Set<T> uniqueSet = new HashSet<>(list);
        // Создаем новый ArrayList из HashSet
        List<T> uniqueList = new ArrayList<>(uniqueSet);
        return uniqueList;
    }
  

}
