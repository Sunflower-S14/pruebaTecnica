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