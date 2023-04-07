import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:/Users/gabri/OneDrive/Documentos/Trabalho/ProjetoCSV/src/names.csv";

        BufferedReader br = new BufferedReader(new FileReader(path));

    }
}