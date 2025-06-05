# Decorator Pattern

## Intent

Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

---

## Motivation

Sometimes you want to add behavior to individual objects, not entire classes. Subclassing can lead to an explosion of classes and is static. Decorators solve this by wrapping objects.

---

## Structure

- **Component:** Interface or abstract class defining operations.
- **ConcreteComponent:** The original object to be decorated.
- **Decorator:** Abstract class implementing Component and containing a reference to a Component object.
- **ConcreteDecorator:** Adds responsibilities to the component.

---

## Example

### Component Interface

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

### Concrete Component

```java
public class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple coffee";
    }
    public double getCost() {
        return 5.0;
    }
}
```

### Decorator Abstract Class

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
```

### Concrete Decorators

```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", milk";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 1.5;
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", sugar";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}
```

### Client Code

```java
Coffee coffee = new SimpleCoffee();
System.out.println(coffee.getDescription() + " $" + coffee.getCost());

coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);

System.out.println(coffee.getDescription() + " $" + coffee.getCost());
```

Output:
```
Simple coffee $5.0
Simple coffee, milk, sugar $7.0
```

---

## Advantages

- More flexible than static inheritance.
- Responsibilities can be added/removed at runtime.
- Avoids class explosion from subclassing every combination.

---

## Disadvantages

- Can result in many small classes.
- Can be harder to understand wrapped objects at runtime.

---

## Summary

The Decorator pattern allows dynamic addition of behavior to objects by wrapping them, promoting flexibility and cleaner code.
