# Trunk-Based Development

**Trunk-Based Development (TBD)** is a streamlined Git workflow where all developers work off a single main branch (often called `main` or `trunk`), aiming for short-lived branches and continuous integration.

---

## 🌳 What Is Trunk-Based Development?

- Developers commit directly to `main` or via **very short-lived** feature branches.
- Continuous Integration (CI) is used to run tests and checks.
- Emphasizes frequent integration to avoid long-lived branches and complex merges.

---

## 🔄 Key Principles

1. **Single Source of Truth**: The `main` branch is always deployable.
2. **Short-Lived Branches**: Feature branches last hours or a day or two—never weeks.
3. **Frequent Commits**: Developers integrate changes multiple times per day.
4. **Feature Toggles**: Use flags to hide incomplete features in production code.
5. **Automated Tests**: CI runs tests after every push to prevent regressions.

---

## ✅ Pros

- Fast feedback
- Fewer merge conflicts
- High collaboration
- Easy to automate deployments

---

## ⚠️ Challenges

- Requires mature CI/CD practices
- Can be risky without feature toggles
- Harder to enforce in large teams without discipline

---

## 🛠️ How to Implement It

- Use `main` as the central branch.
- Developers clone and pull frequently:

```bash
git checkout main
git pull origin main
```

- Make changes on a feature branch (optional but short-lived):

```bash
git checkout -b tiny-fix
# make change
git commit -m "Fix typo"
git checkout main
git pull origin main
git merge tiny-fix
git push origin main
git branch -d tiny-fix
```

- Automate builds/tests using GitHub Actions, Jenkins, etc.

---

## Summary

| Principle               | Description                             |
|-------------------------|-----------------------------------------|
| One main branch         | Everyone works off of `main`            |
| Fast integration        | Changes merged quickly and often        |
| CI/CD                   | Tests and builds run automatically      |
| Feature toggles         | Hide incomplete features in production  |

---
