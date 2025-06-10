# 📱 Compose MVI Shop

This project is an Android application developed with **Jetpack Compose** and the **MVI (Model-View-Intent)** architecture. It simulates a footwear store, displaying a list of products, allowing screen navigation, and showing detailed product information.

---

## ✨ Features

- Display products in a grid with `LazyVerticalGrid`
- Product detail screen with image, name, and price
- Navigation with `NavController` using argument-based routes
- Category tab navigation with `ScrollableTabRow`
- Bottom navigation bar with routes to Home, Cart, and Profile
- Custom theme with **Lexend** font applied globally

---

## 🧱 Architecture

The project follows the **MVI (Model-View-Intent)** pattern, with a clear separation of concerns:

```
app/
├── data/             # Mocked data (or remote/local data source)
├── di/               # Dependency injection (Koin)
├── intent/           # User intents and UI events
├── navigation/       # Route definitions and NavHost
├── repository/       # Repository interface (data abstraction)
├── ui/               # Composables and screens
├── viewmodel/        # ViewModel with state flow management
├── constants/        # Reusable fixed texts and values
```

---

## 📦 Main Dependencies

- **Jetpack Compose** (declarative UI)
- **Koin** (dependency injection)
- **Navigation Compose** (screen navigation)
- **StateFlow / MVI** (state management)
- **Material3** (modern design system)
- **Google Fonts (Lexend)** via local `.ttf` files

---

## 🎨 Theme and Typography

The default theme is customized to use the **Lexend** font, applied globally via `Typography`.

Font example setup:

```kotlin
val Lexend = FontFamily(
    Font(R.font.lexend_regular, FontWeight.Normal),
    Font(R.font.lexend_medium, FontWeight.Medium),
    Font(R.font.lexend_bold, FontWeight.Bold)
)
```

Applied in the `MaterialTheme`:

```kotlin
MaterialTheme(
    colorScheme = LightColorScheme,
    typography = Typography, // Lexend as default
    content = content
)
```

---

## 🚀 Navigation

- `home`: main screen with products and categories
- `productDetail/{name}/{price}/{imageRes}`: product detail screen
- `cart`: cart screen
- `profile`: user profile screen

Navigation example:

```kotlin
navController.navigate("productDetail/$name/$price/$imageRes")
```

---

## 📂 Screen Structure

- `ProductScreen`: displays product grid
- `ProductDetailScreen`: shows selected product details
- `CategoryScreen`: shows filtered category content or empty state
- `HomeScreen`: integrates `SearchBar`, `CategoryTabs`, and main content

---

## 📌 Notes

- `BottomNavigationBar` is only visible on main screens (`home`, `cart`, `profile`).
- The bottom bar is **automatically hidden** on the `ProductDetailScreen` based on the route.
- Product data is currently mocked, but the code is ready for future API or local database integration.

---

## ✅ Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/teodoront/AvaliacaoComposeMVI.git
   ```

2. Open in **Android Studio Hedgehog or newer**

3. Ensure your environment includes:

   - Kotlin `1.9+`
   - Compose `1.6+`
   - Gradle `8+`

4. Run the app

