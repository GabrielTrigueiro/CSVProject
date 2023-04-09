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
                String[] valores = linha.split(",");
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

                boolean possui = false;
                String[] index1 = quebrarIndex(dataBruta[i][9]);
                String[] index2 = quebrarIndex(dataBruta[i][10]);

                for (String palavra: index1) {
                    if(palavra.equals(value)){
                        possui = true;
                        break;
                    }
                }

                for (String palavra: index2) {
                    if(palavra.equals(value)){
                        possui = true;
                        break;
                    }
                }

                if(possui) {
                    for (int j = 0; j < dataBruta[i].length-1; j++) {
                        writer.write(dataBruta[i][j] + ",");
                    }
                    writer.write(dataBruta[i][dataBruta[i].length-1]);
                    writer.write(System.lineSeparator());
                }
        }
        writer.close();
    }
    public static String[] quebrarIndex(String index){
        return index.split(" ");
    }
}

