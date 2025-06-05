# Strategy Pattern

## Intent

Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

---

## Motivation

When multiple algorithms exist for a specific task, and you want to choose or change the algorithm dynamically at runtime without modifying the client code.

---

## Structure

- **Strategy:** Interface common to all supported algorithms.
- **ConcreteStrategy:** Implements a specific algorithm.
- **Context:** Uses a Strategy object to execute the algorithm.

---

## Example

### Strategy Interface

```java
public interface PaymentStrategy {
    void pay(int amount);
}
```

### Concrete Strategies

```java
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card " + cardNumber);
    }
}

public class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal account " + email);
    }
}
```

### Context

```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}
```

### Client Code

```java
ShoppingCart cart = new ShoppingCart();

cart.setPaymentStrategy(new CreditCardStrategy("1234-5678-9012-3456"));
cart.checkout(100);

cart.setPaymentStrategy(new PayPalStrategy("user@example.com"));
cart.checkout(200);
```

---

## Advantages

- Algorithms can be changed at runtime.
- Avoids conditional statements for selecting behavior.
- Promotes code reuse and separation of concerns.

---

## Disadvantages

- Increases number of classes.
- Clients must be aware of different strategies.

---

## Summary

The Strategy pattern encapsulates interchangeable algorithms and lets clients select them dynamically, improving flexibility and maintainability.
