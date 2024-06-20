package org.h800570023.order.api.rest.user.ticket.query;

import lombok.Data;
import org.h800570023.order.api.BaseReposeDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuertUserTickeReposeDTO extends BaseReposeDTO {

    private List<CreateOrderRequestTicketDTO> tickets = new ArrayList<>();

    @Data
    public static class CreateOrderRequestTicketDTO {
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
        private String changeLog = "";
        private List<CreateOrderRequestItemDTO> items = new ArrayList<>();
    }

    @Data
    public static class CreateOrderRequestItemDTO {
        private String title;
        private int quantity;
        private String code;
        private int price;

    }
}
