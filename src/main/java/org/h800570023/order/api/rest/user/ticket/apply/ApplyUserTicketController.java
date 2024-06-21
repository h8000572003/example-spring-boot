package org.h800570023.order.api.rest.user.ticket.apply;

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
     * 狀態變更
     *
     * @return
     */
    @PostMapping("/updateStatus")
    public ApplyUserTickeReposeDTO apply(@RequestBody ApplyStatusUserRequestDTO applyDTO) {
        ApplyUserTickeReposeDTO order = new ApplyUserTickeReposeDTO();
        try {
            orderService.apply(applyDTO);
            return order;
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



}
