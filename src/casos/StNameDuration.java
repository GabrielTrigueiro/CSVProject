package casos;

import ordenacoes.MergeSort;
import transformacoes.FuncoesDeArquivo;

import java.io.File;

public class StNameDuration {
    //executar manipulações
    public static void createData(String path){
        File fileLAMetro = new File("LAMetroTrips.csv");
        String urlLAMetro = fileLAMetro.getAbsolutePath();
        String[][] fileReaded = FuncoesDeArquivo.lerCSVNovo(urlLAMetro);
        createBestCase(fileReaded);
    }
    //melhor caso
    public static void createBestCase(String[][] file){
        MergeSort.mergeSort(file,1, "LAMetroTrips_MelhorCaso.csv");
    }
}
