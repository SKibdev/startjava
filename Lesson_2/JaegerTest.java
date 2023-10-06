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
        Jaeger jaeger2 = new Jaeger("Cherno Alpha", "Mark-1", "Russia", 85.34f, 2.412f, 
                3, 10, 10, "Stun Core 08", 2);
        System.out.println("modelName = " + jaeger1.getModelName());
        System.out.println("modelName = " + jaeger2.getModelName());
        // jaegerOne.setModelName("");
        // System.out.println("modelName = " + jaegerOne.getModelName());
        // jaegerOne.setModelName("Java");
        // System.out.println("modelName = " + jaegerOne.getModelName());
        // System.out.println("height = " + jaegerOne.height);
        // jaegerOne.height = -1f;
        // System.out.println("height = " + jaegerOne.height);
        // System.out.println("mark = " + jaegerOne.mark);
        // System.out.println("speed = " + jaegerOne.speed);
        // System.out.println(jaegerOne.drift());

    }
}