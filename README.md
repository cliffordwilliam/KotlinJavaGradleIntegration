# KotlinJavaGradleIntegration

This project uses **Gradle** with both **Java** and **Kotlin** sources.  
Use this guide to build and run it on Arch Linux from scratch.

---

## 🛠️ Setup Instructions (for Arch Linux)

### 1. Install OpenJDK (version 17)
Gradle 8.13 has known issues with JDK 24+. Stick with JDK 17 (LTS):

```bash
sudo pacman -S jdk-openjdk
````

Then install Gradle (choose option 2 when prompted for Java environment):

```bash
sudo pacman -S gradle
```

When asked:

```
:: There are 4 providers available for java-environment<=21:
1) jdk11-openjdk  2) jdk17-openjdk  3) jdk21-openjdk  4) jdk8-openjdk
```

📌 **Pick `2` for `jdk17-openjdk`**

Set it as the default:

```bash
sudo archlinux-java set java-17-openjdk
```

Confirm with:

```bash
archlinux-java status
```

---

## 🧱 Build the Project

Make sure the Gradle wrapper is executable:

```bash
chmod +x gradlew
```

Then build the project:

```bash
./gradlew build
```

---

## 🚀 Run the App

If the `application` plugin is configured correctly in `build.gradle(.kts)`:

```bash
./gradlew run
```

---

## 🧪 Extra Tips

* View all available Gradle tasks:

  ```bash
  ./gradlew tasks
  ```

* If build fails due to JDK incompatibilities, make sure you're not using JDK 24+.

* JAR output will be in:

  ```
  build/libs/
  ```

You can run it manually with:

```bash
java -cp build/libs/yourproject.jar your.package.MainKt
```

---

## 📦 Project Dependencies

* Kotlin
* Java
* Gradle Wrapper (`gradlew`)
* JDK 17

---

## ✅ Confirmed Working On

* Arch Linux (manual setup)
* JDK 17
* Gradle 8.13 (via wrapper)
