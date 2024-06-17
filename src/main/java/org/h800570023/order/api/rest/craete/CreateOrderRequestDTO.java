package org.h800570023.order.api.rest.craete;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CreateOrderRequestDTO {
    private String name;
    private String phone;
    private Date pickupTime;//取貨日期
    private String email;
    private String pickupCode;//取貨時間
    private String memo;
    private List<CreateOrderRequestItemDTO> items=new ArrayList<>();

    @Data
    public static class CreateOrderRequestItemDTO{
        private String title;
        private int quantity;

    }
}
