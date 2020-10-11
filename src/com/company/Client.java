package com.company;

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
        Personals person1 = new PersonalsBuilder().setFirstName("Abdi")
                .setSurname("Bako")
                .setEmailAddress("bako@gmail.com")
                .setPassword("kdfgh")
                .setMobileNo(122333).createPersonals();
        BonusMemberFactory factory =
                new BonusMemberFactory(person1,LocalDate.of(2020,1,1));
        // System.out.println(factory.registerPoints(7000));

        Personals person2 = new PersonalsBuilder().setFirstName("Abdi")
                .setSurname("Bako")
                .setEmailAddress("bako@gmail.com")
                .setPassword("kdfgh")
                .setMobileNo(122333)
                .setPostNo(2819).createPersonals();
        BonusMemberFactory factory2 =
                new BonusMemberFactory(person2,LocalDate.of(2010,1,1));
        System.out.println(factory.registerPoints(25000));
        // System.out.println(factory.registerPoints(2000));

    }
}
