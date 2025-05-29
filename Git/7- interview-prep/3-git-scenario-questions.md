# Git Scenario Questions

This document contains real-world Git workflow and debugging scenarios to prepare for practical interview questions.

---

## Scenario 1: Accidentally Committed to the Wrong Branch

**Question:** You made a commit on the `main` branch but it should have been on `feature` branch. How do you fix it?

**Answer:**

\```bash
git checkout feature
git cherry-pick <commit-hash>   # Apply the commit to feature branch
git checkout main
git reset --hard HEAD~1          # Remove commit from main branch
\```

---

## Scenario 2: Merge Conflict During Pull

**Question:** You did `git pull` and encountered a merge conflict. What steps do you take?

**Answer:**

1. Identify conflicted files: `git status`  
2. Open conflicted files and resolve conflicts manually.  
3. Stage resolved files: `git add <file>`  
4. Complete merge with commit: `git commit`  
5. Continue your workflow.

---

## Scenario 3: Undo a Commit But Keep Changes

**Question:** You committed changes but want to undo the commit but keep the changes unstaged.

**Answer:**

\```bash
git reset --soft HEAD~1
\```

---

## Scenario 4: Revert a Commit That Has Already Been Pushed

**Question:** You pushed a bad commit. How do you undo it without rewriting history?

**Answer:**

\```bash
git revert <commit-hash>
git push origin main
\```

---

## Scenario 5: Lost Changes in Working Directory

**Question:** You accidentally deleted changes in your working directory before committing. How do you recover?

**Answer:**

- If changes were staged or committed previously, use `git checkout -- <file>` or `git reset --hard`.  
- If not staged or committed, changes may be lost unless you use tools like your editor's undo or file recovery.

---

## Scenario 6: Multiple Commits to One Commit

**Question:** You want to combine several commits into one before merging. How?

**Answer:**

\```bash
git rebase -i HEAD~<number-of-commits>

# In the editor, change 'pick' to 'squash' or 'fixup' for commits to combine.

\```

---

## Scenario 7: Checking Out a Remote Branch Locally

**Question:** How do you check out a remote branch `feature/login` locally?

**Answer:**

\```bash
git fetch origin
git checkout -b feature/login origin/feature/login
\```

---

These scenarios will help you demonstrate your practical Git knowledge in interviews.

---
