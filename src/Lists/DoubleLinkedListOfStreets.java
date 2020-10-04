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
    //TODO: TESTAR /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Street element) {
        //TODO: Implementar este método
        Node n = new Node(element);
        if(header.next == trailer){
            header.next = n;
            trailer.prev = n;
        }
        else{
            trailer.prev.next = n;
            trailer.prev = n;
        }
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
        //TODO: Implementar este método
        Node n = new Node(element);
        if (index == 0) {
            if(count == 0){
                header.next = n;
                trailer.prev = n;
            }
            else{
                header.next = n;
                header.next.prev = n;
            }
        }
        else if (index == count) {
            trailer.prev.next = n;
            trailer.prev = n;
        }
        else{
            Node nAux = header.next;
            for (int i = 0; i < index-1; i++){
                nAux = nAux.next;
                n.next = nAux.next;
                n.prev = nAux;
            }
        }
        count++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Street element) {
        // TODO:Implementar este método
        if (count == 0) {
            return false;
        }
        if(header.next.element.equals(element)){
            if(count == 1){
                header.next = trailer;
                trailer.prev = header;
                count--;
                return true;
            }
        }
        if(trailer.prev.element.equals(element)){
            trailer.prev.prev.next = trailer;
            trailer.prev = trailer.prev.prev;
            count--;
            return true;
        }
        else{
            Node nAux = header.next;
            while (nAux != trailer){
                if(nAux.element.equals(element)){
                    nAux.prev.next = nAux.next;
                    nAux.next.prev = nAux.prev;
                    count--;
                    return true;
                }
            }
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
        // TODO: Implementar este método
        Street eRemovido = null;

        if(index == 0){
            eRemovido = header.next.element;
            header.next = header.next.next;
            header.next.next.prev = header;
        }
        else if(index == count-1){
            eRemovido = header.next.element;
            trailer.prev.prev.next = trailer;
            trailer.prev = trailer.prev.prev;
        }
        else{
            Node nAux = header.next;
            for (int i = 0; i < index; i++){
                nAux = nAux.next;
            }
            eRemovido = nAux.element;
            nAux.prev = nAux.next;
            nAux.next = nAux.prev;
        }
        count--;
        return eRemovido;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Street element) {
        // TODO:Implementar este método
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
        // TODO:Implementar este método
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
        //TODO:Implementar este método
        if(index == count-1){
            return trailer.prev.element;
        }

        Node nAux = header.next;
        int ind = 0;
        while (ind < index){
            nAux = nAux.next;
            ind++;
        }
        return nAux.element;
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
        //TODO: Implementar este método

        Street street = null;
        if(index == count -1){
            street = trailer.prev.element;
            trailer.prev.element = element;
            return street;
        }
        Node nAux = header.next;
        for (int i = 0; i < index; i++) {
            nAux = nAux.next;
        }
        street =nAux.element;
        nAux.element = element;
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

    //TODO: IMPLEMENTAR MÉTODO COMPARADO STRING NOME
    public void addIncreasingOrder(Acidente element){}
}