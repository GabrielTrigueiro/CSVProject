import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TransformarCSV {
    //lê a quantidade de linhas do arquivo
    public static int contarLinhas(String caminhoArquivo) {
        int linhas = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
            while (br.readLine() != null) {
                linhas++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    //lê o aquivo csv e armazena os dados
    public static String[][] lerCSV(String caminhoArquivo) {
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
                    dados = new String[contarLinhas(caminhoArquivo)][colunas];
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

    //faz a transformação
    public static String[][] substituirIDs(String caminhoArquivo1, String caminhoArquivo2) {
        String[][] dados1 = lerCSV(caminhoArquivo1);
        String[][] dados2 = lerCSV(caminhoArquivo2);
        for (int i = 1; i < dados1.length; i++) {
            String id = dados1[i][0];
            for (int j = 1; j < dados2.length; j++) {
                if (dados2[j][0].equals(id)) {
                    for (int k = 1; k < dados2[j].length; k++) {
                        dados1[i][k] = dados2[j][k];
                    }
                    break;
                }
            }
        }
        return dados1;
    }

}
