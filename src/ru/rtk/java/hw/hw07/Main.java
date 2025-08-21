package ru.rtk.java.hw.hw07;

import java.util.Scanner;

public class Main {

    /* статус продажи 0 - ввод покупателей, 1 ввод товарав, 2 продажа */
    private int status = 0;  
    private String codePage = "cp866";  // set code page, default 866        
    private Person buyer = new Person();    // класс покупатели 
    private ProductCollection products= new ProductCollection();    // класс коллекции продуктов, возможна скидка
    
    public static void main(String[] args) {
        Main obj = new Main();
        obj.goSales();
    }

    /**
     * продажи
     */
    public void goSales() {
        boolean lWhile = true;
        System.out.print("Введите полупателей и какой суммой он располагает в формате: Покупатель = 100. Знаком ; разделить покупателей: ");
        Scanner sc = new Scanner(System.in,this.codePage);
        while (lWhile) {
            String line = sc.nextLine().trim();  
            // завершить продажи
            if  ("END".equals(line)){
                lWhile = false;
                this.buyer.itogoAllBag();
            } else {
                if (this.status == 0) {
                    // status == 0 ввод покупателей    
                    this.buyer.addStrBuyer(line);
                    this.status++;   
                    System.out.print("Введите товары и их цену в формате: Товар = цена. Знаком ; разделить товары: ");
                }
                else if (this.status == 1){
                    // this.status == 1 ввод товара
                    this.products.addStrProducts(line);
                    this.status++;      
                    System.out.print("Продажи, введите в формате: Покупатель - товар: ");
                } else if (this.status > 1)  {  
                    // this.status == 2 продажи
                    String[] aStrBuy = line.split("-");
                    if (aStrBuy.length == 2){
                        this.purchase(aStrBuy[0].trim(), aStrBuy[1].trim());
                    } 
                }
            }
        }   
        sc.close();
        //this.buyer.printAllPersons();
        //this.products.printAllProducts();
    }    
    /**
     * обработака продаж
     * @param namePerson  (String) имя покупателя
     * @param nameProduct (String) название продукта
     */
    public void purchase(String namePerson, String nameProduct ) {
        if  (this.buyer.isPersons(namePerson) && this.products.isProduct(nameProduct) ) { 
            this.buyer.buyPersons(namePerson, nameProduct, products.getCollectionCost(nameProduct));  
        } else {
            System.out.println("Error: Не найден товар или покупатель, " + namePerson + " товар " + nameProduct); 
        }
    }
}
