# Java Lombok+DTO + Python+Flet

Este repositorio contiene una aplicación que integra Java utilizando Lombok y DTO (Data Transfer Object) con un backend en Python utilizando Flet.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes programas:

- **IntelliJ IDEA** (para trabajar con Java y Maven).
- **Python** (preferentemente una versión >= 3.7).

Si no tienes IntelliJ, también puedes usar Maven desde la línea de comandos para manejar las dependencias de Java.

## Instrucciones de instalación

### 1. Clonar el repositorio

Clona el repositorio en tu máquina local:

```bash
git clone https://github.com/MestreFrancisco/Java-lombok-jpa-hibernate-Flet-Python.git
```

### 2. Configuración del proyecto Java

#### a. Usar IntelliJ IDEA (recomendado)

1. Abre **IntelliJ IDEA** y selecciona "Abrir" el directorio del proyecto.
2. IntelliJ reconocerá automáticamente el proyecto como un proyecto Maven.
3. Maven descargará todas las dependencias necesarias para el proyecto automáticamente.

#### b. Si no tienes IntelliJ, puedes usar Maven desde la línea de comandos

Asegúrate de tener **Maven** instalado en tu máquina. Si no lo tienes, instálalo siguiendo la [guía oficial de Maven](https://maven.apache.org/install.html).

Luego, desde la línea de comandos dentro del directorio del proyecto, ejecuta:

```bash
mvn clean install
```

Este comando descargará todas las dependencias definidas en el `pom.xml` del proyecto.

### 3. Configuración del proyecto Python

1. **Instala las dependencias de Python**.

Dentro del directorio donde se encuentra el proyecto Python (probablemente en una carpeta separada dentro del repositorio), ejecuta:

```bash
pip install -r requisitos.txt
```

Este comando instalará todas las dependencias necesarias para el proyecto Python.

2. **Ejecuta la aplicación con Flet**.

Asegúrate de tener **Flet** instalado. Si no lo tienes, puedes instalarlo con:

```bash
pip install flet
```

Una vez que todo esté configurado, para ejecutar la aplicación, usa el siguiente comando:

```bash
flet run
```

Esto iniciará el servidor y podrás interactuar con la aplicación.

## Estructura del proyecto

- **Backend Java**: El proyecto Java está basado en **Lombok** para la simplificación del código, y **DTO** para la transferencia de datos entre las capas de la aplicación.
- **Backend Python**: La parte de Python utiliza **Flet** para crear aplicaciones interactivas de forma sencilla.

## Contribuciones

Si deseas contribuir a este proyecto, por favor realiza un **fork** del repositorio y crea un **pull request** con tus cambios.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.
"""


