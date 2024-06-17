package org.h800570023.order.api.rest.login;

import lombok.Data;
import org.h800570023.order.api.BaseReposeDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoginReposeDTO extends BaseReposeDTO {
    private String userName;
    private String token;
    private List<UrlConfig> urls = new ArrayList<>();


    @Data
    public static class UrlConfig {
        private String urlId;
        private String label;
        private String url;
    }
}
