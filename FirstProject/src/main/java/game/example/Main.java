package game.example;

public class Main {
    public static void main(String[] args) {
        IO.println("hello world");

        GameService gs = new GameService();
        gs.start();
    }
}
