package casos;

import ordenacoes.MergeSort;
import transformacoes.FuncoesDeArquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StNameAlfabetic {

    public static void createDataAlfa(String url, String saida){

        File fileLAMetro = new File(url);
        String urlLAMetro = fileLAMetro.getAbsolutePath();
        String[][] laReaded = FuncoesDeArquivo.lerCSVNovo(urlLAMetro);

       mergeSortMelhorCaso(laReaded, saida);

    }


    public static void createData(String url){

        File fileLAMetro = new File(url);
        String urlLAMetro = fileLAMetro.getAbsolutePath();
        String[][] laReaded = FuncoesDeArquivo.lerCSVNovo(urlLAMetro);

        createBestCase(laReaded);
        createWorstCase(laReaded);
    }
    public static void createBestCase(String[][] fileReaded){
        mergeSortMelhorCaso(fileReaded, "LAMetroTrips_Alfabetic_MelhorCaso.csv");
    }
    public static void createWorstCase(String[][] fileReaded){
        mergeSortPiorCaso(fileReaded, "LAMetroTrips_Alfabetic_PiorCaso.csv");
    }
    public static void mergeSortMelhorCaso(String[][] arr, String arquivoSaida) {
        mergeSort(arr, 1, arr.length - 1);
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));

            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length - 1; j++) {
                    escritor.write(arr[i][j] + ",");
                }
                escritor.write(arr[i][arr[i].length-1]);
                escritor.write(System.lineSeparator());
            }
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    public static void mergeSortPiorCaso(String[][] arr, String arquivoSaida){
        mergeSort(arr, 1, arr.length - 1);
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
            for (int i = arr.length-1; i > 1 ; i--) {
                for (int j = 0; j < arr[i].length - 1; j++) {
                    escritor.write(arr[i][j] + ",");
                }
                escritor.write(arr[i][arr[i].length-1]);
                escritor.write(System.lineSeparator());
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    public static void mergeSort(String[][] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void merge(String[][] arr, int start, int mid, int end) {
        String[][] temp = new String[end - start + 1][];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (compare(arr[i][9], arr[j][9]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[start + p] = temp[p];
        }
    }
    public static int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (Character.isDigit(c1) && Character.isDigit(c2)) {
                // Extrai os números inteiros completos
                int num1 = 0, num2 = 0;
                while (i < len1 && Character.isDigit(s1.charAt(i))) {
                    num1 = num1 * 10 + Character.getNumericValue(s1.charAt(i));
                    i++;
                }
                while (j < len2 && Character.isDigit(s2.charAt(j))) {
                    num2 = num2 * 10 + Character.getNumericValue(s2.charAt(j));
                    j++;
                }
                // Compara os números inteiros
                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }
            } else if (Character.isDigit(c1)) {
                // s2 começa com letra, então s1 é menor
                return -1;
            } else if (Character.isDigit(c2)) {
                // s1 começa com letra, então s2 é menor
                return 1;
            } else {
                // Compara as strings como antes
                int cmp = s1.compareTo(s2);
                if (cmp != 0) {
                    return cmp;
                }
                i++;
                j++;
            }
        }
        // Trata o caso em que os números são iguais mas as strings possuem
        // tamanhos diferentes
        if (i < len1) {
            return 1;
        } else if (j < len2) {
            return -1;
        } else {
            return 0;
        }
    }
}
