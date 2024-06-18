package org.h800570023.order.api.rest.config.update;

import lombok.Data;

@Data
public class QuertConfigRequestDTO {
    private String address;
    private String tel;
    private String isOpenOrder;
    private String url;

}
