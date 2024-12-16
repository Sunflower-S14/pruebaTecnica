public class indexString {
    
    public static void main(String[] args) {
        
        // Ejemplo 1
        String haystack = "sadbutsad";
        String needle = "sad";

        //Creamos el objeto para usar el método strStr
        Solution solucion = new Solution();
        System.out.println("Output: " + solucion.strStr(haystack, needle)); // Salida: 0
    }
}


class Solution {
    public int strStr(String haystack, String needle) {

        int [] lps = computeLPSArray(needle); //se tendrá que generar el array LPS del patrón 
        int i = 0; //índice para haystack (recorrido)
        int j = 0; //índice para needle

        //KMP
        while (i <haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) { // Si el carácter actual del texto coincide con el carácter actual del patrón
                i++; //avanzará al siguiente carácterr del texto
                j++; //avanzará al siguiente carácter del patrón
                
                //si se ha recorrido todo el patrón
                if(j == needle.length()){
                    return i - j; //regresará el índice donde comienzza la coincidencia del texto
                }
            }else{ //si no coinciden
                if (j != 0) { //si estamos en una posición dentro del patrón j mayor a 0
                    j = lps[j -1];   //usamos LPS para retroceder en el patrón, para no volver a comparar
                }else{ //si estamos al inicio del patrón j == 0
                    i++; //avanzamos al siguiente carácter en el texto
                }
            }            
        }
        return -1; //Retornará -1 si el whle no encuentra el patrón en el texto   
    }
    
    //Se realiza un preprocesamiento (LPS) Longitud del patrón
    // Almacena la longitud del prefijo más largo
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()]; // Array LPS de la longitud del patrón
        int len = 0; // Longitud del prefijo más largo que también es sufijo
        int i = 1; // Comienza desde el segundo carácter del patrón
    
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++; // Incrementamos la longitud del prefijo/sufijo
                lps[i] = len; // Guardamos el valor en LPS
                i++; // Avanzamos al siguiente carácter
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Retrocedemos usando el valor del LPS
                } else {
                    lps[i] = 0; // No hay prefijo que sea también sufijo
                    i++;
                }
            }
        }
        return lps;
    }
    
}