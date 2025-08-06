package ru.rtk.java.attestation.attestation01;

import java.util.Scanner;

public class App {

    /* статус продажи 0 - ввод покупателей, 1 ввод товарав, 2 продажа */
    private int status = 0;  
    private String codePage = "cp866";  // set code page, default 866        
    private Person buyer = new Person();    // класс покупатели 
    private Product products = new Product();    // класс продукты

    public static void main(String[] args) {
        App obj = new App();
        obj.goSales();
    }

    /* продажи */
    public void goSales() {
        boolean lWhile = true;
        this.infoStatus();
        Scanner sc = new Scanner(System.in,this.codePage);
        while (lWhile) {
            String line = sc.nextLine().trim();  
            if  ("END".equals(line)){
                lWhile = false;
                this.buyer.itogoAllBag();
            } else {
                if (this.status < 2){
                    String[] aStrPos = line.split(";");
                    for (String str : aStrPos) {
                        String[] aPos = str.split("="); 
                        if (aPos.length == 2){
                            this.addData(aPos[0], aPos[1]);
                        } 
                    }   
                    this.status++;      
                    this.infoStatus();                    
                } else {  // продажи
                    String[] aStrBuy = line.split("-");
                    if (aStrBuy.length == 2){
                        this.purchase(aStrBuy[0].trim(), aStrBuy[1].trim());
                    } 
                }
            }
        }    
        sc.close();
        //  this.buyer.printAllPersons();
        //  this.products.printAllProducts();
    }    
    /*  обработака продаж */
    public void purchase(String namePerson, String nameProduct ) {
        this.buyer.buyPersons(namePerson, nameProduct, products.getProductCost(nameProduct));  
    }

    /* инициализация пользователей и товаров */
    public void addData(String name2, String money ) {
        Boolean error = false;  // нет ошибок 
        String errorMsg = "";  // информация об ошибке
        String name = name2.trim();
        String nameName = (this.status == 0) ? "Покупатель: " : "Товар: ";
        String nameName2 = (this.status == 0) ? "Имя " : "Название ";
        String nameMoney = (this.status == 0) ? " с суммой " : " с ценой: ";
        String nameCost = (this.status == 0) ? "сумма " : "цена ";

        if (name.length() == 0 ) {
            error = true;
            errorMsg += nameName2 +"не может быть пустым, ";
        }
        else if (name.length() < 3 ) {
            error = true;
            errorMsg += nameName2 + "не может быть короче 3 символов, ";
        }
        int cost = 0;
        try {  
            cost = Integer.parseInt(money.trim());
            if (cost< 0 ) {
                error = true;
                errorMsg += nameCost+ "не может быть отрицательной";
            }
        } catch (NumberFormatException e) {  
            error = true;
            errorMsg += "Введена неправильная "+ nameCost;
        }  
        if (error) {
            System.out.println("Error: "+ name + cost +" "+ errorMsg);  
        } else {
            if (this.status == 0) {
                this.buyer.setPersons(name, cost);   // добавим покупателя
            } else if (this.status == 1) {
                this.products.setProduct(name, cost);   // добавим товар
            }
            System.out.println(nameName + name + nameMoney + cost); 
        }
    }

    /* информация о статусе продаж */
    public void infoStatus() {
        if (this.status == 0) {
            System.out.print("Введите полупателей и какой суммой он располагает в формате: Покупатель = 100. Знаком ; разделить покупателей: ");
        } else if (this.status == 1) {
            System.out.print("Введите товары и их цену в формате: Товар = цена. Знаком ; разделить товары: ");
        } else if (this.status == 2) {
            System.out.print("Продажи, введите в формате: Покупатель - товар: ");
        }    

    }
}
