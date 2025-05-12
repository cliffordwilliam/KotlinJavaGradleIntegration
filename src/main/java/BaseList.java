// all class that have list like method follow this sig
// e.g. cupcakesList

import java.util.List;

public interface BaseList<T> {
    int size();
    boolean isEmpty();
    T get(int position);
    T remove(int position);
    void insert(int position, T item);
    List<T> getList();
    void clearList();
    boolean isNextPageAvailable();
}
