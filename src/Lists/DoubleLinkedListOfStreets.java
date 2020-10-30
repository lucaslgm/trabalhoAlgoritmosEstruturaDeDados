package Lists;

import Entities.Acidente;
import Entities.Street;

public class DoubleLinkedListOfStreets {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;
    // Referencia para uma posicao corrente na lista
    private Node current;
    // Inicializa o current na primeira posicao (para percorrer do inicio para o fim)
    public void resetNext() {
        current = header.next;
    }
    // Retorna o elemento da posicao corrente e faz current apontar para o proximo
    public Street next() { //O(1)
        if (current != trailer) {
            Street street = current.element;
            current = current.next;
            return street;
        }
        return null;
    }
    public Street next2() { //O(1)
        if (current != trailer) {
            current = current.next;
            return current.element;
        }
        return null;
    }
    public Street prev2() { //O(1)
        if (current != header) {
            current = current.prev;
            return current.element;
        }
        return null;
    }


    public void resetPrev() {
        current = trailer.prev;
    }
    public Street prev() { //O(1)
        if (current != header) {
            Street street = current.element;
            current = current.prev;
            return street;
        }
        return null;
    }

    private class Node {
        public Street element;
        public Node next;
        public Node prev;
        public Node(Street e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfStreets() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Street element) {
        Node n = new Node(element);
        n.next = trailer;
        n.prev = trailer.prev;
        n.prev.next = n;
        trailer.prev = n;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Street element) throws IndexOutOfBoundsException {
        // indice invalido
        if (index < 0 || index > count ){
            throw new IndexOutOfBoundsException();
        }
        if(index == count) {
            this.add(element);
        }
        else {
            Node n = new Node(element);
            Node aux = getNodeRef(index);
            n.next = aux;
            n.prev = aux.prev;
            n.prev.next = n;
            aux.prev = n;
            count++;
        }
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Street element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Street removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return aux.element;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Street element) {
        Node nAux = header.next;
        while (nAux != trailer){
            if (element.equals(nAux.element)){
                return true;
            }
            nAux = nAux.next;
        }
        return false;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param rua o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(String rua) {
        Node nAux = header.next;
        while (nAux != trailer){
            if (rua.equals(nAux.element.getNome())){
                return true;
            }
            nAux = nAux.next;
        }
        return false;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Street get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param rua a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Street get(String rua) {
        Node nAux = header.next;
        while (nAux != trailer){
            if (rua.equals(nAux.element.getNome())){
                return nAux.element;
            }
            nAux = nAux.next;
        }
        return null;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Street set(int index, Street element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeRef(index);
        Street street = aux.element;
        aux.element = element;
        return street;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Street element) {
        //TODO: Implementar este método
        Node nAux = header.next;
        for (int i = 0; i < count; i++) {
            if(element.equals(nAux.element)){
                return i;
            }
            nAux = nAux.next;
        }
        return -1;
    }

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    private Node getNodeRef(int index) {
        Node aux = null;

        if(index<count/2) { // percorre do inicio para o meio
            aux = header.next; // faz aux apontar para o primeiro elemento da lista
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // percorre do fim para o meio
            aux = trailer.prev;
            for(int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }

        return aux;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public Street getCurrent() {
        return current.element;
    }

    //TODO: IMPLEMENTAR MÉTODO COMPARANDO STRING NOME
    public void addIncreasingOrder(Acidente element){}
}