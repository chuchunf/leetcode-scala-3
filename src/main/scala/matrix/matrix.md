# Matrix


### 54. Spiral Matrix
```scala
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] =
    val result = mutable.ListBuffer[Int]()
    val size = matrix.length * matrix(0).length
    var (left, right, top, bottom) = (0, matrix(0).length - 1, 0, matrix.length - 1)
    while (result.length < size)
      for (i <- left to right) if (result.length < size) result.append(matrix(top)(i)) // left to right, same top
      top = top + 1
      for (j <- top to bottom) if (result.length < size) result.append(matrix(j)(right)) // top to bottom, same right
      right = right - 1
      for (i <- right to left by -1) if (result.length < size) result.append(matrix(bottom)(i)) // right to left, same bottom
      bottom = bottom - 1
      for (j <- bottom to top by -1) if (result.length < size) result.append(matrix(j)(left)) // bottom to top, same left
      left = left + 1
    result.toList
```
