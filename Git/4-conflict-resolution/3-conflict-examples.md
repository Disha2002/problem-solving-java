# Merge Conflict Examples

Below are some real-world examples of merge conflicts and how to resolve them.

---

## 🧪 Example 1: Same Line Conflict

### Scenario

You and a teammate both edit the same line in `greeting.txt`.

- Your branch (`feature/hello`):

```txt
Hello, world!
```

- Teammate’s branch (`main`):

```txt
Hi, world!
```

### Conflict Markers

When you merge:

```text
<<<<<<< HEAD
Hello, world!
=======
Hi, world!
>>>>>>> main
```

### Resolution

Manually edit to resolve:

```txt
Hello and Hi, world!
```

Then:

```bash
git add greeting.txt
git commit -m "Resolve conflict in greeting.txt"
```

---

## ⚔️ Example 2: File Deleted in One Branch

- In `feature/remove-file`: `notes.txt` is deleted.
- In `main`: `notes.txt` is edited.

### Conflict

When merging, Git throws:

```text
CONFLICT (modify/delete): notes.txt deleted in feature/remove-file and modified in main.
```

### Resolution Options

- Keep the file: restore and apply changes.
- Accept deletion: remove the file and commit.

```bash
# To accept deletion
git rm notes.txt
git commit -m "Resolve conflict: delete notes.txt"
```

---

## 🔁 Example 3: Directory/File Name Conflict

- `main` has a file named `logs`
- `feature/archive` has a directory named `logs/`

Merge will fail due to file vs directory conflict.

### Resolution

- Rename either the file or directory in one branch.
- Commit the change.
- Retry the merge.

---

## 💡 Tips for Conflict Resolution

- Use GUI tools: VS Code, GitHub Desktop, Sourcetree
- Use `git status` to see unmerged files
- Use `git log --merge` to inspect conflicting commits
- Use `git diff` or `git diff --base` to see what changed

---

## Summary

| Conflict Type           | Cause                                 | Resolution                           |
|-------------------------|----------------------------------------|--------------------------------------|
| Same line edits         | Edits to same lines in both branches   | Manually merge the lines             |
| Modify/delete           | File changed in one, deleted in other  | Choose to keep or delete             |
| File vs directory       | Name collision                         | Rename one side                      |

---
