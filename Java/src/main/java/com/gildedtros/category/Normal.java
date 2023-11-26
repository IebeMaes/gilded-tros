package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemCategory;

import static com.gildedtros.Constants.MINIMAL_QUALITY;

public class Normal implements ItemCategory {
    public Normal() {
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality > MINIMAL_QUALITY) {
            item.quality--;
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }
}
