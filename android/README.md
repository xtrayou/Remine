# REMINE - Aplikasi Android E-Perpustakaan Digital

Aplikasi perpustakaan mobile (e-perpustakaan) untuk membaca buku secara digital menggunakan Java Android.

## 📱 Fitur

- ✨ **Splash Screen** - Logo animasi saat aplikasi dibuka
- 📖 **Onboarding Screen** - 3 halaman pengenalan aplikasi
- 🏠 **Home Screen** - Katalog buku dengan berbagai kategori
- 📚 **Book of the Week** - Rekomendasi buku pilihan mingguan
- ⭐ **Popular Books** - Daftar buku populer
- 🔍 **Search** - Pencarian buku berdasarkan judul/penulis
- 📄 **Book Detail** - Informasi lengkap buku dengan rating
- 📖 **Reading Interface** - Antarmuka membaca buku
- 🍔 **Navigation Drawer** - Menu navigasi samping
- 🔻 **Bottom Navigation** - Navigasi bawah

## 🛠 Teknologi

- **Language:** Java
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Libraries:**
  - AndroidX AppCompat
  - Material Design Components
  - RecyclerView
  - CardView
  - ViewPager2
  - Glide (Image Loading)
  - CircleImageView

## 📁 Struktur Project

```
android/
├── app/
│   ├── src/main/
│   │   ├── java/com/remine/elibrary/
│   │   │   ├── activities/
│   │   │   │   ├── SplashActivity.java
│   │   │   │   ├── OnboardingActivity.java
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── BookDetailActivity.java
│   │   │   │   └── ReadingActivity.java
│   │   │   ├── adapters/
│   │   │   │   ├── OnboardingAdapter.java
│   │   │   │   ├── BookAdapter.java
│   │   │   │   ├── PopularBookAdapter.java
│   │   │   │   └── NewsAdapter.java
│   │   │   ├── models/
│   │   │   │   ├── Book.java
│   │   │   │   ├── OnboardingItem.java
│   │   │   │   └── News.java
│   │   │   └── utils/
│   │   │       └── BookData.java
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   ├── drawable/
│   │   │   ├── values/
│   │   │   └── menu/
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## 🚀 Cara Menjalankan

### Prerequisite
1. **Android Studio** (versi terbaru)
2. **JDK 8** atau lebih tinggi
3. **Android SDK** (API 24 - 34)

### Langkah-langkah

1. **Buka Android Studio**
2. **Import Project:**
   - File → Open
   - Pilih folder `c:\laragon\www\Remine\android`
3. **Sync Gradle:**
   - Tunggu Android Studio mendownload dependencies
4. **Run Aplikasi:**
   - Klik tombol "Run" (▶) atau tekan `Shift+F10`
   - Pilih emulator atau device Android

### Build APK
```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease
```

APK akan tersimpan di: `app/build/outputs/apk/`

## 📸 Screenshot

Aplikasi memiliki tampilan:
1. **Splash Screen** - Logo dengan gradient background
2. **Onboarding** - 3 slide pengenalan
3. **Home** - Featured book, recommended, popular
4. **Detail** - Info buku dengan tabs
5. **Reading** - Interface membaca buku

## 🔧 Pengembangan Selanjutnya

- [ ] Integrasi database (Room/SQLite)
- [ ] Autentikasi pengguna
- [ ] Download buku offline
- [ ] Bookmark dan highlight
- [ ] Dark mode
- [ ] Multi-language support
- [ ] Push notification
- [ ] Social sharing

## 📄 License

MIT License - Free for personal and commercial use.

---
Dikembangkan dengan ❤️ untuk pecinta buku
