package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @version 1.0
 * @description test class for GildedRose
 *
 */
class GildedRoseTest {

    @Test
    void testNewCatalog() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testQualityAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].quality);
        System.out.println("\n Name: " + app.items[0].name + "\n Quality: " + app.items[0].quality + "\n Sell in " + app.items[0].sellIn + " day(s)");
    }

    @Test
    void testQualityBackstagePasses() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(21, app.items[0].quality);
        System.out.println("\n Name: " + app.items[0].name + "\n Quality: " + app.items[0].quality + "\n Sell in " + app.items[0].sellIn + " day(s)");
    }

    @Test
    void testQualityConjured() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        System.out.println("\n Name: " + app.items[0].name + "\n Quality: " + app.items[0].quality + "\n Sell in " + app.items[0].sellIn + " day(s)");
    }

    @Test
    void testLegendaryItem() {

        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateSellInValue();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        System.out.println("\n Name: " + app.items[0].name + "\n Quality: " + app.items[0].quality + "\n Sell in " + app.items[0].sellIn + " day(s)");
    }

    @Test
    void testOnlySellInValue() {
        Item[] items = new Item[]{new Item("Sword", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateSellInValue();
        assertEquals(4, app.items[0].sellIn);
        System.out.println("\n Name: " + app.items[0].name + "\n Quality: " + app.items[0].quality + "\n Sell in " + app.items[0].sellIn + " day(s)");
    }
}
