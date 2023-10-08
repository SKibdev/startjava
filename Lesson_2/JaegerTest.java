public class JaegerTest {
    
    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();
        jaeger1.setModelName("Gipsy Danger");
        jaeger1.setMark("Mark-3");
        jaeger1.setOrigin("USA");
        jaeger1.setHeight(79.25f);
        jaeger1.setWeight(1.980f);
        jaeger1.setSpeed(7);
        jaeger1.setStrength(8);
        jaeger1.setArmor(6);
        jaeger1.setEnergyCore("Arc-9 reactor (analog)");
        jaeger1.setNumberPilots(3);
        jaeger1.displayInfo();
        jaeger1.drift();
        jaeger1.setStrength(10);
        System.out.println(jaeger1.scanKaiju());
        jaeger1.executePowerMove("Elbow Rocket");
        jaeger1.setModelName("Copy Gipsy Danger");
        System.out.println("\nmodel Name " + jaeger1.getModelName() + "\nMark " + jaeger1.getMark() +
                "\nOrigin " + jaeger1.getOrigin() + "\nHeight " + jaeger1.getHeight() + 
                "\nWeight " + jaeger1.getWeight() + "\nSpeed " + jaeger1.getSpeed() + 
                "\nStrength " + jaeger1.getStrength() + "\nArmor " + jaeger1.getArmor() + 
                "\nEnergy Core " + jaeger1.getEnergyCore() + 
                "\nNumber Pilots " + jaeger1.getNumberPilots());

        Jaeger jaeger2 = new Jaeger("Cherno Alpha", "Mark-1", "Russia", 85.34f, 2.412f, 
                3, 10, 10, "Stun Core 08", 2);
        jaeger2.displayInfo();
        jaeger2.drift();
        System.out.println(jaeger2.scanKaiju());
        jaeger2.executePowerMove("Sluggernaut");
        jaeger2.move();
        jaeger2.setOrigin("USA");
        System.out.println("Измененная информация о " + jaeger2.getModelName() + "\nOrigin: " + 
                jaeger2.getOrigin());
    }
}