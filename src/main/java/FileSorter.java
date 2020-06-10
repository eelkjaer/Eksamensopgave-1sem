import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSorter{
    private final File originalFile;

    public FileSorter(){
        this.originalFile = new File("");
    }

    public FileSorter(File originalDataFile){
        this.originalFile = originalDataFile;
    }

    public static void sighej(){
        System.out.println("hej thorbjørn");
    }

    public void sortWordsFromFile() {
        try {
            ArrayList<String> unsortedList = readWordsFromFile(this.originalFile);
            ArrayList<String> sortedList = sortList(unsortedList);
            writeWordsToFile(sortedList);
        } catch (Exception e){
            System.out.println("Exception thrown: " + e);
        }
    }

    private ArrayList<String> readWordsFromFile(File file) {
        ArrayList<String> tmpList = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(file);

            if (!file.exists()) {
                throw new FileNotFoundException("Filen findes ikke!");
            }

            while (fileReader.hasNextLine()) {
                String str = fileReader.nextLine();
                tmpList.add(str.toLowerCase());
            }

            System.out.println("Original array: " + tmpList);
        } catch(FileNotFoundException e){
            System.out.println("Exception catched: " +e);
        }
        return tmpList;
    }

    private ArrayList<String> sortList(ArrayList<String> unsortedList){
        ArrayList<String> sortedList = new ArrayList<>();

        for(String word: unsortedList){
            if(!sortedList.contains(word)){
                sortedList.add(word);
            } else {
                System.out.println("\"" + word + "\" fandtes allerede.");
            }
        }
        Collections.sort(sortedList);
        System.out.println("Sorted array: " + sortedList);

        return sortedList;
    }

    private void writeWordsToFile(ArrayList<String> list) {
        File newFile = new File("Data/newfile.csv");
        try {
            if (!this.originalFile.exists()) {
                newFile.createNewFile();
            }

            FileWriter fw = new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);

            for(String word: list){
                bw.write(word);
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (IOException e){
            System.out.println("Exception catched: " +e);
        }

    }
}
