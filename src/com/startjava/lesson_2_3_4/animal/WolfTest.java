package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("female");
        wolfOne.setNickname("Bad");
        wolfOne.setWeight(27.5f);
        wolfOne.setAge(5);
        wolfOne.setColor("gray");
        System.out.println("gender: " + wolfOne.getGender() + "\nnickname: " + 
            wolfOne.getNickname() + "\nweight: " + wolfOne.getWeight() + "\nage: " + wolfOne.getAge() + 
                "\ncolor: " + wolfOne.getColor());
        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}