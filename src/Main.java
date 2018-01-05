public class Main {
//    gameWindow gameWindow = new gameWindow();

    public static class Car{
        String color;
        int number;
        double speed;
        void run(){
            System.out.println("run....");
        }
    }
    public static void main(String[] args) {
//        Car toyotaCar = new Car();
//        toyotaCar.color = "Red";
//        toyotaCar.number = 4;
//        toyotaCar.speed = 500.0;
//
//        toyotaCar.run();
        gameWindow gameWindow = new gameWindow();
        gameWindow.gameLoop();
    }
}
