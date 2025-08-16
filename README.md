# Tic-Tac-Toe Game - Low Level Design Implementation

A well-structured Tic-Tac-Toe game implementation in Java demonstrating various **Design Patterns** and **SOLID Principles**. This project serves as an excellent example of object-oriented design and clean code architecture.

## 🎮 Features

- Interactive console-based gameplay
- Two-player support (X and O pieces)
- Dynamic board display
- Input validation and error handling
- Win detection for rows, columns, and diagonals
- Tie game detection

## 🏗️ Architecture Overview

```
src/
├── Main.java                 # Entry point
├── TicTacToeGame.java        # Game controller and logic
└── Model/
    ├── Board.java            # Board state and operations
    ├── Player.java           # Player representation
    ├── PlayingPiece.java     # Base class for game pieces
    ├── PlayingPieceX.java    # X piece implementation
    ├── PlayingPieceO.java    # O piece implementation
    └── PieceType.java        # Enum for piece types
```

## 🎯 Design Patterns Implemented

### 1. **Strategy Pattern**
- **Implementation**: `PlayingPiece` hierarchy with `PlayingPieceX` and `PlayingPieceO`
- **Purpose**: Different piece behaviors encapsulated in separate classes
- **Benefits**: Easy to extend with new piece types without modifying existing code

### 2. **Template Method Pattern**
- **Implementation**: `TicTacToeGame.startGame()` method
- **Purpose**: Defines the skeleton of game flow:
  ```java
  while (gameActive) {
      getCurrentPlayer();
      displayBoard();
      getUserInput();
      placePiece();
      checkWinner();
      switchTurns();
  }
  ```

### 3. **Model-View-Controller (MVC)**
- **Model**: `Board`, `Player`, `PlayingPiece` classes
- **View**: Console output methods
- **Controller**: `TicTacToeGame` class managing game flow

## ⚡ SOLID Principles Applied

### ✅ Single Responsibility Principle (SRP)
Each class has a single, well-defined responsibility:
- `Board`: Manages board state and operations
- `Player`: Represents player information
- `PlayingPiece`: Defines piece behavior
- `TicTacToeGame`: Controls game flow and logic

### ✅ Open/Closed Principle (OCP)
- `PlayingPiece` hierarchy is **open for extension** (new piece types can be added)
- **Closed for modification** (existing code doesn't need changes)
- Example: Adding a new piece type only requires extending `PlayingPiece`

### ✅ Liskov Substitution Principle (LSP)
- `PlayingPieceX` and `PlayingPieceO` can substitute `PlayingPiece` seamlessly
- All subclasses maintain the contract of their parent class

### ⚠️ Interface Segregation Principle (ISP)
- Classes have focused, cohesive interfaces
- No unnecessary method dependencies

### ⚠️ Dependency Inversion Principle (DIP)
- `Player` depends on `PlayingPiece` abstraction rather than concrete implementations
- Room for improvement: Use dependency injection for better testability

## 🚀 How to Run

1. **Compile the Java files:**
   ```bash
   javac *.java Model/*.java
   ```

2. **Run the game:**
   ```bash
   java Main
   ```

3. **Follow the prompts:**
   - Enter row and column coordinates (0-based indexing)
   - Format: `row,column` (e.g., `1,2`)

## 🎲 Game Rules

1. The game is played on a 3×3 grid
2. Players take turns placing their pieces (X and O)
3. First player to get 3 pieces in a row (horizontally, vertically, or diagonally) wins
4. If all 9 squares are filled without a winner, the game is a tie

## 📝 Sample Gameplay

```
    | X   |     
    | O   | X   
 O  |     |     

Player: Player 1 Enter row, column: 0,2
 X  | X   | X   
    | O   | X   
 O  |     |     

game winner is: Player 1
```

## 🔧 Code Quality Features

- **Separation of Concerns**: Clear separation between game logic, board management, and player handling
- **Extensibility**: Easy to add new features like different board sizes, new piece types, or game modes
- **Maintainability**: Well-organized code structure with meaningful class and method names
- **Error Handling**: Input validation and graceful error recovery

## 🚀 Future Enhancements

### Potential Design Pattern Additions:
1. **Factory Pattern**: For creating different types of playing pieces
2. **Observer Pattern**: For notifying multiple game observers
3. **Command Pattern**: For implementing undo/redo functionality
4. **State Pattern**: For managing different game states

### Feature Enhancements:
- [ ] Configurable board sizes (4x4, 5x5, etc.)
- [ ] AI player implementation
- [ ] Game history and replay
- [ ] Score tracking across multiple games
- [ ] GUI implementation using Swing/JavaFX

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 👨‍💻 Author

**Mukul Soni** - [GitHub Profile](https://github.com/mukuls10)

---

**⭐ If you found this implementation helpful, please consider giving it a star!**

*This project demonstrates the practical application of software design principles and patterns in a simple yet comprehensive way, making it an excellent learning resource for software developers.*
