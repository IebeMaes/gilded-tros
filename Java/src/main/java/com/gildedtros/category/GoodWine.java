package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemUpdater;

public class GoodWine extends Item implements ItemUpdater {
    public GoodWine(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn(Item item) {

    }

    @Override
    public void updateQuantity(Item item) {

    }
}
