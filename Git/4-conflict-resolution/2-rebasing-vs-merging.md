# Rebasing vs Merging

Both **rebasing** and **merging** are used to integrate changes from one branch into another, but they work differently and have distinct use cases.

---

## 🔀 Git Merge

Combines histories and creates a **new merge commit**.

```bash
git checkout feature
git merge main
```

- Keeps all history
- Results in a non-linear commit history
- Useful for collaborative, multi-developer workflows

---

## 📐 Git Rebase

Moves or re-applies commits from one branch onto another to create a **linear history**.

```bash
git checkout feature
git rebase main
```

- Rewrites commit history
- No merge commits
- Useful for cleaner history, especially before merging to `main`

---

## 🧪 Example

**Merge:**

```
A---B---C (main)
     \
      D---E (feature)
           \
            F (merge commit)
```

**Rebase:**

```
A---B---C---D'---E' (feature rebased onto main)
```

---

## ⚠️ Caution with Rebase

- Never rebase public/shared branches.
- Only rebase local work that hasn’t been pushed/shared yet.
- Rewriting history of shared branches can confuse collaborators.

---

## ✅ When to Use What?

| Use Case                        | Use Merge       | Use Rebase       |
|---------------------------------|------------------|------------------|
| Preserve full history           | ✅               | ❌               |
| Clean linear history            | ❌               | ✅               |
| Feature integration in teams    | ✅               | ❌ (unless local)|
| Solo cleanup before PR          | ❌               | ✅               |

---

## Summary

| Command        | Behavior                            |
|----------------|--------------------------------------|
| `git merge`    | Preserves history, creates merge commit |
| `git rebase`   | Linearizes history, rewrites commits     |

---
