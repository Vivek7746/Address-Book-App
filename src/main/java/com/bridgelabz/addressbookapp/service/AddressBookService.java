package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private Long idCounter = 1L; // Auto-increment ID

    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    public Optional<AddressBook> getEntryById(Long id) {
        return addressBookList.stream().filter(entry -> entry.getId().equals(id)).findFirst();
    }

    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook();
        entry.setId(idCounter++); // Assign an auto-increment ID
        entry.setName(dto.getName());
        entry.setPhoneNumber(dto.getPhoneNumber());
        addressBookList.add(entry);
        return entry;
    }

    public Optional<AddressBook> updateEntry(Long id, AddressBookDTO dto) {
        return getEntryById(id).map(entry -> {
            entry.setName(dto.getName());
            entry.setPhoneNumber(dto.getPhoneNumber());
            return entry;
        });
    }

    public boolean deleteEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}