package com.nisum.bci.user.manager.repository;

import com.nisum.bci.user.manager.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserDao, Long> {

    UserDao findByEmail(String email);
}
