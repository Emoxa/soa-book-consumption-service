package com.filrouge.consumption.entity;

import java.time.LocalDate;
import java.util.Objects;

public class BillEntity {

    /**
     * Consumer identification id
     **/
    private Long consumerid = null;
    private Currency currency = null;

    /**
     * Ending date of the time interval
     **/
    private LocalDate end = null;
    /**
     * Starting date of the time interval
     **/
    private LocalDate start = null;

    private Double value = null;

    public Long getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Long consumerid) {
        this.consumerid = consumerid;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

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
        BillEntity bill = (BillEntity) o;
        return Objects.equals(consumerid, bill.consumerid) && Objects.equals(currency, bill.currency)
                && Objects.equals(end, bill.end) && Objects.equals(start, bill.start)
                && Objects.equals(value, bill.value);
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
