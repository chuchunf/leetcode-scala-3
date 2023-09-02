# Binary Search Tree
Binary Search Tree is a node-based binary tree data structure which has the following properties:
- The left subtree of a node contains only nodes with keys lesser than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.

Binary search trees allow binary search for **fast lookup, addition, and removal of data items**.
- A balanced binary tree is a binary tree structure in which the left and right subtrees of every node differ in height by no more than 1. 
- A perfect binary tree is a tree with all leaves are at the same level, and every parent has two children.

## Related data structures
TreeMap and TreeSet data structures are internally implemented using self-balancing BSTs.

## Check BST properties
### 98. Validate Binary Search Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/ValidateBinarySearchTree.scala#L6-L9

### 100. Same Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/SameTree.scala#L6-L11

### 235. Lowest Common Ancestor of a Binary Search Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/LowestCommonAncestorofBST.scala#L9-L12

## Modify BST
### 450. Delete Node in a BST
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/DeleteNodeinaBST.scala#L6-L22

### 701. Insert into a Binary Search Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/InsertIntoaBST.scala#L6-L17

## Construct BST
### 108. Convert Sorted Array to Binary Search Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/ConvertSortedArraytoBST.scala#L6-L10

### 173. Binary Search Tree Iterator
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/BinarySearchTreeIterator.scala#L7-L25

## Traversal of BST
### 99. Recover Binary Search Tree
For a valid BST, the in order search will be sorted
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/RecoverBinarySearchTree.scala#L6-L20

### 257. Binary Tree Paths
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/bst/BinaryTreePaths.scala#L8-L16
