package com.wrthompsonjr.personal.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface CreditRepository extends JpaRepository<Credit, Long> {
}