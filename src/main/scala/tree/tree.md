# Tree
A tree is an abstract data type representing a hierarchical structure, with a root node and subtrees of linked children nodes.
- Children nodes must be connected to exactly one parent, except for the root node, which has no parent.
- These constraints mean there are no cycles or loops.
- Each child can be treated like the root node of its own subtree => **recursion**

Tree and linked list
- It is like a 2d linked list so share some similarities
- Given its hierarchical structure, it works naturally with **recursion**

### Tips
- A **temp helper node** could be used to hold a particular node while transformation
- A **helper function** to take two nodes and/or a container to store results
- Instead of changing the value of the node, pointing to another node works naturally with recursion

## Other specific Tree structures
1. Binary trees, which constrain the number of children for each parent to exactly two.
2. Balanced trees, a binary tree in which the height of the left and right subtree of any node differ by not more than 1.
3. Binary search trees, a binary tree in which the left subtree contains key values less than the root, while the right subtree contains key values greater than the root
4. AVL trees, a self-balancing binary search tree

## Related Algorithms
1. Recursion
2. Depth-first search
3. Width-first search
4. Graph

## Tree Traversals 
- pre-order => root, left then right
- in order => left, root then right
- post order => left, right then root

### 144. Binary Tree Preorder Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BinaryTreeTraversal.scala#L16-L24

### 94. Binary Tree Inorder Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BinaryTreeTraversal.scala#L6-L14

### 145. Binary Tree Postorder Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BinaryTreeTraversal.scala#L26-L34

### 102. Binary Tree Level Order Traversal
line by line horizontally (with a list cache of the next level of nodes)
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BinaryTreeTraversal.scala#L36-L49

### 103. Binary Tree Zigzag Level Order Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BinaryTreeTraversal.scala#L51-L66

## Other operations
### 226. Invert Binary Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/InvertBinaryTree.scala#L4-L11

## Check Tree properties
### 110. Balanced Binary Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/BalancedBinaryTree.scala#L4-L7

### 101. Symmetric Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/SymmetricTree.scala#L4-L9

### 104. Maximum Depth of Binary Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/MaximumDepthofBinaryTree.scala#L4-L9

### 111. Minimum Depth of Binary Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/MinimumDepthofBinaryTree.scala#L4-L6

### 236. Lowest Common Ancestor of a Binary Tree
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/LowestCommonAncestorofaBinaryTree.scala#L4-L17

## Construction and Destruction of Tree
### 114. Flatten Binary Tree to Linked List
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/FlattenBinaryTreetoLinkedList.scala#L4-L17

### 105. Construct Binary Tree from Preorder and Inorder Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/ConstructBinaryTreefromPreorderandInorder.scala#L4-L13

### 106. Construct Binary Tree from Inorder and Postorder Traversal
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/tree/ConstructBinaryTreefromInorderandPostorder.scala#L4-L13
