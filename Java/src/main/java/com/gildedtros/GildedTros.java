package com.gildedtros;

import static com.gildedtros.ItemConverter.getItemCategory;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final var itemCategory = getItemCategory(item);
            itemCategory.updateSellIn(item);
            itemCategory.updateQuality(item);
        }
    }
}