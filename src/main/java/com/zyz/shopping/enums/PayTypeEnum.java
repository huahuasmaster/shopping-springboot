package com.zyz.shopping.enums;

public enum PayTypeEnum {
    ONLINE(1, "线上支付"),
    CASH_ON_DELIVERY(2, "货到付款"),
    OTHER_ONE_PAY(3, "他人支付"),
    BANK_TRANSFER(4, "银行转账");

    private Integer id;
    private String name;

    PayTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
