package ordenacoes;
import transformacoes.FuncoesDeArquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HeapSort_Duration  {
    public static String[][] lerCSVNovo2(String caminhoArquivo) {

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
    public static void heapSort_Duration_method(String url) {
        String arquivoEntrada = url;
        String arquivoSaida = "LAMetroTrips_duration_HeapSort_medioCaso.csv";

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
            String[][] dataBruta = lerCSVNovo2(url);


            heapSort(dataBruta);


            escritor.write(dataBruta[dataBruta.length - 1][0]);
            for (int j = 1; j < dataBruta[dataBruta.length - 1].length; j++) {
                escritor.write("," + dataBruta[dataBruta.length - 1][j]);
            }
            escritor.write(System.lineSeparator());

            for (int i = 0; i < dataBruta.length - 1; i++) {
                escritor.write(dataBruta[i][0]);
                for (int j = 1; j < dataBruta[i].length; j++) {
                    escritor.write("," + dataBruta[i][j]);
                }
                escritor.write(System.lineSeparator());
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }




    public static void heapSort(String[][] data) {
        // Transformar a matriz em um heap
        int n = data.length ;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i + 1);
        }

        // Extrair o maior elemento do heap e colocá-lo na posição correta
        for (int i = n - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, i, 0);
        }
    }

    private static void heapify(String[][] data, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && Integer.parseInt(data[left][1]) > Integer.parseInt(data[largest][1]))
            largest = left;

        if (right < n && Integer.parseInt(data[right][1]) > Integer.parseInt(data[largest][1]))
            largest = right;

        if (largest != i) {
            swap(data, i, largest);
            heapify(data, n, largest);
        }
    }

    private static void swap(String[][] data, int i, int j) {
        String[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

