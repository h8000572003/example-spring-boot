package org.h800570023.order.api.rest.custom.config.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.commons.ApBusinessException;
import org.h800570023.order.api.rest.config.ConfigService;
import org.h800570023.order.api.rest.config.query.QueryConfigReposeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/custom/config")
public class QuertCustomerConfigController {


    private final ConfigService service;

    @PostMapping("/query")
    public QueryConfigReposeDTO creatOrder() {
        QueryConfigReposeDTO order = new QueryConfigReposeDTO();
        try {
            return service.query();
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
