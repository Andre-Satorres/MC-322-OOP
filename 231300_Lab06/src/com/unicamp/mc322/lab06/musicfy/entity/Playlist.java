package com.unicamp.mc322.lab06.musicfy.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Playlist {
    private final String name;
    private double totalStorageMB;
    private final List<Item> items;
    private int current;

    public Playlist(String name) {
        this.name = name;
        this.totalStorageMB = 0;
        this.items = new ArrayList<>();
        this.current = 0;
    }

    public Playlist(String name, Item ... items) {
        this(name);

        for (Item item: items) {
            this.addItem(item);
        }
    }

    boolean isEmpty() {
        return this.items.isEmpty();
    }

    double getTotalStorageMB() {
        return totalStorageMB;
    }

    private void increaseTotalSize(double amount) {
        this.totalStorageMB += amount;
    }

    private void decreaseTotalSize(double amount) {
        this.totalStorageMB -= amount;
    }

    void addItem(Item item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
            increaseTotalSize(item.getTotalStorageMB());
        }
    }

    void deleteItem(Item item) {
        if (this.items.contains(item)) {
            decreaseTotalSize(item.getTotalStorageMB());
            this.items.remove(item);
        }
    }

    public Item leastLastingItem() {
        return items.stream().min(Comparator.comparingDouble(Item::getDurationSeconds)).orElse(null);
    }

    public Item longerLastingItem() {
        return items.stream().max(Comparator.comparingDouble(Item::getDurationSeconds)).orElse(null);
    }

    public double avgItemDuration() {
        return items.stream().mapToDouble(Item::getDurationSeconds).average().orElse(Double.NaN);
    }

    public double totalDuration() {
        return items.stream().mapToDouble(Item::getDurationSeconds).sum();
    }

    Item play() {
        if (current == this.items.size()) {
            current = 0;
        }

        return items.get(current++);
    }

    Item play(boolean shuffle) {
        if (!shuffle) {
            return play();
        }

        int toGet;
        do {
            toGet = (int) (Math.random() * items.size());
        } while (toGet == current);

        current = toGet;
        return items.get(toGet);
    }

    @Override
    public String toString() {
        return String.format("(%s - %.2fMB - Items:%s)", name, totalStorageMB, items);
    }
}
