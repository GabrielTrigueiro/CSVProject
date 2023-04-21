package ordenacoes;
import transformacoes.FuncoesDeArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort {
    public static void mergeSort(String[][] url, int index, String arquivoSaida) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
            mergesort(url, 1, url.length - 1, index); // índice 1 = duration

            for (int i = 0; i < url.length; i++) {
                for (int j = 0; j < url[i].length - 1; j++) {
                    escritor.write(url[i][j] + ",");
                }
                escritor.write(url[i][url[i].length-1]);
                escritor.write(System.lineSeparator());
            }
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    public static void mergeSortPiorCaso(String[][] url, int index, String arquivoSaida){
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
            mergesort(url, 1, url.length - 1, index); // índice 1 = duration

            for (int i = url.length-1; i > 0 ; i--) {
                for (int j = 0; j < url[i].length - 1; j++) {
                    escritor.write(url[i][j] + ",");
                }
                escritor.write(url[i][url[i].length-1]);
                escritor.write(System.lineSeparator());
            }
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    private static void mergesort(String[][] a, int esq, int dir, int coluna) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(a, esq, meio, coluna);
            mergesort(a, meio + 1, dir, coluna);
            merge(a, esq, meio, dir, coluna);
        }
    }
    private static void merge(String[][] a, int esq, int meio, int dir, int coluna) {
        String[][] temp = new String[dir - esq + 1][];
        int i = esq, j = meio + 1, k = 0;

        while (i <= meio && j <= dir) {
            if (Integer.parseInt(a[i][coluna]) <= Integer.parseInt(a[j][coluna])) {
                temp[k] = a[i];
                k++;
                i++;
            } else {
                temp[k] = a[j];
                k++;
                j++;
            }
        }

        while (i <= meio) {
            temp[k] = a[i];
            k++;
            i++;
        }

        while (j <= dir) {
            temp[k] = a[j];
            k++;
            j++;
        }

        for (k = 0; k < temp.length; k++) {
            a[esq + k] = temp[k];
        }
    }
}
