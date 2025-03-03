package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "address_book")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    // Default constructor
    public AddressBook() {}

    // Constructor accepting DTO
    public AddressBook(AddressBookDTO dto) {
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}