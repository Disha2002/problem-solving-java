# Git Init and Clone

These are the first two commands you’ll use to start working with Git repositories.

---

## `git init`

Initializes a new Git repository locally.

```bash
git init
```

- Creates a `.git` folder in your project directory.
- Starts tracking changes in that folder.
- Use it when you start a brand-new project from scratch.

### Example:

```bash
mkdir my-project
cd my-project
git init
```

---

## `git clone`

Creates a local copy of an existing remote repository.

```bash
git clone <repository-url>
```

- Downloads the entire project history.
- Automatically sets up the remote named `origin`.

### Example

```bash
git clone https://github.com/user/repo.git
```

---

## Differences Between `init` and `clone`

| Command      | Purpose                               | When to Use                 |
|--------------|-------------------------------------|-----------------------------|
| `git init`   | Create a new empty repo locally      | Starting a new project       |
| `git clone`  | Download a remote repo to local      | Working on an existing project|

---

## Common Flags

- `git clone --depth 1 <repo>`  
  Clones only the latest snapshot (shallow clone) without full history.

---

## Summary

- Use `git init` to start fresh.
- Use `git clone` to work on existing repos.

---

## Next Steps

After initializing or cloning, use `git add`, `git commit`, and `git push` to manage changes.

