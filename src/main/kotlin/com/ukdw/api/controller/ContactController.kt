package com.ukdw.api.controller

import com.ukdw.api.model.Contact
import com.ukdw.api.services.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/*")
class ContactController {

    @Autowired
    lateinit var contactService: ContactService

    @GetMapping("v1/contacts")
    fun getContacts() = contactService.getAllContact()

    @GetMapping("v1/contact/{id}")
    fun getContact(@PathVariable id: Long) = contactService.getContactById(id)

    @PostMapping("v1/contact/create")
    fun createContact(@RequestBody contact: Contact) = contactService.addContact(contact)

    @PutMapping("v1/contact/update")
    fun modifyContact(@RequestParam firstname: String, @RequestParam lastname: String, @RequestParam email: String, @RequestParam phonenumber: String, @RequestParam id: Long) = contactService.updateContact(firstname, lastname, email, phonenumber, id)

    @DeleteMapping("v1/contact/remove")
    fun removeContact(@RequestBody id: Long) = contactService.deleteContactById(id)

    @DeleteMapping("v1/contact/remove/all")
    fun clearContacts() = contactService.deleteAllContact()
}