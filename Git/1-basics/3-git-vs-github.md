# Git vs GitHub

Many people use the terms **Git** and **GitHub** interchangeably, but they are **not the same**. Here’s a clear breakdown of what each is and how they relate to each other.

---

## 🔧 What is Git?

- Git is a **distributed version control system (VCS)**.
- It lets developers **track changes**, **revert to previous versions**, and **collaborate** through branching and merging.
- Git runs **locally on your machine**.
- You interact with Git using **command-line tools** (like `git init`, `git commit`, etc.).

### ✅ Key Features of Git:
- Local version tracking
- Branching and merging
- Commit history
- Fast and lightweight
- Works offline

---

## ☁️ What is GitHub?

- GitHub is a **cloud-based hosting platform** for Git repositories.
- It allows developers to **store their Git-tracked projects online**, **collaborate**, and **manage pull requests, issues, and wikis**.
- GitHub provides a **web-based interface** and integrates with tools like CI/CD, code review, etc.

### ✅ Key Features of GitHub:
- Remote repository hosting
- Collaboration tools (pull requests, issues)
- Access control and permissions
- Actions (CI/CD pipelines)
- Web UI, insights, activity logs

---

## ⚖️ Git vs GitHub: Key Differences

| Feature              | Git                             | GitHub                                 |
|----------------------|----------------------------------|-----------------------------------------|
| Type                 | Version Control System (tool)   | Web-based Git Repository Hosting       |
| Installation         | Installed on local machine      | Web service, no install needed         |
| Works Offline?       | Yes                              | No (requires internet)                 |
| Collaboration        | Manual with shared repos        | Easy with forks, pull requests         |
| Web Interface        | No                               | Yes                                    |
| Popular Commands     | `git init`, `git commit`, etc.  | `git push origin`, `pull request`, etc.|

---

## 🔄 How They Work Together

1. You **use Git** to track and manage changes in your project **locally**.
2. You **push your code to GitHub** to back it up or collaborate with others.
3. Others can **clone your GitHub repo**, make changes, and **create pull requests** to suggest updates.

> ✅ Git is the tool. GitHub is the platform built around the tool.

---

## 💡 Examples

### Example 1: Using Git Locally

```bash
git init
git add .
git commit -m "Initial commit"
```

### Example 2: Pushing to GitHub

```bash
git remote add origin https://github.com/username/repo.git
git push -u origin main
```

---

## ✅ Summary

| Git                      | GitHub                                |
|--------------------------|----------------------------------------|
| Local tool for version control | Remote platform for sharing Git projects |
| Does not require internet | Requires internet                    |
| CLI-based tool           | Web-based service                    |
| Manages code history     | Manages remote collaboration         |

> Learn Git to control your code, use GitHub to collaborate with the world.

