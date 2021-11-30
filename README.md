# Verificación y Validación del Software 2021
GRUPO IWM-42 Grupo 2

# Integrantes del grupo
* Alvaro Avilés Redondo
* Cristian Chelemen
* Diego Aldama Campos
* Fabián Magro del Pozo
* Pablo Moisés Ruiz Muñoz
* Jesús  Antón Díaz

# Información adicional sobre el proyecto
Proyecto donde esta alojado el código de la práctica de pruebas de integración de la asignatura verificación y validación

# Instrucciones para utilizar este proyecto
* Para descargar el proyecto, clonarlo desde la URL del repositorio de Github en el IDE de desarrollo de su preferencia (Eclipse, Netbeans, IntelliJ, etc.)
* Comprobar que el IDE reconoce el proyecto como un proyecto maven (Maven 3.6.3)
* Asegurarse de utilizar Java JDK 1.8 o superior
* Comprobar que se disponen de las dependencias necesarias para poder usar Mockito
* Comprobar que se disponen de las dependencias necesarias para poder usar Junit5
* Para ejecutar las pruebas se pueden ejecutar directamente los test desde el IDE, o bien, se puede hacer uso de comandos maven para ejecutarlas (cabe destacar que si se ejecuta con comandos maven se generaras ficheros de reporte con los detalles), como por ejemplo:
    - mvn test //Para ejecutar todas los tests
    - mvn -Dtest=clase test //Para ejecutar los tests de una clase en concreto
    - mvn -Dtest=clase1,clase2 test //Para ejecutar los tests varias clases a la vez
    - mvn -Dtest=clase#nombremetodo test //Para ejecutar un test concreto de una clase específica
    - mvn -Dtest=clase#patron* test //Para ejecutar todas los tests que sigan el patron "patron*"
