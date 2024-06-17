package org.h800570023.order.api.rest.custom.craete;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h800570023.order.api.commons.ApBusinessException;
import org.h800570023.order.api.commons.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顧客訂單服務
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CreateCustomerOrderController {


    private final OrderService orderService;

    @PostMapping("/createOrder")
    public CreateOrderReposeDTO creatOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO) {
        CreateOrderReposeDTO order = new CreateOrderReposeDTO();
        try {
            return orderService.createOrder(createOrderRequestDTO);
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
