# sorty

A library of sorting algorithms.

### Description

This project is an **experimental and education project** and not to be used in
anything important.

It will have all sorting strategy implementations and in different ways if
possible.

The whole idea started when I read about Insertion Sort and the question came:
How does it improve performance in real time when we do the following:

1. Find insertion position using Binary Search
2. Replace using for for shifting of elements to something like
   `System.arraycopy` which is a native call.

Lets see where this project leads to.

### Things to learn:

1. Sorting algorithms
2. Benchmarking using [JMH](https://github.com/openjdk/jmh)
3. Use profilers/Flame graphs to understand more nitty gritties.

### LICENSE

This is under [MIT LICENSE](LICENSE)
