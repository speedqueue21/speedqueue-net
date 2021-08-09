package com.weebkun.skipdq_net;

import com.squareup.moshi.Json;

public class Order {
    public String id;
    @Json(name = "cust_id")
    public String customerId;
    @Json(name = "stall_id")
    public String stallId;
    public String datetime;
    public int code;
    public String status;
}
