import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
    int[][]nums;
    int id;

    public BingoCard(int id) {
        this.id = id;
        int min,max;

        Random random = new Random();
        nums = new int[5][5];

        for(int i = 0; i < 5; i++) { //row
            ArrayList<Integer> bingoDupe = new ArrayList<>();
            int bingoNum;
            min = 1+(15*i);
            max = 15*(i+1);

            for(int j = 0; j < 5; j++) { //col
                if(i == 2 && j == 2) {
                    bingoNum = 0;
                } else {

                    do {
                        bingoNum = random.nextInt(min,max);
                    } while(bingoDupe.contains(bingoNum));

                }

                bingoDupe.add(bingoNum);
                nums[j][i] = bingoNum;
            }

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0;row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
