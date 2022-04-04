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
public class GildedRoseCBackstagePassesTestRefactored {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int SELLIN_BETWEEN_5_AND_10 = 7;
    private static final int SELLING_GREATER_THAN_10 = 15;
    private static final int SELLIN_BETWEEN_1_AND_4 = 4;
    private static final int SELLIN_EXPIRED = 0;
    private static final int DEFAULT_QUALITY = 3;
    private static final int EXPIRED_QUALITY = 0;

    @Test
    public void BackstagePassesBeyond10Days_qualityIncreasesBy1() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLING_GREATER_THAN_10, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(BACKSTAGE_PASSES, SELLING_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);

    }

    @Test
    public void BackstagePassesBetween5and10Days_qualityIncreasesBy2() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_BETWEEN_5_AND_10, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(BACKSTAGE_PASSES, SELLIN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void BackstagePassesBetween1and4Days_qualityIncreasesBy2_qualityIncreasesBy3() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_BETWEEN_1_AND_4, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(BACKSTAGE_PASSES, SELLIN_BETWEEN_1_AND_4 - 1, DEFAULT_QUALITY + 3);
        assertItem(expected, app.items[0]);
    }
    @Test
    public void expiredBackstagePasses_qualityDropTo0() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_EXPIRED, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(BACKSTAGE_PASSES, SELLIN_EXPIRED - 1, EXPIRED_QUALITY);
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
