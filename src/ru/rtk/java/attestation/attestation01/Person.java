package ru.rtk.java.attestation.attestation01;

import java.util.HashMap;
import java.util.Map;

public class Person {

    HashMap<String, Integer> persons = new HashMap<>();  // покуматели и из суммы
    HashMap<String, String>  bagGoods  = new HashMap<>();  // покупки покупателя

    /* покупка */
    public void buyPersons(String namePerson, String nameFood, int priceFood) {
        String point; 
        String bag;
        int sumPerson = this.getPersonsSum(namePerson);
        if (sumPerson< priceFood) {
            System.out.println(namePerson + " не может позволить себе " + nameFood );
        } else {
            this.persons.put(namePerson, sumPerson - priceFood);     // спишим сумму из кошелька
            bag = this.getBagGoods(namePerson).trim();
            point = (bag.length() >0 )  ? ", " : "";
            if  ("Ничего не куплено".equals(bag)) {
                this.bagGoods.put(namePerson, nameFood);
            } else {
                this.bagGoods.put(namePerson, bag + point + nameFood);
            }
            System.out.println(namePerson + " купил(а) " + nameFood );
        }
    }

    /* показать что во всех сумках */
    public void itogoAllBag() {  
        
        for (Map.Entry<String, String> entry : bagGoods.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }    
    /* есть ли такой покупатель возвращает true*/
    public boolean isPersons(String name) {
        return this.persons.containsKey(name);
    }

    /* возвращает сумму у покупателя */
    public int getPersonsSum(String name) {
        return this.persons.get(name);
    }
    /* возвращает список покупок в пакете */
    public String getBagGoods(String namePerson) {
        return this.bagGoods.get(namePerson);
    }

    /* устанавливает данные покупателя */
    public void setPersons(String name, int sum) {
        this.persons.put(name, sum);     // данные покупателя 
        this.bagGoods.put(name, "Ничего не куплено"); // покупки покупателя
    }
    /* показать всех покупателей */
    public void printAllPersons(){
        System.out.println(this.persons);
        System.out.println(this.bagGoods);
    }

}
