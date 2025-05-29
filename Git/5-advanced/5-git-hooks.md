# Git Hooks

Git hooks are scripts that run automatically at certain points in the Git workflow to automate tasks or enforce policies.

---

## 🛠️ Types of Git Hooks

Hooks live in the `.git/hooks/` directory of a repository. There are two main types:

- **Client-side hooks**: run on local operations like commit, push, merge.
- **Server-side hooks**: run on the server for actions like receiving pushes.

---

## 🔥 Common Client-Side Hooks

| Hook Name            | When It Runs                      | Purpose                         |
|----------------------|----------------------------------|---------------------------------|
| `pre-commit`         | Before a commit is made           | Validate code, run linters       |
| `prepare-commit-msg` | Before commit message editor opens| Modify commit message template   |
| `commit-msg`         | After commit message is entered   | Validate commit message format   |
| `post-commit`        | After a commit is made            | Notifications, logging           |

---

## 🔧 Common Server-Side Hooks

| Hook Name          | When It Runs                       | Purpose                        |
|--------------------|----------------------------------|--------------------------------|
| `pre-receive`      | Before push is accepted           | Enforce policies (e.g. no force push)|
| `update`           | Once per branch update during push| Validate branch-specific rules  |
| `post-receive`     | After push is accepted            | Trigger CI/CD pipelines          |

---

## ⚙️ How to Use Hooks

1. Navigate to `.git/hooks/`
2. Create or edit a hook script (no file extension, executable)
3. Write shell script or any executable code

Example: `.git/hooks/pre-commit`

```bash
#!/bin/sh
# Run tests before committing
npm test
if [ $? -ne 0 ]; then
  echo "Tests failed, aborting commit."
  exit 1
fi
```

4. Make the script executable:

```bash
chmod +x .git/hooks/pre-commit
```

---

## 📝 Using Tools for Hooks

- Use `husky` (for Node.js projects) to manage Git hooks easily.
- Other tools: `pre-commit` framework (Python), custom scripts.

---

## Summary

| Hook Type         | Example Hook      | Use Case                          |
|-------------------|-------------------|----------------------------------|
| Client-side       | `pre-commit`      | Run tests/lint before commit      |
| Server-side       | `pre-receive`     | Enforce push rules on server      |

---
