package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemCategory;

public class GoodWine implements ItemCategory {
    public GoodWine() {

    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateQuantity(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
