import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{
    List<BingoCard> cards;
    static final boolean[] result = new boolean[76];
    static boolean isBingo;

    @Override
    public void run() {
        result[0] = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }

        // TODO RANDOM RESULTS
        // TODO randomly get number from 1-75 while not bingo

        Thread[] checkerThrds = new Thread[cnt];
        for(int i = 0; i <cnt; i++) {
            for(int j = 1; j <= 5; j++) {
                checkerThrds[i] = new Thread(new BingoRowChecker(cards.get(i),j));
                checkerThrds[i] = new Thread(new BingoColumnChecker(cards.get(i),j));
                checkerThrds[i].start();
            }
        }

        Random random = new Random();
        int randomNum;
        while(!isBingo) {
            do {
                randomNum = random.nextInt(1,76);
            } while(result[randomNum]); //if true or na agi ang number
            System.out.print(randomNum + " ");
            result[randomNum] = true;

            synchronized (result) {
                result.notifyAll();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) { }

        }

    }

}