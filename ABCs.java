import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABCs {

    public static void main(String[] args) throws FileNotFoundException {

        // USACO 2020 December Contest, Bronze
        // Problem 1. Do You Know Your ABCs?

        // link: http://www.usaco.org/index.php?page=viewproblem2&cpid=1059

        Kattio io = new Kattio();

        String input = io.nextLine();

        int[] numbers = intArrayOf(input);

        Arrays.sort(numbers);

        int a = numbers[0];
        int b = numbers[1];
        int c = (numbers[numbers.length - 1] - a - b);

        io.println(a + " " + b + " " + c);
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