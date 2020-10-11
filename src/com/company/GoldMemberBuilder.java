package com.company;

import java.time.LocalDate;

public class GoldMemberBuilder {
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;
    private int bonusPoints;

    public GoldMemberBuilder setMemberNo(int memberNo) {
        this.memberNo = memberNo;
        return this;
    }

    public GoldMemberBuilder setPersonals(Personals personals) {
        this.personals = personals;
        return this;
    }

    public GoldMemberBuilder setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
        return this;
    }

    public GoldMemberBuilder setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
        return this;
    }

    public GoldMember createGoldMember() {
        return new GoldMember(memberNo, personals, enrolledDate, bonusPoints);
    }
}