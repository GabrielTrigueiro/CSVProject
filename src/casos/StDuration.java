package casos;

import ordenacoes.MergeSort;
import transformacoes.FuncoesDeArquivo;

import java.io.File;

public class StDuration {
    public static void createData(String url){
        File fileLAMetro = new File(url);
        String urlLAMetro = fileLAMetro.getAbsolutePath();
        String[][] fileReaded = FuncoesDeArquivo.lerCSVNovo(urlLAMetro);

        createBestCase(fileReaded);
        createWorstCase(fileReaded);
    }
    public static void createBestCase(String[][] fileReaded){
        MergeSort.mergeSort(fileReaded,1, "LAMetroTrips_Duration_MelhorCaso.csv");
    }
    public static void createWorstCase(String[][] fileReaded){
        MergeSort.mergeSortPiorCaso(fileReaded, 1, "LAMetroTrips_Duration_PiorCaso.csv");
    }
}
