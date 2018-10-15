/**
 * This is the demo code for our lab-01.
 * @author Baojian Zhou
 * @email: bzhou6@albany.edu
 *
 * Instructions:
 * (1) Implement the bubble sort and the quicksort algorithm.
 * (2) Do the following 10 times:
 *      (a) Generate a random list of 100 items.
 *      (b) Have each algorithm (bubble sort and quicksort) sort the list.
 *      (c) Give the original list, the sorted list,
 *          and the number of comparisons done by each algorithm.
 * (3) At the end:
 *      For each algorithm and each list length give the average of
 *      the number of comparisons.
 *
 * usage:
 *      gcc -o lab_01_sorting -std=c11 -Wall -Wextra -O3 lab_01_sorting.c
 */
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

/**
 * This method is the implementation of bubble_sort
 * algorithm, which shown in Page 40. of reference [1].
 *
 * reference:
 * [1] Cormen, Thomas H., Charles E. Leiserson, Ronald L. Rivest, and
 *     Clifford Stein. Introduction to algorithms. MIT press, 2009.
 *     Third Edition.
 *
 * @param list: the list(array) to be sorted.
 * @param list_len: the number of elements in this list.
 * @return the number of comparisons of bubble sort algorithm for sorting list.
 */
int bubble_sort(int *list, int list_len) {
    int i, j, tmp, num_comp = 0, flag = 0;
    for (i = 0; i < list_len - 2; i++) {
        for (j = list_len - 1; j > i; j--) {
            if (list[j] < list[j - 1]) {
                tmp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = tmp;
                flag = 1;
            }
            num_comp++;
        }
        //if it is already sorted, then we are done.
        if (flag == 0) {
            break;
        } else {
            flag = 0;
        }
    }
    return num_comp;
}

/**
 * The partition algorithm of quick sort.
 * @param list the list to be split into two sub-lists.
 * @param p: the index of first element.
 * @param r: the index of second element.
 * @param num_comp: the number of comparisons of quick sort.
 * @return the position of element, which the list will be split.
 */
int quick_sort_partition(int *list, int p, int r, int *num_comp) {
    int x = list[r], i = p - 1, tmp;
    for (int j = p; j < r; j++) {
        if (list[j] < x) {
            i++;
            tmp = list[i];
            list[i] = list[j];
            list[j] = tmp;
        }
        (*num_comp)++;
    }
    tmp = list[i + 1];
    list[i + 1] = list[r];
    list[r] = tmp;
    return i + 1;
}

/**
 * This method is the implementation of quick_sort
 * algorithm, which shown in Page 171. of reference [1].
 *
 * reference:
 * [1] Cormen, Thomas H., Charles E. Leiserson, Ronald L. Rivest, and
 *     Clifford Stein. Introduction to algorithms. MIT press, 2009.
 *     Third Edition.
 *
 * @param list: the list(array) to be sorted.
 * @param p: the index of the first element of the list.
 * @param r: the index of the last element of the list.
 * @param num_comp: the number of comparisons of quick sort algorithm.
 */
void quick_sort(int *list, int p, int r, int *num_comp) {
    if (p < r) {
        int q = quick_sort_partition(list, p, r, num_comp);
        quick_sort(list, p, q - 1, num_comp);
        quick_sort(list, q + 1, r, num_comp);
    }
}

/**
 * Pretty print.
 * @param list: the list to be printed.
 * @param stride: for each stride elements, we print a new line.
 */
void print_list(int *list, int list_len, int stride) {
    for (int j = 0; j < list_len; j++) {
        printf("%02d ", list[j]);
        if ((j + 1) % stride == 0) {
            printf("\n");
        }
    }
}


int main() {
    // to set a random seed.
    time_t t;
    srand((unsigned) time(&t));

    // we try 10 times and take average of
    // the number of comparisons of two algorithms
    int num_trials = 10;
    int list_len = 100;

    // 3 lists with 100 elements.
    // list_original will be used to save the original list.
    int list_original[list_len];
    // list_bubble will be used by bubble_sort
    int list_bubble[list_len];
    // list_quick will be used by quick_sort
    int list_quick[list_len];
    int total_comp_bubble = 0;
    int total_comp_quick = 0;
    char *line = "--------------------------------";

    for (int trial_i = 0; trial_i < num_trials; trial_i++) {
        printf("\n%s trial-%01d %s\n", line, trial_i, line);

        // to generate random list and get two copies to two algorithms.
        for (int i = 0; i < list_len; i++) {
            // We use rand()%100 method to generate numbers in range [0, 99].
            list_original[i] = rand() % 100;
            list_bubble[i] = list_original[i];
            list_quick[i] = list_original[i];
        }

        int num_comp_quick_sort = 0;
        int num_comp_bubble_sort = 0;
        int *num_comp = &num_comp_quick_sort;

        // to sort list_bubble and list_quick
        quick_sort(list_quick, 0, list_len - 1, num_comp);
        num_comp_bubble_sort = bubble_sort(list_bubble, list_len);
        total_comp_bubble += num_comp_bubble_sort;
        total_comp_quick += num_comp_quick_sort;

        printf("\noriginal list: \n");
        print_list(list_original, list_len, 25);
        printf("\nsorted list by bubble sort: \n");
        print_list(list_bubble, list_len, 25);
        printf("\nsorted list by quick sort: \n");
        print_list(list_quick, list_len, 25);

        printf("\nnumber of comparisons of bubble_sort: %04d\n",
               num_comp_bubble_sort);
        printf("number of comparisons of  quick_sort: %04d\n",
               num_comp_quick_sort);

    }
    printf("\ntaking average of comparisons\n");
    printf("the average of 10 trials of comparisons of bubble_sort: %0.2f\n",
           (total_comp_bubble / 10.));
    printf("the average of 10 trials of comparisons of  quick_sort: %0.2f\n",
           (total_comp_quick / 10.));
    return 0;
}
