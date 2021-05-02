package br.unicamp.mc322.lab04.pidao;

import java.util.*;

public class Pidao {
    private final Restaurant restaurant;
    private final List<Item> menu;
    private final List<Order> orders;
    private final Map<String, Integer> totalOrdersByUser;

    public Pidao(String restaurantName, String restaurantCNPJ, double x, double y) {
        this.restaurant = new Restaurant(restaurantName, restaurantCNPJ, new Coordinate(x, y));
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.totalOrdersByUser = new HashMap<>();
    }

    public User registerUser(String userName, String userCPF, int x, int y) {
        if (existsUserById(userCPF)) {
            throw new IllegalArgumentException("There is already an User registered with this CPF!");
        }

        totalOrdersByUser.put(userCPF, 0);
        return new User(userName, userCPF, new Coordinate(x, y));
    }

    public void addToMenu(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item!");
        }

        if (existsItemOnMenu(item)) {
            throw new IllegalArgumentException("The Item with id " + item.getId() + " has already been added to the menu!");
        }

        menu.add(item);
    }

    public void removeFromMenu(String itemId) {
        menu.removeIf(it -> it.getId().equalsIgnoreCase(itemId));
    }

    public void createOrder(Order order) {
        if (existsThisOrderReference(order)) {
            throw new IllegalArgumentException("This Order has already been requested!");
        }

        if (orderHasNonexistentItems(order)) {
            throw new IllegalArgumentException("This order has items not present in today's menu!");
        }

        if (!existsUserById(order.getUserCpf())) {
            throw new IllegalArgumentException("This Order belongs to a User not registered in our systems! Please, register first.");
        }

        Discount discount = discountForUser(order.getUserCpf(), order.getTotalCost());
        order.setDiscount(discount);
        order.updateStatus();
        this.orders.add(order);
        this.addOrder(order.getUserCpf());
    }

    public void applyDiscount(String itemId, double evaluation, DiscountType discountType) {
        findItemById(itemId).applyDiscount(evaluation, discountType);
    }

    public void removeDiscount(String itemId) {
        findItemById(itemId).removeDiscount();
    }

    // Preferi um metodo que retornasse String ao inves de um I/O dentro da classe pensando que isso prejudicaria a reutibilidade da classe.
    public String getMenuInfo() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(restaurant.toString()).add("");
        stringJoiner.add("Today's menu:");
        menu.forEach(item -> stringJoiner.add(item.toString()));
        return stringJoiner.add("").toString();
    }

    // Preferi um metodo que retornasse String ao inves de um I/O dentro da classe pensando que isso prejudicaria a reutibilidade da classe.
    public String getAllOrdersInfo() {
        String separator = "============================================";
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("There are " + orders.size() + " orders:");
        stringJoiner.add(separator);
        orders.forEach(order -> stringJoiner.add(order.toString()).add(separator));

        return stringJoiner.toString();
    }

    public void updateStatus(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Cannot update status of null order!");
        }

        orders.stream().filter(order::equals).findFirst().ifPresent(Order::updateStatus);
    }

    public void cancelOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Cannot update status of null order!");
        }

        orders.stream().filter(order::equals).findFirst().ifPresent(Order::cancel);
    }

    private Item findItemById(String itemId) {
        try {
            return menu.stream().filter(it -> itemId.equalsIgnoreCase(it.getId())).findFirst().orElseThrow();
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("This itemId is not present in the current menu!");
        }
    }

    private boolean existsThisOrderReference(Order order) {
        return orders.stream().anyMatch(it -> it == order); // don't let the same reference be inserted again
    }

    private boolean orderHasNonexistentItems(Order order) {
        return order.getItems().stream().anyMatch(it -> !existsItemOnMenu(it));
    }

    private boolean existsItemOnMenu(Item item) {
        return menu.stream().anyMatch(it -> it.equals(item));
    }

    private boolean existsUserById(String userId) {
        return totalOrdersByUser.containsKey(userId);
    }

    private void addOrder(String cpf) {
        Integer newAmount = totalOrdersByUser.get(cpf) + 1;
        totalOrdersByUser.replace(cpf, newAmount);
    }

    private Discount discountForUser(String cpf, double totalCost) {
        int totalOrders = totalOrdersByUser.get(cpf);

        if (totalOrders == 0) {
            return new Discount(20, DiscountType.PERCENTAGE);
        }

        if (totalOrders % 10 == 0) {
            return totalCost <= 60 ? new Discount(100, DiscountType.PERCENTAGE) : new Discount(60, DiscountType.VALUE);
        }

        if (totalCost > 100) {
            return new Discount(10, DiscountType.PERCENTAGE);
        }

        return null;
    }
}
