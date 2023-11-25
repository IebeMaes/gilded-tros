package com.gildedtros.category;

import com.gildedtros.Item;
import com.gildedtros.ItemCategory;

import static com.gildedtros.Constants.MAXIMAL_QUALTIY;

public class InterestingConference implements ItemCategory {
    public InterestingConference() {
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < MAXIMAL_QUALTIY) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < MAXIMAL_QUALTIY) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < MAXIMAL_QUALTIY) {
                item.quality++;
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
