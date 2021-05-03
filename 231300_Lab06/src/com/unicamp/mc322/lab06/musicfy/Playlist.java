package com.unicamp.mc322.lab06.musicfy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Playlist {
    private String name;
    private double totalStorageMB;
    private final List<Item> items;
    private final double MAX_ALLOWED_DURATION_SECONDS = 60;
    private int current;
    private LocalDateTime createdOn;

    public Playlist(String name) {
        this.name = name;
        this.totalStorageMB = 0;
        this.items = new ArrayList<>();
        this.current = 0;
        this.createdOn = LocalDateTime.now();
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

    Item leastLastingItem() {
        return items.stream().min(Comparator.comparingDouble(Item::getDurationSeconds)).orElse(null);
    }

    Item longerLastingItem() {
        return items.stream().max(Comparator.comparingDouble(Item::getDurationSeconds)).orElse(null);
    }

    double avgItemDuration() {
        return items.stream().mapToDouble(Item::getDurationSeconds).average().orElse(Double.NaN);
    }

    double totalDuration() {
        return items.stream().mapToDouble(Item::getDurationSeconds).sum();
    }

    Item play() {
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

        return items.get(toGet);
    }

    private boolean isMBLimitApplicable() {
        return longerLastingItem().getDurationSeconds() < MAX_ALLOWED_DURATION_SECONDS;
    }
}
