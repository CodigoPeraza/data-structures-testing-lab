# Diseño y complejidad

## Estructuras implementadas

| Estructura | Operación | Complejidad |
| --- | --- | --- |
| `Stack` | `push`, `pop`, `peek` | O(1) |
| `Queue` | `enqueue`, `dequeue`, `peek` | O(1) |
| `SinglyLinkedList` | `addFirst` | O(1) |
| `SinglyLinkedList` | `addLast` | O(n) |
| `SinglyLinkedList` | `remove`, `contains` | O(n) |
| `SinglyLinkedList` | `toList` | O(n) |
| `BinarySearchTree` | `insert`, `contains` | O(log n) promedio, O(n) peor caso |
| `BinarySearchTree` | `inOrder`, `height` | O(n) |
| `BracketValidator` | `isBalanced` | O(n) |

El espacio adicional es O(n) para las estructuras lineales y O(h) para la recursión del árbol, donde `h` es la altura.

## Decisiones

- **Nodos enlazados:** pila, cola y lista se implementan con nodos propios para mostrar el manejo explícito de referencias.
- **Genéricos:** `Stack`, `Queue` y `SinglyLinkedList` aceptan cualquier tipo y rechazan `null` al insertar.
- **Errores explícitos:** las operaciones sobre estructuras vacías lanzan `NoSuchElementException`.
- **Instantáneas inmutables:** `toList()` e `inOrder()` devuelven listas inmutables para evitar modificar la estructura desde fuera.
- **Duplicados en el árbol:** `insert` devuelve `false` si el valor ya existe; el árbol representa un conjunto ordenado.
- **Validación de corchetes:** `BracketValidator` usa una pila y un mapa de cierres; ignora caracteres que no son corchetes.

## Límites conocidos

- La lista enlazada no mantiene una referencia al final, por eso `addLast` es O(n).
- El árbol no implementa eliminación ni balanceo; una secuencia ordenada produce un árbol degenerado.
- Las estructuras no son thread-safe.
