import java.io.FileNotFoundException;

public class MixMilk {

    public static void main(String[] args) throws FileNotFoundException {

        Kattio io = new Kattio("mixmilk");

        // problem link: http://www.usaco.org/index.php?page=viewproblem2&cpid=855

        int[][] arrayOfBuckets = new int[3][2]; // capacity, milk amount

        int capacity1 = io.nextInt();
        arrayOfBuckets[0][0] = capacity1;
        int milkAmount1 =  io.nextInt();
        arrayOfBuckets[0][1] = milkAmount1;

        int capacity2 = io.nextInt();
        arrayOfBuckets[1][0] = capacity2;
        int milkAmount2 = io.nextInt();
        arrayOfBuckets[1][1] = milkAmount2;

        int capacity3 = io.nextInt();
        arrayOfBuckets[2][0] = capacity3;
        int milkAmount3 = io.nextInt();
        arrayOfBuckets[2][1] = milkAmount3;

        int currentBucket = 0, nextBucket = 0;

        int turn = 0;
        for (int i = 0; i < 100; i++) {
            currentBucket = turn % 3;
            if (currentBucket < 2) {
                nextBucket = currentBucket + 1;
            } else if (currentBucket == 2){
                nextBucket = 0;
            }

            arrayOfBuckets[nextBucket][1] += arrayOfBuckets[currentBucket][1]; // current bucket's milk added to the next bucket's
            int leftoverMilk = Math.abs(arrayOfBuckets[nextBucket][0] - (arrayOfBuckets[nextBucket][1] + arrayOfBuckets[currentBucket][1]));
            arrayOfBuckets[currentBucket][1] = leftoverMilk;

            turn++;
        }

        io.println(arrayOfBuckets[0][1]);
        io.println(arrayOfBuckets[1][1]);
        io.println(arrayOfBuckets[2][1]);
        io.close();


    }

}
