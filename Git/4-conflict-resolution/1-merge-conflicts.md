# Merge Conflicts

A **merge conflict** occurs when Git is unable to automatically reconcile differences between two commits.

---

## 🧠 When Do Merge Conflicts Happen?

Conflicts typically occur when:

- Two branches modify the same line in a file.
- A file is deleted in one branch but modified in another.
- Changes are made to a file and it is renamed elsewhere.

---

## 🔥 Example Scenario

You and a teammate both edit `app.js`:

- You edit line 10 in `feature/navbar`.
- Your teammate edits line 10 in `main`.
- You try to merge `main` into your branch → conflict!

---

## 🧪 How to Identify Conflicts

Git will notify you:

```bash
Auto-merging app.js
CONFLICT (content): Merge conflict in app.js
Automatic merge failed; fix conflicts and then commit the result.
```

---

## 🛠️ How to Resolve Conflicts

1. Open the conflicted file(s):

```text
<<<<<<< HEAD
Your changes
=======
Their changes
>>>>>>> main
```

2. Edit the file manually to keep what you want.
3. After resolving:

```bash
git add app.js
git commit -m "Resolve merge conflict in app.js"
```

---

## 🧹 Abort the Merge

If you want to cancel:

```bash
git merge --abort
```

---

## ✅ Best Practices

- Pull frequently to avoid diverging too far from `main`.
- Communicate with your team on overlapping files.
- Keep commits focused and small.
- Use code review tools to catch issues early.

---

## Summary

| Action              | Command                          |
|---------------------|----------------------------------|
| See conflicts       | `git status`                     |
| Resolve & stage     | Edit files + `git add <file>`    |
| Complete merge      | `git commit`                     |
| Abort merge         | `git merge --abort`              |

---
