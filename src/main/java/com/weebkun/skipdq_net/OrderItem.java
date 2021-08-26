package com.weebkun.skipdq_net;

import com.squareup.moshi.Json;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class OrderItem {
    public String id;
    @Json(name = "item_id")
    public String itemId;
    @Json(name = "order_id")
    public String orderId;
    public String name;
    public String selections;
    public int quantity;
    public double amount;

    public Selections parseSelections() throws IOException {
        // get selections
        return new Moshi.Builder().build().adapter(Selections.class).fromJson(selections);
    }

    public static class Selections {
        public double price;
        public String[] selections;
    }
}
