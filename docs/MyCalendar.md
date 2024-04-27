# My Calendar
My calendar is a series of problem of handling **range overlapping** with different requirements:
1. My Calendar I: no **double** booking
2. My Calendar II: no **triple** booking
3. My Calendar III: get the value of k as the **number of overlapping** 

<br>
<details>
<summary><b>Thinking progress</b></summary>

For two entries to overlap, at least one end of one entry must be within the other entry. 
So the problem is to find out if a number (begin or end of one entry) is smaller than the end and bigger than the begin of another entry.
1. An array or list could be used to store the begin and end, but the complexity will be O(n)
2. A hashmap provide O(1) look up but, map is not ordered, we have to loop all entries to find out if there is an overlap
3. A **sorted set/map** is ideal in this situation, it provides functions such as  minBefore, maxAfter in O(log(n))

Tip: **use the start as key and end as value**, so we can get both ends in a single call.

For **My calendar II**, we can use the same idea to store the start as key and end as value, 
however, we need to the same check twice as double booking is now allowed.

**My calendar III** is a more general case, which is to find the number of overlapping
1. We could continue use the same idea, however, we will have to iterate each entry against all entries to find out the max
2. We could use an array with the size of max end, uses the index as day and value as number of overlaps, a single pass will get all max. However it will result lots of empty space.
3. So again an ordered map is the ideal data structure, it provides the fast lookup and min space requirement,
4. Most importantly, the ordered map **keeps the order of begin and end** 

Hence, we could use the start and end as key and the number of overlaps as value, 
1. A single pass of all entries, for start, we add 1 and for end we deduct 1
2. Keep a running max and compare with current overlap for each entry
</details>
<br>

### 729. My Calendar I
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

```
Example 1:
Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar.scala#L6-L14

### 731. My Calendar II
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
```
Example 1:
Input
["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output
[null, true, true, true, false, true, true]
```
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar2.scala#L6-L22

### 732. My Calendar III
A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

You are given some events [startTime, endTime), after each given event, return an integer k representing the maximum k-booking between all the previous events.

Implement the MyCalendarThree class:

MyCalendarThree() Initializes the object.
int book(int startTime, int endTime) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
```
Example 1:
Input
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output
[null, 1, 1, 2, 3, 3, 3]
```
Use Order Map to simulate the time line to save space, as the time spot will be sparse.
https://github.com/chuchunf/leetcode-scala-3/blob/96edcbc70953e25ba3eedbcbaa7bf18b8034eff0/src/main/scala/orderedset/MyCalendar3.scala#L6-L14

