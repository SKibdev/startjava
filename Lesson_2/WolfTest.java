public class WolfTest {
    
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.gender = "female";
        wolfOne.nickname = "Bad";
        wolfOne.weight = 27.5f;
        wolfOne.age = 5;
        wolfOne.color = "gray";

        System.out.println("gender: " + wolfOne.gender + "\nnickname: " + wolfOne.nickname + 
                "\nweight: " + wolfOne.weight + "\nage: " + wolfOne.age + 
                "\ncolor: " + wolfOne.color);
        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}