package com.westbank.web.form;

import com.westbank.domain.MaritalStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerRegistrationForm {
    private String title;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private MaritalStatus maritalStatus;
    private Integer numberOfChildren;
    private String occupation;
    private Double income;
    private Integer lengthOfService;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String phone;
    private String mobilePhone;
    private String email;
    private String newPin;
    private String newPinAgain;
    public CustomerRegistrationForm() {}
    // Getters and setters for all fields
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public MaritalStatus getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }
    public Integer getNumberOfChildren() { return numberOfChildren; }
    public void setNumberOfChildren(Integer numberOfChildren) { this.numberOfChildren = numberOfChildren; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public Double getIncome() { return income; }
    public void setIncome(Double income) { this.income = income; }
    public Integer getLengthOfService() { return lengthOfService; }
    public void setLengthOfService(Integer lengthOfService) { this.lengthOfService = lengthOfService; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNewPin() { return newPin; }
    public void setNewPin(String newPin) { this.newPin = newPin; }
    public String getNewPinAgain() { return newPinAgain; }
    public void setNewPinAgain(String newPinAgain) { this.newPinAgain = newPinAgain; }
} 