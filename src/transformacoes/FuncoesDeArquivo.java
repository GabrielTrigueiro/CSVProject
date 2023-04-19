package transformacoes;

import casos.StNameDuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FuncoesDeArquivo {

    public static void execTransf(){

        long tempoInicial = System.currentTimeMillis();

        File fileData = new File("data.csv");
        String urlData = fileData.getAbsolutePath();
        File fileStation = new File("stations.csv");
        String urlStations = fileStation.getAbsolutePath();

        //1º
//        TrocarIds.substituirIDs(urlData, urlStations);

        File fileLAMetro = new File("LAMetroTrips.csv");
        String urlLAMetro = fileLAMetro.getAbsolutePath();

        //2º
//        FiltrarDataBase.filtrarData(urlLAMetro);

        //3º
//        MediaGeral.realizarFiltro(urlLAMetro);

        StNameDuration.createData(urlLAMetro);

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
