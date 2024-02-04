package com.sai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.model.bankapplication;

// bankRepo.java
@Repository
public interface bankRepo extends JpaRepository<bankapplication, Integer> {



	public bankapplication findByAccountAndNameAndPassword(long account, String name, String password);

	public bankapplication findByAccount(int targetAccount);

}

