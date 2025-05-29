# Writing Good Commits

Writing good commits means creating clear, meaningful, and focused changes that help maintain a clean and understandable project history.

---

## Characteristics of a Good Commit

- **Atomic:** Each commit should represent a single logical change or fix.
- **Self-contained:** It should not depend on other uncommitted changes.
- **Clear message:** The commit message should explain *what* was changed and *why*.
- **Tested:** The code in the commit should work and not break the build.
- **Consistent style:** Follow the project’s commit message guidelines.

---

## Why It Matters

- Easier to review and understand changes
- Simplifies debugging and rollback
- Helps track features and fixes effectively
- Improves collaboration with teammates

---

## Best Practices

1. **Make small commits**  
   Break large changes into smaller chunks that are easier to review and understand.

2. **Write meaningful commit messages**  
   Use the commit message style guide to write clear and descriptive messages.

3. **Test before committing**  
   Ensure your changes work and do not introduce bugs.

4. **Avoid mixing unrelated changes**  
   Don’t combine formatting fixes with functional changes in the same commit.

5. **Use branches for features or fixes**  
   Keep your main branch clean and integrate work through focused branches.

---

## Example of a Good Commit Workflow

\```bash
git checkout -b feature/add-user-auth

# make code changes

git add .
git commit -m "feat(auth): add user authentication with JWT"
git push origin feature/add-user-auth
\```

---

## Summary

Good commits make your project history a useful resource rather than a confusing mess. They enhance communication, reduce bugs, and make collaboration smoother.

---
