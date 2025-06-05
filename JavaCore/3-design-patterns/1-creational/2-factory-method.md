# Factory Method Pattern

## Intent

Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

---

## Motivation

When a class can’t anticipate the type of objects it needs to create, or wants to delegate the responsibility of instantiation, the Factory Method provides a way to encapsulate object creation.

---

## Structure

- **Product:** Interface or abstract class defining the objects the factory method creates.
- **ConcreteProduct:** Concrete implementations of the Product.
- **Creator:** Declares the factory method, may define a default implementation.
- **ConcreteCreator:** Overrides the factory method to instantiate ConcreteProducts.

---

## Example

### Product Interface

```java
public interface Button {
    void render();
    void onClick();
}
```

### Concrete Products

```java
public class WindowsButton implements Button {
    public void render() {
        System.out.println("Render Windows button");
    }
    public void onClick() {
        System.out.println("Windows button clicked");
    }
}

public class HTMLButton implements Button {
    public void render() {
        System.out.println("Render HTML button");
    }
    public void onClick() {
        System.out.println("HTML button clicked");
    }
}
```

### Creator

```java
public abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
        okButton.onClick();
    }

    // Factory method
    protected abstract Button createButton();
}
```

### Concrete Creators

```java
public class WindowsDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}

public class WebDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new HTMLButton();
    }
}
```

### Client Code

```java
Dialog dialog;

if (System.getProperty("os.name").equals("Windows")) {
    dialog = new WindowsDialog();
} else {
    dialog = new WebDialog();
}

dialog.renderWindow();
```

---

## Advantages

- Supports open/closed principle by allowing new products without changing existing code.
- Encapsulates object creation.
- Allows subclasses to decide what to instantiate.

---

## Disadvantages

- Can introduce a lot of subclasses.
- Complexity increases with number of products.

---

## Summary

The Factory Method pattern provides a way to delegate object creation to subclasses, promoting flexibility and loose coupling between creator and concrete products.
