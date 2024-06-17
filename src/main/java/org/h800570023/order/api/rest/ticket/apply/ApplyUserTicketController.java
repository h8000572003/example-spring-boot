package org.h800570023.order.api.rest.ticket.apply;

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
public class ApplyUserTicketController {


    private final OrderService orderService;

    /**
     * 審查
     * @param query
     * @return
     */
    @PostMapping("/apply")
    public ApplyUserTickeReposeDTO apply(@RequestBody ApplyUserTickeRequestDTO query) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        ApplyUserTickeReposeDTO order = new ApplyUserTickeReposeDTO();
        try {
            return orderService.apply(query);
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
    @PostMapping("/update")
    public ApplyUserTickeReposeDTO update(@RequestBody ApplyUserTickeRequestDTO query) {
        ApplyUserTickeReposeDTO order = new ApplyUserTickeReposeDTO();
        try {
            return orderService.update(query);
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
    @PostMapping("/reject")
    public ApplyUserTickeReposeDTO reject(@RequestBody ApplyUserTickeRequestDTO query) {
        ApplyUserTickeReposeDTO order = new ApplyUserTickeReposeDTO();
        try {
            return orderService.reject(query);
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
