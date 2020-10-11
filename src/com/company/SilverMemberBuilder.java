package com.company;

import java.time.LocalDate;

public class SilverMemberBuilder {
    private static final float FACTOR_SILVER = 1.2F ;
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;
    private int bonusPoints;

    public SilverMemberBuilder setMemberNo(int memberNo) {
        this.memberNo = memberNo;
        return this;
    }

    public SilverMemberBuilder setPersonals(Personals personals) {
        this.personals = personals;
        return this;
    }

    public SilverMemberBuilder setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
        return this;
    }

    public SilverMemberBuilder setBonusPoints(int bonusPoints) {
        bonusPoints*= FACTOR_SILVER;
        this.bonusPoints= bonusPoints;

        return this;
    }

    public SilverMember createSilverMember() {
        return new SilverMember(memberNo, personals, enrolledDate, bonusPoints);
    }
}