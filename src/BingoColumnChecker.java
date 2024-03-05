public class BingoColumnChecker extends BingoChecker{
    BingoCard card;
    int col;
    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col-1;
    }

    @Override
    public void run() {
        for (int row = 0; row < 5; row++) {
            int num = card.nums[row][col];
            while (!BingoGame.result[num]) { ///* wala pa napilian si num*/
                try {
                    synchronized (BingoGame.result) {
                        BingoGame.result.wait();
                    }
                } catch (InterruptedException e) { }
            }
        }
        System.out.println("\nBINGO! Card " +card.id +" done:\n" +card);
        BingoGame.isBingo = true;
    }
}