package com.zyz.shopping.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_order", schema = "duangduang", catalog = "")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OrderEntity {
    private int id;
    private String orderNum;
    private int buyerId;
    private int bookId;
    private int addressId;
    private Integer tradeStatus;
    private Integer payId;
    private String onlinePlatform;
    private Integer payStatus;
    private Double orderAmount;
    private Timestamp payDate;
    private String outerTradeNo;
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
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
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
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    public void setOuterTradeNo(String outerTradeNo) {
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
                buyerId == that.buyerId &&
                bookId == that.bookId &&
                addressId == that.addressId &&
                Objects.equals(orderNum, that.orderNum) &&
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
        return Objects.hash(id, orderNum, buyerId, bookId, addressId, tradeStatus, payId, onlinePlatform, payStatus, orderAmount, payDate, outerTradeNo, createDate, remark, requireInvoice);
    }
}
