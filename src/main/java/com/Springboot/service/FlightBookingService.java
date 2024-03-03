package com.Springboot.service;

import com.Springboot.dto.FlightBookingAcknowledgement;
import com.Springboot.dto.FlightBookingRequest;
import com.Springboot.entity.PassengerInfo;
import com.Springboot.entity.PaymentInfo;
import com.Springboot.repository.PassengerInfoRepository;
import com.Springboot.repository.PaymentInfoRepository;
import com.Springboot.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        FlightBookingAcknowledgement acknowledgement=null;

                PassengerInfo  passengerInfo = request.getPassengerInfo();
                passengerInfo = passengerInfoRepository.save( passengerInfo);

                PaymentInfo paymentInfo=request.getPaymentInfo();
                PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

                paymentInfo.setPassengerId(passengerInfo.getPId());
                paymentInfo.setAmount(passengerInfo.getFare());
                paymentInfoRepository.save(paymentInfo);
                return new FlightBookingAcknowledgement("success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }

}

