# Singleton Pattern

## Intent

Ensure a class has only **one instance** and provide a global point of access to it.

---

## Motivation

Some classes require exactly one object to coordinate actions across the system — e.g., configuration managers, logging services, or thread pools.

---

## Implementation

### Eager Initialization

Instance is created at class loading time.

```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### Lazy Initialization (Not Thread-safe)

Instance created on first request.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Thread-safe Lazy Initialization (Using synchronized)

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Double-Checked Locking (Efficient Thread-safe)

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### Initialization-on-demand Holder Idiom (Recommended)

```java
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

---

## Advantages

- Controlled access to sole instance.
- Reduces namespace pollution.
- Permits refinement of operations and representation.
- Allows a variable number of instances (by modifying code).
- More flexible than static classes.

---

## Disadvantages

- Difficult to unit test due to global state.
- Can introduce hidden dependencies.
- Can be broken by reflection or serialization if not handled carefully.

---

## Usage Example

```java
Singleton logger = Singleton.getInstance();
logger.log("Start application");
```

---

## Summary

The Singleton pattern ensures that only one instance of a class exists and provides a global access point to it, making it useful for shared resources or configurations.
