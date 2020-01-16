package pt.ispgaya.trabalho1.Algorithms;

public class BinarySearch {
    public BinarySearch(int[] arr, int elementToSearch) {

        int found = -1;

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // termination condition (element isn't present)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // if the middle element is our goal element, return its index
            if (arr[middleIndex] == elementToSearch) {
                found = middleIndex;
                break;
            }

            // if the middle element is smaller
            // point our index to the middle+1, taking the first half out of consideration
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // if the middle element is bigger
                // point our index to the middle-1, taking the second half out of consideration
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }

        if (found >= 0) {
            String space = found >= 10 ? "\t" : "\t\t";
            System.out.print("Position: " + found + space);
        } else {
            System.out.print("Value not found\t");
        }
    }
}
