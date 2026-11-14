package com.kelompok.narkotika.structure;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> implements StrukturData<T> {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public DynamicArray(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity harus lebih dari 0");
        }
        data = new Object[capacity];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index tidak valid: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int position) {
        checkIndex(position);
        return (T) data[position];
    }

    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int position) {
        checkIndex(position);

        T removed = (T) data[position];

        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index di luar batas: " + index);
        }
    }

    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(data, size)));
    }
}
