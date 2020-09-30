package Lists;

import Entities.Acidente;

public class DoubleLinkedList {
    private class Node{
        public Node prev;
        public Acidente acidente;
        public Node next;

        public Node(Acidente acidente) {
            this.prev = null;
            this.acidente = acidente;
            this.prev = null;
        }

        public Node(Acidente acidente, Node prev, Node next) {
            this.prev = prev;
            this.acidente = acidente;
            this.prev = next;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Acidente acidente)  { // O(1)
        Node n = new Node(acidente);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    public Acidente get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.acidente;

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.acidente);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            s.append(aux.acidente.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public void add(int index, Acidente acidente) {
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }

        Node n = new Node(acidente);

        if (index == 0) { // se insercao no inicio
            if(count == 0) // se a lista esta vazia
                tail = n;
            else
                n.next = head;
            head = n;
        }
        else if (index == count) { // se insercao no final
            tail.next = n;
            tail = n;
        }
        else { // se insercao no meio
            Node ant = head;
            for(int i=0; i<index-1; i++) // "caminha" ate a posicao anterior
                ant = ant.next;    // a posicao onde o elemento sera inserido
            n.next = ant.next;
            ant.next = n;
        }

        // Incrementa o contador
        count++;
    }
}
