package ru.rtk.java.hw.hw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hw08 {

     /**
      * Реализовать  метод, который на вход принимает ArrayList<T>, 
      * а возвращает набор уникальных элементов этого массива. 
      * Решить, используя коллекции. 
      * @param <T>  - тип ранных данных коллекции
      * @param list - коллекция данных для обработки
      * @return other - первое массив для сравнения
      */
  public <T> List<T> getUniqueElem(ArrayList<T> list) {
        // удаляем дубликаты
        Set<T> uniqueSet = new HashSet<>(list);
        // Создаем новый ArrayList из HashSet
        List<T> uniqueList = new ArrayList<>(uniqueSet);
        return uniqueList;
    }

  /**
   * С консоли на вход подается две строки s и t. 
   * Необходимо вывести true, если одна строка является валидной 
   * анаграммой другой строки, и false – если это не так.
   * @param s String - первое слово для сравнения 
   * @param t String - второе слово для сравнения
   * @return boolean - true, если строка является  
   * анаграммой другой строки, и false – если это не так
   */
    public boolean checkAnagrams(String s, String t) {
        // разная длина строк
        if (s.trim().length() != t.trim().length()) {
            return false;
        }
        // в нижний регистр, в массивы символов и их сортировка
        char[] sArr = s.toLowerCase().trim().toCharArray();
        char[] tArr = t.toLowerCase().trim().toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        // Сравнение
        return Arrays.equals(sArr, tArr);
    }
    /**
     * метод проверяет, являются ли заданные слова анаграммами
     * @param s String - первое слово для сравнения 
     * @param t String - второе слово для сравнения
     */
    public void checkAnagramsInfo(String s, String t) {
        if (checkAnagrams(s, t)) {
            System.out.println("Это анаграмма: " + s +" и "+ t);
        } else {
            System.out.println("НЕТ это не анаграмма: " + s +" и "+ t);            
        }
    }

}
