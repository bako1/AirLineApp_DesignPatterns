package com.company;

import java.time.LocalDate;

/**
 * The class inherits the Class BonusMember.
 * All members are BasicMembers initially, Based on the earned points they could be
 * upgraded to either silver or Gold member.
 * */
public class BasicMember implements IBonusMember {
    private int memberNo;
    private Personals personals;
    private LocalDate enrolledDate;
    private int bonusPoint;

    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate,int bonusPoint) {
    this.memberNo = memberNo;
    this.personals = personals;
    this.enrolledDate = enrolledDate;
    this.bonusPoint = bonusPoint;
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
        return bonusPoint;
    }


    @Override
    public void registerPoints(int bonusPoints) {
        this.bonusPoint+= bonusPoints;



    }


    @Override
    public String toString() {
        return "BasicMember\n" + "\n----------\n"+
                "MemberNo: " + memberNo +
                ", \t EnrolledDate: " + enrolledDate +
                ",\t BonusPoint: " + bonusPoint +
                "\nPersonals:\t" + personals ;
    }
}
