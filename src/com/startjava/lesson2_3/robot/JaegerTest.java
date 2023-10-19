package com.startjava.lesson2_3.robot;

public class JaegerTest {
    
    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger();
        gipsyDanger.setModelName("Gipsy Danger");
        gipsyDanger.setMark("Mark-3");
        gipsyDanger.setOrigin("USA");
        gipsyDanger.setHeight(79.25f);
        gipsyDanger.setWeight(1.980f);
        gipsyDanger.setSpeed(7);
        gipsyDanger.setStrength(8);
        gipsyDanger.setArmor(6);
        gipsyDanger.setEnergyCore("Arc-9 reactor (analog)");
        gipsyDanger.setNumberPilots(3);
        gipsyDanger.displayInfo();
        gipsyDanger.drift();
        gipsyDanger.setStrength(10);
        System.out.println(gipsyDanger.scanKaiju());
        gipsyDanger.executePowerMove("Elbow Rocket");
        gipsyDanger.setModelName("Copy Gipsy Danger");
        System.out.println("\nmodel Name " + gipsyDanger.getModelName() + "\nMark " + gipsyDanger.getMark() +
                "\nOrigin " + gipsyDanger.getOrigin() + "\nHeight " + gipsyDanger.getHeight() + 
                "\nWeight " + gipsyDanger.getWeight() + "\nSpeed " + gipsyDanger.getSpeed() + 
                "\nStrength " + gipsyDanger.getStrength() + "\nArmor " + gipsyDanger.getArmor() + 
                "\nEnergy Core " + gipsyDanger.getEnergyCore() + 
                "\nNumber Pilots " + gipsyDanger.getNumberPilots());

        Jaeger chernoAlpha = new Jaeger("Cherno Alpha", "Mark-1", "Russia", 85.34f, 2.412f, 
                3, 10, 10, "Stun Core 08", 2);
        chernoAlpha.displayInfo();
        chernoAlpha.drift();
        System.out.println(chernoAlpha.scanKaiju());
        chernoAlpha.executePowerMove("Sluggernaut");
        chernoAlpha.move();
        chernoAlpha.setOrigin("USA");
        System.out.println("Измененная информация о " + chernoAlpha.getModelName() + "\nOrigin: " + 
                chernoAlpha.getOrigin());
        System.out.println(gipsyDanger.toString());
        System.out.println(chernoAlpha.toString());
    }
}