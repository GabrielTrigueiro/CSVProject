import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FuncoesDeArquivo {

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
                    dados = new String[FuncoesDeArquivo.contarLinhas(caminhoArquivo)][colunas];
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

}
