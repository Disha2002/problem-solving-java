# Markdown Syntax Guide

Markdown is a lightweight markup language used to format text. It’s widely used for README files, documentation, comments, and more.

---

## Headers

Use `#` to create headers. The number of `#` signs indicates the level.

\```markdown

# H1 (largest)

## H2

### H3

#### H4

##### H5

###### H6 (smallest)

\```

---

## Emphasis

- *Italic* text: wrap text in single asterisks or underscores  
  `*italic*` or `_italic_`
- **Bold** text: wrap text in double asterisks or underscores  
  `**bold**` or `__bold__`
- ***Bold and italic***: combine them  
  `***bold and italic***`

---

## Lists

- **Unordered lists**: use `-`, `*`, or `+`

\```markdown

- Item 1
- Item 2
  - Subitem 2a
  - Subitem 2b
\```

- **Ordered lists**: use numbers followed by a dot

\```markdown

1. First
2. Second
3. Third
\```

---

## Links and Images

- Links: `[link text](URL)`  
  Example: `[OpenAI](https://openai.com)`
- Images: `![alt text](image URL)`  
  Example: `![Logo](https://example.com/logo.png)`

---

## Code

- Inline code: wrap with single backticks  
  Example: ``Use the `git status` command.``
- Code blocks: wrap with triple backticks  
  Specify language for syntax highlighting (optional):

\```python
def hello():
    print("Hello, world!")
\```

---

## Blockquotes

Use `>` to create blockquotes:

\```markdown
> This is a quote.
> It can span multiple lines.
\```

---

## Horizontal Rule

Create a horizontal line with three or more dashes, asterisks, or underscores:

\```markdown

---
***
___
\```

---

## Tables

Create tables using pipes `|` and dashes `-`:

\```markdown

| Name    | Age | City      |
|---------|-----|-----------|
| Alice   |  30 | New York  |
| Bob     |  25 | San Francisco |

\```

---

## Escaping Characters

Use a backslash `\` before a character to escape it if you want it to be treated literally, like `\*` or `\#`.

---

Markdown is simple yet powerful for writing formatted text quickly and clearly.

---
