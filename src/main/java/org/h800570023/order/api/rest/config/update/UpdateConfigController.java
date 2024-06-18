package org.h800570023.order.api.rest.config.update;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.BaseReposeDTO;
import org.h800570023.order.api.commons.ApBusinessException;
import org.h800570023.order.api.rest.config.ConfigService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/config")
public class UpdateConfigController {


    private final ConfigService service;

    @PostMapping("/update")
    public BaseReposeDTO update(@RequestBody QuertConfigRequestDTO quertConfigRequestDTO) {
        BaseReposeDTO order = new BaseReposeDTO();
        try {
            service.update(quertConfigRequestDTO);
            order.setExCode("O");
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
