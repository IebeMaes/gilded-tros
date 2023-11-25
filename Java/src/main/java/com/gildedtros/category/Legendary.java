package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemCategory;

public class Legendary implements ItemCategory {
    public Legendary() {
    }

    @Override
    public void updateSellIn(Item item) {
        // Geen actie nodig voor legendarische items
    }

    @Override
    public void updateQuality(Item item) {
        // Geen actie nodig voor legendarische items
    }
}
