import java.io.*;
import java.util.StringTokenizer;

public class Word {

    public static void main(String[] args) throws IOException {

        // USACO 2020 January Contest, Bronze
        // Problem 1. Word Processor

        // link: http://www.usaco.org/index.php?page=viewproblem2&cpid=987

        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter("word.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] essayArray = br.readLine().split(" ");

        String lineToPrint = essayArray[0];
        String nextWord;
        int currentLength = lineToPrint.length();

        for (int i=1; i<n; i++) {
            nextWord = essayArray[i];
            if (currentLength + nextWord.length() <= k) {
                lineToPrint = lineToPrint + " " + nextWord;
                currentLength += nextWord.length();
            } else {
                pw.println(lineToPrint);
                lineToPrint = nextWord;
                currentLength = lineToPrint.length();
            }

        }
        pw.print(lineToPrint);

        pw.close();
    }

}
