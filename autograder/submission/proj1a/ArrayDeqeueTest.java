public class ArrayDeqeueTest {
    public static boolean checkSize(int expect, int real) {
        if (expect != real) {
            System.out.println("size() return  " + real + ", but expected value is " + expect);
            return false;
        }
        return true;
    }

    public static boolean checkEmpty(int expect, int real) {
        if (expect != real) {
            System.out.println("isEmpty() return  " + real + ", but expected value is " + expect);
            return false;
        }
        return true;
    }

    public static boolean checkIntElement(int expect, int real) {
        if (expect != real) {
            System.out.println("expect element's value is " + expect + ", but receiving " + real);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] truthArray = new int[] {};

        ArrayDeqeue<Integer> evalArray = new ArrayDeqeue();
        evalArray.addFirst(3);
        evalArray.addFirst(2);
        evalArray.addFirst(1);
        evalArray.addLast(4);
        evalArray.addLast(5);
        evalArray.removeFirst();
        evalArray.removeFirst();
        evalArray.removeLast();
        evalArray.removeLast();
        evalArray.removeLast();
        evalArray.removeLast();

        for (int i = 0; i < truthArray.length; i++) {
            checkIntElement(truthArray[i], evalArray.get(i));
        }
        evalArray.printDeqeue();
    }

}
