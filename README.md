# GildedRose Quality Management

This project manages item quality and sell-in values in the GildedRose system.

## Classes

### GildedRose

Manages the item catalog, updating quality and sell-in values.

#### Methods

- **`GildedRose(Item[] items)`**: Initializes with an array of items.
- **`updateCatalog()`**: Calls `updateSellInValue()` and `updateQuality()`.
- **`updateSellInValue()`**: Decreases `sellIn` values (except "Sulfuras").
- **`updateQuality()`**: Updates `quality` based on item type.

### Item

Represents an item with `name`, `sellIn`, and `quality`.

## Quality Update Rules

- **"Aged Brie"**: Increases in quality.
- **"Backstage passes"**: Quality increases as the event approaches, drops to 0 after.
- **"Conjured" Items**: Decrease in quality twice as fast.
- **"Sulfuras"**: Quality does not change.
- **General Items**: Quality decreases, constrained between 0 and 50.

## How to Use

1. Create `Item` objects.
2. Instantiate `GildedRose` with items.
3. Call `updateCatalog()`.

Example:
```java
Item[] items = new Item[] {
    new Item("Aged Brie", 10, 20),
    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30),
    new Item("Conjured Mana Cake", 5, 25)
};
GildedRose gildedRose = new GildedRose(items);
gildedRose.updateCatalog();
