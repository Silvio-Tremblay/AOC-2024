import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class part1 {
    public static void main(String[] args) {

        try {
            File myObj = new File("src/input.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            while (myReader.hasNextInt()) {
                int n = myReader.nextInt();
                int m = myReader.nextInt();
                list1.add(n);
                list2.add(m);
            }
            Collections.sort(list1);
            Collections.sort(list2);
            int distance = 0;

            for (int i = 0; i < list1.size(); i++) {
                distance += Math.abs(list1.get(i) - list2.get(i));
            }
            System.out.println(distance);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}