package ru.rtk.java.hw.hw08;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    /**
     * метод возвращает пересечение двух наборов
     * @param <T> - тип сравниваемых методов
     * @param set1 - 1 набор для сравнения
     * @param set2 - 2 набор для сравнения
     * @return возвращает пересечение двух наборов
     */
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<T>(set1); // копия set1
        result.retainAll(set2);
        return result;
     }
    /**
     * метод возвращает объединение двух наборов
     * @param <T> - тип сравниваемых методов
     * @param set1 - 1 набор для сравнения
     * @param set2 - 2 набор для сравнения
     * @return  возвращает объединение двух наборов
     */
     public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1); // копия set1
        result.addAll(set2); // дубликаты игнорируются
        return result;
     }
    /**
     * метод возвращает элементы первого набора без тех, 
     * которые находятся также и во втором наборе
     * @param <T> - тип сравниваемых методов
     * @param set1 - 1 набор для сравнения
     * @param set2 - 2 набор для сравнения
     * @return возвращает элементы первого набора без второго
     */
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);   // удаляем что есть во 2 наборе    
        return result;
    } 

} 
