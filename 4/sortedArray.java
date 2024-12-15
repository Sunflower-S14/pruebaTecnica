import java.util.Scanner;

public class sortedArray {
    
    //método principal
    public static void main(String[] args) {
        /*  Realizar pruebas con:
            Entrada: int [] nums = {1, 1, 2}; 
            Salida: {1,2,_}
            k = 2;
            Entrada: int [] nums = {0,0,1,1,1,2,2,3,3,4};
            Salida: {0,1,2,3,4,_,_,_,_,_}
            k = 5;
         */

        Scanner scanner = new Scanner(System.in);
        //Se pedirá en la terminal la cantidad de datos para el array, para hacer las pruebas fácilmente:
        System.out.print("Ingresa la cantidad de elementos a ingresar: ");
        //La variable "n" guardará el tamaño del array: 
        int n;
        n = scanner.nextInt();

        //scanner.close();
        
        //se declara un array nums en donde se le pasa la cantidad que el usuario le establezca
        int [] nums = new int[n];

        //Probamos si devuelve el tamaño que se le asignó
        System.out.println(nums.length);

        [] nums = solucion.insertarDatos();

    }


}

//se crea una clase que tendrá la lógica de solución
class Solution {

    public static insertNumbers(){

        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

    }
    public int removeDuplicates(int[] nums) {
        
    }
}