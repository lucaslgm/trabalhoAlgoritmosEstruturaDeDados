package Lists;

import Entities.Acidente;

public class LinkedListOfAcidentes {
    private class Node {
        public Acidente element;
        public Node next;

        public Node(Acidente element) {
            this.element = element;
            next = null;
        }

        public Node(Acidente element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedListOfAcidentes() {
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

    public void add(Acidente element)  { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    public void add(int index, Acidente element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node n = new Node(element);

        if (index == 0) {
            if(count == 0)
                tail = n;
            else
                n.next = head;
            head = n;
        }
        else if (index == count) {
            tail.next = n;
            tail = n;
        }
        else {
            Node ant = head;
            for(int i=0; i<index-1; i++)
                ant = ant.next;
            n.next = ant.next;
            ant.next = n;
        }
        count++;
    }
    //TODO: TRATAR NULLPOINTEREXCEPTION
    public void addIncreasingOrder(Acidente element){
        if(element.getDataHora() != null){
            if (count==0) {
                this.add(element);
            }
            else if (element.getDataHora().isBefore(head.element.getDataHora())) {
                this.add(0,element);
            }
            else if (element.getDataHora().isAfter(tail.element.getDataHora())) {
                this.add(element);
            }
            else{
                Node nAux = head.next;
                for(int i = 1; i < count-1; i++) {
                    if (nAux.element.getDataHora().isAfter(element.getDataHora())) {
                        this.add(i, element);
                        break;
                    }
                    else if (nAux.element.getDataHora().isEqual(element.getDataHora())) {
                        this.add(i+1, element);
                        break;
                    }
                    nAux = nAux.next;
                }
            }
        }
        else{
            this.add(element);
        }
    }

    public Acidente get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }

    public Acidente set(int index, Acidente element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        if (index == count-1) {
            Acidente lmnt = tail.element;
            tail.element = element;
            return lmnt;
        }

        Node aux = head;
        for (int i=0; i<index; i++) {
            aux = aux.next;
        }
        Acidente num = aux.element;
        aux.element = element;
        return num;
    }

    public boolean remove(Acidente element) {
        if (count == 0) {
            return false;
        }

        if (head.element.equals(element)) {
            if (count == 1)
                tail = null;
            head = head.next;
            count--;
            return true;
        }

        Node ant = head;
        Node aux = head.next;

        while (aux != null) {
            if (aux.element.equals(element)) {
                if (aux == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            ant = ant.next;
            aux = aux.next;
        }

        return false;
    }

    public Acidente removeByIndex(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Acidente lmntRemovido = null;

        if (index == 0) {
            if (count==1)
                tail = null;
            lmntRemovido = head.element;
            head = head.next;
        }
        else {
            Node ant = head;
            for(int i=0; i<index-1; i++)
                ant = ant.next;
            if (index==count-1) {
                lmntRemovido = tail.element;
                tail = ant;
                tail.next = null;
            }
            else {
                Node aux = ant.next;
                lmntRemovido = aux.element;
                ant.next = aux.next;
            }
        }

        count--;
        return lmntRemovido;
    }

    public int indexOf(Acidente element) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    public boolean contains(Acidente element) {
        Node aux = head;
        while (aux != null) {
            if (element.equals(aux.element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }
}
