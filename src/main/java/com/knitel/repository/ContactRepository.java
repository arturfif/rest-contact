package com.knitel.repository;

import com.knitel.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
