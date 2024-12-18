package com.gildedrose;

class GildedRose {
    Item[] items;
    final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateCatalog() {
        updateSellInValue();
        updateQuality();
    }

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

    public void updateSellInValue() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].sellIn < MAX_QUALITY) {
                items[i].sellIn -= 1;
            }
        }
    }
}

//
//        for(
//    int i = 0;
//    i<items.length;i++)
//
//    {
//        if (!items[i].name.equals("Aged Brie")
//                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//            if (items[i].quality > 0) {
//                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                    items[i].quality = items[i].quality - 1;
//                }
//            }
//        } else {
//            if (items[i].quality < 50) {
//                items[i].quality = items[i].quality + 1;
//
//                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                    if (items[i].sellIn < 11) {
//                        if (items[i].quality < 50) {
//                            items[i].quality = items[i].quality + 1;
//                        }
//                    }
//
//                    if (items[i].sellIn < 6) {
//                        if (items[i].quality < 50) {
//                            items[i].quality = items[i].quality + 1;
//                        }
//                    }
//                }
//            }
//        }
//
//        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//            items[i].sellIn = items[i].sellIn - 1;
//        }
//
//        if (items[i].sellIn < 0) {
//            if (!items[i].name.equals("Aged Brie")) {
//                if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                    if (items[i].quality > 0) {
//                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                            items[i].quality = items[i].quality - 1;
//                        }
//                    }
//                } else {
//                    items[i].quality = items[i].quality - items[i].quality;
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//                }
//            }
//        }
//    }

