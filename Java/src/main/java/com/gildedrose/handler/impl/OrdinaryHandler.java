package com.gildedrose.handler.impl;

import com.gildedrose.Item;
import com.gildedrose.handler.Handler;

public class OrdinaryHandler implements Handler {
    @Override
    public void handle(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
