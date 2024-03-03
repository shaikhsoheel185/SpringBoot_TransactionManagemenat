package com.Springboot.repository;

import com.Springboot.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository  extends JpaRepository<PassengerInfo,Long> {
}
