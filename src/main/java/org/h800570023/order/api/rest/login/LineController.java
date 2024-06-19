package org.h800570023.order.api.rest.login;//package org.h800570023.order.api.rest.login;
//
//import lombok.RequiredArgsConstructor;
//import org.h800570023.order.api.rest.user.notice.NotifyRequestDTO;
//import org.h800570023.order.api.rest.user.notice.NotifyService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequiredArgsConstructor
//public class LineController {
//
//    private final NotifyService notifyService;
//
//    @GetMapping("/api/line")
//    public String index(@RequestParam(name = "code") String code) {
//        NotifyRequestDTO notifyRequestDTO = new NotifyRequestDTO();
//        notifyRequestDTO.setToke(code);
//        notifyService.update(notifyRequestDTO);
//        return "redirect:index.html";
//    }
//}
