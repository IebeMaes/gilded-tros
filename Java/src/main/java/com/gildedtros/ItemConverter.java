package com.gildedtros;

import com.gildedtros.category.GoodWine;
import com.gildedtros.category.InterestingConference;
import com.gildedtros.category.Legendary;
import com.gildedtros.category.NormalItem;

import java.util.List;
import java.util.stream.Collectors;

public class ItemConverter {

    private static final String LEGENDARY_ITEM = "B-DAWG Keychain";
    private static final String GOOD_WINE = "Good Wine";
    private static final List<String> INTERESTING_CONFERENCES = List.of("Backstage passes for Re:Factor", "Backstage passes for HAXX");

    public static ItemCategory getItemCategory(Item item) {
        return switch (item.name) {
            case GOOD_WINE -> new GoodWine();
            case LEGENDARY_ITEM -> new Legendary();
            default -> isInterestingConference(item.name) ? new InterestingConference() : new NormalItem();
        };
    }

    private static boolean isInterestingConference(String itemName){
        return INTERESTING_CONFERENCES.contains(itemName);
    }
}
