package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        // Loop door elk item in de items array
        for (int i = 0; i < items.length; i++) {

            // Kwaliteit verminderen voor alle items, uitgezonderd legendarisch item (B-DAWG), Good wine en Backstage passes
            if (!items[i].name.equals("Good Wine")
                    && !items[i].name.equals("Backstage passes for Re:Factor")
                    && !items[i].name.equals("Backstage passes for HAXX")) {

                // Kwaliteit kan niet onder 0 gaan
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("B-DAWG Keychain")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
            // De items die in de eerste if geskipt worden zijn speciale items waarvan de kwaliteit alleen stijgt
            else {

                // Kwaliteit kan niet boven de 50 gaan
                // Legendarische items hebben een kwaliteit van 80 en worden hier ook overgeslagen
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    // Speciale regels voor Backstage passes
                    if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX")) {

                        // Kwaliteit verhoogt nogmaals als sellIn 10 dagen of minder is & kwaliteit onder de 50
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // Kwaliteit verhoogt nogmaals als sellIn 5 dagen of minder is & kwaliteit onder de 50
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // Legendarisch item moet nooit verkocht worden
            // Andere items moeten wel verkocht worden dus elke dag verlaagt de sellIn met 1
            if (!items[i].name.equals("B-DAWG Keychain")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            // SellIn onder 0 -> kwaliteit gaat dubbel zo snel achteruit
            if (items[i].sellIn < 0) {
                // Goede wijn wordt alleen maar beter met de jaren
                if (!items[i].name.equals("Good Wine")) {

                    // Kwaliteit van Backstage passes wordt ook niet verlaagd
                    if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
                        // Kwaliteit kan niet onder 0 gaan
                        if (items[i].quality > 0) {
                            // Legendarische items kunnen niet zakken in kwaliteit
                            if (!items[i].name.equals("B-DAWG Keychain")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // Voor Backstage passes wordt de kwaliteit op 0 gezet als deze verlopen
                        items[i].quality = 0;
                    }
                } else {
                    // Voor goede wijn stijgt de kwaliteit tot 50
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}