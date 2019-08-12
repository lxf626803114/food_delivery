package com.mall.food.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Commodity {
    private String type;
    private String bId;
    private String size;
    private BigDecimal price;
    private String describe;
    private String picture;
}
