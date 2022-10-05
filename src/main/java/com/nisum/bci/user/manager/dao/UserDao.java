package com.nisum.bci.user.manager.dao;

import com.nisum.bci.user.manager.service.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity(name ="user")
@Table(name ="user_")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDao {

    @Id
    private String userId;

    private String created;

    private String modified;

    private String lastLogin;

    private String token;

    private String isActive;

    private String name;

    private String email;

    private String password;

    @Column(length = 500)
    private String phones;

}
