package com.example.modulo2.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modulo2.repository.orm.UserOrm;

@Repository
public interface MySQLUserRepository extends JpaRepository<UserOrm, String> {
}
