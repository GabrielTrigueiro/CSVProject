import java.io.FileWriter;
import java.io.IOException;

public class FiltrarDataBase {

    public static void filtrarData(String urlArquivo) throws IOException {

        FileWriter writer = new FileWriter("LAMetroTrips_F1.csv");
        TrocarIds obj = new TrocarIds();
        String[][] dataBruta = obj.lerCSV(urlArquivo);

        String value = "Pasadena";

        for (int i = 0; i < dataBruta.length; i++) {
            for (int j = 0; j < dataBruta[i].length; j++) {
                if(dataBruta[i][9] == value | dataBruta[i][10] == value){
                    for (int k = 0; k < dataBruta[i].length; k++) {
                        writer.write(dataBruta[i][k] + " ");
                    }
                }
                writer.write(System.lineSeparator());
            }
        }
        writer.close();
    }
}
