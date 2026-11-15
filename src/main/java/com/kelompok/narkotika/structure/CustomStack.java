
package com.kelompok.narkotika.structure;

public class CustomStack<T> {

    private Object[] data;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomStack() {
        data = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public CustomStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException(
                    "Kapasitas harus lebih dari 0"
            );
        }

        data = new Object[capacity];
        top = -1;
    }

    private void ensureCapacity() {
        if (top == data.length - 1) {
            Object[] newData = new Object[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    public void push(T value) {
        ensureCapacity();
        top++;
        data[top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Stack kosong, tidak bisa pop"
            );
        }

        T value = (T) data[top];
        data[top] = null;
        top--;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Stack kosong"
            );
        }

        return (T) data[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        while (!isEmpty()) {
            data[top] = null;
            top--;
        }
    }


    public boolean validateInvariant() {
        if (top < -1 || top >= data.length) {
            return false;
        }

        for (int i = top + 1; i < data.length; i++) {
            if (data[i] != null) {
                return false;
            }
        }

        return true;
    }


    public boolean searchPreserve(T target) {
        CustomStack<T> temporary = new CustomStack<>(data.length);
        boolean found = false;

        while (!isEmpty()) {
            T value = pop();

            if (java.util.Objects.equals(value, target)) {
                found = true;
            }

            temporary.push(value);
        }

        restore(temporary);

        return found;
    }


    public void restore(CustomStack<T> temporary) {
        if (temporary == null || temporary == this) {
            throw new IllegalArgumentException(
                    "Stack sementara tidak valid"
            );
        }

        while (!temporary.isEmpty()) {
            push(temporary.pop());
        }
    }


    public void display() {
        System.out.println("Isi Stack:");

        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
    public boolean search(T value) {
        for (int i = top; i >= 0; i--) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
