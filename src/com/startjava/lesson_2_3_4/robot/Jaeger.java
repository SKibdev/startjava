package com.startjava.lesson_2_3_4.robot;

public class Jaeger {
    
    private String modelName;
    private String mark;
    private String origin;
    private float height;
    private float weight;
    private int speed;
    private int strength;
    private int armor;
    private String energyCore;
    private int numberPilots;

    public Jaeger() { 
    }

    public Jaeger(String modelName, String mark, String origin, float height, float weight,
            int speed, int strength, int armor, String energyCore, int numberPilots) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
        this.energyCore = energyCore;
        this.numberPilots = numberPilots;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getEnergyCore() {
        return energyCore;
    }

    public void setEnergyCore(String energyCore) {
        this.energyCore = energyCore;
    }

    public int getNumberPilots() {
        return numberPilots;
    }

    public void setNumberPilots(int numberPilots) {
        this.numberPilots = numberPilots;
    }

    public void displayInfo() {
        System.out.println("\n  Информация о Jaeger\nmodel Name: " + modelName + 
                "\nMark: " + mark + 
                "\nOrigin: " + origin + 
                "\nHeight: " + height + 
                "\nWeight: " + weight + 
                "\nSpeed: " + speed + 
                "\nStrength: " + strength + 
                "\nArmor: " + armor + 
                "\nEnergy Core: " + energyCore + 
                "\nNumber Pilots: " + numberPilots);
    }

    public boolean drift() {
        System.out.println("\nПилоты " + modelName + " вошли в дрифт");
        return true;
    }

    public void move() {
        System.out.println(modelName + " прошел 5 шагов");
    }

    public String scanKaiju() {
        return modelName + " провел сканирование - Kaiju не найдены";
    }

    // Power Move(s) Gipsy Danger: Palm grip backlash or Elbow Rocket;
    //  Power Move(s) Cherno Alpha: Sluggernaut or Headshock
    public void executePowerMove(String powerMove) {
        System.out.println(modelName + " применил силовой прием " + powerMove);
    }

@Override
    public String toString() {
        return "Main{" + 
            "model Name:'" + modelName + '\'' +
            ", Mark: " + mark + '\'' +
            " Height: " + height + 
            "weight: " + weight + 
            '}';
    }
}