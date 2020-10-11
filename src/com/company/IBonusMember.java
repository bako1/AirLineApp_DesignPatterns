package com.company;

import java.time.LocalDate;

public interface IBonusMember {

    int getMemberNo();

    Personals getPersonals();

    LocalDate getEnrolledDate();

    int getBonusPoints();

    void registerPoints(int bonusPoints);
}
