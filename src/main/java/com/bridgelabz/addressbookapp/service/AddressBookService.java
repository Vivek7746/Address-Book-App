package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    public Optional<AddressBook> getEntryById(Long id) {
        return repository.findById(id);
    }

    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook(dto);
        return repository.save(entry);
    }

    public Optional<AddressBook> updateEntry(Long id, AddressBookDTO dto) {
        return repository.findById(id).map(entry -> {
            entry.setName(dto.getName());
            entry.setPhoneNumber(dto.getPhoneNumber());
            return repository.save(entry);
        });
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}