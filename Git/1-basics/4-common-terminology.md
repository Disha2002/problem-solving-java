# Common Git Terminology

This file covers the most commonly used Git terms that you'll encounter while learning Git or working with version control in software development.

---

## 📦 1. Repository (Repo)

A **repository** is a project folder that Git tracks. It contains all your project files and the entire version history of every file.

- **Local repo**: On your computer  
- **Remote repo**: On platforms like GitHub

---

## 📌 2. Commit

A **commit** is a snapshot of your code at a specific point in time.

```bash
git commit -m "Describe your changes"
```

Each commit has a unique hash (ID) and includes a message describing the change.

---

## 🌱 3. Branch

A **branch** is a separate line of development that allows you to work on features or fixes without affecting the main codebase.

- Default branch: `main` (or sometimes `master`)  
- Common practice: `feature/login-page`, `bugfix/navbar-crash`

```bash
git branch feature-xyz
```

---

## 🧬 4. Merge

To **merge** means to combine changes from one branch into another, typically from a feature branch into the main branch.

```bash
git merge feature-xyz
```

Git tries to auto-resolve differences, but you may have to resolve conflicts manually.

---

## 🔀 5. Fork

A **fork** is a copy of someone else's repository (usually from GitHub) under your own account. You can freely experiment, then submit changes back via a pull request.

---

## ⏮️ 6. Clone

To **clone** a repository means to create a full local copy of a remote repo.

```bash
git clone https://github.com/user/repo.git
```

This includes the entire project and its version history.

---

## ⏫ 7. Push

To **push** means to upload your local commits to a remote repository (like GitHub).

```bash
git push origin main
```

---

## ⏬ 8. Pull

To **pull** means to fetch and integrate changes from the remote repository into your local branch.

```bash
git pull origin main
```

---

## 🕵️ 9. Staging Area (Index)

Before committing, Git uses a **staging area** where you prepare a snapshot of changes.

```bash
git add file.txt
```

Think of this as a preview of what will be included in the next commit.

---

## 🧹 10. .gitignore

A `.gitignore` file tells Git which files or folders to ignore in your repo. Useful for excluding logs, build artifacts, credentials, etc.

Example:

```
node_modules/
.env
.DS_Store
```

---

## ✅ Summary Table

| Term         | Description                                  |
|--------------|----------------------------------------------|
| Repository   | Project folder tracked by Git                |
| Commit       | Snapshot of changes                          |
| Branch       | Independent line of development              |
| Merge        | Combine two branches                         |
| Fork         | Copy of a repo under a different user        |
| Clone        | Download a remote repo locally               |
| Push         | Upload commits to remote                     |
| Pull         | Download and merge remote changes            |
| Staging Area | Pre-commit space to collect changes          |
| .gitignore   | Tells Git which files to exclude             |

---

Understanding these terms is crucial for navigating Git comfortably and confidently, whether you're solo coding or collaborating in a team.

