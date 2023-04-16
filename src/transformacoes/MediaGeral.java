package transformacoes;

import java.io.FileWriter;
import java.io.IOException;

public class MediaGeral {

    public static void realizarFiltro(String urlArquivo){
        String[][] arquivoInMemory = FuncoesDeArquivo.lerCSVNovo(urlArquivo);
        filtrarPorTempo(arquivoInMemory, descobrirMediaGeral(arquivoInMemory));
    }
    public static double descobrirMediaGeral(String[][] arquivo){

        int somaGeral = 0;

        int linhas = 0;

        double mediaGeral = 0;

        for (int i = 1; i < arquivo.length; i++) {
            for (int j = 0; j < arquivo[i].length; j++) {
                somaGeral += Integer.parseInt(arquivo[i][1]);
            }
            linhas++;
        }
        mediaGeral = (double) somaGeral /linhas;
        System.out.println("Media Geral: " + mediaGeral);
        return mediaGeral;
    }
    public static void filtrarPorTempo(String[][] arquivo, double mediaGeral){

        try{

            FileWriter writer = new FileWriter("LAMetroTrips_F2.csv");

            for (int i = 1; i < arquivo.length; i++) {
                int tempoByIndex = Integer.parseInt(arquivo[i][1]);
                if(tempoByIndex > mediaGeral){
                    for (int j = 0; j < arquivo[i].length-1; j++) {
                        writer.write(arquivo[i][j] + ",");
                    }
                    writer.write(arquivo[i][arquivo[i].length-1]);
                    writer.write(System.lineSeparator());
                }
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
}

