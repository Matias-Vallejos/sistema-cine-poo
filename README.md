# Sistema de Gestión de Cine — Java POO

Sistema integral desarrollado en **Java** para la administración de salas de cine, cartelera de películas, programación de funciones y venta de entradas con control de aforo en memoria. El proyecto aplica los fundamentos de la **Programación Orientada a Objetos (POO)**, modelado de relaciones entre entidades y validación exhaustiva de datos por consola.

---

## 🏛️ Arquitectura y Diagrama de Clases

El diseño desacopla las entidades del dominio, las proyecciones y el registro de ventas:

![Diagrama de Clases](./Diagrama.drawio.png)

---

## 🚀 Conceptos de POO y Diseño Implementados

* **Herencia y Polimorfismo:**
  * Clase abstracta base `Pelicula` con atributos compartidos (`nombre`, `duracion`, `genero`).
  * Subclases `Largometraje` (agrega `duracionTrailer`) y `Cortometraje` (agrega `origen`).
* **Encapsulamiento y Control de Capacidad:**
  * Atributos privados con métodos de acceso y mutación.
  * La clase `Sala` encapsula `capacidad` y `capacidadDisponible`, actualizando los asientos libres ante cada venta mediante `actualizarCapacidad()`.
* **Composición y Agregación:**
  * `Funcion`: Compone una instancia de `Pelicula`, una de `Sala` y almacena el horario asignado.
  * `CompraCliente`: Registra la transacción asociando los datos del `Cliente`, la `Funcion` elegida y la cantidad de entradas adquiridas.
* **Colecciones en Memoria:**
  * La clase `Cine` gestiona listas dinámicas (`ArrayList<T>`) para películas, salas, funciones programadas y registro histórico de compras.
* **Validaciones Robustas:**
  * Clase `Utilidades` para la captura y saneamiento de entradas en consola (números enteros, rangos de opciones y control de cadenas no vacías).

---

## 🛠️ Funcionalidades Principales

* 🎬 **Gestión de Películas:** Registro de largometrajes y cortometrajes con validación de duración y metadatos técnicos.
* 🚪 **Administración de Salas:** Creación de salas numeradas con control de capacidad total.
* 🕒 **Programación de Funciones:** Asignación de películas a salas en horarios determinados con validación de existencia previa.
* 🎟️ **Venta de Entradas:**
  * Selección guiada de funciones disponibles por listado indexado.
  * Control estricto de disponibilidad: verificación de que la cantidad solicitada no supere la capacidad restante de la sala.
  * Registro automático del comprador (`Cliente`) asociado a la transacción.
* 📋 **Consultas y Listados:**
  * Muestra de cartelera completa con detalles de cada función (película, sala, horario y butacas libres).
  * Historial de compras por cliente con detalle de entradas adquiridas.

---

## 💻 Requisitos y Ejecución

* **JDK:** Java SE 17 o superior.
* **IDE recomendado:** IntelliJ IDEA o Eclipse.

### Compilación y ejecución por consola:

```bash
# Compilar todas las clases dentro de src
javac -d bin src/cine/*.java

# Ejecutar el programa principal
java -cp bin cine.Main
```
> 🎓 Contexto académico: Proyecto integrador final para la materia Programación Orientada a Objetos — Carrera de Analista de Sistemas.
