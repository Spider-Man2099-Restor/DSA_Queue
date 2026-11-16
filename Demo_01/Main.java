import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*IO.println("WOMEN : ");
    for (String string : female) {
        IO.println(string);
    }

    IO.println("MEN : ");
    for (String string : male) {
        IO.println(string);
    } */

void main() {

    Queue<String> female = new LinkedList<>();
    Queue<String> male = new LinkedList<>();
    int femaleCount = 0, maleCount = 0;
    String waiting = "";
    int limit = 0;

    try (Scanner sc = new Scanner(
            new File("H:\\New Testament\\College\\2ndYear\\ITC121 (DSA)\\Queue\\Demo_01\\data.txt"))) {

        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            if (str.startsWith("F")) {
                female.add(str);
            } else if (str.startsWith("M")) {
                male.add(str);
            }
        }
        femaleCount = female.size();
        maleCount = male.size();
    } catch (Exception e) {
        e.printStackTrace();
    }

    IO.println(femaleCount + " | " + maleCount);

    if (femaleCount > maleCount) {
        waiting = "male";
        limit = maleCount;
    } else {
        waiting = "female";
        limit = femaleCount;
    }

    int time = 0;

    for (int i = 0; i < limit; i++) {
        String f[] = female.poll().split(" ");
        String m[] = male.poll().split(" ");
        time += Integer.parseInt(f[2]) + Integer.parseInt(m[2]);
        IO.println("The female dancer is " + f[1] + " and the male dancer is " + m[1]  + " (" + time + " seconds consumed from the timer before the next pair can dance)");
    }
}
