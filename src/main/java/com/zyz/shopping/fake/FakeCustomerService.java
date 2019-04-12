package com.zyz.shopping.fake;

import com.alibaba.fastjson.JSON;
import com.zyz.shopping.http.vo.OrderVO;
import com.zyz.shopping.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
@Slf4j
public class FakeCustomerService {

    @Autowired
    private OrderService orderService;

    @PostConstruct
    private void init() {
        // 通过访问controller接口，模拟用户下单的情况
        new Thread(() -> {
            while (true) {
                // 1拼接访问参数
                try {
                    log.info("开始模拟下单操作");
                    OrderVO orderVO = new OrderVO();
                    orderVO.setAddressId(getRandom(1, 10));
                    orderVO.setBookId(getRandom(2, 20));
                    orderVO.setBuyerId(getRandom(1, 10));
                    orderVO.setOnlinePlatform(getRandom(1, 5).toString());
                    orderVO.setOrderAmount(getRandom(30, 120).doubleValue());
                    orderVO.setRequireInvoice(new Random().nextBoolean());

                    log.info(JSON.toJSONString(orderVO));

                    orderService.save(orderVO);
                    Integer sleep = getRandom(600, 1200);
                    log.info("下单完成，开始睡眠:{}秒", sleep);

                    //睡眠10~60s
                    Thread.sleep(getRandom(10, 50) * 1000L);
                } catch (Exception e) {
                    log.error("出现错误", e);
                }
            }
        }).start();
    }


    private Integer getRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
