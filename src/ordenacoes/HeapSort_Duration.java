package ordenacoes;
import transformacoes.FuncoesDeArquivo;
import transformacoes.TrocarIds;

import java.io.*;


public class HeapSort_Duration  {
    public static void createData(){
        File melhor = new File("LAMetroTrips_Duration_MelhorCaso.csv");
        String urlLAMetroMelhor = melhor.getAbsolutePath();

        File medio = new File("LAMetroTrips.csv");
        String urlLAMetroMedio = medio.getAbsolutePath();

        File pior = new File("LAMetroTrips_Duration_PiorCaso.csv");
        String urlLAMetroPior = pior.getAbsolutePath();

        heapSort_Duration_method(urlLAMetroMelhor, "LAMetroTrips_duration_heapSort_melhorCaso.csv");
        heapSort_Duration_method(urlLAMetroMedio, "LAMetroTrips_duration_heapSort_medioCaso.csv");
        heapSort_Duration_method(urlLAMetroPior, "LAMetroTrips_duration_heapSort_piorCaso.csv");
    }
    public static void heapSort_Duration_method(String url, String saida) {
        String[][] dataBruta = FuncoesDeArquivo.lerCSVNovo(url);
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(saida));
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

