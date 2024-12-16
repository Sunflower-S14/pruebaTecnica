import java.util.Scanner;

public class calculadoraCadenas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cadena: ");
        String cadena = scanner.nextLine();
        // Cerramos el scanner después de leer la entrada
        scanner.close();

        // Mostrar la entrada
        System.out.println("Entrada: " + cadena);

        // Crear el objeto Solution y calcular el resultado
        Solution solucion = new Solution();
        int resultado = solucion.lengthOfLongestSubstring(cadena);

        // Mostrar la salida
        System.out.println("Salida: " + resultado);
    }
 
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        //Se establece un arreglo para el rastreo de las últimas posiciones de los caracteres
        int[] rastreoIndices = new int[128]; //ASCII caracteres estándar
        int maxTam = 0; //almacenará la longitud máxima de la subcadena
        int izq = 0; //puntero izquierdo de la ventana deslizante
        int der; //puntero derecho de la ventana deslizante
        //String subcadena = ""; // Para almacenar la subcadena más larga sin repetir caracteres
        String mejorSubcadena = ""; // La mejor subcadena encontrada

        //se recorrerá cada caracter de la cadena usando el puntero derecho
        for(der = 0; der < s.length(); der++){
            //se obtiene el carácter en que der este posicionado
            char actualCaracter = s.charAt(der);

            //Si el caracter fue ya encontrado, se mueve el puntero izquierdo con Math.max después de su última aparición registrada en rastreoIndices
            izq = Math.max(izq, rastreoIndices[actualCaracter]);

            //Se calcula la longitud de la subcadena actual y se actualiza maxTam
            //maxTam = Math.max(maxTam, der - izq + 1);

            // Calcular la longitud de la subcadena actual
            int tamSubcadena = der - izq + 1;

            // Si la subcadena actual es más larga, actualizar la longitud máxima
            if (tamSubcadena > maxTam) {
                maxTam = tamSubcadena;
                mejorSubcadena = s.substring(izq, der + 1); // Guardar la mejor subcadena
            }

            
            //se actualiza la última posición del carácter actual en el arreglo
            rastreoIndices[actualCaracter] = der + 1;
        }

        // Mostrar la subcadena que es la respuesta
        System.out.println("El resultado es \"" + mejorSubcadena + "\", con una longitud de " + maxTam + ".");

        //Devuelve la longitud máxima encontrada
        return maxTam;
    }

    
}