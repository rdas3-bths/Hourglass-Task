import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = getMatrix("data/hourglass_data");
        System.out.println("Max sum is: " + findHighestHourglass(matrix));

    }

    public static int findHighestHourglass(int[][] matrix) {
        return 0;
    }

    public static int[][] getMatrix(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                int number = Integer.parseInt(d.charAt(j) + "");
                matrix[i][j] = number;
            }
        }
        return matrix;

    }

    public static void generateRandomMatrix(String fileName) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (int i = 0; i < 50; i++) {
                String line = "";
                for (int j = 0; j < 50; j++) {
                    int r = (int)(Math.random()*10);
                    line = line + r;
                }
                if (i == 49) {
                    fw.write(line);
                }
                else
                    fw.write(line + "\n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Error");
            System.exit(1);
        }

    }
}