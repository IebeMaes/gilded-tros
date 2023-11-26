package com.gildedtros;

import com.gildedtros.category.GoodWine;
import com.gildedtros.category.InterestingConference;
import com.gildedtros.category.Normal;
import com.gildedtros.category.Smelly;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    public void testUpdateQuality_NormalItems() {
        Item[] items = new Item[] {
                new Item("Elixir of the SOLID", 10, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(19, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_NormalItemsOnSellIn() {
        Item[] items = new Item[] {
                new Item("Elixir of the SOLID", 1, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(19, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_NormalItemPastSellIn() {
        Item[] items = new Item[] {
                new Item("Elixir of the SOLID", 0, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(18, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_NormalItemPastSellInWithZeroQuality() {
        Item[] items = new Item[] {
                new Item("Elixir of the SOLID", -12, 0)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-13, items[0].sellIn);
    }

    @Test
    public void testUpdate_NormalItemClass(){
        Item item = new Item("Elixir of the SOLID", 10, 20);

        Normal normalCategory = new Normal();
        normalCategory.updateQuality(item);
        normalCategory.updateSellIn(item);

        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);

    }

    @Test
    public void testUpdateQuality_GoodWine() {
        Item[] items = new Item[] {
                new Item("Good Wine", 5, 30)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(31, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    public void testUpdate_GoodWineClass(){
        Item item = new Item("Good Wine", 5, 30);

        GoodWine goodWineCategory = new GoodWine();
        goodWineCategory.updateQuality(item);
        goodWineCategory.updateSellIn(item);

        assertEquals(31, item.quality);
        assertEquals(4, item.sellIn);

    }

    @Test
    public void testUpdateQuality_GoodWineAfterSellIn() {
        Item[] items = new Item[] {
                new Item("Good Wine", 0, 35)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(37, items[0].quality);
    }

    @Test
    public void testUpdateQuality_GoodWineMaximumQuality() {
        Item[] items = new Item[] {
                new Item("Good Wine", 5, 50)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    public void testUpdateQuality_GoodWineAfterSellInMaximumQuality() {
        Item[] items = new Item[] {
                new Item("Good Wine", 0, 50)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    public void testUpdateQuality_BackstagePasses() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 23, 35)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(36, items[0].quality);
        assertEquals(22, items[0].sellIn);
    }

    @Test
    public void testUpdate_BackstagePassClass(){
        Item item = new Item("Backstage passes for Re:Factor", 23, 35);

        InterestingConference interestingConferenceCategory = new InterestingConference();
        interestingConferenceCategory.updateQuality(item);
        interestingConferenceCategory.updateSellIn(item);

        assertEquals(36, item.quality);
        assertEquals(22, item.sellIn);

    }

    @Test
    public void testUpdateQuality_BackstagePassesAfterSellIn() {
        Item[] items = new Item[] {
                new Item("Backstage passes for HAXX", 0, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void testUpdateQuality_BackstagePassesQualityIncreaseTenDaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 10, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(22, items[0].quality);
    }

    @Test
    public void testUpdateQuality_BackstagePassesQualityIncreaseFiveDaysLeft() {
        Item[] items = new Item[] {
                new Item("Backstage passes for HAXX", 5, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(23, items[0].quality);
    }

    @Test
    public void testUpdateQuality_LegendaryItem() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 15, 80)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(15, items[0].sellIn);
    }


    @Test
    public void testUpdateQuality_SmellyItems() {
        Item[] items = new Item[] {
                new Item("Duplicate Code", 10, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(18, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_SmellyItemsOnSellIn() {
        Item[] items = new Item[] {
                new Item("Long Methods", 1, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(18, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_SmellyItemPastSellIn() {
        Item[] items = new Item[] {
                new Item("Ugly Variable Names", 0, 20)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(16, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void testUpdateQuality_SmellyItemPastSellInWithZeroQuality() {
        Item[] items = new Item[] {
                new Item("Duplicate Code", -12, 0)
        };
        GildedTros gildedTros = new GildedTros(items);

        gildedTros.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-13, items[0].sellIn);
    }

    @Test
    public void testUpdate_SmellyItemClass(){
        Item item = new Item("Long Methods", 10, 20);

        Smelly smellyCategory = new Smelly();
        smellyCategory.updateQuality(item);
        smellyCategory.updateSellIn(item);

        assertEquals(18, item.quality);
        assertEquals(9, item.sellIn);

    }
}