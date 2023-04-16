import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrocarIds {

    //faz a transformação
    public static void substituirIDs(String caminhoArquivo1, String caminhoArquivo2) {
        String[][] dados1 = FuncoesDeArquivo.lerCSVNovo(caminhoArquivo1);
        String[][] dados2 = FuncoesDeArquivo.lerCSVNovo(caminhoArquivo2);
        for (int i = 1; i < dados1.length; i++) {
            String id = dados1[i][9];

            String id2 = dados1[i][10];

            for (int j = 1; j < dados2.length; j++) {
                if (dados2[j][0].equals(id)) {
                    for (int k = 1; k < dados2[j].length; k++) {
                        dados1[i][9] = dados2[j][1];
                    }
                    break;
                }
            }

            for (int j = 1; j < dados2.length; j++) {
                if (dados2[j][0].equals(id2)) {
                    for (int k = 1; k < dados2[j].length; k++) {
                        dados1[i][10] = dados2[j][1];
                    }
                    break;
                }
            }
        }
        try {
            FileWriter writer = new FileWriter("LAMetroTrips.csv");

            for (int i = 0; i < dados1.length; i++) {
                for (int j = 0; j < dados1[i].length-1; j++) {
                    writer.write(dados1[i][j] + ",");
                }
                writer.write(dados1[i][dados1[i].length-1]);
                writer.write(System.lineSeparator());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }

}
