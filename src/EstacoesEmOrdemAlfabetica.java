import java.io.*;


public class EstacoesEmOrdemAlfabetica {
    public static void bubbleSort(String urlArquivo) throws IOException {

        String arquivoEntrada = urlArquivo;
        String arquivoSaida = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTripsTESTEBUBBLE.csv";


        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));

            // Lê a primeira linha do arquivo (cabeçalho) e escreve na saída
            String linha = leitor.readLine();
            escritor.write(linha);
            escritor.newLine();

            // Lê as demais linhas e as armazena em um array de strings
            String[] linhas = new String[FuncoesDeArquivo.contarLinhas("C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTrips.csv")]; // assume que não haverá mais de 1000 linhas
            int numLinhas = 0;
            while ((linha = leitor.readLine()) != null) {
                linhas[numLinhas] = linha;
                numLinhas++;
            }

            // Ordena o array de linhas pelo nome da estacao usando bubblesort
            boolean trocou = true;
            while (trocou) {
                trocou = false;
                for (int i = 1; i < numLinhas - 1; i++) {
                    String[] dados1 = linhas[i].split(",");
                    String[] dados2 = linhas[i + 1].split(",");
                    String nome1 = dados1[9].trim(); // índice 9 = nome da estacao
                    String nome2 = dados2[9].trim();

                    if (nome1.compareToIgnoreCase(nome2) > 0) {
                        // troca as linhas de posição
                        String temp = linhas[i];
                        linhas[i] = linhas[i + 1];
                        linhas[i + 1] = temp;
                        trocou = true;
                    }
                }
            }

            // Escreve as linhas ordenadas no arquivo de saída
            for (int i = 0; i < numLinhas; i++) {
                escritor.write(linhas[i]);
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }

    }
}
