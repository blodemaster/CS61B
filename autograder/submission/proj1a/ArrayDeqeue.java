public class ArrayDeqeue<T> {
    private T[] array;
    private int size;
    private int start;

    private static int RESIZE_FACTOR = 2;
    private static double USAGE_FACTOR = 0.25;

    /**
     * Convert the given index to the real index for the underlying array
     * @param index
     * @return
     */
    public int indexConversion(int index) {
        return (start + index) % this.array.length;
    }

    public ArrayDeqeue() {
        this.array = (T[]) new Object[2];
        this.size = 0;
    }

    public void addFirst(T item) {
        int arrLen = this.array.length;
        if (this.size < arrLen) {
            if (this.start == 0) {
                this.start = arrLen - 1;
            } else {
                this.start -= 1;
            }
            this.array[start] = item;
        } else {
            T[] auxArray = (T[]) new Object[arrLen * RESIZE_FACTOR];
            auxArray[0] = item;
            for (int i = 0; i < this.size; i++) {
                int index = indexConversion(i);
                auxArray[i + 1] = this.array[index];
            }
            this.start = 0;
            this.array = auxArray;
        }
        this.size++;
    }
    public void addLast(T item) {
        int arrLen = this.array.length;
        if (this.size < arrLen) {
            int index = indexConversion(this.size);
            this.array[index] = item;
        } else {
            T[] auxArray = (T[]) new Object[arrLen * RESIZE_FACTOR];
            for (int i = 0; i < this.size; i++) {
                int index = indexConversion(i);
                auxArray[i] = this.array[index];
            }
            auxArray[arrLen] = item;
            this.start = 0;
            this.array = auxArray;
        }
        this.size++;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int size() {
        return this.size;
    }
    public void printDeqeue() {
        for (int i = 0; i < this.size; i++) {
            int currentIndex = indexConversion(i);
            System.out.print(this.array[currentIndex] + " ");
        }
    }
    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        int arrLen = this.array.length;
        T toReturn = this.array[this.start];
        if (this.size > (USAGE_FACTOR * arrLen) + 1) {
            this.array[this.start] = null;
            this.start = indexConversion(1);
        } else {
            T[] auxArray = (T[]) new Object[arrLen / 2];
            for (int i = 1; i < this.size; i++) {
                int index = indexConversion(i);
                auxArray[i - 1] = this.array[index];
            }
            this.start = 0;
            this.array = auxArray;
        }
        this.size--;
        return toReturn;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        int arrLen = this.array.length;
        this.size--;

        T toReturn = this.array[this.start + this.size];
        if (this.size > (USAGE_FACTOR * arrLen)) {
            this.array[this.start + this.size] = null;
        } else {
            T[] auxArray = (T[]) new Object[arrLen / 2];
            for (int i = 0; i < this.size; i++) {
                int index = indexConversion(i);
                auxArray[i] = this.array[index];
            }
            this.start = 0;
            this.array = auxArray;
        }
        return toReturn;
    }

    public T get(int index) {
        int realIndex = indexConversion(index);
        return this.array[realIndex];
    }


}
