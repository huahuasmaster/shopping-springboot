package com.zyz.shopping.bury;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class BuryDTO {
    public static BuryDTO fromBase(Integer userId, String event, String path, Long date) {
        BuryDTO buryDTO = new BuryDTO();
        buryDTO.setUserId(userId);
        buryDTO.setTriggerDate(date);
        buryDTO.setEvent(event);
        buryDTO.setPath(path);
        return buryDTO;
    }

    @ApiModelProperty("事件名称")
    private String event;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("所在页面")
    private String path;

    @ApiModelProperty("触发时间")
    private Long triggerDate;

    @ApiModelProperty("dom相关属性")
    private Map<String, String> domProperties;

    @ApiModelProperty("相关属性")
    private Map<String, Object> data;
}
