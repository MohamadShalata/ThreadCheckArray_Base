# Project README

## 1. Recursive Multithreaded Subset Sum Algorithm

The recursive multithreaded Subset Sum algorithm is designed to solve the subset sum problem efficiently by breaking it down into smaller subproblems and solving them concurrently using multiple threads.

### Algorithm Overview

- **Subset Sum Problem**: Given a set of integers, find if there exists a subset whose sum equals a given target.
  
- **Recursive Approach**: The algorithm recursively divides the problem into two parts:
  - One where the last element is included in the subset.
  - Another where the last element is excluded from the subset.

### Thread Synchronization

To ensure that multiple threads do not interfere with each other, thread synchronization mechanisms are employed. Specifically, we use a `Semaphore` to control access to shared resources, such as the list of subsets and their sums.

- **Semaphore Initialization**: A semaphore is initialized with a value equal to the number of threads.
  
- **Acquire and Release**: Before entering a critical section (e.g., updating the list of subsets), each thread acquires a permit from the semaphore. After completing its task, it releases the permit back to the semaphore.

## 2. Data Structure Refactoring to ArrayList<Integer>

The previous implementation used an array-based data structure to store subsets and their sums. For better flexibility and performance, we refactored this to use `ArrayList<Integer>`.

### Benefits of Using ArrayList

- **Dynamic Sizing**: Unlike arrays, `ArrayList` can grow dynamically as needed.
  
- **Ease of Use**: Provides convenient methods for adding, removing, and accessing elements.
  
- **Memory Efficiency**: Automatically manages memory allocation based on the number of elements.

## 3. Code Documentation with Javadoc

To improve code readability and maintainability, we have added extensive Javadoc comments to all public classes, methods, and fields.

### How to Generate Javadoc

You can generate Javadoc by running the following command in your terminal:

```bash
javadoc -d docs src/main/java/com/example/subsetsum/*.java
```

This will generate HTML documentation in the `docs` directory.

## 4. Authors and Git Collaboration Roles

- **Author**: [Your Name]
  
- **Git Role**:
  - **Developer**: Responsible for writing, reviewing, and testing code.
  - **Code Reviewer**: Ensures that the code adheres to best practices and meets project requirements.
  - **Project Manager**: Oversee the development process and coordinate with team members.

## 5. Licensing

This project is licensed under the 'Braude College Academic License'. You can find more details in the [LICENSE](LICENSE) file.

### License Summary

- **Permission**:
  - You are free to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software.
  
- **Conditions**:
  - You must include a copy of the license with any distribution.
  - You must not remove or alter the license notice in any files.

By using this software, you agree to be bound by the terms of the 'Braude College Academic License'.