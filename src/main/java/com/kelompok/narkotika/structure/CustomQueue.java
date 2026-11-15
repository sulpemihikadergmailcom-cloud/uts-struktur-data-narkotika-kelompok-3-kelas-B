package com.kelompok.narkotika.structure;

public class CustomQueue<T> {

    private Object[] data;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomQueue() {
        data = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public CustomQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0");
        }
        data = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == data.length) {
            resize();
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        rear = size;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue kosong");
        }

        T value = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue kosong");
        }
        return (T) data[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
        front = 0;
        rear = 0;
    }
}
