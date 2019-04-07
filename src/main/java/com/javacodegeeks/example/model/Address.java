package com.javacodegeeks.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private int aptNum;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getAptNum() {
		return aptNum;
	}

	public void setAptNum(int aptNum) {
		this.aptNum = aptNum;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@Override
    public String toString() {
        return String.format("Address{id=%d, street='%s', aptNumber=%d, PersonId=%d}", id, street, aptNum, personId);
    }
}
