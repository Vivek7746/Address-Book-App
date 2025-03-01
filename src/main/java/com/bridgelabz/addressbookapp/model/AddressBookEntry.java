package com.bridgelabz.addressbookapp.model;

public class AddressBookEntry {
    private String name;
    private String phoneNumber;

    // Constructors
    public AddressBookEntry() {}

    public AddressBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}