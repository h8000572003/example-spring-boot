package org.h800570023.order.api.rest.user.notice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.BaseReposeDTO;
import org.h800570023.order.api.commons.ApBusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserNotfrontroller {
    private final NotifyService notfiyService;

    @PostMapping("/line")
    public BaseReposeDTO creatOrder(@RequestBody NotifyRequestDTO query) {
        BaseReposeDTO order = new BaseReposeDTO();
        try {
            notfiyService.update(query);
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

}