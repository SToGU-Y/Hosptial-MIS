package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.PaymentType;

import java.util.List;

public interface PaymentTypeMapper {

    List<PaymentType> findAllPaymentType();
}
