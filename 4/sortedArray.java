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
        
        //Validación: 1 <= nums.length <= 3 * 10^4
        if(n <1 || n > 30000){
            System.out.println("El tamaño del arreglo debe estar entre 1 y 30000.");
            return; //terminar el programa
        }

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

        //Validación: -100 <= nums[i] <= 100
        if (!solucion.validateRange(nums)) {
            System.out.println("\nTodos los elementos deben estar en el rango de -100 a 100.");
            return; // Terminar el programa si la validación falla
        }

        //Validación: nums is sorted in non-decreasing order.
        if (!solucion.validateSorted(nums)) {
            System.out.println("\nEl arreglo debe estar ordenado en orden no decreciente.");
            return; // Terminar el programa si la validación falla
        }
        
        //Eliminación de duplicados
        int k = solucion.removeDuplicates(nums);

        //Se tiene que imprimir la cantidad de valores únicos:
        System.out.print("\nK = "+ k);
        
        System.out.print("\nArreglo sin datos duplicados: ");
        //iteración del arreglo usando el valor de K
        for(int num : nums){
            if (num == Integer.MIN_VALUE){ 
                System.out.print(" _ "); //Los elementos eliminados se muestran con un "_"
            }else{
                System.out.print(num + " "); //Imprimira los primeros valores únicos que encuentre
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
                puntero = i; //se actualiza el puntero al nuevo valor único
            }else{
                nums[i] = Integer.MIN_VALUE; // Marcar duplicados como un valor especial
            }
        }
        //Contar los elementos no únicos (no marcados como duplicados)
        int contador = 0;
        for(int num : nums){
            if(num != Integer.MIN_VALUE){
                contador++;
            }
        }
        return contador; //Tiene que devolver la cantidad de valores únicos
    }

    //método para validar que los elementos esten entre -100 <=nums[i] <= 100
    public boolean validateRange(int[]nums){
        for(int num:nums){
            if(num <-100 || num > 100){
                return false; //si algún elemento no cumple con el rango
            }
        }
        return true;
    }

    //método para validar que el arreglo esté ordenado en orden ascendente
    public boolean validateSorted(int[]nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i]< nums[i -1]){
                return false; //si el orden es no decreciente será falso
            }
        }
        return true;
    }
}