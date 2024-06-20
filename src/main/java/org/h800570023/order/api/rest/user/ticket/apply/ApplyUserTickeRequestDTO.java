package org.h800570023.order.api.rest.user.ticket.apply;

import lombok.Data;
import org.h800570023.order.api.rest.user.ticket.query.QuertUserTickeReposeDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ApplyUserTickeRequestDTO {

    private String transactionId;
    private String name;
    private String phone;
    private String pickupTime;
    private String status;
    private String temperature;
    private int total;
    private String pickupCode;
    private String email;
    private String memo;
    private String storeMemo;
    private int deposit;
    private List<QuertUserTickeReposeDTO.CreateOrderRequestItemDTO> items = new ArrayList<>();
}
