package pt.ispgaya.trabalho6;

import java.util.ArrayList;

public class HeapSort {

    public void sort(ArrayList<Processo> arrA) {
        int size = arrA.size();

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arrA, size, i);

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i = size - 1; i >= 0; i--) {

            //arrA[0] is a root of the heap and is the max element in heap
            Processo x = arrA.get(0);
            arrA.set(0, arrA.get(i));
            arrA.set(i, x);

            // call max heapify on the reduced heap
            heapify(arrA, i, 0);
        }
    }

    // To heapify a subtree with node i
    void heapify(ArrayList<Processo> arrA, int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIdx = 2 * i + 1; // left = 2*i + 1
        int rightChildIdx = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (
                leftChildIdx < heapSize &&
                        arrA.get(leftChildIdx).get_pri() > arrA.get(largest).get_pri()
        )
            largest = leftChildIdx;

        // If right child is larger than largest so far
        if (
                rightChildIdx < heapSize &&
                        arrA.get(rightChildIdx).get_pri() > arrA.get(largest).get_pri()
        )
            largest = rightChildIdx;

        // If largest is not root
        if (largest != i) {
            Processo swap = arrA.get(i);
            arrA.set(i, arrA.get(largest));
            arrA.set(largest, swap);

            // Recursive call to  heapify the sub-tree
            heapify(arrA, heapSize, largest);
        }
    }
}
