# Git Theory Questions

This file contains common Git theory questions frequently asked in interviews, along with brief explanations.

---

## 1. What is Git?

Git is a distributed version control system that helps track changes in source code during software development. It allows multiple developers to collaborate and maintain a complete history of changes.

---

## 2. How does Git differ from SVN?

- Git is distributed, meaning every developer has a full copy of the repository.
- SVN is centralized, relying on a single central server.
- Git supports branching and merging more efficiently and flexibly.

---

## 3. What is a commit in Git?

A commit is a snapshot of changes in the repository. It records what has changed, who made the change, and when.

---

## 4. What is branching?

Branching allows you to create separate lines of development. Branches let you work on features, bug fixes, or experiments independently before merging back into the main codebase.

---

## 5. What is merging?

Merging is the process of integrating changes from one branch into another, combining the histories and changes.

---

## 6. What is rebasing?

Rebasing moves or reapplies commits from one branch onto another, creating a linear history. It rewrites commit history.

---

## 7. What is a detached HEAD?

A detached HEAD state occurs when HEAD points directly to a commit instead of a branch, often when checking out a specific commit.

---

## 8. What is the difference between git fetch and git pull?

- `git fetch` downloads changes from the remote but doesn’t merge them.
- `git pull` fetches and then merges the changes into your current branch.

---

## 9. How do you resolve merge conflicts?

Merge conflicts occur when changes clash. They are resolved by manually editing conflicted files, then staging and committing the resolved changes.

---

## 10. What is the staging area?

The staging area (index) is where changes are placed before committing. It allows you to prepare and review changes before saving them in the repository.

---

## 11. What are tags in Git?

Tags mark specific points in history as important, commonly used for releases.

---

## 12. What is the difference between git reset, git revert, and git checkout?

- `git reset` moves the HEAD to a previous commit and can modify the staging area and working directory.
- `git revert` creates a new commit that undoes changes from a previous commit.
- `git checkout` switches branches or restores files.

---

## 13. What is the purpose of .gitignore?

It specifies intentionally untracked files that Git should ignore.

---

## 14. What is a remote repository?

A remote repository is a version of your project hosted on the internet or network, such as GitHub or GitLab.

---

## 15. What is a fast-forward merge?

A fast-forward merge occurs when the branch you are merging has all commits ahead of the target branch with no divergent history. Git simply moves the pointer forward.

---

Feel free to study these questions as part of your Git interview prep!

---
