import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/input.txt");
            Scanner myReader = new Scanner(myObj);
            int safe = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] split = line.split(" ");
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    list.add(Integer.parseInt(split[i]));
                }
                String order = "";
                boolean saved  = false;
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i - 1).equals(list.get(i)) || list.get(i) > list.get(i - 1) + 3 ||
                            list.get(i) < list.get(i - 1) - 3) {
                        break;
                    } else if (list.get(i) > list.get(i - 1) && !order.equals("decreasing")){
                        order = "increasing";
                    } else if  (list.get(i) < list.get(i - 1) && !order.equals("increasing")){
                        order = "decreasing";
                    } else {
                        break;
                    }
                    if (i == list.size() - 1) {
                        safe++;
                        saved = true;
                    }
                }
                while (!saved) {
                    for (int n = 0; n < list.size(); n++) {
                        ArrayList<Integer> temp = new ArrayList<>(list);
                        list.remove(n);
                        order = "";
                        for (int i = 1; i < list.size(); i++) {
                            if (list.get(i - 1).equals(list.get(i)) || list.get(i) > list.get(i - 1) + 3 ||
                                    list.get(i) < list.get(i - 1) - 3) {
                                break;
                            } else if (list.get(i) > list.get(i - 1) && !order.equals("decreasing")) {
                                order = "increasing";
                            } else if (list.get(i) < list.get(i - 1) && !order.equals("increasing")) {
                                order = "decreasing";
                            } else {
                                break;
                            }
                            if (i == list.size() - 1) {
                                safe++;
                                saved = true;
                            }
                        }
                        if (saved) {
                            break;
                        }
                        list = temp;
                    }
                    break;
                }
            }
            System.out.println(safe);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
