package org.h800570023.order.api.rest.custom.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.commons.ApBusinessException;
import org.h800570023.order.api.commons.OrderService;
import org.h800570023.order.api.rest.ticket.query.QuertUserTickeReposeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class QuertCustomTicketController {


    private final OrderService orderService;

    @PostMapping("/query")
    public QuertUserTickeReposeDTO creatOrder(@RequestBody QuertCustomTickeRequestDTO query) {
        QuertUserTickeReposeDTO order = new QuertUserTickeReposeDTO();
        try {
            QuertUserTickeReposeDTO quertUserTickeReposeDTO = orderService.queryCustom(query);
            if (quertUserTickeReposeDTO.getTickets().isEmpty()) {
                throw new ApBusinessException("查無資料確定輸入條件正確");
            }
            return quertUserTickeReposeDTO;
        } catch (ApBusinessException e) {
            log.info("createOrder error", e);
            order.setExCode("X");
            order.setExMessage(e.getMessage());
            return order;
        } catch (Exception e) {
            log.info("createOrder error", e);
            order.setExCode("X");
            order.setExMessage("系統異常");
            return order;
        }
    }

}
