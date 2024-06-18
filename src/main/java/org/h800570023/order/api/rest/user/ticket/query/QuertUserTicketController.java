package org.h800570023.order.api.rest.user.ticket.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.commons.ApBusinessException;
import org.h800570023.order.api.commons.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class QuertUserTicketController {


    private final OrderService orderService;

    @PostMapping("/query")
    public QuertUserTickeReposeDTO creatOrder(@RequestBody QuertUserTickeRequestDTO query) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        QuertUserTickeReposeDTO order = new QuertUserTickeReposeDTO();
        try {
            return orderService.query(query);
        } catch (ApBusinessException e) {
            log.info("createOrder error", e);
            order.setExCode("X");
            order.setExMessage(e.getMessage());
            return order;
        }catch (Exception e) {
            log.info("createOrder error", e);
            order.setExCode("X");
            order.setExMessage("系統異常");
            return order;
        }
    }

}
