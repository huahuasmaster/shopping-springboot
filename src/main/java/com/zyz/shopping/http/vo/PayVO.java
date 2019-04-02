package com.zyz.shopping.http.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayVO {

    @ApiModelProperty("支付方式")
    private Integer payId;

    @ApiModelProperty("网上支付平台")
    private String onlinePlatform;

    @ApiModelProperty("转账银行")
    private String bankName;

    @ApiModelProperty("第三方支付流水号")
    private String outerTradeNo;

    @ApiModelProperty("支付时间")
    private Long payDate;

}
