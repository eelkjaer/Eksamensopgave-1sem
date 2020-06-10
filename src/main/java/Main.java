import java.io.File;

public class Main {

    public static void main(String[] args) {
        File originalFile = new File("Data/olddata.csv");
        FileSorter.sighej();
	    FileSorter fs = new FileSorter(originalFile);
	    fs.sortWordsFromFile();
    }
}
