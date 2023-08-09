package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.handler.impl.AgedHandler;
import com.gildedrose.handler.impl.BackstagePassesHandler;
import com.gildedrose.handler.impl.LegendaryHandler;
import com.gildedrose.handler.impl.OrdinaryHandler;
import com.gildedrose.product.ProductEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerDispatcher {
    private Map<ProductEnum, Handler> map = new HashMap<>(ProductEnum.values().length);
    public HandlerDispatcher() {
        map.put(ProductEnum.AGED, new AgedHandler());
        map.put(ProductEnum.BACKSTAGE_PASSES, new BackstagePassesHandler());
        map.put(ProductEnum.LEGENDARY, new LegendaryHandler());
        map.put(ProductEnum.ORDINARY, new OrdinaryHandler());
    }
    public Handler determineProcessor(ProductEnum productEnum) {
        return map.get(productEnum);
    }


}
