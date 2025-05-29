# Git Pull and Fetch

Both commands are used to update your local repository from a remote repository, but they behave differently.

---

## 1. `git fetch`

Downloads commits, files, and refs from a remote repository into your local repo—but **does not merge** them into your current branch.

```bash
git fetch origin
```

- Fetch updates remote-tracking branches (e.g., `origin/main`).
- Useful to see what changes are available without altering your working directory.

---

## 2. `git pull`

Downloads and **automatically merges** changes from the remote branch into your current local branch.

```bash
git pull origin main
```

- Equivalent to `git fetch` followed by `git merge`.
- May lead to merge conflicts if changes clash.

---

## When to Use Which?

| Command     | Use Case                                         |
|-------------|-------------------------------------------------|
| `git fetch` | When you want to review changes before merging. |
| `git pull`  | When you want to quickly update your branch.    |

---

## Example Workflow

```bash
# Fetch updates without merging
git fetch origin

# View remote changes
git log HEAD..origin/main

# Merge when ready
git merge origin/main
```

Or simply:

```bash
# Fetch and merge in one step
git pull origin main
```

---

## Handling Conflicts

- `git pull` can result in conflicts that need manual resolution.
- After resolving conflicts, commit the merge.

---

## Summary

| Command    | What it Does                         |
|------------|-------------------------------------|
| `git fetch`| Downloads changes but does NOT merge|
| `git pull` | Downloads and merges changes         |

---
