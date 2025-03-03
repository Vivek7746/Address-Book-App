package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address_book")
@Data
@NoArgsConstructor
public class AddressBookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    // Constructor to create an entity from DTO
    public AddressBookEntry(AddressBookDTO dto) {
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
    }

    // Update method to modify entity from DTO
    public void updateFromDTO(AddressBookDTO dto) {
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
    }
}