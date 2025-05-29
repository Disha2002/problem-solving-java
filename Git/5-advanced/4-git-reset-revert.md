# Git Reset vs Git Revert

Both `git reset` and `git revert` are used to undo changes, but they behave very differently. Use them wisely depending on whether your changes are local or already pushed.

---

## 🔁 Git Reset

`git reset` moves the HEAD and optionally changes the index (staging area) and working directory.

### Types of Reset

```bash
git reset --soft <commit>
```
- Moves HEAD only.
- Keeps changes staged.

```bash
git reset --mixed <commit>
```
- Moves HEAD and un-stages changes.
- Keeps changes in working directory.

```bash
git reset --hard <commit>
```
- Moves HEAD and **removes all changes** in staging and working directory.

### ⚠️ Use with Caution
- `--hard` is destructive: you lose local changes.
- Never reset public branches unless you're sure.

---

## 🔄 Git Revert

`git revert` creates a new commit that reverses the effect of a previous commit.

### Syntax

```bash
git revert <commit>
```

### Example

```bash
git revert a1b2c3d
```

This does NOT delete the commit; it adds a new one that undoes its changes. Safe for public/shared history.

---

## 🤔 Reset vs Revert: Comparison

| Feature            | `git reset`                          | `git revert`                       |
|--------------------|--------------------------------------|------------------------------------|
| Modifies history   | ✅ (changes commit history)          | ❌ (preserves history)             |
| Safe for remote    | ❌ (only local/private branches)     | ✅ (safe for public branches)      |
| Destructive        | Can be (`--hard`)                    | No                                |
| Undo last commit   | Yes (with `--soft`, `--mixed`)       | Yes                                |

---

## 🧪 Undo Last Commit Examples

### Undo but keep changes staged:
```bash
git reset --soft HEAD~1
```

### Undo and unstage:
```bash
git reset --mixed HEAD~1
```

### Completely discard last commit:
```bash
git reset --hard HEAD~1
```

### Undo by creating a new commit:
```bash
git revert HEAD
```

---

## Summary

| Command                      | Use Case                                     |
|------------------------------|----------------------------------------------|
| `git reset --soft`           | Undo commit, keep staged                     |
| `git reset --mixed`          | Undo commit, keep working directory          |
| `git reset --hard`           | Wipe out changes (dangerous!)                |
| `git revert <commit>`        | Safely undo a commit by making a new one     |

---