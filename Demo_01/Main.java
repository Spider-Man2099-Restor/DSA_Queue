import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<String[]> femaleQueue = new LinkedList<>();
        Queue<String[]> maleQueue = new LinkedList<>();

        int totalTime = 0; // Running cumulative timer

        try (Scanner sc = new Scanner(new File("data.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ");
                char gender = parts[0].charAt(0);
                int timeVal = Integer.parseInt(parts[2]);

                // Accumulate time as each person is processed from the input
                totalTime += timeVal;

                if (gender == 'F') {
                    if (!maleQueue.isEmpty()) {
                        String[] m = maleQueue.poll();
                        System.out.println("The Female dancer is " + parts[1] + " and the male dancer is " + m[1] + 
                                           " (" + totalTime + " second/s consumed from the timer before they dance)");
                    } else {
                        femaleQueue.add(parts);
                    }
                } else if (gender == 'M') {
                    if (!femaleQueue.isEmpty()) {
                        String[] f = femaleQueue.poll();
                        System.out.println("The Female dancer is " + f[1] + " and the male dancer is " + parts[1] + 
                                           " (" + totalTime + " second/s consumed from the timer before they dance)");
                    } else {
                        maleQueue.add(parts);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print remaining spares who didn't get a partner
        if (!femaleQueue.isEmpty()) {
            System.out.println(femaleQueue.size() + " female dancer/s are waiting to dance");
        } else if (!maleQueue.isEmpty()) {
            System.out.println(maleQueue.size() + " male dancers are waiting to dance");
        }
    }
}