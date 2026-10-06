package com.bookmyshow.demo.ServiceImpl;

import com.bookmyshow.demo.Dto.ProfieResponse;

import com.bookmyshow.demo.Dto.createProfileRequest;
import com.bookmyshow.demo.Entity.Customer;
import com.bookmyshow.demo.Exception.ProfileConflictException;
import com.bookmyshow.demo.Service.ProfileService;
import com.bookmyshow.demo.repository.CustomerRepo;

import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final CustomerRepo customerRepo;

    public ProfileServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


   public ProfieResponse createProfile(createProfileRequest request)
   {

    String email=request.email().trim().toLowerCase(Locale.ROOT);
    String phone=request.phoneNo();

    if(customerRepo.existsByEmail(email))
    {
        throw new ProfileConflictException("An account with this email already exists with this email");
    }

    if(customerRepo.existsByphoneno(phone))
    {
        throw new ProfileConflictException("An account with this phone number already exists with this phone number");
    }
   return ProfieResponse.from(customerRepo.save(new Customer(request.name().trim(),email,phone)));
   }
}
