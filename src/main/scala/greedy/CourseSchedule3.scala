package greedy

import heap.PriorityQueue

object CourseSchedule3 {
  def scheduleCourse(courses: Array[Array[Int]]): Int =
    courses.sortBy(_(1))
    val heap = new PriorityQueue[Int]()
    var days = 0
    for (course <- courses) {
      days = days + course(0)
      heap.offer(course(0), course(0))
      if (days > course(1)) then days = days - heap.poll()
    }
    heap.length()
}
