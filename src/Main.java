public class Main {
    public static void main(String[] args) {
        Thread bingo = new Thread(new BingoGame());
        bingo.run();
    }
}