<div align="center">

# Data Structures & Testing Lab

**Estructuras de datos implementadas desde cero con pruebas unitarias y cobertura en Java.**

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![JaCoCo](https://img.shields.io/badge/JaCoCo-Cobertura-2E8B57?style=for-the-badge)

</div>

## Descripción

Laboratorio de estructuras de datos en Java 17 con pruebas unitarias con JUnit 5 y reporte de cobertura con JaCoCo. Incluye pila, cola, lista enlazada simple, árbol binario de búsqueda y un validador de corchetes basado en pila.

El foco es doble: entender cómo funcionan las estructuras por dentro y demostrar una práctica de pruebas sistemática sobre casos normales, límites y errores.

## Estructuras

| Clase | Descripción |
| --- | --- |
| `Stack<T>` | Pila LIFO con nodos enlazados. |
| `Queue<T>` | Cola FIFO con referencias al inicio y al final. |
| `SinglyLinkedList<T>` | Lista enlazada simple con inserción, búsqueda y eliminación. |
| `BinarySearchTree` | Árbol binario de búsqueda de enteros con recorrido in-order. |
| `BracketValidator` | Validación de `()`, `[]` y `{}` mediante pila. |

## Pruebas

Las pruebas cubren:

- Orden LIFO y FIFO.
- `peek` sin eliminar elementos.
- Estructuras vacías y excepciones esperadas.
- Rechazo de valores `null`.
- Eliminación de la primera ocurrencia en la lista.
- Listas inmutables devueltas al exterior.
- Inserción, búsqueda, duplicados, recorrido y altura del árbol.
- Corchetes balanceados, desbalanceados, anidados y texto sin corchetes.

## Stack

- Java 17
- Maven 3.9+
- JUnit 5
- JaCoCo
- GitHub Actions

## Estructura

```text
data-structures-testing-lab/
├── src/main/java/com/codigoperaza/ds/
│   ├── Stack.java
│   ├── Queue.java
│   ├── SinglyLinkedList.java
│   ├── BinarySearchTree.java
│   ├── BracketValidator.java
│   └── Main.java
├── src/test/java/com/codigoperaza/ds/
│   ├── StackTest.java
│   ├── QueueTest.java
│   ├── SinglyLinkedListTest.java
│   ├── BinarySearchTreeTest.java
│   └── BracketValidatorTest.java
├── docs/design.md
├── .github/workflows/ci.yml
└── pom.xml
```

## Ejecución

Requiere JDK 17 o superior. El wrapper descarga Maven automáticamente.

```bash
./mvnw verify
java -cp target/classes com.codigoperaza.ds.Main
```

Salida esperada del demo:

```text
Pila LIFO: segundo, primero
Cola FIFO: primero, segundo
Lista: [5, 10, 20] | contiene 20: true
Árbol in-order: [1, 3, 4, 6, 7, 8, 10, 13, 14] | altura: 4
Balance de corchetes: true
```

## Cobertura

```bash
./mvnw verify
```

El reporte HTML queda en `target/site/jacoco/index.html`.

## Diseño y complejidad

La tabla de complejidad y las decisiones están en [docs/design.md](docs/design.md).

## Integración continua

El flujo de GitHub Actions ejecuta `./mvnw -B verify` en Java 17 para cada push a `main` y cada pull request.

## Limitaciones

- El árbol no implementa eliminación ni balanceo.
- La lista enlazada no mantiene referencia al final, por lo que `addLast` es O(n).
- Las estructuras son didácticas y no thread-safe.
- No se comparan con las colecciones de la biblioteca estándar mediante benchmarks.

## Materias que respalda

- Estructuras de Datos.
- Programación Orientada a Objetos.
- Testing y Calidad de Software.
- Análisis de Algoritmos.

## Autor

**Francisco Javier Peraza** · [GitHub](https://github.com/CodigoPeraza) · [contacto.peraza@gmail.com](mailto:contacto.peraza@gmail.com)
