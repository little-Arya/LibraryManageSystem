package cn.itcast.domain;

import java.util.Date;

public class Book {
    private Integer bkID;
    private String bkCode;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private String bkDatePress;
    private String bkISBN;
    private String bkCatalog;
    private String bkLanguage;
    private Integer bkPages;
    private Double bkPrice;
    private String bkDateIn;
    private String bkBrief;
    private String bkCover;//图书封面照片
    private String bkStatus;//图书状态

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public String getBkCode() {
        return bkCode;
    }

    public void setBkCode(String bkCode) {
        this.bkCode = bkCode;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }



    public String getBkISBN() {
        return bkISBN;
    }

    public void setBkISBN(String bkISBN) {
        this.bkISBN = bkISBN;
    }

    public String getBkCatalog() {
        return bkCatalog;
    }

    public void setBkCatalog(String bkCatalog) {
        this.bkCatalog = bkCatalog;
    }

    public String getBkLanguage() {
        return bkLanguage;
    }

    public void setBkLanguage(String bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public Integer getBkPages() {
        return bkPages;
    }

    public void setBkPages(Integer bkPages) {
        this.bkPages = bkPages;
    }

    public Double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(Double bkPrice) {
        this.bkPrice = bkPrice;
    }

    public String getBkDatePress() {
        return bkDatePress;
    }

    public void setBkDatePress(String bkDatePress) {
        this.bkDatePress = bkDatePress;
    }

    public String getBkDateIn() {
        return bkDateIn;
    }

    public void setBkDateIn(String bkDateIn) {
        this.bkDateIn = bkDateIn;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public String getBkCover() {
        return bkCover;
    }

    public void setBkCover(String bkCover) {
        this.bkCover = bkCover;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkID=" + bkID +
                ", bkCode='" + bkCode + '\'' +
                ", bkName='" + bkName + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPress='" + bkPress + '\'' +
                ", bkDatePress=" + bkDatePress +
                ", bkISBN='" + bkISBN + '\'' +
                ", bkCatalog='" + bkCatalog + '\'' +
                ", bkLanguage='" + bkLanguage + '\'' +
                ", bkPages=" + bkPages +
                ", bkPrice=" + bkPrice +
                ", bkDateIn=" + bkDateIn +
                ", bkBrief='" + bkBrief + '\'' +
                ", bkCover='" + bkCover + '\'' +
                ", bkStatus='" + bkStatus + '\'' +
                '}';
    }
}