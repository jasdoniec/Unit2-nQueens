# Unit 2 - Assignment 5: N-Queens Problem

## Overview
The **N-Queens Problem** is a classic puzzle in computer science and mathematics. The goal is to place $N$ chess queens on an $N \times N$ chessboard such that no two queens attack each other. 

According to the rules of chess, a queen can attack any piece in the same **row**, **column**, or **diagonal**. Therefore, a valid solution requires exactly one queen per row and column, with zero diagonal conflicts.

In this assignment, you will implement a **recursive backtracking algorithm** in `NQueens.java` to visually find and display the first valid solution on a grid of size $N \times N$.

---

## Visualizing Backtracking

Backtracking explores potential paths step-by-step and steps back as soon as it hits a dead end:
1. **Try:** Place a queen in the first safe column of row $q$.
2. **Recurse:** Attempt to place a queen in row $q+1$.
3. **Backtrack:** If row $q+1$ has no valid column positions, remove the queen from row $q$, move to the next column in row $q$, and try again.

---

## How to Compile and Run

This project uses the `GridWorld` graphical library (`lib/gridworld.jar`).

### Option 1: VS Code GUI (Recommended)
1. Open `NQueensRunner.java`.
2. Click the **Play Icon** in the top-right corner, or press `F5`.

### Option 2: Integrated Terminal

* **Windows (`cmd`):**
  ```cmd
  javac -cp "lib/*;." *.java
  java -cp "lib/*;." NQueensRunner
  ```

* **Mac / Linux (`bash` / `zsh`):**
  ```bash
  javac -cp "lib/*:." *.java
  java -cp "lib/*:." NQueensRunner
  ```

---

## Your Task

Open `NQueens.java` and complete the two missing methods:

### 1. `locationIsOK(Location loc)`
This helper method checks if placing a queen at `loc` is safe from queens already placed in rows **above** it.
* **Check Column:** Loop through all prior rows ($r < \text{row}$) in the same column to verify no queen exists.
* **Check Up-Right Diagonal:** (*Provided as a code example*).
* **Check Up-Left Diagonal:** Write a loop moving up and left ($r--, c--$) verifying no queen exists.

> **Note:** You only need to check rows above `loc` because queens have not yet been placed in rows below it.

---

### 2. `placeQueen(int q)`
This is the recursive backtracking method that places the queen for row $q$:
* **Base Case:** If $q \ge \text{board.getNumRows()}$, all queens have been placed successfully! Return `true`.
* **Recursive Step:**
  1. Loop through each column ($c$) in row $q$.
  2. Create a `Location loc = new Location(q, c);`.
  3. If `locationIsOK(loc)` is `true`:
     * Place the queen using `addQueen(loc);`.
     * Pause briefly to animate: `try { Thread.sleep(20); } catch (Exception e) {}`.
     * Recurse: `if (placeQueen(q + 1)) return true;`.
     * If recursion fails, backtrack: `removeQueen(loc);` and pause briefly.
  4. If no columns in row $q$ work, return `false` to trigger backtracking in the previous row.

---

## Expected Output

When your code works correctly, running `NQueensRunner.java` will open a GridWorld window. You will see queens dynamically placed and removed as the computer tests positions, eventually stopping when a complete non-attacking placement is found!