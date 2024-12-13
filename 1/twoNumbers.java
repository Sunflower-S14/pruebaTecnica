import java.util.Scanner;

public class twoNumbers {

    public static void main(String[] args) {
        //Los datos de cada lista primero serán establecidas en código
        //Se pide los datos de la primera lista
        System.out.println("Primera Lista Enlazada: ");
        ListaNodo l1 = solucion.leerListaNodo();

        //Se piden lo datos de la segunda lista
        System.out.println("Segunda Lista Enlazada");
        ListaNodo l2 = solucion.leerListaNodo();

        //Sumar las dos listas
        solucion suma = new solucion();

        ListaNodo resultado = suma.addTwoNumbers(l1, l2);

        //Imprimir la lista de resultados
        
        System.out.println("El resultado es: ");
        solucion.imprimirLista(resultado);
    }
}

//se sacan las clases para que no esten dentro de la clase principal
    //puede ir en un paquete aparte- esta clase permitirá crear la lista de los nodos
    class ListaNodo {
        //Representa un nodo de la lista enlazada 
        //con un valor entero val y una referencia next
        int val;
        ListaNodo next;

        ListaNodo() {}
        ListaNodo(int val) { this.val = val; }
        ListaNodo(int val, ListaNodo next) { this.val = val; this.next = next; }            
    }


    class solucion{

        //permitirá que el usuario ingrese datos a la lista
        public static ListaNodo leerListaNodo(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce los valores para la lista enlazada, separados en espacios: ");
            System.out.println("Por ejemplo: 5 7 1");
            String[] valores = scanner.nextLine().split(" ");
            if(valores.length ==  0){
                return null;
            }
            

            //Construcción de la lista enlazada usando nodos de la clase ListaNodo
            ListaNodo cabeza = new ListaNodo(Integer.parseInt(valores[0]));
            ListaNodo actual = cabeza;

            for (int i = 1; i < valores.length; i++){
                actual.next = new ListaNodo(Integer.parseInt(valores[i]));
                actual = actual.next;
            }
            return cabeza;
        }


        public ListaNodo addTwoNumbers(ListaNodo l1, ListaNodo l2){
            //inicializar la construcción de la lista enlazada
            ListaNodo inicio = new ListaNodo(0);
            ListaNodo actual = inicio; //se instanció y se usa un nodo ficticio de nombre "inicio"
            int acarreo = 0; //acarreo (simula el acarreo de una suma común)

            //recorrera las dos listas para veirificar que no queden nodos
            while (l1 != null || l2 != null) {
                //se obtendrán los valores actuales de los nodos aunque sean nulos:
                int valor1 = (l1 != null) ? l1.val : 0;
                int valor2 = (l2 != null) ? l2.val : 0;

                //calcular la suma y acarreo
                int sum = valor1 + valor2 + acarreo;
                acarreo = sum / 10;
                int sobrante = sum % 10; //se obtiene la parte sobrante de la división

                //se crea un nuevo nodo y se movera el puntero
                actual.next = new ListaNodo(sobrante);
                actual = actual.next;

                //Se moveran los punteros (l1 y l2) si no son nulos
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            //en caso de un acarreo en el fin, será un nuevo nodo
            if (acarreo > 0) {
                actual.next = new ListaNodo();                
            }
            return inicio.next;
        }

        public static void imprimirLista(ListaNodo nodo){
            while (nodo != null) {
                System.out.print(nodo.val);   
                if(nodo.next != null){
                    System.out.print(" - ");
                }     
                nodo = nodo.next;
            }
            System.out.println();
        }
    }