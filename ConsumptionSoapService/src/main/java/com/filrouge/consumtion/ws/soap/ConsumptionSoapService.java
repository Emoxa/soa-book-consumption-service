package com.filrouge.consumtion.ws.soap;

import com.filrouge.consumption.entity.BillEntity;
import com.filrouge.consumption.entity.ConsumptionEntity;
import com.filrouge.consumption.entity.ConsumptionMode;
import com.filrouge.consumption.entity.Period;
import com.filrouge.consumption.service.ConsumptionService;
import com.filrouge.consumption.service.impl.ConsumptionServiceImpl;
import com.filrouge.consumtion.ws.soap.entity.SoapLocalDateParam;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.BindingType;

@WebService(serviceName = "ConsumptionWS", portName = "ConsumptionWebService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL)
public class ConsumptionSoapService {

    /**
     * TODO use @Inject instead because it's ugly otherwise
     **/
    private ConsumptionService consumptionService = new ConsumptionServiceImpl();

    @WebMethod(operationName = "getPowerConsumptionByConsumerId")
    @WebResult(name = "consumption")
    public ConsumptionEntity getPowerConsumptionByConsumerId(
            @WebParam(name = "consumerId") @XmlElement(required = true) Long consumerId,
            @WebParam(name = "filter") String filter, @WebParam(name = "period") String period,
            @WebParam(name = "from") SoapLocalDateParam from,
            @WebParam(name = "to") SoapLocalDateParam to) {
        return consumptionService.getPowerConsumptionByConsumerId(consumerId,
                ConsumptionMode.getOptionalValueOf(filter),
                Period.getOptionalValueOf(period), SoapLocalDateParam.getLocalDateOrNull(from),
                SoapLocalDateParam.getLocalDateOrNull(to));
    }

    @WebMethod(operationName = "getPowerConsumptionByBlock")
    @WebResult(name = "consumption")
    public ConsumptionEntity getPowerConsumptionByBlock(
            @WebParam(name = "blockId") @XmlElement(required = true) Long blockId,
            @WebParam(name = "filter") String filter, @WebParam(name = "period") String period,
            @WebParam(name = "from") SoapLocalDateParam from,
            @WebParam(name = "to") SoapLocalDateParam to) {
        return consumptionService.getPowerConsumptionByBlock(blockId,
                ConsumptionMode.getOptionalValueOf(filter), Period.getOptionalValueOf(period),
                SoapLocalDateParam.getLocalDateOrNull(from),
                SoapLocalDateParam.getLocalDateOrNull(to));
    }

    @WebMethod(operationName = "computePowerConsumptionEstimatedBillByApplianceId")
    @WebResult(name = "bill")
    public BillEntity computePowerConsumptionEstimatedBillByApplianceId(@WebParam(name = "consumerId") @XmlElement(required = true) Long consumerId, @WebParam(name = "applianceId") @XmlElement(required = true) Long applianceId,
                                                                        @WebParam(name = "filter") String filter, @WebParam(name = "period") String period, @WebParam(name = "from") SoapLocalDateParam from, @WebParam(name = "to") SoapLocalDateParam to) {

        return consumptionService.computePowerConsumptionEstimatedBillByApplianceId(consumerId, applianceId, ConsumptionMode.getOptionalValueOf(filter), Period.getOptionalValueOf(period), SoapLocalDateParam.getLocalDateOrNull(from), SoapLocalDateParam.getLocalDateOrNull(to));
    }

    @WebMethod(operationName = "computePowerConsumptionEstimatedBillById")
    @WebResult(name = "bill")
    public BillEntity computePowerConsumptionEstimatedBillById(@WebParam(name = "consumerId") @XmlElement(required = true) Long consumerId, @WebParam(name = "filter") String filter,
                                                               @WebParam(name = "period") String period, @WebParam(name = "from") SoapLocalDateParam from, @WebParam(name = "to") SoapLocalDateParam to) {
        return consumptionService.computePowerConsumptionEstimatedBillById(consumerId, ConsumptionMode.getOptionalValueOf(filter), Period.getOptionalValueOf(period), SoapLocalDateParam.getLocalDateOrNull(from), SoapLocalDateParam.getLocalDateOrNull(to));
    }

    @WebMethod(operationName = "getPowerConsumptionByApplianceId")
    @WebResult(name = "consumption")
    public ConsumptionEntity getPowerConsumptionByApplianceId(@WebParam(name = "consumerId") @XmlElement(required = true) Long consumerId, @WebParam(name = "applianceId") @XmlElement(required = true) Long applianceId,
                                                              @WebParam(name = "filter") String filter, @WebParam(name = "period") String period, @WebParam(name = "from") SoapLocalDateParam from, @WebParam(name = "to") SoapLocalDateParam to) {
        return consumptionService.getPowerConsumptionByApplianceId(consumerId, applianceId, ConsumptionMode.getOptionalValueOf(filter), Period.getOptionalValueOf(period), SoapLocalDateParam.getLocalDateOrNull(from), SoapLocalDateParam.getLocalDateOrNull(to));
    }


}
