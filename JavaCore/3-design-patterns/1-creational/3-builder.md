# Builder Pattern

## Intent

Separate the construction of a complex object from its representation, allowing the same construction process to create different representations.

---

## Motivation

When an object has many optional parameters or requires step-by-step construction, a builder helps create instances more clearly and flexibly than constructors with many parameters.

---

## Structure

- **Builder:** Specifies an abstract interface for creating parts of a Product object.
- **ConcreteBuilder:** Constructs and assembles parts of the product.
- **Director:** Constructs an object using the Builder interface.
- **Product:** The complex object under construction.

---

## Example

### Product Class

```java
public class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public void setDough(String dough) { this.dough = dough; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setTopping(String topping) { this.topping = topping; }

    @Override
    public String toString() {
        return "Pizza with " + dough + ", " + sauce + ", " + topping;
    }
}
```

### Builder Interface

```java
public interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}
```

### Concrete Builder

```java
public class MargheritaPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public MargheritaPizzaBuilder() {
        pizza = new Pizza();
    }

    public void buildDough() {
        pizza.setDough("thin crust");
    }

    public void buildSauce() {
        pizza.setSauce("tomato");
    }

    public void buildTopping() {
        pizza.setTopping("mozzarella cheese");
    }

    public Pizza getPizza() {
        return pizza;
    }
}
```

### Director

```java
public class Cook {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
```

### Client Code

```java
Cook cook = new Cook();
PizzaBuilder margheritaBuilder = new MargheritaPizzaBuilder();

cook.setPizzaBuilder(margheritaBuilder);
cook.constructPizza();

Pizza pizza = cook.getPizza();
System.out.println(pizza);
```

---

## Advantages

- Allows step-by-step construction.
- Isolates complex construction code.
- Can create different representations using the same building process.
- Improves code readability with fluent builders (optional).

---

## Disadvantages

- Can be overkill for simple objects.
- Adds more classes to the project.

---

## Summary

The Builder pattern helps construct complex objects with many parts or options, keeping construction code separate from the object representation.
