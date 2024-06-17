package org.h800570023.order.api.rest.custom.craete;

import lombok.Data;
import org.h800570023.order.api.BaseReposeDTO;

@Data
public class CreateOrderReposeDTO extends BaseReposeDTO {
    private String transactionId;
}
