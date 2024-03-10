package linked;

public interface List <E>{
    void clear();

    int size();

    boolean isEmpty();

    void add(E element);
    void add(int size,E element);

    E get();
    E set();

    E remove();
    int indexOf(E element);

    boolean contains(E element);

    String toString();


}
