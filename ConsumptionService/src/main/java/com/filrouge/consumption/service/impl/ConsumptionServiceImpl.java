package com.filrouge.consumption.service.impl;

import com.filrouge.consumption.entity.*;
import com.filrouge.consumption.service.ConsumptionService;

import javax.inject.Named;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import java.util.Optional;


@Named
public class ConsumptionServiceImpl implements ConsumptionService {

    public ConsumptionEntity getPowerConsumptionByBlock(Long blockId, Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to) {
        Objects.requireNonNull(blockId, "blockId must not be null");
        printArg("getPowerConsumptionByBlock", blockId, filter, period, from, to);
        return getFakeConsumption(from, to);
    }

    public BillEntity computePowerConsumptionEstimatedBillByApplianceId(Long consumerId, Long applianceId, Optional<ConsumptionMode> filter,
                                                                        Optional<Period> period, LocalDate from, LocalDate to) {
        Objects.requireNonNull(consumerId, "consumerId must not be null");
        Objects.requireNonNull(applianceId, "applianceId must not be null");
        printArg2("computePowerConsumptionEstimatedBillByApplianceId", consumerId, applianceId, filter, period, from, to);
        return getFakeBill(consumerId, from, to);
    }

    public BillEntity computePowerConsumptionEstimatedBillById(Long consumerId, Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from,
                                                               LocalDate to) {
        Objects.requireNonNull(consumerId, "consumerId must not be null");
        printArg("computePowerConsumptionEstimatedBillById", consumerId, filter, period, from, to);
        return getFakeBill(consumerId, from, to);
    }


    public ConsumptionEntity getPowerConsumptionByApplianceId(Long consumerId, Long applianceId, Optional<ConsumptionMode> filter, Optional<Period> period,
                                                              LocalDate from, LocalDate to) {
        Objects.requireNonNull(consumerId, "consumerId must not be null");
        Objects.requireNonNull(applianceId, "applianceId must not be null");
        printArg2("getPowerConsumptionByApplianceId", consumerId, applianceId, filter, period, from, to);
        return getFakeConsumption(from, to);
    }

    public ConsumptionEntity getPowerConsumptionByConsumerId(Long consumerId, Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from,
                                                             LocalDate to) {
        Objects.requireNonNull(consumerId, "consumerId must not be null");
        printArg("getPowerConsumptionByConsumerId", consumerId, filter, period, from, to);
        return getFakeConsumption(from, to);
    }

    private void printArg(String methodName, Long id, Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to) {
        System.out.println("*********printArg**********");
        System.out.println("methodName = " + methodName);
        System.out.println("id = " + id);
        System.out.println("filter = " + filter);
        System.out.println("period = " + period);
        System.out.println("from = " + from);
        System.out.println("to = " + to);
        System.out.println("********************");
    }

    private void printArg2(String methodName, Long consumerId, Long applianceId, Optional<ConsumptionMode> filter,
                           Optional<Period> period, LocalDate from, LocalDate to) {
        System.out.println("********printArg2***********");
        System.out.println("methodName = " + methodName);
        System.out.println("consumerId = " + consumerId);
        System.out.println("applianceId = " + applianceId);
        System.out.println("filter = " + filter);
        System.out.println("period = " + period);
        System.out.println("from = " + from);
        System.out.println("to = " + to);
        System.out.println("********************");
    }

    private ConsumptionEntity getFakeConsumption() {
        ConsumptionEntity consumption = new ConsumptionEntity();

        LocalDate start = LocalDate.of(2016, Month.AUGUST, 22);
        consumption.setStart(start);

        LocalDate end = LocalDate.of(2016, Month.NOVEMBER, 10);
        consumption.setEnd(end);
        consumption.setValue(14.0);

        return consumption;
    }

    private BillEntity getFakeBill(Long id) {
        BillEntity bill = new BillEntity();

        LocalDate start = LocalDate.of(2016, Month.AUGUST, 22);
        bill.setStart(start);

        LocalDate end = LocalDate.of(2016, Month.NOVEMBER, 10);
        bill.setEnd(end);

        bill.setCurrency(Currency.Euro);
        bill.setValue(14.0);
        bill.setConsumerid(id);

        return bill;
    }

    private ConsumptionEntity getFakeConsumption(LocalDate from, LocalDate to) {
        ConsumptionEntity consumptionEntity = getFakeConsumption();
        consumptionEntity.setStart(from);
        consumptionEntity.setEnd(to);
        return consumptionEntity;
    }

    private BillEntity getFakeBill(Long consumerId, LocalDate from, LocalDate to) {
        BillEntity billEntity = getFakeBill(consumerId);
        billEntity.setStart(from);
        billEntity.setEnd(to);
        return billEntity;
    }

}
