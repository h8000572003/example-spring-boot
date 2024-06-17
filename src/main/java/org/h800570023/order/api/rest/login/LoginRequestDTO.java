package org.h800570023.order.api.rest.login;

import lombok.Data;
import org.h800570023.order.api.BaseReposeDTO;

@Data
class LoginRequestDTO  {
    private String username;
    private String password;

    // getters and setters
}
