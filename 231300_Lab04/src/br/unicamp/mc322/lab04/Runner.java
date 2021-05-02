package br.unicamp.mc322.lab04;

import br.unicamp.mc322.lab04.pidao.*;

public class Runner {
    public static void main(String[] args) {
        try {
            Pidao pidaoApp = new Pidao("MARAMBAR", "123.456.789-10", 10, 2);

            User user1 = pidaoApp.registerUser("Marcos Paulo", "123.789.643-11", 1, 2);
            // User user2 = pidaoApp.registerUser("Pereira", "123.789.643-11", 8, 4);
            User user2 = pidaoApp.registerUser("Pereira", "123.789.643-12", 8, 4);
            User user3 = pidaoApp.registerUser("Andre Satorres", "123.456.789-0", 0, 9);

            Item cuscuz = new Item("CCZ00", "Cuscuz com ovo", 10.00);
            Item macaxeira = new Item("MXCOS", "Macaxeira com costela no bafo", 15.00);
            Item coxinhaFrango = new Item("CXFRA", "Coxinha de frango", 8.00);

            pidaoApp.addToMenu(cuscuz);
            pidaoApp.addToMenu(macaxeira);
            pidaoApp.addToMenu(coxinhaFrango);

            pidaoApp.applyDiscount("CCZ00", 10, DiscountType.PERCENTAGE);

            Order p1 = new Order(user1);
            p1.addItem(cuscuz);
            p1.addItem(macaxeira);
            pidaoApp.createOrder(p1);

            Order p2 = new Order(user2);
            p2.addItem(coxinhaFrango);
            p2.addItem(coxinhaFrango);
            pidaoApp.createOrder(p2);

            Order p3 = new Order(user2);
            p3.addItem(coxinhaFrango);
            p3.addItem(coxinhaFrango);
            pidaoApp.createOrder(p3);

            pidaoApp.addToMenu(new Item("AA200", "Bolo de Chocolate", 8.50));
            pidaoApp.removeFromMenu("AA200");

            Item bolo = new Item("AA200", "Bolo de Leite Ninho", 8.50);
            pidaoApp.addToMenu(bolo);
            pidaoApp.applyDiscount("AA200", 8, DiscountType.VALUE);
            pidaoApp.removeDiscount("AA200");

            Order o1 = new Order(user3);
            o1.addItem(bolo);
            pidaoApp.createOrder(o1);

            Order o2 = new Order(user3);
            o2.addItem(bolo);
            pidaoApp.createOrder(o2);

            Order o3 = new Order(user3);
            o3.addItem(bolo);
            pidaoApp.createOrder(o3);

            Order o4 = new Order(user3);
            o4.addItem(bolo);
            pidaoApp.createOrder(o4);

            Order o5 = new Order(user3);
            o5.addItem(bolo);
            pidaoApp.createOrder(o5);

            Order o6 = new Order(user3);
            o6.addItem(bolo);
            pidaoApp.createOrder(o6);

            Order o7 = new Order(user3);
            o7.addItem(bolo);
            pidaoApp.createOrder(o7);

            Order o8 = new Order(user3);
            o8.addItem(bolo);
            pidaoApp.createOrder(o8);

            Order o9 = new Order(user3);
            o9.addItem(bolo);
            pidaoApp.createOrder(o9);

            Order o10 = new Order(user3);
            o10.addItem(bolo);
            pidaoApp.createOrder(o10);

            Order o11 = new Order(user3);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            o11.addItem(bolo);
            pidaoApp.createOrder(o11);

            Item caro = new Item("CARO1", "Comida cara", 100.00);
            pidaoApp.addToMenu(caro);

            Order o12 = new Order(user3);
            o12.addItem(caro);
            o12.addItem(caro);
            pidaoApp.createOrder(o12);


            pidaoApp.updateStatus(p3);
            pidaoApp.updateStatus(p1);
            pidaoApp.updateStatus(p1);
            pidaoApp.cancelOrder(p2);
            pidaoApp.updateStatus(o1);

            // pidaoApp.updateStatus(p4);
            // pidaoApp.updateStatus(p4);
            // pidaoApp.updateStatus(p4);

            System.out.println(pidaoApp.getMenuInfo());
            System.out.println(pidaoApp.getAllOrdersInfo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
