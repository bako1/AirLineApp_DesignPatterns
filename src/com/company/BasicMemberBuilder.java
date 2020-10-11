package com.company;

import java.time.LocalDate;

public class BasicMemberBuilder {
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;
    private int bonusPoint;

    public BasicMemberBuilder setMemberNo(int memberNo) {
        this.memberNo = memberNo;
        return this;
    }

    public BasicMemberBuilder setPersonals(Personals personals) {
        this.personals = personals;
        return this;
    }

    public BasicMemberBuilder setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;

        return this;
    }

    public BasicMemberBuilder setBonusPoint(int bonusPoint) {
        this.bonusPoint+= bonusPoint;
        return this;
    }

    public BasicMember build() {
        return new BasicMember(memberNo, personals, enrolledDate, bonusPoint);
    }
}