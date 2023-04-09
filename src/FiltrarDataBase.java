import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FiltrarDataBase {

    //lê o aquivo csv e armazena os dados
    public static String[][] lerCSVNovo(String caminhoArquivo) {
        String[][] dados = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            int linhas = 0;
            int colunas = 0;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(" ");
                if (dados == null) {
                    colunas = valores.length;
                    dados = new String[TrocarIds.contarLinhas(caminhoArquivo)][colunas];
                }
                for (int i = 0; i < valores.length; i++) {
                    dados[linhas][i] = valores[i];
                }
                linhas++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    public static void filtrarData(String urlArquivo) throws IOException {

        FileWriter writer = new FileWriter("LAMetroTrips_F1.csv");
        String[][] dataBruta = lerCSVNovo(urlArquivo);

        String value = "Pasadena";

        for (int i = 1; i < dataBruta.length; i++) {
            for (int j = 0; j < dataBruta[i].length; j++) {
                if(Objects.equals(dataBruta[i][9], value) | Objects.equals(dataBruta[i][10], value)){
                    for (int k = 0; k < dataBruta[i].length; k++) {
                        writer.write(dataBruta[i][k] + " ");
                    }
                }
                writer.write(System.lineSeparator());
            }
        }
        writer.close();
    }
}
