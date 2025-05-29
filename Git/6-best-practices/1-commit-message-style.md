# Commit Message Style Guide

Writing clear, concise, and consistent commit messages is essential for maintaining a readable project history. Good commit messages help team members understand what changes were made and why, making collaboration and debugging easier.

---

## Why Good Commit Messages Matter

- **Clarity:** Help others (and your future self) understand the purpose of a change.
- **History:** Provide context for why code evolved in a certain way.
- **Debugging:** Easier to track down when and why bugs were introduced.
- **Automation:** Tools like changelogs and release notes often rely on commit messages.

---

## Structure of a Good Commit Message

A typical commit message has three parts:

\```
<type>(<scope>): <subject>

<body>

<footer>
\```

### 1. Subject line (header)

- Brief summary of the change (50 characters or less)
- Capitalize the first letter
- Use the imperative mood (e.g., "Fix bug", "Add feature")
- Do **not** end with a period
- Optionally include a scope in parentheses to specify the part of the code affected, e.g., `feat(parser):`, `fix(login):`

### 2. Body (optional)

- Explain **what** and **why** vs. **how**
- Use complete sentences and wrap lines at 72 characters
- Provide context, reasoning, or links to related issues/tickets
- Separate paragraphs with a blank line

### 3. Footer (optional)

- Reference issues or breaking changes, e.g., `Closes #123`, `BREAKING CHANGE:`

---

## Common Commit Types

Use conventional prefixes to categorize commits:

| Type     | Description                             |
|----------|-------------------------------------|
| feat     | A new feature                        |
| fix      | A bug fix                           |
| docs     | Documentation only changes          |
| style    | Code style changes (formatting, no logic) |
| refactor | Code changes that neither fix a bug nor add a feature |
| perf     | Performance improvements            |
| test     | Adding or fixing tests              |
| chore    | Changes to build process or tools  |

---

## Examples

\```
feat(auth): add OAuth2 login support

Added support for OAuth2 login via Google and Facebook.
This allows users to authenticate using their existing accounts.

Closes #45
\```

\```
fix(api): handle null pointer exception on GET /users

Prevented server crash when the user data is null by adding a check
before accessing properties.

BREAKING CHANGE: API now returns 404 instead of 500 when user not found.
\```

---

## Tips

- Write messages **before** coding the change when possible.
- Avoid vague messages like "fix" or "update".
- Keep each commit focused on a single logical change.
- Use tools like `git commit --verbose` to help write messages.
- Review your commit messages before pushing.

---

By following a consistent commit message style, you make your Git history a valuable source of knowledge for your team and yourself.

---
