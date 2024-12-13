import java.util.Scanner;

class validParenthesis {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa los siguientes parejas de caracteres: () {} []");
        String s = scanner.nextLine();        

    }

    public static boolean validacion(String s) {
        //se crea una pila que permitirá guardar los caracteres ingresados en la terminal
        char[] pila = new char[s.length()];
        int limite = -1;

        return limite == -1;
    }

    //función booleana para verificar si los caracteres de inicio y fin son correctos
    public static boolean par(char inicio, char fin){
        return (inicio == '(' && fin == ')'            
        );
    }
    

}