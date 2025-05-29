# Git Cherry-Pick

`git cherry-pick` allows you to apply a single commit (or a range of commits) from one branch onto another.

---

## 🎯 When to Use Cherry-Pick

- You want to apply a bug fix from one branch to another.
- You need just one or a few specific commits without merging the entire branch.
- You made a commit in the wrong branch and want to bring it to the correct one.

---

## 🧰 Basic Usage

```bash
git cherry-pick <commit-hash>
```

This applies the changes introduced by the given commit onto your current branch.

---

## 📍 Example

### Scenario

- Bug fix commit on `feature/fix-typo`: `c0ffee1`
- You want to apply it to `main`.

### Steps

```bash
git checkout main
git cherry-pick c0ffee1
```

Git creates a new commit on `main` with the same changes.

---

## 📜 Cherry-Pick Multiple Commits

```bash
git cherry-pick A..B  # Applies all commits after A up to and including B
```

Or pick a set of specific commits:

```bash
git cherry-pick c0ffee1 deadbeef baddcafe
```

---

## ⚠️ Resolving Conflicts

If conflicts occur:

1. Resolve them manually.
2. Then:

```bash
git add .
git cherry-pick --continue
```

To cancel:

```bash
git cherry-pick --abort
```

---

## ✅ Best Practices

- Use cherry-pick sparingly—overuse can lead to duplicate commits and messy history.
- Consider merging or rebasing if many commits are involved.
- Always test the result after cherry-picking, especially across divergent branches.

---

## Summary

| Command                        | Description                           |
|--------------------------------|---------------------------------------|
| `git cherry-pick <hash>`       | Apply a single commit                 |
| `git cherry-pick A..B`         | Apply a range of commits              |
| `git cherry-pick --continue`   | Continue after resolving conflicts    |
| `git cherry-pick --abort`      | Abort the cherry-pick                 |

---
