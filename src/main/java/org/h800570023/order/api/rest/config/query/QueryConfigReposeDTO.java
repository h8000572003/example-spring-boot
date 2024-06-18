package org.h800570023.order.api.rest.config.query;

import lombok.Data;
import org.h800570023.order.api.BaseReposeDTO;

@Data
public class QueryConfigReposeDTO extends BaseReposeDTO {
    private String address;
    private String tel;
    private String isOpenOrder;
    private String url;
}
