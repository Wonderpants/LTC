package pt.ispgaya.trabalho1.Algorithms;

public class LinearSearch {
    public LinearSearch(int[] arr, int elementToSearch) {
        int found = -1;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch) {
                found = index;
                break;
            }
        }
        if (found >= 0) {
            String space = found >= 10 ? "\t" : "\t\t";
            System.out.print("Position: " + found + space);
        } else {
            System.out.print("Value not found\t");
        }
    }
}
