package com.wrthompsonjr.personal.finance;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface Financial_Institution_Repository extends JpaRepository<Financial_Institution, Long> {
}