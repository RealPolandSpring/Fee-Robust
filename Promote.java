import java.io.*;
import java.util.StringTokenizer;

public class Promote {

    public static void main(String[] args) throws FileNotFoundException {

        // USACO 2016 January Contest, Bronze
        // Problem 1. Promotion Counting

        // link: http://www.usaco.org/index.php?page=viewproblem2&cpid=591

        Kattio io = new Kattio("promote");

        int[] line1 = intArrayOf(io.nextLine());
        int[] line2 = intArrayOf(io.nextLine());
        int[] line3 = intArrayOf(io.nextLine());
        int[] line4 = intArrayOf(io.nextLine());


        // platinum
        int initialPlatinum = line4[0];
        int endPlatinum = line4[1];
        int promoFromGoldToPlat = endPlatinum - initialPlatinum;

        // gold
        int initialGold = line3[0];
        int endGold = line3[1];
        int promoSilverToGold = (endGold - initialGold + promoFromGoldToPlat );

        // silver
        int initialSilver = line2[0];
        int endSilver = line2[1];
        int promoBronzeToSilver = (endSilver - initialSilver + promoSilverToGold);


        // bronze
        int initialBronze = line1[0];
        int endBronze = line1[1];





        // at the end

        io.println(promoBronzeToSilver);
        io.println(promoSilverToGold);
        io.println(promoFromGoldToPlat);
        io.close();

    }

    public static int[] intArrayOf(String str) {

        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];

        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    // standard input.in
    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input.in
    public Kattio(String problemName) throws FileNotFoundException {
        super(problemName + ".out");
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // return null if no more input line
    public String nextLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    // returns null if no more input.in
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (IOException e) {
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }


}