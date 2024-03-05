import java.util.List;

public class BingoPattern implements Runnable{
    List<BingoChecker> bingoCheckers;
    BingoCard bingoCard;

    public BingoPattern(BingoCard bingoCard) {
        this.bingoCard = bingoCard;
    }

    @Override
    public void run() {
        bingoCheckers.add(new Thread(new))
    }
}
