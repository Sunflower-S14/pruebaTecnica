import java.util.Scanner;

class validParenthesis {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Verificador de signos de  agrupación===");
        System.out.println("Ingresa los siguientes caracteres: () {} []");
        System.out.println("Escribe 'salir' para terminar el programa.");

        while (true) { 
            System.out.println("Ingrese una cadena: ");
            String s = scanner.nextLine();        

            if(s.equals("salir")){
                System.out.println("Usted a terminado su sesión.");
                break;
            }

            if (validacion(s)) {
                System.out.println("La cadena es valida. La cadena ingresada fue: " + s);
            } else {
                System.out.println("La cadena no es válida. La cadena ingresada fue: " + s);
            }
            scanner.close();
        }
        
    }

    public static boolean validacion(String s) {
        //se crea una pila que permitirá guardar los caracteres ingresados en la terminal
        char[] pila = new char[s.length()];
        int limite = -1;

        for (char caracter : s.toCharArray()){
            if(caracter == '(' || caracter == '{' || caracter == '['){
                pila[++limite] = caracter;
            }else{
                if (limite == -1 || !par(pila[limite], caracter)){
                    return false;
                }
                limite--;
            }
        }

        return limite == -1;
    }

    //función booleana para verificar si los caracteres de inicio y fin son correctos
    public static boolean par(char inicio, char fin){
        return (inicio == '(' && fin == ')' )||
                (inicio == '{' && fin == '}') ||
                (inicio == '[' && fin == ']');            
    }
    

}