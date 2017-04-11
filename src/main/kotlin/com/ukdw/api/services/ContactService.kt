package com.ukdw.api.services

import com.ukdw.api.model.Contact
import com.ukdw.api.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service(value = "contactService")
class ContactService {

    @Autowired
    lateinit var repository: ContactRepository

    fun getAllContact(): Iterable<Contact> = repository.findAll()

    fun getContactById(id: Long): Contact = repository.findContactById(id)

    fun addContact(contact: Contact): Contact = repository.save(contact)

    fun updateContact(firstname: String, lastname: String, email: String, phonenumber: String, id: Long) = repository.updateContactById(firstname, lastname, email, phonenumber, id)

    fun deleteContactById(id: Long) = repository.delete(id)

    fun deleteAllContact() = repository.deleteAll()
}