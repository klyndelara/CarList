package com.KimlynsPractice.demo.model;

public class Members {
    private int membersId;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Members(int membersId, String name, String phoneNumber, String address, String city, String state, String zipCode) {
        this.membersId = membersId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getMembersId() {
        return membersId;
    }

    public void setMembersId(int membersId) {
        this.membersId = membersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }




}
