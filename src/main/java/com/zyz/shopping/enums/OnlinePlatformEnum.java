package com.zyz.shopping.enums;

public enum OnlinePlatformEnum {
    ZFB(1, "支付宝"),
    WX(2, "微信"),
    KUAI_QIAN(3, "快钱"),
    HUA_BEI(4, "花呗");
    private Integer id;
    private String name;

    OnlinePlatformEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
