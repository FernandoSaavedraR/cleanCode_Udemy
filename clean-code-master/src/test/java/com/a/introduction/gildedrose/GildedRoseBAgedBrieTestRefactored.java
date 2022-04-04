/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fernando
 */
public class GildedRoseBAgedBrieTestRefactored {

    private static final String AGED__BRIE = "Aged Brie";
    private static final int DEFAULT_QUALITY = 3;
    private static final int NOT_EXPIRED_SELLIN = 4;
    private static final int EXPIRED_SELLIN = -1;
    private static final int MAXIMUM_QUALITY = 50;

    @Test
    public void unexpiredAgedBrie_qualityIncreasesBy1() {

        GildedRose app = createGildedRoseWithOneItem(AGED__BRIE, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(AGED__BRIE, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void expiredAgedBrie_qualityIncreasesBy2() {
        GildedRose app = createGildedRoseWithOneItem(AGED__BRIE, EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(AGED__BRIE, EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);

    }
    @Test
    public void unexpiredAgedBrie_maxQuality() {
        GildedRose app = createGildedRoseWithOneItem(AGED__BRIE, NOT_EXPIRED_SELLIN, MAXIMUM_QUALITY);
        app.updateQuality();
        final Item expected = new Item(AGED__BRIE, NOT_EXPIRED_SELLIN - 1, MAXIMUM_QUALITY);
        assertItem(expected, app.items[0]);
    }

    private GildedRose createGildedRoseWithOneItem(final String itemType, final int Sellin, final int quality) {
        Item item = new Item(itemType, Sellin, quality);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        return app;
    }

    private void assertItem(final Item expected, final Item actualValue) {
        // expected, actual
        assertEquals(expected.name, actualValue.name);
        assertEquals(expected.sellIn, actualValue.sellIn);
        assertEquals(expected.quality, actualValue.quality);
    }
}
