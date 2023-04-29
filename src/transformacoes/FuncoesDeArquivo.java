package transformacoes;

import casos.StDuration;
import casos.StNameAlfabetic;
import ordenacoes.HeapSort_Duration;
import ordenacoes.MergeSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FuncoesDeArquivo {

    public static void execTransf() throws IOException {

        long tempoInicial = System.currentTimeMillis();

        File fileData = new File("data.csv");
        String urlData = fileData.getAbsolutePath();
        File fileStation = new File("stations.csv");
        String urlStations = fileStation.getAbsolutePath();

       TrocarIds.substituirIDs(urlData, urlStations);

       File fileLAMetro = new File("LAMetroTrips.csv");
        String urlLAMetro = fileLAMetro.getAbsolutePath();


       FiltrarDataBase.filtrarData(urlLAMetro);
     MediaGeral.realizarFiltro(urlLAMetro);

        StDuration.createData(urlLAMetro);

        File MergeBestCase = new File("LAMetroTrips_Duration_MelhorCaso.csv");
        String MergeBestCaseDuration = MergeBestCase.getAbsolutePath();

        File MergeWorstCase = new File("LAMetroTrips_Duration_PiorCaso.csv");
        String MergeWorstCaseDuration = MergeWorstCase.getAbsolutePath();

        MergeSort.createDataDuration(MergeBestCaseDuration, "LAMetroTrips_duration_MergeSort_melhorCaso.csv");
        MergeSort.createDataDuration(MergeWorstCaseDuration, "LAMetroTrips_duration_MergeSort_piorCaso.csv");
        MergeSort.createDataDuration(urlLAMetro, "LAMetroTrips_duration_MergeSort_medioCaso.csv");


        StNameAlfabetic.createData(urlLAMetro);

        File AlfabeticBestCase = new File("LAMetroTrips_Alfabetic_MelhorCaso.csv");
        String  AlfabeticBestCaseS = AlfabeticBestCase.getAbsolutePath();

        File AlfabeticWorstCase = new File("LAMetroTrips_Alfabetic_piorCaso.csv");
        String  AlfabeticWorstCaseS = AlfabeticWorstCase.getAbsolutePath();

        StNameAlfabetic.createDataAlfa(AlfabeticBestCaseS, "LAMetroTrips_station_MergeSort_melhorCaso.csv");
        StNameAlfabetic.createDataAlfa(AlfabeticWorstCaseS, "LAMetroTrips_station_MergeSort_piorCaso.csv");
        StNameAlfabetic.createDataAlfa(urlLAMetro, "LAMetroTrips_station_MergeSort_medioCaso.csv");


        HeapSort_Duration.createData();

        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Transformações duraram: " + tempoExecucaoSegundos + " segundos");
    }
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
