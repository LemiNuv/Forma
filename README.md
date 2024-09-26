# Forma

Un sencillo generador de planos hecho en java y para terminal.

Genera planos a partir de semillas o cargar un plano con archivos de texto. Permite personalizar los carácteres que representan caracteres vacíos (true) y caracteres llenos (false), esto al generar semillas aleatorias.

 <img src="https://i.postimg.cc/j5783zFZ/Qyih-Bk-E6-XI-jfktn-removebg-preview.png" alt="Cocodrilo watoncito, no es mascota oficial solo me gusta el cocodrilito" width="50" />

## Características principales
- Generación de planos a partir de semillas.
- Carga y corrección de matrices desde archivos.
- Posibilidad de personalizar los caracteres del plano.
- Visualización de estadísticas de los planos generados o importados.

## Datos Técnicos

- **Generación de Semillas Aleatorias**: El programa utiliza valores booleanos a partir del número ingresado y randomizado para decidir si es un `true` o un `false`. Por lo cual, si se ingresa el mismo número, se obtendrá el mismo patrón. Adicionalmente, **un carácter** por defecto son dos caracteres (`String`), que en semillas aleatorias se traducen como celdas vacías (`'░░'`) para `true` y celdas llenas (`'██'`) para `false`.
  
- **Estructura del Plano**: El plano generado o leído desde un archivo se maneja como una matriz bidimensional (`String[][]`). Eso hace que si se genera un plano aleatoriamente, se guarda y se carga, dirá que tiene el doble de columnas.

- **Corrección Automática de Matrices**: Ligado a lo anterior, al cargar un archivo, si las filas tienen una longitud desigual, el programa se encarga de ajustar la matriz, rellenando las celdas faltantes con un carácter por defecto que puede elegir el usuario desde la configuración.

- **Guardar Plano anterior y Plano por Defecto**: En el menú se permite guardar el plano anteriormente creado por si por error se salió de la pantalla del generador de planos. Si no se ha creado un plano y se intenta guardar uno, por defecto se guardará un plano que se encuentra en el código.

- **Estadísticas**: El programa muestra estadísticas del plano generado o importado. Del aleatorio siendo mayor en detalles. En el importado mostrará una lista de los caracteres encontrados.

- **Personalización de Caracteres**: El usuario puede personalizar los caracteres a usar en la generación de planos aleatorios. Los caracteres son `Strings` por lo que se puede poner palabras para las celdas llenas y vacías.

## License

[MIT](https://choosealicense.com/licenses/mit/)
