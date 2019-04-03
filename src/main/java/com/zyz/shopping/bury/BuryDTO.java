package com.zyz.shopping.bury;

import lombok.Data;

import java.util.Map;

@Data
public class BuryDTO {

    private String event;

    private Integer userId;

    private Long triggerDate;

    private Map<String, String> domProperties;

    private Map<String, String> data;
}
