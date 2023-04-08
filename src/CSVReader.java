import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws IOException {

      TransformarCSV transformers = new TransformarCSV();
      String arquivo1 = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/src/dados.csv";
      String arquivo2 = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/src/stations.csv";

      transformers.substituirIDs(arquivo1, arquivo2);



    }

}