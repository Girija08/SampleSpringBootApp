package com.verizon.adb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;

	@NotEmpty(message = "First Name cannot be empty")
	@Size(min = 2, max = 15, message = "First name must have 2 to 15 characters only")
	private String firstName;

	@NotEmpty(message = "Last Name cannot be empty")
	@Size(min = 5, max = 15, message = "Last name must have 5 to 15 characters only")
	private String lastName;

	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message = "Date of Birth cannot be empty")
	@Column(name = "dob")
	private LocalDate dateOfBirth;

	@NotEmpty(message = "Email cannot be null")
	@Email(message = "Invalid email id")
	private String emailId;

	@NotEmpty(message = "Mobile Number cannot be null")
	@Pattern(regexp = "\\d{10}", message = "Mobile no. can have only 10 digits")
	@Column(name = "mno")
	private String mobileNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
