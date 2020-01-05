package cn.itcast.domain;

public class User {
    private Integer rdType;
    private String rdTypeName;
    private Integer canendQty;
    private Integer canendDay;
    private Integer canContinueTimes;
    private Double punishRate;
    private Integer pateValid;

    public Integer getRdType() {
        return rdType;
    }

    public void setRdType(Integer rdType) {
        this.rdType = rdType;
    }

    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }

    public Integer getCanendQty() {
        return canendQty;
    }

    public void setCanendQty(Integer canendQty) {
        this.canendQty = canendQty;
    }

    public Integer getCanendDay() {
        return canendDay;
    }

    public void setCanendDay(Integer canendDay) {
        this.canendDay = canendDay;
    }

    public Integer getCanContinueTimes() {
        return canContinueTimes;
    }

    public void setCanContinueTimes(Integer canContinueTimes) {
        this.canContinueTimes = canContinueTimes;
    }

    public Double getPunishRate() {
        return punishRate;
    }

    public void setPunishRate(Double punishRate) {
        this.punishRate = punishRate;
    }

    public Integer getPateValid() {
        return pateValid;
    }

    public void setPateValid(Integer pateValid) {
        this.pateValid = pateValid;
    }

    @Override
    public String toString() {
        return "User{" +
                "rdType=" + rdType +
                ", rdTypeName='" + rdTypeName + '\'' +
                ", canendQty=" + canendQty +
                ", canendDay=" + canendDay +
                ", canContinueTimes=" + canContinueTimes +
                ", punishRate=" + punishRate +
                ", pateValid=" + pateValid +
                '}';
    }
}
