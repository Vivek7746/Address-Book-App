package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;

    public AddressBookDTO(String name, String phoneNumber, String email, String address, String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
    }

    // Manually added getters in case Lombok is not working
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}