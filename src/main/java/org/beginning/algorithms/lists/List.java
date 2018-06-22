package org.beginning.algorithms.lists;

import org.beginning.algorithms.iteration.Iterable;

/**
 * List interface represents a list which is an ordered collection of elements supporting random access to each
 * element, much like an array — you can query a list to get the value contained at any arbitrary element. Lists
 * also preserve insertion order so that, assuming there are no intervening modifications, a given list will always
 * return the same value for the same position. Like arrays, lists make no attempt to preserve the uniqueness of
 * values, meaning a list may contain duplicate values
 */
public interface List extends Iterable {
    void insert(int index, Object value) throws IndexOutOfBoundsException;
    void add(Object value);
    Object delete(int index) throws IndexOutOfBoundsException;
    boolean delete(Object value);
    void clear();
    Object set(int index, Object value) throws IndexOutOfBoundsException;
    Object get(int index) throws IndexOutOfBoundsException;
    int indexOf(Object value);
    boolean contains(Object value);
    int size();
    boolean isEmpty();
}
