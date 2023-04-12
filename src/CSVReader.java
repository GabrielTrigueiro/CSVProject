import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws IOException {

        //primeiraTransoformacao();
        //segundaTransformacao();
        EstacoesEmOrdemAlfabetica.bubbleSort("C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTrips.csv");



    }



    public static void primeiraTransoformacao(){
        //marcar tempo de execução
        long tempoInicial = System.currentTimeMillis();

        TrocarIds transformers = new TrocarIds();
        String arquivo1 = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/src/dados.csv";
        String arquivo2 = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/src/stations.csv";

        transformers.substituirIDs(arquivo1, arquivo2);

        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Tempo da primeira execução: " + tempoExecucaoSegundos + " segundos");
    }

    public static void segundaTransformacao() throws IOException {
        long tempoInicial = System.currentTimeMillis();

        String arquivoBrutoPath = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTrips.csv";
        FiltrarDataBase filtro = new FiltrarDataBase();
        filtro.filtrarData(arquivoBrutoPath);

        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Tempo da segunda execução: " + tempoExecucaoSegundos + " segundos");
    }
}