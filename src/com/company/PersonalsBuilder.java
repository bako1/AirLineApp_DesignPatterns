
package com.company;

public class PersonalsBuilder {
    private String firstName;
    private String surname;
    private String emailAddress;
    private String password;
    private int mobileNo;
    private int postNo;

    public PersonalsBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonalsBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonalsBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public PersonalsBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public PersonalsBuilder setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }
    public PersonalsBuilder setPostNo(int postNo){
        this.postNo = postNo;
        return this;
    }
    public Personals createPersonals() {
        return new Personals(firstName, surname, emailAddress, password,mobileNo,postNo);
    }


}
