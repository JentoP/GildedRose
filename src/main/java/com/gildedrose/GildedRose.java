package com.gildedrose;

/**
 * @version 1.0
 */
class GildedRose {
    Item[] items;
    final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * @author Jento Pieters
     * @description updates the complete list of items by using both updateSellInValue and updateQuality methods
     */
    public void updateCatalog() {
        updateSellInValue();
        updateQuality();
    }

    /**
     * @author Jento Pieters
     * @description updates the quality of the items ensuring that it meets the requirements.
     */
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

//            updates quality for Aged Brie
            if (items[i].name.equals("Aged Brie")) {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality = items[i].quality + 1;
                }
            }
//            updates quality of Backstage passes
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality < MAX_QUALITY) {
                    if (items[i].sellIn > 10) {
                        items[i].quality = items[i].quality + 1;
                    }
                    if (items[i].sellIn <= 10) {
                        items[i].quality = items[i].quality + 2;
                    }
                    if (items[i].sellIn <= 5) {
                        items[i].quality = items[i].quality + 3;
                    }
                    if (items[i].sellIn <= 0) {
                        items[i].quality = 0;
                    }
                }
            }
//            updates quality of conjured items
            if (items[i].name.toLowerCase().contains("conjured")) {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 2;
                }
            }
//            updates quality below 0
            if (items[i].quality < 0) {
                items[i].quality = 0;
            }
//            updates quality above 50
            if (items[i].quality > MAX_QUALITY && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = MAX_QUALITY;
            }
        }
    }

    /**
     * @description updates the sellIn value of the items
     *  it makes it possible to update the sellIn value of all items by 1 day
     */
    public void updateSellInValue() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].sellIn < MAX_QUALITY) {
                items[i].sellIn -= 1;
            }
        }
    }
}

