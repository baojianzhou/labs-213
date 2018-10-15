import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the demo code for our lab-01.
 *
 * @author Baojian Zhou email: bzhou6@albany.edu
 * Instructions:
 * (1) Implement the bubble sort and the quicksort algorithm.
 * (2) Do the following 10 times:
 * (a) Generate a random list of 100 items.
 * (b) Have each algorithm (bubble sort and quicksort) sort the list.
 * (c) Give the original list, the sorted list,
 * and the number of comparisons done by each algorithm.
 * (3) At the end:
 * For each algorithm and each list length give the average of
 * the number of comparisons.
 * usage:
 * Java ...
 */
public class Lab01Sorting {

    // 3 lists with 100 elements.
    // list_original will be used to save the original list
    private List<Integer> originalList;
    // list_bubble will be used by bubbleSort
    private List<Integer> bubbleSortList;
    // list_quick will be used by quickSort
    private List<Integer> quickSortList;
    private Integer numCompBubble;
    private Integer numCompQuick;

    /**
     * to set a random we try 10 times and take average of
     * the number of comparisons of two algorithms
     *
     * @param listSize    the size of the sorted list.
     * @param randomBound the range of random number [0,randomBound)
     */
    public Lab01Sorting(Integer listSize, Integer randomBound) {
        this.originalList = new ArrayList<>();
        this.bubbleSortList = new ArrayList<>();
        this.quickSortList = new ArrayList<>();
        this.numCompBubble = 0;
        this.numCompQuick = 0;
        Random random = new Random();
        for (int j = 0; j < listSize; j++) {
            originalList.add(random.nextInt(randomBound));
            bubbleSortList.add(originalList.get(j));
            quickSortList.add(originalList.get(j));
        }
    }

    /**
     * This method is the implementation of bubble_sort algorithm, which shown
     * in Page 40. of reference [1].The number of comparisons of bubble sort
     * algorithm will also be calculated for sorting list. reference:
     * <p>
     * [1] Cormen, Thomas H., Charles E. Leiserson, Ronald L. Rivest, and
     * Clifford Stein. Introduction to algorithms. MIT press, 2009.
     * Third Edition.
     *
     * @param list: the list(array) to be sorted.
     */
    private void bubbleSort(List<Integer> list) {
        int i, j, tmp, flag = 0;
        for (i = 0; i < list.size() - 2; i++) {
            for (j = list.size() - 1; j > i; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                    flag = 1;
                }
                numCompBubble++;
            }
            //if it is already sorted, then we are done.
            if (flag == 0) {
                break;
            } else {
                flag = 0;
            }
        }
    }

    /**
     * This method is the implementation of quick_sort
     * algorithm, which shown in Page 171. of reference [1].
     * <p>
     * reference:
     * [1] Cormen, Thomas H., Charles E. Leiserson, Ronald L. Rivest, and
     * Clifford Stein. Introduction to algorithms. MIT press, 2009.
     * Third Edition.
     *
     * @param list: the list(array) to be sorted.
     * @param p:    the index of the first element of the list.
     * @param r:    the index of the last element of the list.
     */
    public void quickSort(List<Integer> list, int p, int r) {
        if (p < r) {
            int q = partition(list, p, r);
            quickSort(list, p, q - 1);
            quickSort(list, q + 1, r);
        }
    }

    /**
     * The partition algorithm of quick sort.
     *
     * @param list the list to be split into two sub-lists.
     * @param p:   the index of first element.
     * @param r:   the index of second element.
     * @return the position of element, which the list will be split.
     */
    private Integer partition(List<Integer> list, int p, int r) {
        int x = list.get(r), i = p - 1, tmp;
        for (int j = p; j < r; j++) {
            if (list.get(j) < x) {
                i++;
                tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);

            }
            numCompQuick++;
        }
        tmp = list.get(i + 1);
        list.set(i + 1, list.get(r));
        list.set(r, tmp);
        return i + 1;
    }

    public Integer getNumCompQuick() {
        return this.numCompQuick;
    }

    public Integer getNumCompBubble() {
        return this.numCompBubble;
    }

    /**
     * Pretty print.
     *
     * @param list:   the list to be printed.
     * @param stride: for each stride elements, we print a new line.
     */
    public void print_list(List<Integer> list, int stride) {
        for (int j = 0; j < list.size(); j++) {
            System.out.printf("%02d ", list.get(j));
            if ((j + 1) % stride == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void main(String args[]) {
        int numTrials = 10;
        int listSize = 100;
        int randomBound = 100;
        double totalNumCompBubble = 0;
        double totalNumCompQuick = 0;
        String line = "--------------------------------";
        for (int curTrial = 0; curTrial < numTrials; curTrial++) {
            System.out.printf("\n%s trial-%01d %s\n", line, curTrial, line);
            Lab01Sorting lab01Sorting = new Lab01Sorting(listSize, randomBound);
            lab01Sorting.bubbleSort(lab01Sorting.bubbleSortList);
            lab01Sorting.quickSort(lab01Sorting.quickSortList, 0,
                    lab01Sorting.quickSortList.size() - 1);
            totalNumCompBubble += lab01Sorting.getNumCompBubble();
            totalNumCompQuick += lab01Sorting.getNumCompQuick();
            System.out.print("\noriginal list: \n");
            lab01Sorting.print_list(lab01Sorting.originalList, 25);
            System.out.print("\nsorted list by bubble sort: \n");
            lab01Sorting.print_list(lab01Sorting.bubbleSortList, 25);
            System.out.print("\nsorted list by quick sort: \n");
            lab01Sorting.print_list(lab01Sorting.quickSortList, 25);
            System.out.printf("\nnumber of comparisons of bubble_sort: %04d\n",
                    lab01Sorting.numCompBubble);
            System.out.printf("number of comparisons of  quick_sort: %04d\n",
                    lab01Sorting.numCompQuick);
        }
        System.out.printf("\ntaking average of comparisons\n");
        System.out.printf("the average of 10 trials of comparisons " +
                        "of bubble_sort: %.2f\n",
                totalNumCompBubble / (numTrials * 1.));
        System.out.printf("the average of 10 trials of comparisons" +
                        " of  quick_sort: %.2f\n",
                totalNumCompQuick / (numTrials * 1.));
    }
}
