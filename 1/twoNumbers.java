public class twoNumbers {

    public static void main(String[] args) {
        
    }

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
}