package com.zyz.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.zyz.shopping.http.DuangDuangResponse;
import com.zyz.shopping.http.vo.OrderVO;
import com.zyz.shopping.http.vo.PayVO;
import com.zyz.shopping.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("duangduang/api/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public DuangDuangResponse<String> save(@RequestBody OrderVO orderVO) {
        String orderNum = orderService.save(orderVO);
        return DuangDuangResponse.success(orderNum);
    }

    @PutMapping("/{orderNum}/payStatus")
    public DuangDuangResponse pay(@PathVariable("orderNum") String orderNum, @RequestBody PayVO payVO) {
        log.info(JSON.toJSONString(payVO));
        orderService.payOrder(orderNum, payVO);
        return DuangDuangResponse.success("支付成功");
    }
}
