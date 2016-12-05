package com.filrouge.consumption.ws.rest.entity;

import com.filrouge.consumption.entity.ConsumptionEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class Consumption {

    private String end = null;
    private String start = null;
    private Double value = null;

    public static Consumption convertBillEntity2Bill(ConsumptionEntity consumption) {
        Consumption consumptionRest = new Consumption().value(consumption.getValue());
        if (consumption.getEnd() != null) consumptionRest.end(consumption.getEnd().toString());
        if (consumption.getStart() != null) consumptionRest.start(consumption.getStart().toString());
        return consumptionRest;
    }

    /**
     **/
    public Consumption end(String end) {
        this.end = end;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     **/
    public Consumption start(String start) {
        this.start = start;
        return this;
    }

    @ApiModelProperty(example = "null", value = "")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    /**
     **/
    public Consumption value(Double value) {
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
        Consumption consumption = (Consumption) o;
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
