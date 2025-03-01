package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBookEntry;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public List<AddressBookEntry> getAllEntries() {
        return repository.findAll();
    }

    public Optional<AddressBookEntry> getEntryById(Long id) {
        return repository.findById(id);
    }

    public AddressBookEntry addEntry(AddressBookEntry entry) {
        return repository.save(entry);
    }

    public AddressBookEntry updateEntry(Long id, AddressBookEntry updatedEntry) {
        return repository.findById(id).map(entry -> {
            entry.setName(updatedEntry.getName());
            entry.setPhoneNumber(updatedEntry.getPhoneNumber());
            return repository.save(entry);
        }).orElse(null);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}