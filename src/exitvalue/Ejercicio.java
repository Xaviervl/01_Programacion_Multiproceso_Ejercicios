package exitvalue;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio {
    public static void main(String[] args) throws IOException {
        Process proceso1 = new ProcessBuilder("cmd", "/c", "dir && notepad.exe").start();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(proceso1.getErrorStream()));

        try{
            String linea;

            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
