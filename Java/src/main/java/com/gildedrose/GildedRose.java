package com.gildedrose;

import com.gildedrose.handler.Handler;
import com.gildedrose.handler.HandlerDispatcher;
import com.gildedrose.product.ProductEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GildedRose {
    Item[] items;

    private Map<ProductEnum, List<Item>> map = new HashMap<>();// 通过读取json文件生成更好

    public GildedRose(Item[] items) {
        this.items = items;
        List<Item> agedProducts = new ArrayList<>();
        List<Item> backstagePassesProducts = new ArrayList<>();
        List<Item> legendaryProducts = new ArrayList<>();
        List<Item> ordinaryProducts = new ArrayList<>();
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                agedProducts.add(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                backstagePassesProducts.add(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                legendaryProducts.add(item);
            } else {
                ordinaryProducts.add(item);
            }
        }
        map.put(ProductEnum.AGED, agedProducts);
        map.put(ProductEnum.BACKSTAGE_PASSES, backstagePassesProducts);
        map.put(ProductEnum.LEGENDARY, legendaryProducts);
        map.put(ProductEnum.ORDINARY, ordinaryProducts);
    }

    public void updateQuality() {
        HandlerDispatcher handlerDispatcher = new HandlerDispatcher();
        for (ProductEnum productEnum : map.keySet()) {
            updateQuantityByProductEnum(productEnum, handlerDispatcher.determineProcessor(productEnum));
        }
    }

    public void updateQuantityByProductEnum(ProductEnum productEnum, Handler handler) {
        for (Item item : map.get(productEnum)) {
            handler.handle(item);
        }
    }
}
