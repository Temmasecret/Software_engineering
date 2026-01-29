import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class main{
    public static void main(String[] args){
        System.out.println("Hello world");
        File obj = new File("tst.txt");
        ArrayList<String> arr = new ArrayList<String>();
        try (Scanner run = new Scanner(obj)){
            while (run.hasNextLine()) {
                String data = run.nextLine();
                arr.add(data);
            }
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(arr.size());
        ArrayList<String> sorted_arr = The_sort(arr);
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            for (String str : sorted_arr) {
                myWriter.write(str + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Boolean cmp(String str1, String str2){
        for (int i = 0; i< str1.length(); i++)
        {
            if (i >= str2.length()) return true;
            if (str1.charAt(i) > str2.charAt(i)) return true;
            else if (str1.charAt(i) < str2.charAt(i)) return false;
        }
        return false;
    }

    public static ArrayList<String> The_sort(ArrayList<String> arr){
        for (int i = 0 ; i<arr.size();i++)
        {
            String No_1 = arr.get(i);
            int pos = i;
            for (int j=i+1; j< arr.size();j++)
            {
                if(!cmp(No_1,arr.get(j)))
                {
                    No_1 = arr.get(j);
                    pos = j;
                }
            }
            String temp = arr.get(i);
            arr.set(i, No_1);
            arr.set(pos, temp);
        }
        return arr;
    }
}