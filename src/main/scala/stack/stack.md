# Stack
A stack is an abstract data type that serves as a collection of elements, supporting two basic operations, 
Push to add an element and Pop to remove the most recently pushed element out. 
Additionally, a peek operation may give access to the top without modifying the stack
- Stack could be implemented use a linked list or an array
- Stack data structures are used in backtracking problems, elements could be pushed in for later processing
  - Unlike back tracking technique, stack normally holds conditions not actual result
  - Matching parentheses => back track of unmatched pair
  - Stock span => back track to the previous height
  - The shortest unsorted array => back track to the previous unsorted
- Stack has similar usage as hashmap to reduce the O(n) to O(1)
  - Hashmap works when we just need to know existence instead of actual operation of each item
  - Stack works when we only need to know the local optimal value related to the problem

### 155. Min Stack
```scala
  private var head: Option[Node[T]] = None
  private var min: Option[T] = None

  def push(value: T): Unit = head match
    case None => head = Option(new Node(value, None))
      min = Option(value)
    case _ => head = Option(new Node(value, head))
      min = Option(if min.get.compareTo(value) > 0 then value else min.get)

  def pop(): T = head match
    case None => throw new IllegalArgumentException("empty stack!")
    case Some(node) => head = head.get.next
      head match {
        case None => min = None
        case _ => var (temp, newmin) = (head, head.get.value)
          while temp.isDefined do
            newmin = if newmin.compareTo(temp.get.value) > 0 then temp.get.value else newmin
            temp = temp.get.next
          min = Option(newmin)
      }
      node.value
```

### 20. Valid Parentheses
```scala
  def isValid(s: String): Boolean =
    val stack = new MinStack[Character]()
    val map = Map(')' -> '(', ']' -> '[', '}' -> '{')
    s.toArray.find(char => char match {
      case '(' | '[' | '{' => stack.push(char); false
      case ')' | ']' | '}' => if (stack.pop() == map(char)) then false else true
      case _ => false
    }).isEmpty
```

### 901. Online Stock Span
```scala
  def calulcateSpan(prices: Array[Int]): Array[Int] = prices match
    case Array() => Array()
    case Array(_) => Array(0)
    case _ => val (stack, array) = (new MinStack[Integer](), mutable.ArrayBuffer[Int](0))
      stack.push(0)
      prices.drop(1).zipWithIndex.foreach { case (price, index) => {
        var (span, i) = (1, index + 1)
        while prices(stack.top()) < price do
          span = span + 1
          stack.pop()
        stack.push(i)
        array.append(span)
      }}
      array.toArray
```

### 581. Shortest Unsorted Continuous Subarray
```scala
  def findUnsortedSubarray(nums: Array[Int]): Int =
    def getEnd(nums: Array[Int]): Int =
      var (end, stack) = (nums.length, new MinStack[Integer]())
      nums.zipWithIndex.foreach { case (num, index) => {
        while (!stack.isEmpty() && nums(stack.top()) > num) do end = end.min(stack.pop())
        stack.push(index)
      }}
      end + 1

    val (left, right) = (getEnd(nums), nums.length - getEnd(nums.reverse))
    if right > left then right - left + 1 else 0
```