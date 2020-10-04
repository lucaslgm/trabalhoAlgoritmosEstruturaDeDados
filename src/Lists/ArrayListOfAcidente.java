package Lists;

import Entities.Acidente;

public class ArrayListOfAcidente {
    private static final int INITIAL_SIZE = 10;
    private Acidente[] data;
    private int count;

    public ArrayListOfAcidente() {
        data = new Acidente[INITIAL_SIZE];
        count = 0;
    }

    public ArrayListOfAcidente(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Acidente[tam];
        count = 0;
    }

    public void clear() { // O(1)
        data = new Acidente[INITIAL_SIZE];
        count = 0;
    }

    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    public int size() { // O(1)
        return count;
    }

    public void add(Acidente element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    public Acidente get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    public Acidente set(int index, Acidente element) { // O(1)
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Acidente aux = data[index];
        data[index] = element;
        return aux;
    }

    public boolean contains(Acidente element) { // O(n)
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) { // O(n)
        if (newCapacity != data.length) {
            int min = 0;
            Acidente[] newData = new Acidente[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public void add(int index, Acidente element) { // O(n)
        if (index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }

        if (count == data.length)
            setCapacity(data.length * 2);

        for(int i = count; i>index; i--)
            data[i] = data[i-1];

        data[index] = element;
        count++;
    }

    public boolean remove(Acidente element) { // O(n)
        for(int i=0; i<count; i++) {
            if(element.equals(data[i])) {
                for(int j = i; j < count-1; j++)
                    data[j] = data[j+1];
                data[count-1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public Acidente removeByIndex(int index) { // O(n)
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Acidente aux = data[index];
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = null;
        count--;
        return aux;
    }

    public int indexOf(Acidente element) { // O(n)
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void addIncreasingOrder(Acidente element){
        if(element.getDataHora() != null){

            if (count == data.length){
                setCapacity(data.length * 2);
            }
            if (count==0) {
                this.add(element);
            }
            else if (element.getDataHora().isBefore(data[0].getDataHora())) {
                this.add(0,element);
            }
            else if (element.getDataHora().isAfter(data[count-1].getDataHora())) {
                this.add(element);
            }
            else{
                for(int i = 0; i < count; i++) {
                    if (data[i].getDataHora().isAfter(element.getDataHora())) {
                        this.add(i, element);
                        break;
                    }
                    else if (data[i].getDataHora().isEqual(element.getDataHora())) {
                        this.add(i+1, element);
                        break;
                    }
                }
            }
        }
    }
}