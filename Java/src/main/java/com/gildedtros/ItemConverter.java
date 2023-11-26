package com.gildedtros;

import com.gildedtros.category.*;

import java.util.List;

public class ItemConverter {

    private static final String LEGENDARY_ITEM = "B-DAWG Keychain";
    private static final String GOOD_WINE = "Good Wine";

    public static ItemCategory getItemCategory(Item item) {
        return switch (item.name) {
            case GOOD_WINE -> new GoodWine();
            case LEGENDARY_ITEM -> new Legendary();
            case "Backstage passes for Re:Factor", "Backstage passes for HAXX" -> new InterestingConference();
            case "Duplicate Code", "Long Methods", "Ugly Variable Names" -> new Smelly();
            default -> new Normal();
        };
    }
}