# Git Branches Documentation

## What is a Git Branch?

A **branch** in Git is a lightweight movable pointer to a commit. Branches allow you to work on different versions of your project simultaneously. The default branch is usually named `main` or `master`. Using branches helps isolate development work without affecting the main codebase.

---

## How to Access Branches

### List all branches

To see all local branches in your repository:

    git branch

To see all remote branches:

    git branch -r

To see all branches (local + remote):

    git branch -a

### Switch to a branch

To switch (checkout) to an existing branch:

    git checkout branch_name

Or using the newer recommended command:

    git switch branch_name

---

## How to Create a Branch

To create and switch to a new branch:

    git checkout -b new_branch_name

Or with the newer command:

    git switch -c new_branch_name

---

## How to Delete a Branch

### Delete a local branch

To delete a local branch:

    git branch -d branch_name

If the branch has unmerged changes and you want to force delete:

    git branch -D branch_name

### Delete a remote branch

To delete a branch on the remote repository:

    git push origin --delete branch_name

---

## Summary of Commands

| Action                   | Command                                                       |
|--------------------------|---------------------------------------------------------------|
| List local branches       | `git branch`                                                  |
| List remote branches      | `git branch -r`                                               |
| Switch to a branch        | `git checkout branch_name` or `git switch branch_name`       |
| Create a new branch       | `git checkout -b new_branch_name` or `git switch -c new_branch_name` |
| Delete local branch       | `git branch -d branch_name`                                   |
| Force delete local branch | `git branch -D branch_name`                                   |
| Delete remote branch      | `git push origin --delete branch_name`                        |
