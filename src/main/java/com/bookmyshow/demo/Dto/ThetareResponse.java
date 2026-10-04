package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Theatre;

public record ThetareResponse(Long id, String name, String city, String address) {


    public static ThetareResponse from(Theatre thetare)
    {
        return new ThetareResponse(thetare.getId(),thetare.getName(),thetare.getCity(),thetare.getAddress());
    }
}
