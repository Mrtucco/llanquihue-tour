# LlanquihueTourApp

* Nombre completo: [Escribe aquí tu nombre]
* Sección: [Escribe aquí tu sección]
* Carrera: Ingeniería en Informática
* Sede: [Escribe aquí tu sede, por ejemplo: Puerto Montt]

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Evaluación Final Transversal** de la asignatura
Desarrollo Orientado a Objetos I. Es la continuación directa del sistema desarrollado
en la Evaluación 1 para la agencia **Llanquihue Tour**, ubicada en la comuna de
Llanquihue, Región de Los Lagos.

El sistema gestiona dos tipos de información:

- **Tours** ofrecidos por la agencia (gastronómicos, lacustres, culturales y de excursión).
- **Personas** vinculadas a la operación de la agencia: **clientes** que contratan tours
  y **empleados** (guías, operadores, administrativos).

Los datos se leen desde archivos `.txt` ubicados en `resources/`, se cargan en
colecciones `ArrayList`, y se valida cada registro con bloques `try-catch` antes de
incorporarlo al sistema. Por consola, el usuario puede listar todos los registros,
buscar por distintos criterios y filtrar tours por precio máximo.

Se aplican los siguientes principios de POO:

- **Encapsulamiento**: todos los atributos son `private`, con sus respectivos getters y setters.
- **Herencia**: `Cliente` y `Empleado` extienden de la clase abstracta `Persona`.
- **Polimorfismo**: cada subclase sobrescribe `getRol()` y `coincideCon()` con su propio comportamiento.
- **Interfaces**: `Tour` y `Persona` implementan `Buscable`, lo que permite tratar
  ambas entidades de forma uniforme al momento de buscar.

## 🧱 Estructura de paquetes y clases

```
src/main/java/
├── model/
│   ├── Persona.java     → Clase abstracta base (nombre, rut, telefono)
│   ├── Cliente.java     → Extiende Persona (tourContratado, cantidadPersonas)
│   ├── Empleado.java    → Extiende Persona (cargo, sueldoBase)
│   └── Tour.java        → Entidad Tour (nombre, tipo, precio)
├── data/
│   └── GestorDatos.java → Lee tours.txt y personas.txt, valida y carga los ArrayList
├── utils/
│   └── Validador.java   → Validaciones de texto, RUT, números y parsing seguro
├── interfaces/
│   └── Buscable.java    → Define coincideCon(String criterio) para búsquedas
└── ui/
    └── Main.java         → Clase principal con el menú interactivo por consola

src/main/resources/
├── tours.txt     → Catálogo de tours (nombre;tipo;precio)
└── personas.txt  → Clientes y empleados (TIPO;nombre;rut;telefono;campo4;campo5)
```

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

   ```
   git clone https://github.com/Mrtucco/llanquihue-tour.git
   ```

2. Abre el proyecto en **IntelliJ IDEA** (se reconoce automáticamente como proyecto Maven).
3. Verifica que la carpeta `src/main/resources` esté marcada como **Resources Root**
   (clic derecho sobre la carpeta → *Mark Directory as* → *Resources Root*).
4. Ejecuta la clase `ui/Main.java` (botón ▶ verde junto al método `main`).
5. Usa el menú numérico que aparece en la consola para listar, buscar o filtrar
   tours y personas.

### Generar la versión de distribución (.jar ejecutable)

Desde la terminal de IntelliJ, en la raíz del proyecto:

```
mvn clean package
```

Esto genera el archivo `target/LlanquihueTourApp-1.0-SNAPSHOT.jar`. Para ejecutarlo
fuera de IntelliJ:

```
java -jar target/LlanquihueTourApp-1.0-SNAPSHOT.jar
```

> **Nota:** al ejecutar el `.jar` desde la terminal, los archivos `tours.txt` y
> `personas.txt` quedan empaquetados dentro del propio `.jar` (gracias a estar en
> `resources/`), por lo que no es necesario copiarlos aparte.

## 🛠️ Tecnologías

- Java SE 21
- Maven
- IntelliJ IDEA Community
- Git / GitHub
