# Adapter Pattern

## Intent

Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

---

## Motivation

When you want to use an existing class but its interface does not match what you need, the Adapter acts as a bridge to translate between interfaces.

---

## Structure

- **Target:** The interface expected by the client.
- **Adaptee:** The existing class with a different interface.
- **Adapter:** Implements the Target interface and wraps an Adaptee object, translating calls from Target to Adaptee.

---

## Example

### Target Interface

```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

### Adaptee (Incompatible interface)

```java
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
```

### Adapter

```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

### Client Using Adapter

```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

---

## Advantages

- Reuse existing functionality without modifying code.
- Provides flexibility by working with unrelated interfaces.
- Helps integrate legacy or third-party code.

---

## Disadvantages

- Can add complexity by introducing extra layers.
- Might require knowledge of both interfaces.

---

## Summary

The Adapter pattern acts as a bridge to allow incompatible interfaces to work together by translating requests from the client to the adaptee.
