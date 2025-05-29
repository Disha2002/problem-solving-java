# Feature Branches

A **feature branch** is used to develop a single new feature in isolation from the main codebase. This workflow promotes cleaner code, easier reviews, and safer deployments.

---

## 🔀 What is a Feature Branch?

- A short-lived branch created from the main branch.
- Focuses on implementing one specific feature or improvement.
- Merged back into `main` after development and review.

---

## 🔧 How to Create a Feature Branch

```bash
# Switch to the main branch
git checkout main

# Pull the latest changes
git pull origin main

# Create and switch to a new branch
git checkout -b feature/user-auth
```

---

## 💻 Work on the Feature

```bash
# Make changes
git add .
git commit -m "Add login form and basic auth logic"
```

---

## 🔁 Merge the Feature Branch

Once done and reviewed (possibly via a pull request):

```bash
# Switch back to main
git checkout main

# Pull latest changes
git pull origin main

# Merge the feature branch
git merge feature/user-auth

# Push to remote
git push origin main
```

---

## 🧹 Clean Up

```bash
# Delete local branch
git branch -d feature/user-auth

# Delete remote branch (if pushed)
git push origin --delete feature/user-auth
```

---

## ✅ Benefits of Using Feature Branches

- Isolated development
- Parallel work by multiple developers
- Easier testing and code reviews
- Clean and stable `main` branch

---

## Naming Conventions

Use descriptive names:

```
feature/login-page
feature/add-api-support
bugfix/fix-header-overlap
```

---

## Summary

| Step              | Command Example                            |
|-------------------|---------------------------------------------|
| Create branch     | `git checkout -b feature/foo`               |
| Work & commit     | `git add . && git commit -m "..."`          |
| Merge             | `git checkout main && git merge feature/foo`|
| Delete            | `git branch -d feature/foo`                 |

---
