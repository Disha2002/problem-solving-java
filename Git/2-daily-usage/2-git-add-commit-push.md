# Git Add, Commit, and Push

These three commands form the core workflow of saving and sharing your code changes.

---

## 1. `git add`

Adds changes in your working directory to the **staging area**.

- Prepares files to be committed.
- You can add specific files or all changes.

```bash
git add file.txt            # Add a single file
git add .                   # Add all changes in current directory
```

---

## 2. `git commit`

Records the staged changes as a **snapshot** in the repository.

- Each commit has a message describing the changes.
- Commits are local until pushed.

```bash
git commit -m "Add user login feature"
```

---

## 3. `git push`

Uploads your local commits to the **remote repository** (e.g., GitHub).

```bash
git push origin main
```

- `origin`: Default remote name.
- `main`: Branch name.

---

## Typical Workflow

```bash
git add .
git commit -m "Your descriptive commit message"
git push origin main
```

---

## Additional Tips

- Use clear and concise commit messages.
- Use `git status` to see which files are staged or modified.
- If you forget to stage some files, you can `git add` them and commit again.

---

## Summary

| Command     | Purpose                           |
|-------------|---------------------------------|
| `git add`   | Stage changes for commit         |
| `git commit`| Save changes locally             |
| `git push`  | Send commits to remote repository|

---

## Next Steps

Learn about branching and merging to manage multiple lines of development.

