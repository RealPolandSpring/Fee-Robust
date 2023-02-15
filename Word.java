import java.io.*;
import java.util.StringTokenizer;

public class Word {

    public static void main(String[] args) throws FileNotFoundException {

        // USACO 2020 January Contest, Bronze
        // Problem 1. Word Processor

        // link: http://www.usaco.org/index.php?page=viewproblem2&cpid=987

        Kattio io = new Kattio("word");

        int n = io.nextInt();
        int k = io.nextInt();
        String essay = io.nextLine();
        String[] essayArray = essay.split(" ");

        //new
        String lineToPrint = "";

        for (String nextWord : essayArray) {
//            String lineToPrint = "";
            //new
            if (lineToPrint.length() + nextWord.length() <= k) {
                if (lineToPrint.length() == 0) {
                    lineToPrint = nextWord;
                } else {
                    lineToPrint = lineToPrint + " " + nextWord;
                }
            } else {
                io.println(lineToPrint);
                lineToPrint = nextWord;
            }

        }
        io.println(lineToPrint);


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
