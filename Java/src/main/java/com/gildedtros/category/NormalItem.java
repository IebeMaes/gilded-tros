package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemUpdater;

public class NormalItem extends Item implements ItemUpdater {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn(Item item) {

    }

    @Override
    public void updateQuantity(Item item) {

    }
}
