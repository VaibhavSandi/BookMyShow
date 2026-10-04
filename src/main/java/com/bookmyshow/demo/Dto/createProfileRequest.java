package com.bookmyshow.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record createProfileRequest(
        @NotBlank @Size(max=100) String name,
        @NotBlank @Size(max=100) String email,
        @NotBlank @Pattern(regexp = "^[0-9+ ()-]{10,20}$") String phoneNo
) {
}
