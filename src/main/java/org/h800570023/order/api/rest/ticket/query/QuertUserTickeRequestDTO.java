package org.h800570023.order.api.rest.ticket.query;

import lombok.Data;

import java.util.Date;

@Data
public class QuertUserTickeRequestDTO {

    private String transactionId;
    private String status;
    private String name;
    private String phone;
    private Date pickupTime;
    private String pickupCode;
    private String temperature;
}
