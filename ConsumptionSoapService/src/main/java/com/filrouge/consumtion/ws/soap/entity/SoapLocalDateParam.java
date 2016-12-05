package com.filrouge.consumtion.ws.soap.entity;

import java.time.LocalDate;

public class SoapLocalDateParam {
    private LocalDate localDate;

    public SoapLocalDateParam() {
        localDate = null;
    }

    /**
     * This is the default constructor which must take in one string parameter.
     * The parameter is no other than the one passed in through the REST
     * end-point. We'll see it later...
     */
    public SoapLocalDateParam(String dateStr) {
        localDate = LocalDate.parse(dateStr);
    }

    /**
     * This is a getter method which returns the parsed date string value as LocalDate
     */
    public static LocalDate getLocalDateOrNull(SoapLocalDateParam soapLocalDate) {
        if (soapLocalDate != null) return soapLocalDate.getLocalDate();
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
