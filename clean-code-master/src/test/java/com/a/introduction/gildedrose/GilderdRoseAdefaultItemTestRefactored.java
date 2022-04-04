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
public class GilderdRoseAdefaultItemTestRefactored {

    private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
    private static final int DEFAULT_QUALITY = 3;
    private static final int NOT_EXPIRED_SELLIN = 15;
    private static final int EXPIRED_SELLIN = -1;

    @Test
    public void unexpiredDefaultItem_QualityDrecreasesBy1() {
        //setup
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
        //invoke
        app.updateQuality();
        //verify
        final Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 1);
        //expected , actual
        assertItem(expected, app.items[0]);
    }

    @Test
    public void expiredDefaultItem_QualityDecreasesby2() {
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);
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
