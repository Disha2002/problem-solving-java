# Command Pattern

## Intent

Encapsulate a request as an object, thereby letting you parameterize clients with queues, requests, and operations; and support undoable operations.

---

## Motivation

Separates the object that invokes the operation from the one that knows how to perform it, allowing for decoupling, queuing, logging, and undo functionality.

---

## Structure

- **Command:** Declares an interface for executing operations.
- **ConcreteCommand:** Implements the Command interface, binding a receiver and an action.
- **Receiver:** Knows how to perform the operations associated with carrying out a request.
- **Invoker:** Asks the command to carry out the request.
- **Client:** Creates ConcreteCommand objects and sets their receivers.

---

## Example

### Command Interface

```java
public interface Command {
    void execute();
}
```

### Receiver

```java
public class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
```

### Concrete Commands

```java
public class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

public class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}
```

### Invoker

```java
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### Client Code

```java
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command switchOn = new TurnOnCommand(light);
        Command switchOff = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(switchOn);
        remote.pressButton();  // Output: Light is ON

        remote.setCommand(switchOff);
        remote.pressButton();  // Output: Light is OFF
    }
}
```

---

## Advantages

- Decouples sender and receiver.
- Supports undo/redo operations.
- Supports queuing and logging commands.
- Easy to add new commands without changing existing code.

---

## Disadvantages

- Can result in many command classes.
- Might increase complexity for simple tasks.

---

## Summary

The Command pattern encapsulates requests as objects, allowing flexible command management, decoupling, and support for undoable operations.
