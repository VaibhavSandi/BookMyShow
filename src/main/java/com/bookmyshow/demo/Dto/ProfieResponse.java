package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Customer;

public record ProfieResponse(Long id, String name, String email, String phone) {


    public static ProfieResponse from(Customer customer)
    {
        return  new ProfieResponse(customer.getId(),customer.getName(),customer.getEmail(),customer.getPhoneno());

    }
}
