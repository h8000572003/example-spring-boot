package org.h800570023.order.api.rest.user.ticket.apply;

import lombok.Data;

@Data
public class ApplyStatusUserRequestDTO {
    private String transactionId;
    private String status;
    private String newStatus;
    private String storeMemo;
}
