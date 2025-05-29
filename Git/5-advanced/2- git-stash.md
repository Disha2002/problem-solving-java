# Git Stash

`git stash` temporarily shelves (or "stashes") changes in your working directory so you can switch branches or work on something else without committing unfinished work.

---

## 🎯 When to Use Git Stash

- You're in the middle of a task but need to quickly switch to another branch.
- You have uncommitted changes you don't want to lose but can't commit yet.

---

## 💡 Basic Usage

```bash
# Stash current changes
git stash
```

This saves:

- Tracked modified files
- Staged files

It does NOT save:

- Untracked files (unless specified)

---

## 📂 View Stashes

```bash
git stash list
```

Example output:

```
stash@{0}: WIP on main: a1b2c3 Added login form
```

---

## 🛠️ Apply a Stash

```bash
git stash apply       # Apply most recent stash, keep stash
git stash pop         # Apply and delete most recent stash
```

To apply a specific stash:

```bash
git stash apply stash@{1}
```

---

## ❌ Drop/Delete a Stash

```bash
git stash drop stash@{0}   # Remove specific stash
git stash clear            # Remove all stashes
```

---

## 🧪 Stashing Untracked Files

To include untracked files:

```bash
git stash -u
```

To include everything, including ignored files:

```bash
git stash -a
```

---

## Example Workflow

```bash
# You have changes but need to pull
git stash
git pull origin main
git stash pop  # reapply your changes after pulling
```

---

## Summary

| Command                  | Description                            |
|--------------------------|----------------------------------------|
| `git stash`              | Save tracked changes                   |
| `git stash -u`           | Save tracked + untracked changes       |
| `git stash list`         | Show list of stashes                   |
| `git stash apply`        | Reapply last stash                     |
| `git stash pop`          | Reapply and delete last stash          |
| `git stash drop {n}`     | Delete a specific stash                |
| `git stash clear`        | Delete all stashes                     |

---
