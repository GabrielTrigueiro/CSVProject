import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws IOException {

        //path do arquivo
        String path = "C:/Users/gabri/OneDrive/Documentos/Trabalho/ProjetoCSV/src/names.csv";
        //storage
        String linha = "";
        //leitor de linhas
        BufferedReader br = new BufferedReader(new FileReader(path));

        //ler até o fim do arquivo
        while((linha = br.readLine()) != null){
            //slit em cada virgula
            String[] values = linha.split(",");
            System.out.println(values[0]);
        }
    }
}