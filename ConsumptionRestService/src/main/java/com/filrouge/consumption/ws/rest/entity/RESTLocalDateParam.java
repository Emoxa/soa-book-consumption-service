package com.filrouge.consumption.ws.rest.entity;

import java.time.LocalDate;

public class RESTLocalDateParam {

    private LocalDate localDate;

    /**
     * This is the default constructor which must take in one string parameter.
     * The parameter is no other than the one passed in through the REST
     * end-point. We'll see it later...
     */
    public RESTLocalDateParam(String dateStr) {
        localDate = LocalDate.parse(dateStr);
    }

    /**
     * This is a getter method which returns the parsed date string value as LocalDate
     */
    public static LocalDate getLocalDateOrNull(RESTLocalDateParam restLocalDate) {
        if (restLocalDate != null) return restLocalDate.getLocalDate();
        return null;
    }

    /**
     * This is a getter method which returns the parsed date string value as LocalDate
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * For convenience of result checking
     */
    @Override
    public String toString() {
        if (localDate != null) {
            return localDate.toString();
        } else {
            return "";
        }
    }
}
