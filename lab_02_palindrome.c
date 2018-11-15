/**
 * TA: Baojian Zhou (bzhou6@albany.edu)
 * Office Hours: Tue. 2:00pm-3:00pm.
 *
 * Lab-02 instructions:
 * We will design and write a computer program to execute the following tasks.
 * Basically, it uses a recursive algorithm to reverse strings until the user
 * types “done” as the entry string.
 * 1.   Read in a string from the user. Prompt the user with something like
 *      “Enter the string to reverse, or ‘done’ to exit”. If the user enters
 *      “done” then exit.
 * 2.   Use a recursive algorithm and implementation to reverse the string.
 * 3.   Compare the original and reversed strings to see if they are the same
 *      (i.e. whether they are palindromes). Print out whether they are
 *      palindromes or not.
 */
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// a maximal width of a window.
#define MAX_STRING_LENGTH 79

/**
 * Given the inputString, use recursive algorithm
 * to reverse the inputString.
 * @param input_str the input string needs to reverse.
 * @param str_len number of chars in the string.
 */
void reverse_string(char *input_str, size_t str_len) {
    if (str_len <= 1) {
        return;
    } else {
        //swap the front and end of this string.
        //and then reverse the remaining substring.
        char tmp = input_str[0];
        input_str[0] = input_str[str_len - 1];
        input_str[str_len - 1] = tmp;
        reverse_string(input_str + 1, str_len - 2);
    }
}

int main() {

    char input_str[MAX_STRING_LENGTH];
    char reversed_str[MAX_STRING_LENGTH];
    while (true) {
        printf("Enter the string to reverse, or ‘done’ to exit: ");
        fgets(input_str, MAX_STRING_LENGTH, stdin);
        strcpy(reversed_str, input_str);
        if (strcmp(input_str, "done\n") == 0) {
            printf("Exit the program!");
            break;
        } else {
            size_t str_len = strlen(reversed_str);
            reverse_string(reversed_str, str_len - 1);
            printf("-----------------------------------------------\n");
            printf("current input string: %s", input_str);
            printf("     reversed string: %s", reversed_str);
            if (strcmp(reversed_str, input_str) == 0) {
                printf("The current input string is palindrome!\n");
            } else {
                printf("The current input string is NOT palindrome!\n");
            }
        }
    }
    return 0;
}