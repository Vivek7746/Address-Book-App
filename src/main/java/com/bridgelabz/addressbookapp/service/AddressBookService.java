package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
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

    public AddressBookEntry addEntry(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry(dto);
        return repository.save(entry);
    }

    public Optional<AddressBookEntry> updateEntry(Long id, AddressBookDTO dto) {
        return repository.findById(id).map(entry -> {
            entry.updateFromDTO(dto);
            return repository.save(entry);
        });
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}