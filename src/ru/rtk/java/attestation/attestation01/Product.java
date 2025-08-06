package ru.rtk.java.attestation.attestation01;

import java.util.HashMap;

public class Product {

 HashMap<String, Integer> products = new HashMap<>();  // товары и их цена

    /* есть ли такой товар возвращает true*/
    public boolean isProduct(String name) {
        return this.products.containsKey(name);
    }
    /* возвращает цену товара */
    public int getProductCost(String name) {
        return this.products.get(name);
    }
    /* добавляет данные товаров имя и цену */
    public void setProduct(String name, int cost) {
        this.products.put(name, cost);
    }
    /* показать все товары с ценами */
    public void printAllProducts(){
        System.out.println(this.products);
    }
}
