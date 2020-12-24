package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.PaymentTypeMapper;
import com.hh.his.graduationproject.model.entity.PaymentType;
import com.hh.his.graduationproject.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentType> findAllPaymentType() {
        List<PaymentType> allPaymentType = paymentTypeMapper.findAllPaymentType();
        return allPaymentType;
    }
}
