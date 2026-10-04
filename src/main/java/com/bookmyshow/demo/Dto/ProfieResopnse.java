package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Customer;

public record ProfieResopnse(Long id, String name, String email, String phone) {


    public static ProfieResopnse from(Customer customer)
    {
        return  new ProfieResopnse(customer.getId(),customer.getName(),customer.getEmail(),customer.getPhoneno());

    }
}
