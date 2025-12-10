# Kairo 🍅

> Gestión de tareas con temporizador Pomodoro integrado. Diseñado para funcionar tanto online como offline.

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green.svg" alt="Platform">
  <img src="https://img.shields.io/badge/Compose%20BOM-2025.12.00-blue.svg" alt="Compose BOM">
  <img src="https://img.shields.io/badge/Kotlin-2.2-purple.svg" alt="Kotlin">
  <img src="https://img.shields.io/badge/Min%20SDK-24-orange.svg" alt="Min SDK">
</p>

---

## 📱 Sobre Kairo

**Kairo** es una aplicación de gestión de tareas que integra la técnica Pomodoro para ayudarte a mantener el foco y la productividad. Funciona completamente offline o sincronizada en la nube, tú decides.

### ✨ Características principales

- **🏠 Home Dashboard** → Vista rápida de tareas asignadas y registros de actividad
- **📋 Gestión de Tareas** → Organiza tus tareas por intervalos de tiempo y prioridades
- **📊 Estadísticas** → Analiza tu productividad con métricas de tiempo Pomodoro, tareas completadas y más
- **👤 Perfil + Configuración** → Gestiona tu cuenta, preferencias y accede a información de la app
- **⚡ Creación Rápida** → FAB central para añadir tareas al instante

### 🔄 Modo Híbrido: Online & Offline

Al iniciar por primera vez, elige cómo quieres usar Kairo:
- **Modo Offline** → Todos los datos en local, sin conexión necesaria
- **Modo Online** → Sincronización en la nube con Firebase (próximamente)
- Cambia entre modos en cualquier momento desde configuración

---

## 🏗️ Arquitectura

Kairo está construido siguiendo las mejores prácticas de Android moderno:

### Tech Stack

- **UI**: Jetpack Compose + Material 3
- **Navegación**: Navigation Compose 3.0
- **Arquitectura**: MVVM + Clean Architecture
- **DI**: Koin
- **Base de Datos**: SQLDelight
- **Async**: Kotlin Coroutines + Flow
- **Build**: Gradle Kotlin DSL

### Estructura del Proyecto

```
app/
├── data/                          # Data layer (Repository, DataSource)
├── domain/                        # Business logic (UseCases, Models)
└── presentation/                  # UI layer (Compose, ViewModels)
    ├── screens/
    │   ├── start/                 # Onboarding (online/offline)
    │   ├── main/                  # Container principal
    │   │   ├── MainScreen.kt
    │   │   └── inner/             # Navegación bottom bar
    │   │       ├── home/
    │   │       ├── tasks/
    │   │       ├── statistics/
    │   │       └── profile/
    │   └── create_task/           # Creación rápida de tareas
    ├── shared/                    # Componentes compartidos
    └── theme/                     # Material 3 theming
```

### Decisiones arquitectónicas

#### Scaffold Hierarchy
- **Root screens** (Start, Main, CreateTask): Cada una con su propio `Scaffold` para control independiente de TopBar/BottomBar
- **Inner screens** (Home, Tasks, Statistics, Profile): Componibles sin Scaffold que heredan padding del padre

#### Principios aplicados
- ✅ **Single Responsibility** → Cada Scaffold controla su layout
- ✅ **DRY** → Padding aplicado una vez en NavDisplay
- ✅ **Composition over Inheritance** → Inner screens desacopladas
- ✅ **KISS** → Sin complejidad innecesaria

#### Escalabilidad
La estructura actual está optimizada para apps de tamaño pequeño-mediano (~20 pantallas). Para crecimiento futuro:
1. **Fase actual**: Organización por navegación (`main/inner/`)
2. **Fase 2**: Migración a feature modules (`feature/tasks/`, `feature/statistics/`)
3. **Fase 3**: Multi-módulo Gradle para equipos grandes

---

## 🚀 Empezar

### Requisitos

- Android Studio Ladybug | 2024.2.1+
- JDK 17
- Android SDK 26+

### Instalación

```bash
# Clonar el repositorio
git clone https://github.com/tuusuario/Kairo.git

# Abrir en Android Studio
# File > Open > Seleccionar carpeta Kairo

# Sincronizar Gradle y ejecutar
```

---

## 🗺️ Roadmap

### MVP (v1.0) - En desarrollo
- [x] Sistema de navegación multi-nivel
- [x] Arquitectura MVVM + Clean
- [x] Estructura escalable de carpetas
- [x] Base de datos local (SQLDelight)
- [ ] CRUD de tareas
- [ ] Temporizador Pomodoro
- [ ] Estadísticas básicas
- [ ] Sistema de configuración

### v1.1 - Próximamente
- [ ] Autenticación con Google (Firebase)
- [ ] Sincronización en la nube
- [ ] Notificaciones push
- [ ] Widgets de home screen

### v2.0 - Futuro
- [ ] Temas personalizados
- [ ] Exportación de datos
- [ ] Integración con calendarios
- [ ] Modo Pomodoro avanzado (sesiones grupales)

---

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Si encuentras un bug o tienes ideas para mejorar Kairo:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add: amazing feature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Guía de estilo

- Sigue las convenciones de Kotlin (ktlint)
- Mantén Clean Architecture
- Documenta código complejo
- Escribe tests para casos de uso críticos

---

## 📄 Licencia

Este proyecto está bajo la **PolyForm Noncommercial License 1.0.0**.

### ¿Qué significa esto?

✅ **Puedes:**
- Ver, estudiar y aprender del código fuente
- Hacer fork del proyecto para uso personal
- Modificar y adaptar el código a tus necesidades
- Usar el proyecto con fines no comerciales

❌ **No puedes:**
- Vender o comercializar el proyecto o sus derivados
- Usar el código con fines comerciales sin autorización

**Nota:** Este proyecto es **source-available**, no open source. El código está públicamente disponible para aprendizaje y uso personal, pero los derechos comerciales son exclusivos del autor.

Ver archivo [LICENSE.md](LICENSE.md) para los términos completos.

---

## 👨‍💻 Autor

**Alberto Gálvez (Galvezsh)**
- GitHub: [@galvezsh](https://github.com/galvezsh)
- LinkedIn: [Alberto Gálvez](https://linkedin.com/in/alberto-galvez-gandullo)

---

## 🙏 Agradecimientos

- Inspirado en la técnica Pomodoro de Francesco Cirillo
- Diseño basado en Material Design 3
- Comunidad de Android Dev Español

---

<p align="center">Hecho con ❤️ y Jetpack Compose</p>
