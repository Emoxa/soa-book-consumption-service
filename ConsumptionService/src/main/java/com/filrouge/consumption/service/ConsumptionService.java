package com.filrouge.consumption.service;

import com.filrouge.consumption.entity.BillEntity;
import com.filrouge.consumption.entity.ConsumptionEntity;
import com.filrouge.consumption.entity.ConsumptionMode;
import com.filrouge.consumption.entity.Period;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Offers operations about consumption.
 */
public interface ConsumptionService {

    /**
     * Returns the consumption of a consumer
     */
    ConsumptionEntity getPowerConsumptionByConsumerId(Long consumerId,
                                                      Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to);

    /**
     * Returns the consumption of the targeted Block
     */
    ConsumptionEntity getPowerConsumptionByBlock(Long blockId,
                                                 Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to);

    /**
     * Returns the estimated bill amount for the Consumer Appliance
     */
    BillEntity computePowerConsumptionEstimatedBillByApplianceId(Long consumerId,
                                                                 Long applianceId, Optional<ConsumptionMode> filter, Optional<Period> period,
                                                                 LocalDate from, LocalDate to);

    /**
     * Returns the estimated bill amount for the Consumer
     */
    BillEntity computePowerConsumptionEstimatedBillById(Long consumerId,
                                                        Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to);

    /**
     * Returns the consumption By Consumer Appliance
     */
    ConsumptionEntity getPowerConsumptionByApplianceId(Long consumerId, Long applianceId,
                                                       Optional<ConsumptionMode> filter, Optional<Period> period, LocalDate from, LocalDate to);
}
