# Gitflow Workflow

**Gitflow** is a popular branching model that defines a strict branching strategy designed for managing large projects with regular releases.

---

## 🧱 Key Branches

| Branch        | Purpose                              |
|---------------|--------------------------------------|
| `main`        | Contains production-ready code       |
| `develop`     | Integration branch for features      |
| `feature/*`   | Individual features under development|
| `release/*`   | Pre-release preparation              |
| `hotfix/*`    | Emergency fixes for production bugs  |

---

## 🔁 Gitflow Workflow Steps

### 1. Start a New Feature

```bash
git checkout develop
git checkout -b feature/awesome-feature
```

Do your work, then:

```bash
git commit -m "Add awesome feature"
git checkout develop
git merge feature/awesome-feature
git branch -d feature/awesome-feature
```

---

### 2. Start a Release

```bash
git checkout develop
git checkout -b release/1.2.0
```

- Final testing, docs, version bumps, etc.
- Then:

```bash
git checkout main
git merge release/1.2.0
git tag -a v1.2.0 -m "Release 1.2.0"
git checkout develop
git merge release/1.2.0
git branch -d release/1.2.0
```

---

### 3. Start a Hotfix

```bash
git checkout main
git checkout -b hotfix/urgent-fix
```

Fix the issue, then:

```bash
git commit -m "Fix: urgent production bug"
git checkout main
git merge hotfix/urgent-fix
git tag -a v1.2.1 -m "Hotfix 1.2.1"
git checkout develop
git merge hotfix/urgent-fix
git branch -d hotfix/urgent-fix
```

---

## ✅ Pros

- Structured and consistent process
- Clear role for each branch
- Great for managing multiple versions and releases

---

## ⚠️ Cons

- Overhead for smaller teams
- Complicated merge strategy
- Works best with automation and CI/CD

---

## Summary

| Branch Type     | Naming Example           | Purpose                        |
|------------------|--------------------------|--------------------------------|
| Main             | `main`                  | Production-ready code          |
| Develop          | `develop`               | Integration of all features    |
| Feature          | `feature/login-form`    | New functionality              |
| Release          | `release/1.2.0`         | Prepare for release            |
| Hotfix           | `hotfix/crash-fix`      | Urgent fixes for production    |

---