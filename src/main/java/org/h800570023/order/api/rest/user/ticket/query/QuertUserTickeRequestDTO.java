package org.h800570023.order.api.rest.user.ticket.query;

import lombok.Data;

import java.util.Date;

@Data
public class QuertUserTickeRequestDTO {

    private String transactionId;
    private String status;
    private String name;
    private String phone;
    private String pickupTime;
    private String pickupCode;
    private String temperature;
}
