package com.gildedtros;

import com.gildedtros.category.*;

import java.util.List;

public class ItemConverter {
    public static ItemCategory getItemCategory(Item item) {
        return switch (item.name) {
            case "Good Wine" -> new GoodWine();
            case "B-DAWG Keychain" -> new Legendary();
            case "Backstage passes for Re:Factor", "Backstage passes for HAXX" -> new InterestingConference();
            case "Duplicate Code", "Long Methods", "Ugly Variable Names" -> new Smelly();
            default -> new Normal();
        };
    }
}