import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class part2 {
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
            int similarity = 0;
            int appearances = 0;

            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(i).equals(list2.get(j))) {
                        appearances++;
                    }
                }
                similarity += (appearances * list1.get(i));
                appearances = 0;
            }
            System.out.println(similarity);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
