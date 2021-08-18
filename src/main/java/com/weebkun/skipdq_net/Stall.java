package com.weebkun.skipdq_net;

import com.squareup.moshi.Json;

import java.io.Serializable;

public class Stall extends Item implements Serializable {
    public String email;
    public String phone;
    @Json(name = "food_court_id")
    public String foodCourtId;
}
