package leha_help;

import java.io.*;
import java.util.ArrayList;

public class CftTest {
    private static ArrayList<String> inputFromFile(String inputFile) throws IOException {
        ArrayList<String> inputArray = new ArrayList<>();
        File f = new File(inputFile);
        if (f.length() == 0) {
            throw new IOException("файл пустой");
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        } catch (FileNotFoundException e) {
            throw new IOException("файл не найден");
        }
        String line;
        while ((line = br.readLine()) != null) {
            inputArray.add(line);
        }
        return inputArray;
    }

    private static void outputInFile(String outputFile, Comparable[] array) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        for (int i = 0; i < array.length; i++) {
            writer.println(array[i]);
        }
        writer.close();
    }

    private static void insertSorting(String directOfSort, Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable tmp = array[i];
            int j = i - 1;

            while (j >= 0 && (("-a".equals(directOfSort) && (array[j]).compareTo(tmp) > 0) || ("-d".equals(directOfSort) && (array[j]).compareTo(tmp) < 0))) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            if (args.length < 4) {
                throw new IllegalArgumentException("должно быть указано 4 параметра");
            }
            ArrayList<String> inputArray = inputFromFile(args[0]);

            if (!("-a".equals(args[3]) || "-d".equals(args[3]))) {
                throw new Exception("Error in 4 parameter");
            }

            Comparable[] array = null;
            if (args[2].equals("-i")) {
                array = new Integer[inputArray.size()];
                try {
                    for (int i = 0; i < inputArray.size(); i++) {
                        array[i] = Integer.parseInt(String.valueOf(inputArray.get(i)));
                    }
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("не число");
                }
            } else if (args[2].equals("-s")) {
                array = new String[inputArray.size()];
                for (int i = 0; i < inputArray.size(); i++) {
                    array[i] = String.valueOf(inputArray.get(i));
                }
            } else {
                throw new RuntimeException("adsf");
            }

            insertSorting(args[3], array);

            outputInFile(args[1], array);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}