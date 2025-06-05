# Proxy Pattern

## Intent

Provide a surrogate or placeholder for another object to control access to it.

---

## Motivation

Use a proxy when you want to:

- Control access to the real object (e.g., lazy initialization, access control).
- Add additional functionality before/after method calls.
- Manage expensive resources.

---

## Structure

- **Subject:** Interface common to RealSubject and Proxy.
- **RealSubject:** The real object being controlled.
- **Proxy:** Controls access to the RealSubject and implements the same interface.

---

## Example

### Subject Interface

```java
public interface Image {
    void display();
}
```

### RealSubject

```java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
```

### Proxy

```java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy loading
        }
        realImage.display();
    }
}
```

### Client Code

```java
public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");

        // Image will be loaded from disk only on first display call
        image.display(); // Loading photo.jpg \n Displaying photo.jpg
        image.display(); // Displaying photo.jpg (no loading)
    }
}
```

---

## Types of Proxies

- **Virtual Proxy:** Controls expensive object creation (lazy loading).
- **Protection Proxy:** Controls access rights.
- **Remote Proxy:** Represents a remote object locally.
- **Caching Proxy:** Caches results of expensive operations.
- **Logging Proxy:** Logs requests to the real object.

---

## Advantages

- Controls access and adds functionality transparently.
- Can improve performance by delaying expensive operations.
- Can add security checks without changing the real object.

---

## Disadvantages

- Can add complexity and overhead.
- Debugging can be harder due to indirection.

---

## Summary

The Proxy pattern provides a placeholder to control access to an object, enabling additional behavior such as lazy loading, access control, or logging.
