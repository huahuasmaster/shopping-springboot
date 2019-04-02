package com.zyz.shopping.service;

import com.alibaba.fastjson.JSON;
import com.zyz.shopping.dao.OrderRepository;
import com.zyz.shopping.dao.entity.OrderEntity;
import com.zyz.shopping.exception.DuangDuangException;
import com.zyz.shopping.http.vo.OrderVO;
import com.zyz.shopping.http.vo.PayVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 提交订单
     * @param orderVO 入参
     * @return 新订单id
     */
    public String save(OrderVO orderVO) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderVO, orderEntity);
        orderEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        String orderNum = getOrderNum(orderVO);
        orderEntity.setOrderNum(orderNum);
        orderEntity.setTradeStatus(0);
        orderEntity.setPayStatus(0);
        orderEntity.setRequireInvoice(orderVO.getRequireInvoice() ? Byte.parseByte("1") : Byte.parseByte("0"));
        log.info("即将存入订单表:{}", JSON.toJSONString(orderEntity));
        orderRepository.save(orderEntity);

        return orderNum;
    }

    /**
     * 将订单修改为已支付状态
     *
     * @param orderNum
     * @return
     */
    public Integer payOrder(String orderNum, PayVO payVO) {
        OrderEntity orderEntity = orderRepository.findByOrderNum(orderNum);
        // 如果订单已经支付
        if (!orderEntity.getTradeStatus().equals(0) || orderEntity.getPayStatus().equals(4) || orderEntity.getPayStatus().equals(2)) {
            throw new DuangDuangException("该笔订单已经支付");
        }
        // 订单状态改为已完成
        orderEntity.setTradeStatus(1);
        // 支付状态改为已支付
        orderEntity.setPayStatus(2);
        // 填入支付平台
        orderEntity.setOnlinePlatform(payVO.getOnlinePlatform());
        // 填入第三方流水号
        orderEntity.setOuterTradeNo(payVO.getOuterTradeNo());
        // 填入支付时间
        orderEntity.setPayDate(new Timestamp(payVO.getPayDate()));
//        log.info("即将存入订单表:{}", JSON.toJSONString(orderEntity));

        orderRepository.save(orderEntity);
        return 1;

    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    public Integer cancelOrder(Integer orderId) {
        return 0;
    }

    private String getOrderNum(OrderVO orderVO) {
        return String.valueOf(orderVO.getBookId()) +
                orderVO.getBuyerId() +
                System.currentTimeMillis();
    }
}
