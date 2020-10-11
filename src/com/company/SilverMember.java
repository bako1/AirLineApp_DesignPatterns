package com.company;

import java.time.LocalDate;

/**
 * The class inherits BonusMember class
 *
 * */
public class SilverMember implements IBonusMember {
   private int bonusPoints;
    static final float FACTOR_SILVER = 1.2F;
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;


    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
        this.memberNo  = memberNo;
        this.personals = personals;
        this.enrolledDate  =enrolledDate;
        this.bonusPoints =  bonusPoints;

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
        this.bonusPoints+= bonusPoints*FACTOR_SILVER;

    }



    @Override
    public String toString() {
        return "\nSilverMember \n" +"---------------\n"+
                "MemberNo: " + memberNo +
                ", \tEnrolledDate: " + enrolledDate +
                "\tBonusPoints: " + bonusPoints +
                "\nPersonals:\t" + personals;
    }
}
