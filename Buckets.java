import java.io.*;
import java.util.StringTokenizer;

public class Buckets {

    public static void main(String[] args) throws FileNotFoundException {

        Kattio io = new Kattio("buckets");

        int barnI = 0, barnJ = 0, rockI = 0, rockJ = 0, lakeI = 0, lakeJ = 0;

        for (int i = 0; i < 10; i++) {
            String row = io.next();
            for (int j = 0; j < 10; j++) {
                if (row.charAt(j) == 'B') {
                    barnI = i;
                    barnJ = j;
                } else if (row.charAt(j) == 'R') {
                    rockI = i;
                    rockJ = j;
                } else if (row.charAt(j) == 'L') {
                    lakeI = i;
                    lakeJ = j;
                }
            }

        }

        int cows = Math.abs(barnI - lakeI) + Math.abs(barnJ - lakeJ) - 1;

        // if the barn lake and rock are in the same row and the rock is between lake and barn

        if ((barnI == lakeI && barnI == rockI) && ((lakeJ < rockJ && rockJ < barnJ) || (barnJ < rockJ && rockJ < lakeJ))) {
            cows += 2;
        }

        // if the barn lake and rock are in the same column and the rock is between lake and barn

        if ((barnJ == lakeJ && barnJ == rockJ) && ((lakeI < rockI && rockI < barnI) || (barnI < rockI && rockI < lakeI))) {
            cows += 2;
        }


        io.println(cows);
        io.close();

    }
}

class Kattio extends PrintWriter {
    private final BufferedReader r;
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
