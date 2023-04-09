import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CSVReader {
    public static void main(String[] args) throws IOException {

        primeiraTransoformacao();

        //segundaTransformacao();

    }
    public static void primeiraTransoformacao(){
        //marcar tempo de execução
        long tempoInicial = System.currentTimeMillis();

        TrocarIds transformers = new TrocarIds();
        String arquivo1 = "C:/Users/gabri/OneDrive/Documentos/Trabalho/ProjetoCSV/src/data.csv";
        String arquivo2 = "C:/Users/gabri/OneDrive/Documentos/Trabalho/ProjetoCSV/src/stations.csv";

        transformers.substituirIDs(arquivo1, arquivo2);

        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Tempo de execução: " + tempoExecucaoSegundos + " segundos");
    }

    public static void segundaTransformacao() throws IOException {
        long tempoInicial = System.currentTimeMillis();

        String arquivoBrutoPath = "C:/Users/gabri/OneDrive/Documentos/Trabalho/ProjetoCSV/LAMetroTrips.csv";
        FiltrarDataBase filtro = new FiltrarDataBase();
        filtro.filtrarData(arquivoBrutoPath);

        long tempoFinal = System.currentTimeMillis();
        double tempoExecucaoSegundos = (tempoFinal - tempoInicial) / 1000.0;
        System.out.println("Tempo de execução: " + tempoExecucaoSegundos + " segundos");
    }
}