package com.kgovt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgovt.models.MasterUser;

public interface MasterUserRepository extends JpaRepository<MasterUser, Integer>{

}
