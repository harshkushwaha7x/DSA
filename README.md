<div align="center">

# 📚 Data Structures and Algorithms in Java 💻

**Data Structures and Algorithms in Java** is a comprehensive collection of fundamental CS concepts implemented to help developers and students master DSA, prepare for technical interviews, and build strong problem-solving skills. The repository features clean, efficient implementations with detailed explanations and organized code structure.

• [Portfolio](https://portflio-3.vercel.app/) • [GitHub](https://github.com/harshkushwaha7x)

</div>

---

<p align="center">
  <a href="https://github.com/harshkushwaha7x/DSA"><img src="https://img.shields.io/github/last-commit/harshkushwaha7x/DSA?style=flat-square" alt="last commit"></a>
  <a href="https://github.com/harshkushwaha7x/DSA"><img src="https://img.shields.io/github/languages/top/harshkushwaha7x/DSA?style=flat-square" alt="languages"></a>
  <a href="https://github.com/harshkushwaha7x/DSA/blob/main/LICENSE"><img src="https://img.shields.io/badge/license-MIT-blue?style=flat-square" alt="license" /></a>
  <img src="https://img.shields.io/badge/version-1.0.0-success?style=flat-square" alt="version" />
</p>

---

## ✨ Summary

This repository provides clear and efficient implementations of essential data structures and algorithms commonly used in software development and technical interviews. Each implementation includes detailed explanations, time/space complexity analysis, and practical examples to enhance understanding and learning.

---

## 📦 Highlights & Use Cases

- Comprehensive coverage of fundamental data structures and algorithms.
- Perfect for technical interview preparation (FAANG, competitive programming).
- Clean, well-documented code suitable for learning and reference.
- Organized structure for easy navigation and experimentation.
- Ideal for computer science students and self-taught developers.

---

## 🚀 Features

- 📊 Complete implementations of essential data structures
- 🔍 Multiple searching and sorting algorithms with complexity analysis
- 🌳 Tree and graph traversal techniques
- 💡 Dynamic programming solutions to classic problems
- 🧪 Test cases and examples for each implementation
- 📖 Detailed comments and documentation
- ⚡ Optimized solutions with best practices

---

## 🧩 Tech Stack

**Language:** Java  
**Development:** JDK 8+  
**Tools:** IntelliJ IDEA / Eclipse / VS Code  
**Testing:** JUnit (optional)  
**Version Control:** Git & GitHub

---

## 📁 Project Structure

```
/DSA
│
├── src/
│   ├── datastructures/
│   │   ├── arrays/           # Array operations
│   │   ├── linkedlists/      # Singly & Doubly Linked Lists
│   │   ├── stacks/           # Stack implementations
│   │   ├── queues/           # Queue variants
│   │   ├── trees/            # Binary Trees, BST, AVL, Heap
│   │   └── graphs/           # Graph representations
│   │
│   ├── algorithms/
│   │   ├── sorting/          # Bubble, Merge, Quick, Heap Sort
│   │   ├── searching/        # Linear, Binary Search
│   │   ├── graphalgorithms/  # Dijkstra, Kruskal, Prim
│   │   └── dynamicprogramming/ # DP solutions
│   │
│   └── utils/                # Helper classes
│
├── tests/                    # Unit tests
├── README.md                 # Project documentation
└── LICENSE                   # License file
```

---

## 🛠️ Quick Start (Local)

1. **Clone the repository**
```bash
git clone https://github.com/harshkushwaha7x/DSA.git
cd DSA
```

2. **Navigate to the source directory**
```bash
cd src
```

3. **Compile and run any Java file**
```bash
javac datastructures/arrays/ArrayOperations.java
java datastructures.arrays.ArrayOperations
```

Or compile and run specific algorithms:
```bash
javac algorithms/sorting/QuickSort.java
java algorithms.sorting.QuickSort
```

---

## 📚 Data Structures

### Arrays
- Array operations: searching, insertion, deletion, traversal
- Two-pointer technique implementations
- Sliding window problems

### Linked Lists
- **Singly Linked List:** Insert, delete, search, reverse operations
- **Doubly Linked List:** Bidirectional traversal and manipulation
- **Circular Linked List:** Loop detection and handling

### Stacks
- Array-based and linked list-based implementations
- Applications: Expression evaluation, parentheses matching
- Min/Max stack variants

### Queues
- Standard Queue operations
- Circular Queue implementation
- Priority Queue using heaps
- Deque (Double-ended Queue)

### Trees
- **Binary Tree:** In-order, pre-order, post-order traversal
- **Binary Search Tree:** Search, insert, delete operations
- **AVL Tree:** Self-balancing BST with rotations
- **Heap:** Min-Heap and Max-Heap implementations
- **Trie:** Prefix tree for string operations

### Graphs
- Adjacency List and Adjacency Matrix representations
- BFS (Breadth-First Search) implementation
- DFS (Depth-First Search) implementation
- Cycle detection algorithms

---

## 🔬 Algorithms

### Sorting Algorithms
| Algorithm | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity |
|-----------|------------------------|---------------------------|-------------------------|------------------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) |

### Searching Algorithms
- **Linear Search:** O(n) time complexity
- **Binary Search:** O(log n) time complexity (sorted arrays)
- **Jump Search:** O(√n) time complexity
- **Interpolation Search:** O(log log n) average case

### Graph Algorithms
- **Dijkstra's Algorithm:** Shortest path in weighted graphs
- **Kruskal's Algorithm:** Minimum Spanning Tree (MST)
- **Prim's Algorithm:** Alternative MST algorithm
- **Bellman-Ford:** Handles negative weights
- **Floyd-Warshall:** All-pairs shortest paths

### Dynamic Programming
- **Knapsack Problem:** 0/1 and unbounded variants
- **Fibonacci Sequence:** Optimized with memoization
- **Longest Common Subsequence:** String comparison
- **Coin Change Problem:** Minimum coins and combinations
- **Edit Distance:** String transformation
- **Matrix Chain Multiplication:** Optimization problem

---

## 🧪 Usage Examples

### Running a Sorting Algorithm
```bash
# Navigate to sorting directory
cd src/algorithms/sorting

# Compile and run Quick Sort
javac QuickSort.java
java QuickSort
```

### Testing a Data Structure
```bash
# Navigate to data structures directory
cd src/datastructures/trees

# Compile and run Binary Search Tree
javac BinarySearchTree.java
java BinarySearchTree
```

---

## 📊 Complexity Analysis

Each implementation includes:
- **Time Complexity:** Best, average, and worst-case scenarios
- **Space Complexity:** Auxiliary space requirements
- **Trade-offs:** Pros and cons of each approach
- **Use Cases:** When to use each data structure/algorithm

---

## ✅ Best Practices

- Clean, readable code with meaningful variable names
- Comprehensive comments explaining logic
- Edge case handling (null checks, empty inputs)
- Optimized implementations following Java conventions
- Modular design for easy testing and reusability

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create your branch: `git checkout -b feature/new-algorithm`
3. Commit changes: `git commit -m "Added new sorting algorithm"`
4. Push and open a Pull Request

**Contribution Guidelines:**
- Follow existing code style and formatting
- Add comments and documentation
- Include complexity analysis
- Test your implementations thoroughly

---

## 📄 License

This project is licensed under the **MIT License** — see [LICENSE](LICENSE).

---

## 📬 Contact

**Harsh Kushwaha** — Developer & Maintainer  
- Portfolio: [https://portflio-3.vercel.app/](https://portflio-3.vercel.app/)  
- GitHub: [https://github.com/harshkushwaha7x](https://github.com/harshkushwaha7x)  
- LinkedIn: [https://linkedin.com/in/harshkushwaha7x](https://www.linkedin.com/in/harsh-kushwaha-7x/)  
- Email: harshkushwaha4151@gmail.com

---

<div align="center">
Made with 💻 by <b>Harsh Kushwaha</b>

Happy Coding! 🚀
</div>