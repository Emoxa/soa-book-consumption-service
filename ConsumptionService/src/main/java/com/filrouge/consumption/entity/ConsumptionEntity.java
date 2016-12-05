package com.filrouge.consumption.entity;

import java.time.LocalDate;
import java.util.Objects;

public class ConsumptionEntity {

    private LocalDate end = null;
    private LocalDate start = null;
    private Double value = null;

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

    /**
     **/
    public ConsumptionEntity value(Double value) {
        this.value = value;
        return this;
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
        ConsumptionEntity consumption = (ConsumptionEntity) o;
        return Objects.equals(end, consumption.end) && Objects.equals(start, consumption.start)
                && Objects.equals(value, consumption.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(end, start, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Consumption {\n");

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
