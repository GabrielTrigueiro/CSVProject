import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws IOException {

    }

    public static void execTransf(){

        //iniciar contagem do tempo
        long tempoInicial = System.currentTimeMillis();

        //pegar o caminho dos dois arquivos base
        File fileData = new File("dataBase.csv");
        String urlData = fileData.getAbsolutePath();

        File fileStation = new File("dataStations.csv");
        String urlStations = fileStation.getAbsolutePath();

        //executar primeira transformação
        firstTransf(urlData, urlStations);

        //encontrar path do arquivo gerado
        File fileLAMetro = new File("LAMetroTrips.csv");
        String urlLAMetro = fileLAMetro.getAbsolutePath();

        //executar segunda transformação
        secondTransf(urlLAMetro);

        //finalizar e mostrar duração da execução
        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Tempo da segunda execução: " + tempoExecucaoSegundos + " segundos");
    }

    public static void firstTransf(String arquivo1, String arquivo2){
        TrocarIds transformers = new TrocarIds();
        transformers.substituirIDs(arquivo1, arquivo2);

    }

    public static void secondTransf(String arquivo){
        FiltrarDataBase filtro = new FiltrarDataBase();
        filtro.filtrarData(arquivo);
    }
}