# Installing Git

Git can be installed on all major operating systems: Windows, macOS, and Linux. Follow the instructions below based on your platform.

---

## 🪟 Windows

### ✅ Option 1: Install via Git for Windows

1. Visit: [https://git-scm.com/download/win](https://git-scm.com/download/win)
2. The download will start automatically.
3. Run the installer and follow the steps:
   - Choose default options unless you have specific needs.
   - On "Choosing the default editor used by Git," you can pick VS Code or your favorite editor.
   - On "Adjusting your PATH environment," select **"Git from the command line and also from 3rd-party software"**.

4. After installation, open **Git Bash** or **Command Prompt** and verify:

   ```bash
   git --version
   ```

---

## 🍎 macOS

### ✅ Option 1: Using Homebrew (Recommended)

1. If you have Homebrew installed:

   ```bash
   brew install git
   ```

2. After installation, check the Git version:

   ```bash
   git --version
   ```

3. You can confirm the install path (should show `/opt/homebrew/bin/git` or similar on Apple Silicon):

   ```bash
   which git
   ```

### ✅ Option 2: Using the Git Installer

1. Visit: [https://git-scm.com/download/mac](https://git-scm.com/download/mac)
2. Download and run the installer.

### ✅ Option 3: Install Xcode Command Line Tools

1. Run:

   ```bash
   xcode-select --install
   ```

2. This installs Git along with other development tools.

3. Check version:

   ```bash
   git --version
   ```

---

## 🐧 Linux

### ✅ Debian/Ubuntu

```bash
sudo apt update
sudo apt install git
```

### ✅ Fedora

```bash
sudo dnf install git
```

### ✅ Arch

```bash
sudo pacman -S git
```

---

## 🔧 Verify Installation

Run the following command in your terminal:

```bash
git --version
```

You should see output like:

```
git version 2.x.x
```

To see where Git was installed from (e.g. Homebrew or system default):

```bash
which git
```

---

## 👤 Optional: Configure Git After Install

Set your global username and email (used for commits):

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

View your configuration:

```bash
git config --list
```

---