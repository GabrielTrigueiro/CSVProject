import transformacoes.FuncoesDeArquivo;

import java.io.*;


public class EstacoesEmOrdemAlfabetica {
    public static void bubbleSort(String urlArquivo) throws IOException {
        String arquivoEntrada = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTrips.csv";
        String arquivoSaida = "C:/Users/tomou/OneDrive/Desktop/ProjetoEstruturaDeDados/CSVProject/LAMetroTripsBubbleSort.csv";
        String separador = ",";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));

            // Lê a primeira linha do arquivo (cabeçalho) e escreve na saída
            String linha = leitor.readLine();
            escritor.write(linha);
            escritor.newLine();

            // Lê as demais linhas e as armazena em um array bidimensional
            String[][] dados = FuncoesDeArquivo.lerCSVNovo(arquivoEntrada);
            int numLinhas = FuncoesDeArquivo.contarLinhas(arquivoEntrada);

            // Ordena o array bidimensional pelo nome do cliente usando bubblesort
            boolean trocou = true;
            while (trocou) {
                trocou = false;
                for (int i = 1; i < numLinhas - 1; i++) {
                    String nome1 = dados[i][9]; // índice 4 = nome do cliente
                    String nome2 = dados[i+1][9];

                    if (nome1.compareToIgnoreCase(nome2) > 0) {
                        // troca as linhas de posição
                        String[] temp = dados[i];
                        dados[i] = dados[i+1];
                        dados[i+1] = temp;
                        trocou = true;
                    }
                }
            }

            // Escreve as linhas ordenadas no arquivo de saída
            for (int i = 1; i < numLinhas; i++) {
                StringBuilder linhaOrdenada = new StringBuilder();
                for (int j = 0; j < dados.length; j++) {
                    linhaOrdenada.append(dados[i][j]).append(separador);
                }
                linhaOrdenada.deleteCharAt(linhaOrdenada.length()-1); // remove o último separador
                escritor.write(linhaOrdenada.toString());
                escritor.newLine();
            }

            leitor.close();
            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
}

