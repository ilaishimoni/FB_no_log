package com.example.fb;

public class company {

    private int TaxNumber;
    private String CompanyName;
    private int PrimaryPhone;
    private int SecondaryPhone;
    private String id;

    public company(){}


    public int getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        TaxNumber = taxNumber;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getPrimaryPhone() {
        return PrimaryPhone;
    }

    public void setPrimaryPhone(int primaryPhone) {
        PrimaryPhone = primaryPhone;
    }

    public int getSecondaryPhone() {
        return SecondaryPhone;
    }

    public void setSecondaryPhone(int secondaryPhone) {
        SecondaryPhone = secondaryPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public company (int TaxNumber, String CompanyName, int PrimaryPhone, int SecondaryPhone, String id) {
        this.TaxNumber=TaxNumber;
        this.CompanyName=CompanyName;
        this.PrimaryPhone=PrimaryPhone;
        this.SecondaryPhone=SecondaryPhone;
        this.id = id;
    }
}
