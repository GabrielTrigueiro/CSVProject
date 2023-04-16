import java.io.FileWriter;
import java.io.IOException;

public class FiltrarDataBase {

    public static void filtrarData(String urlArquivo){

        try{
            FileWriter writer = new FileWriter("LAMetroTrips_F1.csv");
            String[][] dataBruta = FuncoesDeArquivo.lerCSVNovo(urlArquivo);

            String value = "Pasadena";

            for (int i = 1; i < dataBruta.length; i++) {

                boolean possui = false;
                String[] index1 = quebrarIndex(dataBruta[i][9]);
                String[] index2 = quebrarIndex(dataBruta[i][10]);

                for (String palavra: index1) {
                    if(palavra.equals(value)){
                        possui = true;
                        break;
                    }
                }

                for (String palavra: index2) {
                    if(palavra.equals(value)){
                        possui = true;
                        break;
                    }
                }

                if(possui) {
                    for (int j = 0; j < dataBruta[i].length-1; j++) {
                        writer.write(dataBruta[i][j] + ",");
                    }
                    writer.write(dataBruta[i][dataBruta[i].length-1]);
                    writer.write(System.lineSeparator());
                }
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    public static String[] quebrarIndex(String index){
        return index.split(" ");
    }
}

