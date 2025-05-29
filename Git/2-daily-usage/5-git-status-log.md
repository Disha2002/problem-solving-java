# Git Status and Log

These commands help you check the current state of your repository and review the commit history.

---

## 1. `git status`

Shows the status of your working directory and staging area.

```bash
git status
```

- Displays:
  - Modified files not staged for commit
  - Files staged and ready to commit
  - Untracked files
- Helps you understand what to do next (add, commit, etc.)

---

## 2. `git log`

Displays the commit history of the current branch.

```bash
git log
```

- Shows commits in reverse chronological order.
- Each commit includes the hash, author, date, and commit message.

---

## Common Useful `git log` Options

- One line per commit:  
  ```bash
  git log --oneline
  ```
- Graphical representation of branches:  
  ```bash
  git log --graph --oneline --all --decorate
  ```
- Limit number of commits:  
  ```bash
  git log -n 5
  ```

---

## Example Workflow

```bash
git status

# Make changes, stage them
git add .

git status

# Commit changes
git commit -m "Fix navbar bug"

# Check commit history
git log --oneline
```

---

## Summary Table

| Command        | Purpose                              |
|----------------|------------------------------------|
| `git status`   | Check current repo status           |
| `git log`      | View commit history                 |

---
