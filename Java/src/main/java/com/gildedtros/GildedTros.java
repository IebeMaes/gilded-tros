package com.gildedtros;

import java.util.List;

class GildedTros {
    Item[] items;
    private final int MINIMAL_QUALITY = 0;
    private final int MAXIMAL_QUALTIY = 50;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        // Loop door elk item in de items array
        for (Item item : items) {


            // Kwaliteit verminderen voor alle items, uitgezonderd legendarisch item (B-DAWG), Good wine en Backstage passes
            if (!item.name.equals("Good Wine")
                    && !item.name.equals("Backstage passes for Re:Factor")
                    && !item.name.equals("Backstage passes for HAXX")) {

                // Kwaliteit kan niet onder 0 gaan
                if (item.quality > MINIMAL_QUALITY) {
                    if (!item.name.equals("B-DAWG Keychain")) {
                        item.quality = item.quality - 1;
                    }
                }
            }
            // De items die in de eerste if geskipt worden zijn speciale items waarvan de kwaliteit alleen stijgt
            else {

                // Kwaliteit kan niet boven de 50 gaan
                // Legendarische items hebben een kwaliteit van 80 en worden hier ook overgeslagen
                if (item.quality < MAXIMAL_QUALTIY) {
                    item.quality = item.quality + 1;

                    // Speciale regels voor Backstage passes
                    if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {

                        // Kwaliteit verhoogt nogmaals als sellIn 10 dagen of minder is & kwaliteit onder de 50
                        if (item.sellIn < 11 && item.quality < MAXIMAL_QUALTIY) {
                            item.quality = item.quality + 1;
                        }

                        // Kwaliteit verhoogt nogmaals als sellIn 5 dagen of minder is & kwaliteit onder de 50
                        if (item.sellIn < 6 && item.quality < MAXIMAL_QUALTIY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            // Legendarisch item moet nooit verkocht worden
            // Andere items moeten wel verkocht worden dus elke dag verlaagt de sellIn met 1
            if (!item.name.equals("B-DAWG Keychain")) {
                item.sellIn--;
            }

            // SellIn onder 0 -> kwaliteit gaat dubbel zo snel achteruit
            if (item.sellIn < 0) {
                // Goede wijn wordt alleen maar beter met de jaren
                if (!item.name.equals("Good Wine")) {

                    // Kwaliteit van Backstage passes wordt ook niet verlaagd
                    if (!item.name.equals("Backstage passes for Re:Factor") && !item.name.equals("Backstage passes for HAXX")) {
                        // Kwaliteit kan niet onder 0 gaan
                        if (item.quality > 0) {
                            // Legendarische items kunnen niet zakken in kwaliteit
                            if (!item.name.equals("B-DAWG Keychain")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // Voor Backstage passes wordt de kwaliteit op 0 gezet als deze verlopen
                        item.quality = 0;
                    }
                } else {
                    // Voor goede wijn stijgt de kwaliteit tot 50
                    if (item.quality < MAXIMAL_QUALTIY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}