import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();
            sb = new StringBuilder();
            for (char c : br.readLine().toCharArray()) {
                if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                    cursor.add(c);
                } else if (c == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (c == '>') {
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else if (c == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                }
            }
            
            for (Character ch : list) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}
