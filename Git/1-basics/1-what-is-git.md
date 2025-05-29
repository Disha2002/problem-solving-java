# What is Git?

Git is a **distributed version control system (VCS)** used to track changes in source code during software development. It helps individuals and teams collaborate, manage code versions, and track every modification with precision.

---

## 🔧 Key Features of Git

- **Distributed**: Every developer has a complete copy of the codebase and history locally.
- **Fast Performance**: Git is optimized for speed, especially for tasks like commits, branching, and merging.
- **Data Integrity**: Every file and commit is checksummed and tracked using SHA-1 hashes.
- **Non-linear Development**: Support for thousands of parallel branches and merges.
- **Efficient Collaboration**: Easy to work with others using platforms like GitHub, GitLab, and Bitbucket.

---

## 📜 Why Use Git?

- Maintain a history of changes.
- Collaborate across teams with proper control.
- Revert to earlier versions of your project if needed.
- Experiment with features using branches without breaking main code.
- Avoid "final-final-v2-really-final.zip" nightmare.

---

## 🔄 Git vs GitHub

| Git                  | GitHub                   |
|----------------------|--------------------------|
| Version control tool | Hosting service for Git  |
| Works locally        | Works online             |
| Command-line tool    | Web interface & API      |
| No network needed    | Needs internet to sync   |

> **Think of Git as your toolbox, and GitHub as a shared workshop.**

---

## 📁 How Git Organizes Data

- **Repository (Repo)**: Project folder tracked by Git.
- **Commit**: A snapshot of your code at a specific point in time.
- **Branch**: A separate line of development.
- **Merge**: Combining changes from different branches.
- **HEAD**: A pointer to the current branch reference.

---

## 📘 Example Use Case

You’re building a website:

1. Initialize a repo: `git init`
2. Track files: `git add .`
3. Save a snapshot: `git commit -m "Initial commit"`
4. Create a new feature: `git checkout -b feature-navbar`
5. Merge it back when done: `git merge feature-navbar`

---

## ✅ Summary

Git is the **industry-standard tool** for tracking code history, collaborating efficiently, and managing software projects of any size. Learning Git is essential for all developers and often a topic in technical interviews.

