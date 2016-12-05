package com.filrouge.consumption.ws.rest;

import com.filrouge.consumption.entity.BillEntity;
import com.filrouge.consumption.entity.ConsumptionEntity;
import com.filrouge.consumption.entity.ConsumptionMode;
import com.filrouge.consumption.entity.Period;
import com.filrouge.consumption.service.ConsumptionService;
import com.filrouge.consumption.ws.rest.entity.Bill;
import com.filrouge.consumption.ws.rest.entity.Consumption;
import com.filrouge.consumption.ws.rest.entity.RESTLocalDateParam;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/consumer")
@Api()
@SwaggerDefinition(info = @Info(
        description = "This API offers allows survey of electric consumption./n "
                + "Made </br> by <a href='https://api.filrouge.com'>filrouge</a>",
        version = "1.0.0",
        title = "Consumption API",
        contact = @Contact(name = "API Team", url = "http://api.filrouge.com", email = "apiteam@filrouge.com"),
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
),
        host = "api.filrouge.com",
        basePath = "/consumption/v1",
        tags = {
                @Tag(name = "Consumer", description = "Operations about consumers consumption and billing follow-up"),
                @Tag(name = "Block", description = "Operations about grid's block consumption follow-up")
        },
        externalDocs = @ExternalDocs(value = "Find out more about FilRouge", url = "http://filrouge.com/info")
)
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen",
        date = "2016-11-24T11:24:31.234+01:00")
@Named
public class ConsumerApi {

    @Inject
    private ConsumptionService consumptionService;

    @GET
    @Path("/{consumerId}")
    @Produces({"application/json"})
    @ApiOperation(value = "Returns the consumption of a consumer", notes = "",
            response = Consumption.class, tags = {"Consumer"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Consumption.class),
            @ApiResponse(code = 400, message = "Invalid Request", response = Consumption.class)})
    public Response getPowerConsumptionByConsumerId(@PathParam("consumerId") Long consumerId,
                                                    @QueryParam("filter") String filter, @QueryParam("period") String period,
                                                    @QueryParam("from") RESTLocalDateParam from, @QueryParam("to") RESTLocalDateParam to) {
        ConsumptionEntity consumption = consumptionService.getPowerConsumptionByConsumerId(
                consumerId, ConsumptionMode.getOptionalValueOf(filter),
                Period.getOptionalValueOf(period), RESTLocalDateParam.getLocalDateOrNull(from),
                RESTLocalDateParam.getLocalDateOrNull(to));
        ResponseBuilder responseBuilder = Response.accepted().entity(
                Consumption.convertBillEntity2Bill(consumption));
        return responseBuilder.build();
    }

    @GET
    @Path("/{consumerId}/appliance/{applianceId}/bill")
    @ApiOperation(value = "Returns the estimated bill amount for the Consumer Appliance",
            notes = "", response = Bill.class, tags = {"Consumer",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Bill.class)})
    public Response computePowerConsumptionEstimatedBillByApplianceId(
            @PathParam("consumerId") Long consumerId, @PathParam("applianceId") Long applianceId,
            @QueryParam("filter") String filter, @QueryParam("period") String period,
            @QueryParam("from") RESTLocalDateParam from, @QueryParam("to") RESTLocalDateParam to) {
        BillEntity bill = consumptionService.computePowerConsumptionEstimatedBillByApplianceId(
                consumerId, applianceId, ConsumptionMode.getOptionalValueOf(filter),
                Period.getOptionalValueOf(period), RESTLocalDateParam.getLocalDateOrNull(from),
                RESTLocalDateParam.getLocalDateOrNull(to));
        ResponseBuilder responseBuilder = Response.accepted().entity(
                Bill.convertBillEntity2Bill(bill));
        return responseBuilder.build();
    }

    @GET
    @Path("/{consumerId}/bill")
    @Produces({"application/json"})
    @ApiOperation(value = "Returns the estimated bill amount for the Consumer",
            notes = "Returns the bill", response = Bill.class, tags = {"Consumer",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Bill.class),
            @ApiResponse(code = 400, message = "Invalid Request", response = Bill.class),
            @ApiResponse(code = 404, message = "There is no such customer", response = Bill.class)})
    public Response computePowerConsumptionEstimatedBillById(
            @PathParam("consumerId") Long consumerId, @QueryParam("filter") String filter,
            @QueryParam("period") String period, @QueryParam("from") RESTLocalDateParam from,
            @QueryParam("to") RESTLocalDateParam to) {
        BillEntity bill = consumptionService.computePowerConsumptionEstimatedBillById(consumerId,
                ConsumptionMode.getOptionalValueOf(filter), Period.getOptionalValueOf(period),
                RESTLocalDateParam.getLocalDateOrNull(from),
                RESTLocalDateParam.getLocalDateOrNull(to));
        ResponseBuilder responseBuilder = Response.accepted().entity(
                Bill.convertBillEntity2Bill(bill));
        return responseBuilder.build();
    }

    @GET
    @Path("/{consumerId}/appliance/{applianceId}")
    @ApiOperation(value = "Returns the consumption By Consumer Appliance", notes = "",
            response = Consumption.class, tags = {"Consumer",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Consumption.class)})
    public Response getPowerConsumptionByApplianceId(@PathParam("consumerId") Long consumerId,
                                                     @PathParam("applianceId") Long applianceId, @QueryParam("filter") String filter,
                                                     @QueryParam("period") String period, @QueryParam("from") RESTLocalDateParam from,
                                                     @QueryParam("to") RESTLocalDateParam to) {
        ConsumptionEntity consumption = consumptionService.getPowerConsumptionByApplianceId(
                consumerId, applianceId, ConsumptionMode.getOptionalValueOf(filter),
                Period.getOptionalValueOf(period), RESTLocalDateParam.getLocalDateOrNull(from),
                RESTLocalDateParam.getLocalDateOrNull(to));
        ResponseBuilder responseBuilder = Response.accepted().entity(
                Consumption.convertBillEntity2Bill(consumption));
        return responseBuilder.build();
    }
}
