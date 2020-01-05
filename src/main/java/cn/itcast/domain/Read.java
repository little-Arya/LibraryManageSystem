package cn.itcast.domain;

public class Read {
    private Integer rdID;
    private String rdName;//读者姓名
    private String rdSex;
    private String rdType;//读者类别
    private String rdDept;
    private String rdPhone;
    private String rdEmail;
    private String rdDateReg;
    private String rdPhoto;
    private String rdStatus;
    private Integer rdBorrowQty;
    private String rdPwd;
    private String rdAdminRoles;

    public Integer getRdID() {
        return rdID;
    }

    public void setRdID(Integer rdID) {
        this.rdID = rdID;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdSex() {
        return rdSex;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
    }

    public String getRdType() {
        return rdType;
    }

    public void setRdType(String rdType) {
        this.rdType = rdType;
    }

    public String getRdDept() {
        return rdDept;
    }

    public void setRdDept(String rdDept) {
        this.rdDept = rdDept;
    }

    public String getRdPhone() {
        return rdPhone;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public String getRdDateReg() {
        return rdDateReg;
    }

    public void setRdDateReg(String rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public String getRdPhoto() {
        return rdPhoto;
    }

    public void setRdPhoto(String rdPhoto) {
        this.rdPhoto = rdPhoto;
    }

    public String getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(String rdStatus) {
        this.rdStatus = rdStatus;
    }

    public Integer getRdBorrowQty() {
        return rdBorrowQty;
    }

    public void setRdBorrowQty(Integer rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }

    public String getRdAdminRoles() {
        return rdAdminRoles;
    }

    public void setRdAdminRoles(String rdAdminRoles) {
        this.rdAdminRoles = rdAdminRoles;
    }

    @Override
    public String toString() {
        return "Read{" +
                "rdID=" + rdID +
                ", rdName='" + rdName + '\'' +
                ", rdSex='" + rdSex + '\'' +
                ", rdType='" + rdType + '\'' +
                ", rdDept='" + rdDept + '\'' +
                ", rdPhone='" + rdPhone + '\'' +
                ", rdEmail='" + rdEmail + '\'' +
                ", rdDateReg='" + rdDateReg + '\'' +
                ", rdPhoto='" + rdPhoto + '\'' +
                ", rdStatus='" + rdStatus + '\'' +
                ", rdBorrowQty=" + rdBorrowQty +
                ", rdPwd='" + rdPwd + '\'' +
                ", rdAdminRoles='" + rdAdminRoles + '\'' +
                '}';
    }
}
