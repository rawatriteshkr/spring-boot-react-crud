package com.ntt.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.data.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
