package com.filrouge.consumption.ws.rest.entity;

import com.filrouge.consumption.entity.BillEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


public class Bill {

    private Long consumerid = null;
    private String currency = null;
    private String end = null;
    private String start = null;
    private Double value = null;

    public static Bill convertBillEntity2Bill(BillEntity bill) {
        Bill billRest = new Bill().consumerid(bill.getConsumerid()).currency(bill.getCurrency().name())
                .value(bill.getValue());
        if (bill.getEnd() != null) billRest.end(bill.getEnd().toString());
        if (bill.getStart() != null) billRest.start(bill.getStart().toString());
        return billRest;
    }

    /**
     * Consumer identification id
     **/
    public Bill consumerid(Long consumerid) {
        this.consumerid = consumerid;
        return this;
    }

    @ApiModelProperty(example = "null", value = "Consumer identification id")
    public Long getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Long consumerid) {
        this.consumerid = consumerid;
    }

    /**
     **/
    public Bill currency(String currency) {
        this.currency = currency;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Ending date of the time interval
     **/
    public Bill end(String end) {
        this.end = end;
        return this;
    }

    @ApiModelProperty(example = "null", value = "Ending date of the time interval")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Starting date of the time interval
     **/
    public Bill start(String start) {
        this.start = start;
        return this;
    }

    @ApiModelProperty(example = "null", value = "Starting date of the time interval")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    /**
     **/
    public Bill value(Double value) {
        this.value = value;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bill bill = (Bill) o;
        return Objects.equals(consumerid, bill.consumerid) &&
                Objects.equals(currency, bill.currency) &&
                Objects.equals(end, bill.end) &&
                Objects.equals(start, bill.start) &&
                Objects.equals(value, bill.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumerid, currency, end, start, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bill {\n");

        sb.append("    consumerid: ").append(toIndentedString(consumerid)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
