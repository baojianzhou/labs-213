import java.util.Scanner;

/**
 * TA: Baojian Zhou (bzhou6@albany.edu)
 * Office Hours: Tue. 2:00pm-3:00pm.
 * 
 * Lab-02 instructions:
 * We will design and write a computer program to execute the following tasks. Basically,
 * it uses a recursive algorithm to reverse strings until the user types “done” as the
 * entry string.
 * 1.   Read in a string from the user. Prompt the user with something like
 * “Enter the string to reverse, or ‘done’ to exit”. If the user enters “done”
 * then exit.
 * 2.   Use a recursive algorithm and implementation to reverse the string.
 * 3.   Compare the original and reversed strings to see if they are the same (i.e.
 * whether they are palindromes). Print out whether they are palindromes or not.
 */
public class Lab02Palindrome {


    private String reversedString;
    private boolean isPalindrome;

    /**
     * The constructor of this program.
     *
     * @param inputString The input string which will be checked.
     */
    private Lab02Palindrome(String inputString) {
        this.reversedString = inputString;
        this.reversedString = reverseString(reversedString);
        this.isPalindrome = this.reversedString.equals(inputString);
    }

    /**
     * Given the inputString, use recursive algorithm to reverse the inputString.
     *
     * @param inputString the input string needs to reverse.
     * @return reversed string.
     */
    private String reverseString(String inputString) {
        if (inputString == null || inputString.length() <= 1) {
            return inputString;
        }
        String front = inputString.substring(0, 1);
        String end = inputString.substring(inputString.length() - 1);
        String middle = inputString.substring(1, inputString.length() - 1);
        return end + reverseString(middle) + front;
    }

    /**
     * getter method.
     *
     * @return return the reversed string.
     */
    private String getReversedString() {
        return reversedString;
    }

    /**
     * Detailed instruction:
     * The program should loop through these three steps until the user indicates they are done.
     * For example, if the user entered “Finally” the program would reverse the string so that
     * it was “yllaniF” and would display that. And then indicate whether they are the same (in
     * this case, no). Then it would prompt for the next string.
     *
     * @param args no need any arguments here.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the string to reverse, or ‘done’ to exit");
            String currentString = scanner.next();
            if (currentString.equals("done")) {
                System.out.println("Exit the program.");
                break;
            } else {
                Lab02Palindrome palindrome = new Lab02Palindrome(currentString);
                System.out.println("-----------------------------------------------");
                System.out.println("current input string: " + currentString);
                System.out.println("     reversed string: " + palindrome.getReversedString());
                if (palindrome.isPalindrome) {
                    System.out.println("The current input string is palindrome!");
                } else {
                    System.out.println("The current input string is NOT palindrome!");
                }
            }
        }//while

    }//main
}
