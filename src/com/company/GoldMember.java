package com.company;

import java.time.LocalDate;

/**
 *
 * The class inherits from Class BonusMember
 */

public class GoldMember implements IBonusMember {
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;
    private int  bonusPoints;
    static final float FACTOR_GOLD = 1.5F;

    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
        this.bonusPoints = bonusPoints;
    }

    @Override
    public int getMemberNo() {
        return memberNo;
    }

    @Override
    public Personals getPersonals() {
        return personals;
    }

    @Override
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    @Override
    public int getBonusPoints() {
        return bonusPoints;
    }



    @Override
    public void registerPoints(int bonusPoints) {
        this.bonusPoints+=FACTOR_GOLD*bonusPoints;

    }


    @Override
    public String toString() {
        return "\nGoldMember " +"\n--------\n"+
                "MemberNo: " + memberNo +
                ", \tEnrolledDate: " + enrolledDate +
                ", \tBonusPoints: " + bonusPoints +
                ", \nPersonals:\t" + personals ;
    }
}
