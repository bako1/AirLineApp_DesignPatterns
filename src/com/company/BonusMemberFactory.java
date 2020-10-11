package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class BonusMemberFactory {
    private HashMap<Integer, IBonusMember> basicMember;
    private HashMap<Integer, IBonusMember> silverMember;
    private HashMap<Integer, IBonusMember> goldMember;
    private Personals personals;
    private MemberArchive memberArchive;
    private LocalDate localDate;
    private LocalDate enrolledDate;
    private static final int DAYS_OF_YEAR = 365;
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;
    private int memNo;

    public BonusMemberFactory(Personals personals, LocalDate enrolledDate) {
        this.personals = personals;
        this.enrolledDate = enrolledDate;

        this.basicMember = new HashMap<>();
        this.silverMember = new HashMap<>();
        this.goldMember = new HashMap<>();
        memberArchive = new MemberArchive();
        this.localDate = LocalDate.now();
        this.memNo = memberArchive.addMember(personals, this.enrolledDate);
    }

    private long daysBetween(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
        long daysBetween = ChronoUnit.DAYS.between(this.enrolledDate, this.localDate);
        return daysBetween;
    }

    public IBonusMember registerPoints(int points) {
        memberArchive.registerPoints(memNo, points);
        for (Map.Entry<Integer, IBonusMember> members : memberArchive.displayMembers().entrySet()) {
            BasicMember base =   new BasicMember(members.getKey(),members.getValue().getPersonals(),
                    members.getValue().getEnrolledDate(),
                    members.getValue().getBonusPoints());

            basicMember.put(members.getKey(),base);


            for(Map.Entry<Integer,IBonusMember> basic:basicMember.entrySet()){
                if(basic.getValue().getBonusPoints()>=SILVER_LIMIT &&
                        basic.getValue().getBonusPoints()<GOLD_LIMIT &&
                        daysBetween(basic.getValue().getEnrolledDate())<=DAYS_OF_YEAR){

                    //Instantiarer SilverMember med verdi fra basic member.
                    // Siden alle medlemmer er basic i første omgang

                    SilverMember silver = new SilverMember(basic.getKey(),basic.getValue().getPersonals()
                            ,basic.getValue().getEnrolledDate(),
                            basic.getValue().getBonusPoints());
                    //silver.registerPoints(points);
                    //silverMember.put(basic.getKey(),silver);

                    return new SilverMember(basic.getKey(),silver.getPersonals(),
                            silver.getEnrolledDate(),
                            silver.getBonusPoints());
                }else if(basic.getValue().getBonusPoints()>=GOLD_LIMIT &&
                        daysBetween(basic.getValue().getEnrolledDate())<=DAYS_OF_YEAR){
                    //Instantiarer GoldMember med verdi fra basic member.
                    // Siden alle medlemmer er basic i første omgang
                    GoldMember gold = new GoldMember(basic.getKey(),basic.getValue().getPersonals(),
                            basic.getValue().getEnrolledDate(),
                            basic.getValue().getBonusPoints());
                    //Legger de som er kvalifiserte for GullMedlem til goldMember.
                    goldMember.put(basic.getKey(),gold);
                    gold.registerPoints(points); //Dersom kravet er oppfylt registreres
                    // poingsummen i gold member, dermed får de

                    return new GoldMember(basic.getKey(),gold.getPersonals(),   //returnerer GoldMember klassen
                            gold.getEnrolledDate(),
                            gold.getBonusPoints());
                }else{

                    return new BasicMember(basic.getKey(),basic.getValue().getPersonals(), basic.getValue().getEnrolledDate(),basic.getValue().getBonusPoints());
                }
            }




        }
    /*        if ((silver.getValue().getBonusPoints() >= SILVER_LIMIT) && (silver.getValue().getBonusPoints() < GOLD_LIMIT)) {

                    silverMember.put(silver.getKey()
                            , new SilverMemberBuilder().setMemberNo(silver.getKey())
                                    .setPersonals(silver.getValue().getPersonals())
                                    .setEnrolledDate(silver.getValue().getEnrolledDate())
                                    .setBonusPoints(silver.getValue().getBonusPoints())
                                    .createSilverMember());


                    return new SilverMemberBuilder().setMemberNo(silver.getKey())
                            .setPersonals(silver.getValue().getPersonals())
                            .setEnrolledDate(silver.getValue().getEnrolledDate())
                            .setBonusPoints(silver.getValue().getBonusPoints())
                            .createSilverMember();
                }
            } else if (silver.getValue().getBonusPoints() >= GOLD_LIMIT) {
                for (Map.Entry<Integer, IBonusMember> gold : memberArchive.displayMembers().entrySet()) {
                    goldMember.put(gold.getKey(), new GoldMemberBuilder().setMemberNo(gold.getKey())
                            .setPersonals(gold.getValue().getPersonals())
                            .setEnrolledDate(gold.getValue().getEnrolledDate())
                            .setBonusPoints(gold.getValue().getBonusPoints())
                            .createGoldMember());
                    return new GoldMemberBuilder()
                            .setMemberNo(gold.getKey())
                            .setPersonals(gold.getValue().getPersonals())
                            .setBonusPoints(gold.getValue().getBonusPoints())
                            .setEnrolledDate(gold.getValue().getEnrolledDate())
                            .createGoldMember();
                }
            }
        }
        for (Map.Entry<Integer, IBonusMember> basic : memberArchive.displayMembers().entrySet()) {
            basicMember.put(basic.getKey(), new BasicMemberBuilder()
                    .setMemberNo(basic.getKey())
                    .setEnrolledDate(basic.getValue().getEnrolledDate())
                    .setPersonals(basic.getValue().getPersonals())
                    .setBonusPoint(basic.getValue().getBonusPoints())
                    .build());
            return new BasicMember(basic.getKey(), basic.getValue().getPersonals(),
                    basic.getValue().getEnrolledDate(), basic.getValue().getBonusPoints());
        }
        return null;*/
        return null;
    }
}
