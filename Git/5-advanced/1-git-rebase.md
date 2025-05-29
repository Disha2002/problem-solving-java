# Git Rebase

`git rebase` is a powerful command that helps you maintain a clean, linear Git history by moving or reapplying commits onto a new base commit.

---

## 🔄 What is Rebasing?

Rebasing changes the base of your branch to a new commit (usually from `main` or `develop`).

### Example

Before rebase:

```
main:    A---B---C
feature:         D---E
```

After rebase:

```
main:    A---B---C---D'---E'
```

---

## 🧰 Basic Rebase Usage

```bash
# Rebase your current branch onto main
git checkout feature
git rebase main
```

This reapplies the feature branch commits (D, E) on top of the current `main`.

---

## 🛑 Resolving Conflicts During Rebase

If a conflict occurs:

1. Git will pause at the conflicting commit.
2. Fix the conflict in the files manually.
3. Add the resolved file:

```bash
git add .
git rebase --continue
```

To abort:

```bash
git rebase --abort
```

---

## 🧪 Interactive Rebase

Interactive rebase lets you squash, edit, or reorder commits.

```bash
git rebase -i HEAD~3
```

Edit the list:

```
pick 123abc First commit
squash 456def Second commit
pick 789ghi Third commit
```

- `pick` = keep as is
- `squash` = combine into previous commit
- `edit` = stop and edit the commit
- `drop` = delete commit

---

## ✅ When to Use Rebase

- Clean up your commit history before opening a PR
- Re-apply your branch onto an updated `main` branch
- Combine multiple small commits into one logical commit

---

## ⚠️ Don't Rebase Shared Branches

Only rebase branches that:

- Have not been pushed yet, or
- Are not being used by others

Rebasing rewrites commit history, which can confuse collaborators.

---

## Summary

| Command                   | Description                          |
|---------------------------|--------------------------------------|
| `git rebase main`         | Rebase current branch onto main      |
| `git rebase -i HEAD~n`    | Interactive rebase last n commits    |
| `git rebase --continue`   | Continue after resolving conflicts   |
| `git rebase --abort`      | Cancel the rebase                    |

---
