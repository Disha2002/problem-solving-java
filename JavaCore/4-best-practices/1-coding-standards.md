# Coding Standards

## Purpose

Establish a consistent style and set of practices to improve code readability, maintainability, and collaboration among developers.

---

## General Guidelines

- **Consistent Naming Conventions:**
  - Classes and Interfaces: PascalCase (e.g., `UserAccount`, `PaymentService`)
  - Methods and Variables: camelCase (e.g., `calculateTotal`, `userName`)
  - Constants: UPPER_SNAKE_CASE (e.g., `MAX_SIZE`, `DEFAULT_TIMEOUT`)

- **Indentation and Spacing:**
  - Use 4 spaces per indentation level.
  - Avoid tabs to ensure consistency across editors.
  - Place a space after commas and around operators.
  - Use blank lines to separate logical code blocks.

- **Braces:**
  - Use K&R style braces:

    ```java
    if (condition) {
        // code
    } else {
        // code
    }
    ```

- **Line Length:**
  - Limit lines to 100 characters to improve readability.

- **Comments:**
  - Use Javadoc comments for classes, methods, and public APIs.
  - Write meaningful inline comments sparingly to explain "why" rather than "what".
  - Keep comments up to date with code changes.

---

## Code Structure

- **Class Design:**
  - Keep classes focused on a single responsibility.
  - Limit class size to improve readability.
  - Group related methods together logically.

- **Methods:**
  - Keep methods short (ideally 20-30 lines).
  - Use descriptive names that clearly indicate purpose.
  - Avoid side effects; methods should do one thing.

- **Variables:**
  - Declare variables close to where they are used.
  - Use final for variables that do not change after initialization.

---

## Exception Handling

- Use checked exceptions for recoverable conditions.
- Use unchecked exceptions for programming errors.
- Always clean up resources in finally blocks or use try-with-resources.
- Provide meaningful messages when throwing exceptions.

---

## Code Practices

- Avoid magic numbers; use named constants instead.
- Prefer immutable objects where possible.
- Avoid deep nesting; use guard clauses.
- Use appropriate design patterns to solve common problems.
- Write unit tests for critical logic and edge cases.
- Avoid premature optimization; focus first on clean, correct code.

---

## Tooling and Formatting

- Use automated formatters and linters to enforce standards.
- Use static analysis tools to catch common errors early.
- Run code reviews to maintain quality and share knowledge.

---

## Summary

Adhering to coding standards fosters code clarity, reduces bugs, and enhances team productivity by making code easier to read, understand, and maintain.
