package com.knitel.controller;

import com.knitel.entity.Contact;
import com.knitel.entity.util.ContactUtil;
import com.knitel.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.BadRequestException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@RestController
public class ContactController {

    private static final int SIZE = 1000000;

    private final ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/hello/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> findByNegativeRegex(@RequestParam(name = "nameFilter") String negativeRegex) {

        Pattern negativePattern = getPattern(negativeRegex);
        List<Contact> contacts = filterByNegativePattern(negativePattern);
        return ResponseEntity.ok(ContactUtil.toJson(contacts).toString());
    }

    private Pattern getPattern(String negateRegex) {
        try {
            return Pattern.compile(negateRegex);
        } catch (PatternSyntaxException e) {
            throw new BadRequestException();
        }
    }

    private List<Contact> filterByNegativePattern(Pattern negatePattern) {

        List<Contact> result = new ArrayList<>();

        List<Contact> dbContacts;
        int page = 0;

        do {
            dbContacts = repository.findAll(new PageRequest(page, SIZE)).getContent();
            if (dbContacts.isEmpty()) break;

            dbContacts.parallelStream()
                    .filter(contact -> contact.getName() == null ||
                        !negatePattern.matcher(contact.getName()).matches()).forEach(result::add);
            page++;
        } while (true);

        return result;
    }

}
