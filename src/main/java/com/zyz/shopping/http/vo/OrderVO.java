package com.zyz.shopping.http.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class OrderVO {

    private Integer buyerId;

    private Integer bookId;

    private Integer addressId;

    private Double orderAmount;

    @ApiModelProperty("支付方式")
    private Integer payId;

    @ApiModelProperty("在线支付平台")
    private String onlinePlatform;

    private String remark;

    private Boolean requireInvoice;
}
