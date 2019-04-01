package com.zyz.shopping.http;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DuangDuangResponse<T> {
    private T data;

    @ApiModelProperty("是否成功")
    private Boolean result;

    private String errorMsg;

    public  DuangDuangResponse(T data, Boolean result, String errorMsg) {
        this.data = data;
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public static<T> DuangDuangResponse<T> success(T data) {
        return new DuangDuangResponse<>(data, true, null);
    }

    public static<T> DuangDuangResponse<T> error(String errorMsg) {
        return new DuangDuangResponse<>(null, false, errorMsg);
    }
}
