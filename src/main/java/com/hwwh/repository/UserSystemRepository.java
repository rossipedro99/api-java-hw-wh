package com.hwwh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwwh.model.UserSystemModel;

public interface UserSystemRepository extends JpaRepository<UserSystemModel, Integer> {

}
