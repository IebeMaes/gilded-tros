package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemCategory;

public class NormalItem implements ItemCategory {
    public NormalItem() {
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateQuantity(Item item) {
        if (item.quality > 0) {
            item.quality--;
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }
}
