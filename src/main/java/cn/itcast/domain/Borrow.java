package cn.itcast.domain;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Borrow {
    private Integer BorrowID;
    private Integer rdID;
    private Integer bkID;
    private Integer ldContinueTimes;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ldDateOut;//借书日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ldDateRetPlan;//应还日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ldDateRetAct;//实际还书日期

    private Integer ldOverDay;
    private Double ldOverMoney;
    private Double ldPunishMoney;
    private Integer lsHasReturn;
    private String OperatorLend;
    private String OperatorRet;

    public Integer getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(Integer borrowID) {
        BorrowID = borrowID;
    }

    public Integer getRdID() {
        return rdID;
    }

    public void setRdID(Integer rdID) {
        this.rdID = rdID;
    }

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public Integer getLdContinueTimes() {
        return ldContinueTimes;
    }

    public void setLdContinueTimes(Integer ldContinueTimes) {
        this.ldContinueTimes = ldContinueTimes;
    }

    public Timestamp getLdDateOut() {
        return ldDateOut;
    }

    public void setLdDateOut(Timestamp ldDateOut) {
        this.ldDateOut = ldDateOut;
    }

    public Date getLdDateRetPlan() {
        return ldDateRetPlan;
    }

    public void setLdDateRetPlan(Date ldDateRetPlan) {
        this.ldDateRetPlan = ldDateRetPlan;
    }

    public Timestamp getLdDateRetAct() {
        return ldDateRetAct;
    }

    public void setLdDateRetAct(Timestamp ldDateRetAct) {
        this.ldDateRetAct = ldDateRetAct;
    }

    public Integer getLdOverDay() {
        return ldOverDay;
    }

    public void setLdOverDay(Integer ldOverDay) {
        this.ldOverDay = ldOverDay;
    }

    public Double getLdOverMoney() {
        return ldOverMoney;
    }

    public void setLdOverMoney(Double ldOverMoney) {
        this.ldOverMoney = ldOverMoney;
    }

    public Double getLdPunishMoney() {
        return ldPunishMoney;
    }

    public void setLdPunishMoney(Double ldPunishMoney) {
        this.ldPunishMoney = ldPunishMoney;
    }

    public Integer getLsHasReturn() {
        return lsHasReturn;
    }

    public void setLsHasReturn(Integer lsHasReturn) {
        this.lsHasReturn = lsHasReturn;
    }

    public String getOperatorLend() {
        return OperatorLend;
    }

    public void setOperatorLend(String operatorLend) {
        OperatorLend = operatorLend;
    }

    public String getOperatorRet() {
        return OperatorRet;
    }

    public void setOperatorRet(String operatorRet) {
        OperatorRet = operatorRet;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "BorrowID=" + BorrowID +
                ", rdID=" + rdID +
                ", bkID=" + bkID +
                ", ldContinueTimes=" + ldContinueTimes +
                ", ldDateOut='" + ldDateOut + '\'' +
                ", ldDateRetPlan='" + ldDateRetPlan + '\'' +
                ", ldDateRetAct='" + ldDateRetAct + '\'' +
                ", ldOverDay=" + ldOverDay +
                ", ldOverMoney=" + ldOverMoney +
                ", ldPunishMoney=" + ldPunishMoney +
                ", lsHasReturn=" + lsHasReturn +
                ", OperatorLend='" + OperatorLend + '\'' +
                ", OperatorRet='" + OperatorRet + '\'' +
                '}';
    }
}
