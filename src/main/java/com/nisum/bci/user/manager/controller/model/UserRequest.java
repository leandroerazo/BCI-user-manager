package com.nisum.bci.user.manager.controller.model;

import com.nisum.bci.user.manager.service.model.Phone;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRequest {

    private String name;

    private String email;

    private String password;

    private List<Phone> phones;
}
