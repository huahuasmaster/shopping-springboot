package com.zyz.shopping.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_order", schema = "duangduang", catalog = "")
public class OrderEntity {
    private int id;
    private String orderNum;
    private Integer buyerId;
    private Integer tradeStatus;
    private Integer payId;
    private String onlinePlatform;
    private Integer payStatus;
    private Integer orderAmount;
    private Timestamp payDate;
    private Integer outerTradeNo;
    private Timestamp createDate;
    private String remark;
    private Byte requireInvoice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_num")
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "buyer_id")
    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "trade_status")
    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Basic
    @Column(name = "pay_id")
    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    @Basic
    @Column(name = "online_platform")
    public String getOnlinePlatform() {
        return onlinePlatform;
    }

    public void setOnlinePlatform(String onlinePlatform) {
        this.onlinePlatform = onlinePlatform;
    }

    @Basic
    @Column(name = "pay_status")
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "order_amount")
    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "pay_date")
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "outer_trade_no")
    public Integer getOuterTradeNo() {
        return outerTradeNo;
    }

    public void setOuterTradeNo(Integer outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "require_invoice")
    public Byte getRequireInvoice() {
        return requireInvoice;
    }

    public void setRequireInvoice(Byte requireInvoice) {
        this.requireInvoice = requireInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id &&
                Objects.equals(orderNum, that.orderNum) &&
                Objects.equals(buyerId, that.buyerId) &&
                Objects.equals(tradeStatus, that.tradeStatus) &&
                Objects.equals(payId, that.payId) &&
                Objects.equals(onlinePlatform, that.onlinePlatform) &&
                Objects.equals(payStatus, that.payStatus) &&
                Objects.equals(orderAmount, that.orderAmount) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(outerTradeNo, that.outerTradeNo) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(requireInvoice, that.requireInvoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNum, buyerId, tradeStatus, payId, onlinePlatform, payStatus, orderAmount, payDate, outerTradeNo, createDate, remark, requireInvoice);
    }
}
