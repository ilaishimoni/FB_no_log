package com.example.fb;

public class sign {



    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public String getFinalName() {
        return FinalName;
    }

    public void setFinalName(String finalName) {
        FinalName = finalName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    private int CardNumber;
    private String FinalName;
    private String FirstName;
    private String CompanyName;
    private String ID;
    private int PhoneNumber;

    public sign(){}

    public sign(int CardNumber, String FinalName, String FirstName, String CompanyName,  String ID, int PhoneNumber) {
        this.CardNumber=CardNumber;
        this.FinalName=FinalName;
        this.FirstName=FirstName;
        this.CompanyName=CompanyName;
        this.ID=ID;
        this.PhoneNumber=PhoneNumber;
    }

}
