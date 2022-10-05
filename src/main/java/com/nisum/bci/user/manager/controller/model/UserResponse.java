package com.nisum.bci.user.manager.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String userId;

    private String created;

    private String modified;

    private String lastLogin;

    private String token;

    private String isActive;

}
