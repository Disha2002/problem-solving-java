# Git Branch and Merge

Branching and merging allow you to work on multiple features or fixes simultaneously without affecting the main codebase.

---

## 1. `git branch`

Lists, creates, or deletes branches.

- List all branches:  

  ```bash
  git branch
  ```

- Create a new branch:  

  ```bash
  git branch <branch-name>
  ```

- Delete a branch:  

  ```bash
  git branch -d <branch-name>
  ```

---

## 2. `git checkout`

Switches to another branch.

```bash
git checkout <branch-name>
```

- Creates and switches to a new branch in one step (with `-b`):  
  ```bash
  git checkout -b <branch-name>
  ```

---

## 3. `git merge`

Combines changes from one branch into the current branch.

```bash
git merge <branch-name>
```

- Common workflow: merge a feature branch into `main`.

---

## Example Workflow

```bash
# Create and switch to feature branch
git checkout -b feature/login

# Work on the feature and commit changes
git add .
git commit -m "Add login page"

# Switch back to main branch
git checkout main

# Merge feature branch into main
git merge feature/login

# Push merged changes
git push origin main
```

---

## Handling Conflicts

- If there are conflicting changes, Git will pause the merge and mark conflicts in files.
- Resolve conflicts manually, then commit the merge.

---

## Summary Table

| Command                | Purpose                      |
|------------------------|------------------------------|
| `git branch`           | List/create/delete branches   |
| `git checkout`         | Switch branches               |
| `git checkout -b`      | Create & switch branch        |
| `git merge`            | Merge another branch          |

---
