package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressBook>> getEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEntryById(id));
    }

    @PostMapping
    public ResponseEntity<AddressBook> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<AddressBook>> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        boolean removed = service.deleteEntry(id);
        if (removed) {
            return ResponseEntity.ok("Entry deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Entry not found");
        }
    }
}