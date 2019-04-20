package com.zyz.shopping.fake;

import com.alibaba.fastjson.JSON;
import com.zyz.shopping.bury.BuryDTO;
import com.zyz.shopping.bury.KafkaUtil;
import com.zyz.shopping.dao.BookRepository;
import com.zyz.shopping.dao.entity.BookEntity;
import com.zyz.shopping.http.vo.OrderVO;
import com.zyz.shopping.http.vo.PayVO;
import com.zyz.shopping.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class FakeCustomerService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookRepository bookRepository;

    private ExecutorService executor;

    private List<BookEntity> bookEntities;


    @Autowired
    private KafkaUtil kafkaUtil;

    @PostConstruct
    private void init() {
        executor = Executors.newCachedThreadPool();
        bookEntities = bookRepository.findAll();

        // 通过访问controller接口，模拟用户下单的情况
        new Thread(() -> {
            while (true) {
                // 1拼接访问参数
                try {
                    log.info("开始提交下单流程");
                    new Thread(getTask()).start();
                    long sleep = getRandom(60, 180) * 1000L;
                    log.info("开始睡眠{}", sleep);
                    Thread.sleep(sleep);

                } catch (Exception e) {
                    log.error("出现错误", e);
                }
            }
        }).start();
    }

    private Runnable getTask() {
        return () -> {
            try {
                BookEntity entity = bookEntities.get(getRandom(0, bookEntities.size() - 1));

                OrderVO orderVO = new OrderVO();
                orderVO.setAddressId(getRandom(1, 10));
                orderVO.setBookId(entity.getId());
                orderVO.setBuyerId(getRandom(1, 10));
                orderVO.setOnlinePlatform(getRandom(1, 5).toString());
                orderVO.setOrderAmount(entity.getPrice().doubleValue());
                orderVO.setRequireInvoice(new Random().nextBoolean());

                PayVO payVO = new PayVO();
                payVO.setOnlinePlatform(orderVO.getOnlinePlatform());
                payVO.setOuterTradeNo("test");
                payVO.setPayDate(System.currentTimeMillis() + 60 * 1000);


                log.info("开始进入首页");
                BuryDTO atHome = BuryDTO.fromBase(orderVO.getBuyerId(),"at_home", "/", System.currentTimeMillis());
                kafkaUtil.send(JSON.toJSONString(atHome));
                if (!wannaContinue(90)) {
                    log.info("进入首页后退出");
                    return;
                }
                Thread.sleep((getRandom(4, 15)) * 1000);

                log.info("开始点击查看书籍");
                BuryDTO checkBook = BuryDTO.fromBase(orderVO.getBuyerId(),"check_book", "/", System.currentTimeMillis());
                injectMap(checkBook, "book", entity);
                kafkaUtil.send(JSON.toJSONString(checkBook));
                if (!wannaContinue(90)) {
                    log.info("点开书籍信息后退出");
                    return;
                }
                Thread.sleep((getRandom(15, 20)) * 1000);

                log.info("开始模拟确认订单操作");
                BuryDTO goBuying = BuryDTO.fromBase(orderVO.getBuyerId(),"go_buying", "/buy/" + orderVO.getBookId(), System.currentTimeMillis());
                injectMap(goBuying, "book", entity);
                kafkaUtil.send(JSON.toJSONString(goBuying));
                if (!wannaContinue(90)) {
                    log.info("查看购物车之后退出");
                    return;
                }
                Thread.sleep((getRandom(6, 20) * 1000));

                log.info("开始模拟下单操作");
                BuryDTO tryPlaceOrder = BuryDTO.fromBase(orderVO.getBuyerId(),"try_place_order", "/buy/" + orderVO.getBookId(), System.currentTimeMillis());
                injectMap(tryPlaceOrder, "params", orderVO);
                kafkaUtil.send(JSON.toJSONString(tryPlaceOrder));
                orderService.save(orderVO);
                if (!wannaContinue(90)) {
                    log.info("下单后放弃支付");
                    return;
                }
                Thread.sleep((getRandom(7,12) * 1000));

                log.info("开始模拟支付操作");
                BuryDTO tryPay = BuryDTO.fromBase(orderVO.getBuyerId(),"try_pay", "/buy/" + orderVO.getBookId(), System.currentTimeMillis());
                injectMap(tryPay, "params", payVO);


                log.info("用户{}的购买操作已全部结束", orderVO.getBuyerId());

            } catch (InterruptedException i) {
                log.info("线程睡眠时被中断");
            } catch (Exception e) {
                log.error("发生错误", e);
            }
        };
    }


    private Integer getRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    private boolean wannaContinue(int percent) {
        return getRandom(0, 100) <= percent;
    }


    private void injectMap(BuryDTO dto, String key, Object o) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, o);
        dto.setData(map);
    }
}
