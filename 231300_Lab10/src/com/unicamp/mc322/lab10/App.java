package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.pidao.Pidao;
import com.unicamp.mc322.lab10.pidao.cost.discount.DiscountType;
import com.unicamp.mc322.lab10.pidao.position.Position;
import com.unicamp.mc322.lab10.pidao.rating.Stars;

import java.util.List;

public class App {

    private final Pidao pidao;

    public App() {
        pidao = new Pidao();
    }

    public void start() {
        String cpf1 = "123456789-00", cpf2 = "124456789-00", cpf3 = "11111111-11", cpf4 = "11111111-12", cpf5 = "11111111-13";
        String cnpj1 = "123", cnpj2 = "124";

        pidao.registerCustomer("Andre", cpf1, Position.of(0, 0));
        pidao.registerCustomer("Jonas", cpf2, Position.of(2, 2));

        pidao.registerDeliveryman("Cesar", cpf3);
        pidao.registerDeliveryman("Carlos", cpf4);
        pidao.registerDeliveryman("Maria", cpf5);

        pidao.registerRestaurant("Steak House", cnpj1, Position.of(5, 5));
        pidao.registerRestaurant("Sergel", cnpj2, Position.of(1, 1));

        pidao.addFoodToRestaurantMenu(cnpj1, "Parme Carne", 38.99, 2);
        pidao.addFoodToRestaurantMenu(cnpj1, "Camarao Flambado", 42.99, 3);
        pidao.addFoodToRestaurantMenu(cnpj1, "Frango Fiorentina", 27.99, 1);

        pidao.addFoodToRestaurantMenu(cnpj2, "Picole", 2.50, 0);
        pidao.addFoodToRestaurantMenu(cnpj2, "Casquinha", 3.50, 1);
        pidao.addFoodToRestaurantMenu(cnpj2, "Cestinha", 12.50, 2);
        pidao.addFoodToRestaurantMenu(cnpj2, "Milkshake", 11.50, 3);

        pidao.assignDeliverymanToRestaurant(cpf3, cnpj1);
        pidao.assignDeliverymanToRestaurant(cpf3, cnpj2);
        pidao.assignDeliverymanToRestaurant(cpf4, cnpj1);
        pidao.assignDeliverymanToRestaurant(cpf4, cnpj2);
        pidao.assignDeliverymanToRestaurant(cpf5, cnpj1);

        List<String> cnpj1FoodIds = pidao.getFoodIdsFromRestaurantMenu(cnpj1);
        List<String> cnpj2FoodIds = pidao.getFoodIdsFromRestaurantMenu(cnpj2);
        pidao.addDiscountToFood(cnpj1, cnpj1FoodIds.get(0), DiscountType.PERCENTAGE, 5);
        pidao.addDiscountToFood(cnpj2, cnpj2FoodIds.get(3), DiscountType.VALUE, 2);

        // with user interaction, would be possible to show the list/possibilities and get the wished indexes
        int orderNumber1 = pidao.registerDeliveryOrder(cpf1, cnpj1, cnpj1FoodIds.get(0), cnpj1FoodIds.get(1));
        int orderNumber2 = pidao.registerWithdrawalOrder(cpf2, cnpj2, cnpj2FoodIds.get(2), cnpj2FoodIds.get(2));

        System.out.println("Menus:");
        System.out.println(pidao.getAllMenus());
        System.out.println("------------------");
        System.out.println("Orders:");
        System.out.println(pidao.getAllOrders());

        pidao.removeDiscountToFood(cnpj2, cnpj2FoodIds.get(3));

        pidao.cancelOrder(cpf1);

        int orderNumber3 = pidao.registerDeliveryOrder(cpf1, cnpj1, cnpj1FoodIds.get(2));
        pidao.addFoodToOrder(cpf1, cnpj1FoodIds.get(2));

        pidao.processOrder(cpf1);
        pidao.processOrder(cpf2);

        System.out.println("------------------");
        System.out.println("Orders:");
        System.out.println(pidao.getAllOrders());

        sleep(5);

        System.out.println("------------------");
        System.out.println("Orders:");
        System.out.println(pidao.getAllOrders());

        pidao.withdrawOrder(cpf2);

        int orderNumber4 = pidao.registerDeliveryOrder(cpf1, cnpj2, cnpj2FoodIds.get(0), cnpj2FoodIds.get(1), cnpj2FoodIds.get(2), cnpj2FoodIds.get(3));
        pidao.processOrder(cpf1);

        int orderNumber5 = pidao.registerDeliveryOrder(cpf2, cnpj1, cnpj1FoodIds.get(0), cnpj1FoodIds.get(1), cnpj1FoodIds.get(2));
        pidao.processOrder(cpf2);

        sleep(10);

        pidao.rateRestaurantOfOrder(orderNumber1, Stars.TWO, "Demorou muito pra fazer ate cancelei");

        pidao.rateRestaurantOfOrder(orderNumber2, Stars.FOUR);
        pidao.rateFoodOfOrder(orderNumber2, cnpj2FoodIds.get(2), Stars.FIVE, "Loved this food");

        pidao.rateRestaurantOfOrder(orderNumber3, Stars.ZERO, "Dislike!");
        pidao.rateDeliverymanOfOrder(orderNumber3, Stars.TWO, "Took too long");
        pidao.rateFoodOfOrder(orderNumber3, cnpj1FoodIds.get(2), Stars.ONE, "thumbs down");

        pidao.rateRestaurantOfOrder(orderNumber4, Stars.FIVE, "Cheap and very good!");
        pidao.rateDeliverymanOfOrder(orderNumber4, Stars.FIVE, "The fastest in the old west!");
        pidao.rateFoodOfOrder(orderNumber4, cnpj2FoodIds.get(0), Stars.FIVE, "Loved");
        pidao.rateFoodOfOrder(orderNumber4, cnpj2FoodIds.get(1), Stars.FOUR);
        pidao.rateFoodOfOrder(orderNumber4, cnpj2FoodIds.get(2), Stars.FIVE, "Loved+++");
        pidao.rateFoodOfOrder(orderNumber4, cnpj2FoodIds.get(3), Stars.FOUR);

        pidao.rateRestaurantOfOrder(orderNumber5, Stars.FIVE, "Not so cheap but very tasty!");
        pidao.rateDeliverymanOfOrder(orderNumber5, Stars.THREE);
        pidao.rateFoodOfOrder(orderNumber5, cnpj1FoodIds.get(0), Stars.FOUR, "Loved-");
        pidao.rateFoodOfOrder(orderNumber5, cnpj1FoodIds.get(1), Stars.FOUR, "Loved-");
        pidao.rateFoodOfOrder(orderNumber5, cnpj1FoodIds.get(2), Stars.FIVE, "Loved++");

        System.out.println("------------------");
        System.out.println("Orders:");
        System.out.println(pidao.getAllOrders());

        System.out.println("------------------");
        System.out.println("Restaurant Ratings:");
        System.out.println(pidao.getAllRestaurantRatings());

        System.out.println("------------------");
        System.out.println("Deliveryman Ratings:");
        System.out.println(pidao.getAllDeliverymanRatings());

        System.out.println("------------------");
        System.out.println("Food Ratings:");
        System.out.println(pidao.getAllFoodRatings());
    }

    private void sleep(int secs) {
        try {
            Thread.sleep(secs * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
