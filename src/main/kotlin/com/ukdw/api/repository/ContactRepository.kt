package com.ukdw.api.repository

import com.ukdw.api.model.Contact
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ContactRepository : CrudRepository<Contact, Long> {

    fun findContactById(id: Long): Contact

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Contact contact SET contact.firstname=:firstname, contact.lastname=:lastname, contact.email=:email, contact.phonenumber=:phonenumber WHERE contact.id=:id")
    fun updateContactById(@Param("firstname") firstname: String, @Param("lastname") lastname: String, @Param("email") email: String, @Param("phonenumber") phonenumber: String, @Param("id") id: Long)
}