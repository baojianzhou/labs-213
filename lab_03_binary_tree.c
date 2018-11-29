/**
 * use the following command to compile this code:
 * gcc -o lab_03_binary_tree -std=c11 -Wall -Wextra -O3 lab_03_binary_tree.c
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// a tree node struct
typedef struct Node {
    int value;
    struct Node *left_child;
    struct Node *right_child;
} Node;

/**
 * Add new node by its value.
 * @param root root of current binary tree.
 * @param new_node add new node by using ordered way.
 * @return root of current binary tree.
 */
Node *add_node(Node *root, Node *new_node) {
    if (root == NULL) {
        return new_node;
    } else {
        if (new_node->value <= root->value) {
            root->left_child = add_node(root->left_child, new_node);
        } else {
            root->right_child = add_node(root->right_child, new_node);
        }
    }
    return root;
}

/**
 * Create an empty binary tree and insert these nodes into
 * this new binary tree.
 * @param list_nodes insert this list of nodes into an empty tree.
 * @param len_list number of nodes.
 * @return root of this binary tree.
 */
Node *create_binary_tree(const int *list_nodes, int len_list) {
    Node *root = NULL;
    for (int ii = 0; ii < len_list; ii++) {
        Node *new_node = (Node *) malloc(sizeof(Node));
        new_node->value = list_nodes[ii];
        new_node->left_child = NULL;
        new_node->right_child = NULL;
        root = add_node(root, new_node);
    }
    return root;
}

/**
 * TODO: check whether the input binary tree is complete or not.
 * @param root: the root of the input binary tree.
 * @return
 */
bool is_complete(Node *root) {
    // TODO Your code goes to here
    return false;
}

/**
 * TODO: check whether the input binary tree is full or not.
 * @param root: the root of the input binary tree.
 * @return
 */
bool is_full(Node *root) {
    // TODO Your code goes to here
    return false;
}

void print_result(Node *root) {
    bool is_full_binary = is_full(root);
    bool is_complete_binary = is_complete(root);
    if (is_complete_binary && is_full_binary) {
        printf("This is a complete and full binary tree!\n");
    } else if (is_complete_binary) {
        printf("This is a complete binary tree!\n");
    } else if (is_full_binary) {
        printf("This is a full binary tree!\n");
    } else {
        printf("This is neither a complete or full tree!\n");
    }
}

int main() {
    /*
     *              20
     *             /  \
     *           10   30
     *           /
     *          5
     */
    int test_tree_01[] = {20, 10, 30, 5};
    Node *root_01 = create_binary_tree(test_tree_01, 4);
    print_result(root_01);
    /*
     *              30
     *            /    \
     *          20     40
     *         /  \    /
     *        15  25  35
     */
    int test_tree_02[] = {30, 40, 20, 15, 25, 35};
    Node *root_02 = create_binary_tree(test_tree_02, 6);
    print_result(root_02);
    /*
     *             30
     *            /  \
     *          20   40
     *              /  \
     *             35  50
     *                /  \
     *               45  60
     */
    int test_tree_03[] = {30, 40, 50, 60, 20, 35, 45};
    Node *root_03 = create_binary_tree(test_tree_03, 7);
    print_result(root_03);
    /*
     *                    30
     *                  /   \
     *                 20   35
     *                /  \
     *              10    25
     *              /  \
     *             5    15
     *            / \
     *           2   7
     */
    int test_tree_04[] = {30, 20, 10, 5, 2, 35, 25, 15, 7};
    Node *root_04 = create_binary_tree(test_tree_04, 9);
    print_result(root_04);
    /*
     *                    5
     *                  /   \
     *                 2     8
     */
    int test_tree_05[] = {5, 2, 8};
    Node *root_05 = create_binary_tree(test_tree_05, 3);
    print_result(root_05);
    /*
     *                     20
     *                   /    \
     *                 10     30
     *                /  \    / \
     *               5   15  25 35
     */
    int test_tree_06[] = {20, 10, 30, 5, 15, 25, 35};
    Node *root_06 = create_binary_tree(test_tree_06, 7);
    print_result(root_06);
    /*
     *                    20
     *                      \
     *                      40
     *                      /
     *                    30
     */
    int test_tree_07[] = {20, 40, 30};
    Node *root_07 = create_binary_tree(test_tree_07, 3);
    print_result(root_07);
    /*
     *                    20
     *                  /   \
     *                 10   30
     *                     /
     *                    25
     */
    int test_tree_08[] = {20, 10, 30, 25};
    Node *root_08 = create_binary_tree(test_tree_08, 4);
    print_result(root_08);
    /*
     * If your implementation is correct, you should
     * expect the following outputs:
     *      This is a complete binary tree!
     *      This is a complete binary tree!
     *      This is a full binary tree!
     *      This is a full binary tree!
     *      This is a complete and full binary tree!
     *      This is a complete and full binary tree!
     *      This is neither a complete or full tree!
     *      This is neither a complete or full tree!
     */
}