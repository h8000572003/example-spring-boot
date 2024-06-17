package org.h800570023.order.api.rest.custom.query;

import lombok.Data;

import java.util.Date;

@Data
public class QuertCustomTickeRequestDTO {

    private String transactionId;
    private String status;
    private String name;
    private String phone;
    private Date pickupTime;
    private String pickupCode;
    private String temperature;
}
