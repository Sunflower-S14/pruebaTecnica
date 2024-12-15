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

        //instanciamos la clase Solution

        Solution solucion = new Solution();

        int[] numsLleno = solucion.insertNumbers(nums, scanner);
        //Probamos si devuelve el tamaño que se le asignó
        //System.out.println(nums.length);
        System.out.print("Elementos que se ingresarón: ");
        for (int num : numsLleno){
            System.out.print(num + " ");
        }

        //Eliminación de duplicados
        int k = solucion.removeDuplicates(nums);

        //Se tiene que imprimir la cantidad de valores únicos:
        System.out.print("\nK = "+ k);
        
        System.out.print("\nArreglo sin datos duplicados: ");
        //iteración del arreglo usando el valor de K
        for(int i = 0; i <k; i++){
            if (i < k){ //Sí el indice del arreglo es menor que K (elemento único)
                System.out.print(nums[i] + " "); //Elementos únicos
            }else{ //si el indice es mayor o igual a K:
                System.out.print(" _ "); //Los elementos eliminados se muestran con un "_"
            }
        }

    }


}

//se crea una clase que tendrá la lógica de solución
class Solution {

    public int[] insertNumbers(int[] nums, Scanner scanner){

        System.out.println("Ingresa los elementos del arreglo en orden ascendente.");
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        return nums; //devolverá el arreglo lleno
    }
    public int removeDuplicates(int[] nums) {
        
        int puntero = 0; //servirá para identificar los elementos únicos (recorrido)

        //Iteración en el arreglo
        for(int i = 1; i < nums.length; i++){
            if (nums[i]!= nums[puntero]) //si el puntero encuentra un valor único en el arreglo
            { 
                puntero++; //se mueve el puntero en la siguiente posición del arreglo
                nums[puntero] = nums[i]; //se actualiza el valor           
            }
        }
        return puntero + 1; //Total de elementos únicos

    }
}