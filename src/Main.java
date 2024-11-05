import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "D:\\\\Proyectos_BanBta\\\\I-Test-AI\\\\ManejoArchivos\\\\Data\\test.txt";
        try {
            procesarArchivo(rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void procesarArchivo(String ruta) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            double suma = 0;
            double mayor = Double.MIN_VALUE;
            double menor = Double.MAX_VALUE;
            int contador = 0;

            while ((linea = br.readLine()) != null) {

                    double numero = Double.parseDouble(linea.trim());
                    suma += numero;
                    if (numero > mayor) {
                        mayor = numero;
                    }
                    if (numero < menor) {
                        menor = numero;
                    }
                    contador++;
            }

            if (contador > 0) {
                double promedio = suma / contador;
                System.out.println("El promedio de los números es: " + promedio);
                System.out.println("El numero mayor es: " + mayor);
                System.out.println("El numero menor es: " + menor);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e.getMessage());
        }
    }
}