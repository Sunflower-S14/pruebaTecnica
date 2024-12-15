import java.util.Scanner;

public class sortedArray {
    
    //método principal
    public static void main(String[] args) {
        int [] nums = {1, 1, 2};

        Scanner scanner = new Scanner(System.in);
        //Se pedirá en la terminal la cantidad de datos para el array, para hacer las pruebas fácilmente:
        System.out.print("Ingresa la cantidad de elementos a ingresar: ");
        //La variable "n" guardará el tamaño del array: 
        int n;
        n = scanner.nextInt();

        scanner.close();
    }


}

/*se crea una clase que tendrá la lógica de solución
class Solution {
    public int removeDuplicates(int[] nums) {
        
    }
}*/