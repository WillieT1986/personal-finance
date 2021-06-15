package com.wrthompsonjr.personal.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface IncomeRepository extends JpaRepository<Income, Long> {
}