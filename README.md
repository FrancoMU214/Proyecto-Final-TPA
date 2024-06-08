# iLib
Basic system for managing a library on Java using Look And Feel and DAO Pattern. The ITPLibrary Version 2.0.

## Features
✔️ Graphic interface with Material Design style (Using Look And Feel).\
✔️ MySQL database connection.\
✔️ Management of books, loans and returns.\
✔️ Penalties for late returns.\
✔️ Movement logs.\
✔️ Lookup tables.\
✔️ DAO Pattern.

# Ilib
Proyecto Final para la Materia de Topicos Avanzados de Programacion
# Clase Database
Esta clase maneja la conexión a la base de datos para nuestro proyecto. Aquí tenemos un resumen de cómo funciona:

Atributos
•	conexion: Guarda el objeto Connection que usamos para interactuar con la base de datos.

•	JDBC_DRIVER: La cadena que identifica el driver JDBC que necesitamos para conectar con MySQL. En este caso, es "com.mysql.jdbc.Driver".

•	DB_URL: La URL de la base de datos a la que nos conectamos. Aquí está configurada para conectar con una base de datos llamada ilib en localhost.

•	USER: El nombre de usuario para acceder a la base de datos, que en este caso es "root".

•	PASS: La contraseña del usuario, aquí es "1234abc".

Métodos
•	Conectar(): Este método intenta establecer la conexión con la base de datos. Usa DriverManager.getConnection para obtener la conexión y Class.forName para asegurarse de que el driver JDBC está disponible. Si hay algún problema al conectar, se captura la excepción SQLException y se registra.

•	Cerrar(): Cierra la conexión a la base de datos si está abierta. Chequea primero si la conexión no es nula y si está abierta antes de cerrarla para evitar errores.
Uso típico

1.	Conexión: Primero, creamos una instancia de Database y llamamos al método Conectar() para iniciar la conexión.
2.	Operaciones: Realizamos las operaciones que necesitemos con la base de datos.
3.	Cierre: Llamamos al método Cerrar() para cerrar la conexión cuando hayamos terminado.
4.	Este enfoque asegura que la conexión se maneje de manera segura y eficiente, evitando fugas de recursos.

# Clase DAOBooksImpl
Esta clase es una implementación del interfaz DAOBooks, extendiendo la clase Database para manejar operaciones específicas con libros en la base de datos. Aquí tienen un desglose de los métodos utilizamos:

Métodos
• Registrar(Books book): Registra un nuevo libro en la base de datos. Prepara y ejecuta una instrucción SQL INSERT con todos los detalles del libro como título, autor, categoría, etc.

• Modificar(Books book): Actualiza los detalles de un libro existente identificado por su ID. Usa una instrucción SQL UPDATE para modificar los campos del libro en la base de datos.

• Eliminar(int bookId): Elimina un libro de la base de datos usando su ID. Ejecuta una instrucción SQL DELETE.

• Listar(String title): Retorna una lista de libros que coincidan con el título proporcionado. Si no se proporciona un título, retorna todos los libros. Usa SELECT para buscar en la base de datos.

• ListarId(String id): Funciona de manera similar a listar, pero filtra los libros por ID.

• GetBookById(int bookId): Obtiene los detalles de un solo libro basado en su ID. Útil para operaciones específicas en un libro determinado.

Uso Típico

1. Conexión y Operaciones: Primero se conecta a la base de datos, realiza operaciones como registrar, modificar o eliminar, y luego cierra la conexión para liberar recursos.
2. Manejo de Excepciones: Todos los métodos están diseñados para manejar excepciones y asegurar que la conexión se cierra correctamente, independientemente de si la operación fue exitosa o no.

Buenas Prácticas

1. Manejo de Recursos: Usa bloques try-with-resources para asegurar que todos los recursos de la base de datos se cierran adecuadamente.
2. Seguridad: Evitar la inyección SQL utilizando PreparedStatement y parámetros.
3. Este diseño ayuda a mantener el código organizado, facilita la reutilización y mejora la mantenibilidad al separar la lógica de acceso a datos del resto de la aplicación.

# Clase DAOLendingsImpl
Esta clase gestiona las operaciones de base de datos relacionadas con los préstamos de libros en la biblioteca. A continuación, les detallamos los métodos implementados en esta clase, que extiende la clase Database:

Métodos

• Registrar(Lendings lending): Registra un nuevo préstamo en la base de datos. Se introducen los IDs de usuario y libro, así como la fecha de salida del libro, utilizando un PreparedStatement para evitar inyecciones SQL.

• Modificar(Lendings lending): Actualiza la información de un préstamo existente, incluyendo el usuario, el libro, la fecha de salida y la fecha de retorno. Esto permite actualizar los registros cuando un libro es devuelto.

• GetLending(Users user, Books book): Busca el préstamo más reciente de un libro específico por un usuario que aún no ha sido devuelto. Esto es útil para rastrear préstamos activos.
listar(): Devuelve una lista de todos los préstamos registrados en la base de datos, ordenados de manera descendente por ID. Esto proporciona una visión general rápida de todos los préstamos.

Uso Típico

1. Conexión a la Base de Datos: Antes de cualquier operación, se conecta a la base de datos.
2. Ejecución de Operaciones: Dependiendo de la necesidad, se registran nuevos préstamos, se modifican préstamos existentes, o se buscan préstamos específicos.
3. Cierre de la Conexión: Después de realizar las operaciones necesarias, se cierra la conexión para optimizar los recursos.

Consideraciones de Diseño

1. Seguridad de Datos: Utiliza PreparedStatement para proteger contra inyecciones SQL.
2. Manejo de Excepciones: Cada método incluye manejo de excepciones para capturar y tratar errores de forma adecuada.
3. Cierre de Recursos: Implementa un bloque finally en cada método para asegurarse de que la conexión a la base de datos se cierre correctamente, incluso si ocurre una excepción.
4. Esta clase es un componente crucial para manejar la lógica de negocios relacionada con los préstamos de libros, asegurando que la base de datos se mantenga actualizada y consistente.

# Clase DAOUsersImpl
Esta clase gestiona las operaciones de base de datos relacionadas con los usuarios en el sistema. Implementa la interfaz DAOUsers y extiende la clase Database para utilizar la conexión a la base de datos. A continuación, se detallan los métodos que ofrece esta clase:

Métodos

•	registrar(Users user): Añade un nuevo usuario a la base de datos. Inserta los detalles del usuario como nombre, apellidos, domicilio y teléfono usando un PreparedStatement.

•	modificar(Users user): Actualiza la información de un usuario existente en la base de datos. Permite cambiar detalles como el nombre, apellidos, domicilio, y teléfono.

•	eliminar(int userId): Elimina un usuario de la base de datos utilizando su ID. Ejecuta un DELETE para remover completamente el registro del usuario.

•	listar(String name): Devuelve una lista de usuarios que coincidan con el nombre dado. Si no se proporciona un nombre, devuelve todos los usuarios. Utiliza un SELECT para obtener los datos.

•	listarId(String id): Similar al método listar, pero filtra los usuarios por su ID.

•	getUserById(int userId): Obtiene la información de un solo usuario por su ID. Es útil para operaciones específicas en un usuario determinado.

•	sancionar(Users user): Actualiza el estado de sanción de un usuario, ajustando el número de sanciones y la cantidad monetaria de las sanciones en la base de datos.

Uso Típico

•	Conexión a la Base de Datos: Se conecta a la base de datos antes de cualquier operación.

•	Ejecución de Operaciones: Se pueden realizar operaciones como registrar, modificar, eliminar, o sancionar usuarios.

•	Cierre de la Conexión: Se cierra la conexión después de realizar las operaciones necesarias para optimizar los recursos.

Consideraciones de Diseño

•	Seguridad de Datos: Utiliza PreparedStatement para proteger contra inyecciones SQL.

•	Manejo de Excepciones: Cada método está diseñado para manejar excepciones adecuadamente, asegurando que los errores se traten de manera efectiva.

•	Cierre de Recursos: Implementa un bloque finally en cada método para garantizar que la conexión se cierre correctamente.

Esta clase es crucial para manejar la lógica de acceso a datos relacionada con los usuarios, facilitando la gestión de usuarios y asegurando que la base de datos se mantenga actualizada y segura.

# Clase Dashboard
Esta clase, Dashboard, básicamente configura y maneja el panel principal de nuestra aplicación. Como podrás ver, hereda de javax.swing.JFrame, lo que significa que es una ventana de nuestra GUI. Aquí te contamos cómo le dimos forma:
Constructor

•	Dashboard(): En el constructor, llamamos a initComponents() que se supone que NetBeans autogenera para inicializar los componentes de la GUI. Luego, ponemos nuestro propio estilo con InitStyles(), establecemos la fecha actual con SetDate(), y finalmente preparamos el contenido inicial con InitContent().

Métodos

•	InitStyles(): Aquí personalizamos un poco los estilos de los componentes de texto como mensaje, navText, dateText, y appName usando propiedades del tema FlatLaf. Por ejemplo, ajustamos el tipo de fuente 
y el color, asegurando que todo tenga un look consistente y elegante.

•	SetDate(): Usamos la fecha actual y la formateamos al estilo español. Esto se muestra en dateText, donde podrías ver algo como "Hoy es viernes 05 de mayo de 2023". Usamos DateTimeFormatter con un patrón específico y la localización para España.

•	InitContent(): Este método simplemente establece el panel inicial que se mostrará en la zona de contenido de nuestra ventana. Llama a ShowJPanel(new Principal()) que es un método estático para cambiar el contenido del panel principal.
Método Estático

•	ShowJPanel(JPanel p): Este método es bastante útil porque permite cambiar el contenido del content panel de nuestro Dashboard. Ajusta el tamaño y la posición del panel que recibe y luego lo agrega al content. Limpia lo que haya antes, lo añade, y luego asegura que la GUI se actualice correctamente con revalidate() y repaint().

Uso y Consideraciones

•	Personalización y estilos: La personalización de los componentes es clave para mantener un estilo uniforme que se alinee con el tema visual de nuestra aplicación.
•	Manejo de fechas: Es crucial cuando la app tiene que presentar o usar fechas, especialmente en formatos localizados.
•	Flexibilidad: El método ShowJPanel ofrece una manera flexible de cambiar entre diferentes pantallas o paneles de nuestra aplicación, manteniendo la transición suave y sin complicaciones.

# INTERFACES

# Interfaz DAOBooks
Esta interfaz define las operaciones esenciales que cualquier implementación de DAOBooks debería tener. Es como el contrato que asegura que quien lo implemente pueda manejar todas las funciones básicas relacionadas con libros en nuestra base de datos. Aquí te explicamos cada método que debe tener:

Métodos

•	registrar(Books book) throws Exception: Se encarga de añadir un nuevo libro a la base de datos. Necesita un objeto Books con toda la info del libro que se va a registrar.

•	modificar(Books book) throws Exception: Actualiza la información de un libro ya existente. Esto es útil cuando hay cambios en los detalles del libro, como el título, autor, o incluso la cantidad en stock.

•	eliminar(int bookId) throws Exception: Remueve un libro de la base de datos usando su ID. Este método es crucial para mantener la base de datos limpia de registros que ya no se necesitan.

•	listar(String title) throws Exception: Devuelve una lista de libros que coinciden con el título proporcionado. Si se pasa una cadena vacía o nula, debería retornar todos los libros disponibles.

•	listarId(String id) throws Exception: Similar al método listar, pero en este caso se busca por ID del libro. Ideal para cuando necesitas detalles específicos de un libro sin tener que cargar toda la lista.

•	getBookById(int bookId) throws Exception: Este método es para obtener un libro específico por su ID. Es súper útil cuando solo necesitas la información de un libro en particular, sin más complicaciones.
Consideraciones Generales

•	Manejo de Excepciones: Todos los métodos pueden lanzar Exception, lo que sugiere que cualquier implementación debe manejar posibles errores durante la interacción con la base de datos. Esto es vital para una app robusta y confiable.

•	Flexibilidad en la Búsqueda: Los métodos listar y listarId ofrecen mucha flexibilidad para obtener libros, ya sea por título o por ID, lo que hace que la interfaz sea bastante útil en diferentes contextos de uso.

Uso Típico

Cualquier clase que implemente esta interfaz será responsable de definir cómo se conecta a la base de datos, cómo ejecuta las consultas SQL, y cómo maneja los resultados y errores. Esto asegura que el resto de nuestra aplicación pueda usar estos métodos sabiendo exactamente qué esperar, sin preocuparse por los detalles de la implementación.

# Interfaz DAOLendings
Esta interfaz define los métodos esenciales que cualquier implementación de manejo de préstamos de libros debe tener. Funciona como una guía que asegura que las clases que la implementen puedan manejar todas las operaciones relacionadas con los préstamos en la biblioteca. Aquí te detallamos cada uno de los métodos que incluye:

Métodos

•	registrar(Lendings lending) throws Exception: Este método está diseñado para añadir un nuevo préstamo a la base de datos. Necesitarás pasarle un objeto Lendings que contiene toda la información del 
préstamo, como quién toma el libro, qué libro es, y la fecha de salida.

•	modificar(Lendings lending) throws Exception: Utilizado para actualizar la información de un préstamo existente, por ejemplo, cuando un libro es devuelto y necesitas registrar la fecha de devolución.

•	getLending(Users user, Books book) throws Exception: Este método busca el préstamo activo más reciente para un libro específico por un usuario determinado, muy útil para controlar los préstamos que no han sido devueltos aún.

•	listar() throws Exception: Devuelve una lista con todos los préstamos registrados en la base de datos. Este método es esencial para obtener una visión general de todos los préstamos, lo cual es crucial para el manejo de inventarios y el seguimiento de los libros.

Consideraciones Generales

•	Manejo de Excepciones: Al igual que otras interfaces de acceso a datos, todos los métodos de DAOLendings pueden lanzar excepciones, lo que implica que las implementaciones deben ser capaces de manejar fallos en la interacción con la base de datos.

•	Flexibilidad y Rastreo: El método getLending añade una capa de flexibilidad y control permitiendo rastrear préstamos específicos, lo cual es vital para evitar pérdidas o malentendidos sobre el estado de los libros prestados.

Uso Típico
1. Las clases que implementen esta interfaz serán responsables de conectar con la base de datos, realizar las consultas necesarias y manejar los resultados y posibles errores. Esto garantiza que el manejo 2. de los préstamos sea transparente y eficiente para el resto de la aplicación, manteniendo la integridad y la disponibilidad de los datos.

# Interfaz DAOUsers
Esta interfaz es crucial porque establece los métodos que cualquier implementación debe tener para manejar las operaciones relacionadas con los usuarios en nuestra base de datos. Es una parte fundamental para asegurar que gestionamos adecuadamente los datos de los usuarios, desde su registro hasta la administración de sanciones. Aquí te explicamos cada uno de los métodos:

Métodos

•	registrar(Users user) throws Exception: Este método es para añadir un nuevo usuario a la base de datos. Necesita toda la información del usuario para poder hacer el registro correctamente.

•	modificar(Users user) throws Exception: Actualiza la información de un usuario ya existente. Esto es útil para corregir datos o actualizar información relevante del usuario.

•	sancionar(Users user) throws Exception: Aplica o actualiza sanciones a un usuario, lo cual es fundamental para gestionar el cumplimiento de las normas dentro de la biblioteca o cualquier sistema que implemente esta interfaz.

•	eliminar(int userId) throws Exception: Remueve a un usuario de la base de datos utilizando su ID. Este método es importante para mantener la base de datos limpia de usuarios que ya no necesitan estar registrados.

•	listar(String name) throws Exception: Devuelve una lista de usuarios que coinciden con el nombre proporcionado. Si no se proporciona un nombre, podría configurarse para retornar todos los usuarios.

•	listarId(String id) throws Exception: Similar al método listar, pero busca y lista usuarios basándose en su ID.

•	getUserById(int userId) throws Exception: Retorna un usuario específico basado en su ID. Es crucial para obtener detalles completos de un usuario sin necesidad de buscar a través de toda la base de datos.
Consideraciones Generales

•	Manejo de Excepciones: Todos los métodos pueden lanzar excepciones, lo que indica que las implementaciones deben ser capaces de manejar posibles errores de interacción con la base de datos de manera eficiente.

•	Flexibilidad y Seguridad: Proporcionar métodos para listar, modificar y eliminar asegura que la interfaz pueda adaptarse a varios escenarios de uso, al tiempo que mantiene la seguridad y la integridad de los datos del usuario.

Uso Típico
1. Cualquier clase que implemente esta interfaz se encargará de definir cómo se realizan las conexiones a la base de datos, cómo se ejecutan las consultas y cómo se manejan los resultados y los errores.
2. Esto garantiza que las operaciones relacionadas con los usuarios sean transparentes y eficaces, facilitando la gestión de los mismos dentro de la aplicación.

# CLASES
# Clase Books
La clase Books representa el modelo de un libro dentro de nuestra aplicación. Es una parte esencial del sistema, pues almacena y gestiona toda la información relevante sobre los libros. Aquí te detallamos cada uno de los atributos y métodos que incluye:

Atributos
•	id: Identificador único para cada libro en la base de datos.

•	title: Título del libro.

•	date: Fecha de publicación o adquisición del libro.

•	author: Autor del libro.

•	category: Categoría a la que pertenece el libro (por ejemplo, novela, ciencia ficción, educativo).

•	edit: Edición del libro.

•	lang: Idioma en el que está escrito el libro.

•	pages: Número de páginas del libro.

•	description: Breve descripción o resumen del libro.

•	ejemplares: Número de copias del mismo libro disponibles en la biblioteca.

•	stock: Número total de copias en stock, incluidas las que están prestadas.

•	available: Número de copias disponibles para ser prestadas.

Métodos de Acceso y Modificación (Getters y Setters)
Cada atributo tiene su correspondiente método set para establecer su valor y método get para obtener su valor. Estos métodos son cruciales para la manipulación y acceso seguro a las propiedades del objeto Books, asegurando que los datos pueden ser actualizados o recuperados según sea necesario. Por ejemplo:
•	setId(int id): Establece el ID del libro.

•	getTitle(): Devuelve el título del libro.

•	setAuthor(String author): Asigna el nombre del autor del libro.

•	getStock(): Obtiene el stock total de copias del libro.

Consideraciones de Diseño
2. Encapsulamiento: Todos los atributos son privados, lo que significa que solo pueden ser accedidos y modificados a través de sus métodos getters y setters. Esto ayuda a mantener la integridad de los datos.
1. Flexibilidad: La clase está diseñada para ser flexible y fácil de integrar con otras partes del sistema, como interfaces de usuario y operaciones de base de datos.

Uso Típico
Un objeto de la clase Books puede ser utilizado en varias partes de una aplicación de gestión bibliotecaria:
1. Registro y Actualización: Cuando se añaden nuevos libros al inventario o se actualizan los detalles de los libros existentes.
2. Consulta: Para recuperar información sobre libros cuando se necesitan para operaciones como préstamos, devoluciones, o búsquedas.

# Clase Lendings
La clase Lendings es parte crucial de nuestro sistema de gestión de biblioteca, específicamente diseñada para manejar los préstamos de libros. Esta clase facilita la representación y manejo de la información relacionada con los préstamos. A continuación, te describo en detalle cada uno de los atributos y métodos:
Atributos

•	id: El identificador único para cada préstamo en la base de datos.

•	user_id: El identificador del usuario que realiza el préstamo.

•	book_id: El identificador del libro que se presta.

•	date_out: La fecha en la que el libro fue prestado.

•	date_return: La fecha en la que el libro fue o será devuelto.

Métodos de Acceso y Modificación (Getters y Setters)
Cada atributo de la clase tiene métodos set para establecer su valor y métodos get para recuperar su valor, permitiendo una manipulación segura de los datos del préstamo:

•	setId(int id), getId(): Establece y recupera el ID del préstamo.

•	setUser_id(int user_id), getUser_id(): Establece y recupera el ID del usuario asociado al préstamo.

•	setBook_id(int book_id), getBook_id(): Establece y recupera el ID del libro prestado.

•	setDate_out(String date_out), getDate_out(): Establece y recupera la fecha de salida del préstamo.

•	setDate_return(String date_return), getDate_return(): Establece y recupera la fecha de retorno del préstamo.

Consideraciones de Diseño

•	Encapsulamiento: Todos los atributos son privados para proteger la integridad de los datos y solo son accesibles mediante métodos específicos. Esto ayuda a prevenir modificaciones no autorizadas y garantiza la consistencia de los datos.

•	Flexibilidad y Claridad: La estructura clara y los nombres descriptivos de los métodos facilitan el uso de esta clase en otras partes del sistema, como las interfaces de gestión de préstamos y las operaciones de reporte.

Uso Típico
La clase Lendings se utiliza ampliamente en el sistema para diversas operaciones relacionadas con los préstamos de libros:
1. Registro de Préstamos: Al registrar un nuevo préstamo, se crea una instancia de Lendings y se llena con la información pertinente.
2. Gestión de Devoluciones: Al gestionar la devolución de libros, se actualiza el atributo date_return para reflejar la fecha en que el libro ha sido devuelto.
3. Consulta de Préstamos: Para consultas específicas sobre préstamos activos o históricos, los métodos getters proporcionan una manera fácil de acceder a la información necesaria.

# Clase Users
La clase Users es un modelo crucial para representar los usuarios en nuestro sistema, como parte de una aplicación que requiere manejar datos personales y relacionados con sanciones. A continuación, detallo cada uno de los atributos y métodos de esta clase:

Atributos

•	id: Identificador único para cada usuario en la base de datos.

•	name: Nombre del usuario.

•	last_name_p: Apellido paterno del usuario.

•	last_name_m: Apellido materno del usuario.

•	domicilio: Dirección domiciliaria del usuario.

•	tel: Número de teléfono del usuario.

•	sanctions: Cantidad de sanciones que ha acumulado el usuario.

•	sanc_money: Monto monetario total debido a sanciones.

Métodos de Acceso y Modificación (Getters y Setters)
Cada atributo tiene un método set para establecer su valor y un método get para obtener su valor, permitiendo manipular los datos de forma controlada y segura:
•	setId(int id), getId(): Establece y recupera el ID del usuario.

•	setName(String name), getName(): Asigna y obtiene el nombre del usuario.

•	setLast_name_p(String last_name_p), getLast_name_p(): Configura y devuelve el apellido paterno.

•	setLast_name_m(String last_name_m), getLast_name_m(): Configura y devuelve el apellido materno.

•	setDomicilio(String domicilio), getDomicilio(): Establece y recupera la dirección del usuario.

•	setTel(String tel), getTel(): Establece y obtiene el número de teléfono.

•	setSanctions(int sanctions), getSanctions(): Configura y devuelve el número de sanciones.

•	setSanc_money(int sanc_money), getSanc_money(): Configura y devuelve el total monetario de las sanciones.

Consideraciones de Diseño
•	Encapsulamiento: Todos los atributos son privados, accesibles solo a través de métodos getters y setters, lo que protege la integridad de los datos.

•	Flexibilidad y mantenimiento: La clase está diseñada para ser fácilmente mantenible y extensible, permitiendo cambios futuros en la estructura de datos sin afectar otras partes del sistema.

Uso Típico
La clase Users se utiliza en diversas partes del sistema para:
1. Registro y gestión de usuarios: Crear y actualizar registros de usuarios en la base de datos.
2. Consulta de información: Recuperar datos específicos del usuario para diversos propósitos, como contacto o gestión de sanciones.
3. Implementación de sanciones: Administrar y registrar las sanciones impuestas a los usuarios, asegurando que se mantenga un registro adecuado de las mismas.


# Clase Utils
La clase Utils en tu paquete com.mycompany.utils es un conjunto de herramientas útiles para realizar diversas operaciones, como validaciones, manejo de fechas, y envío de correos electrónicos. Aquí te explico cada método y su función:

Métodos

•	isNumeric(String strNum): Verifica si una cadena es numérica. Retorna true si la cadena puede ser convertida a un número entero, de lo contrario retorna false. Es útil para validaciones de entrada antes 
de realizar operaciones que requieran valores numéricos.

•	getFechaActual(): Retorna la fecha actual en el formato dd-MM-yyyy. Utiliza SimpleDateFormat para formatear la fecha actual, lo cual es útil para registros o cualquier función que requiera la fecha del día.

•	diferenciasDeFechas(Date fechaInicial, Date fechaFinal): Calcula la diferencia en días entre dos fechas. Ambas fechas se convierten a medianoche para asegurar que la diferencia sea calculada en términos completos de días. Retorna el número de días entre las dos fechas.

•	stringToDate(String fecha): Convierte una cadena en formato dd-MM-yyyy a un objeto java.util.Date. Es útil cuando se necesitan realizar operaciones con fechas que se reciben como cadenas de texto.

•	sendEmail(): Envía un correo electrónico utilizando la configuración SMTP de Gmail. Configura las propiedades necesarias para la conexión, autentica usando un nombre de usuario y contraseña, y luego construye y envía un mensaje de correo electrónico. También maneja errores de autenticación y otros problemas de mensajería, informando al usuario mediante cuadros de diálogo.
Consideraciones de Diseño

•	Separación de Responsabilidades: Cada método tiene una responsabilidad clara y definida, lo que hace que la clase sea un recurso reutilizable en diferentes partes de la aplicación.

•	Manejo de Excepciones: Los métodos que involucran formatos y fechas manejan las excepciones internamente, lo que evita que la aplicación falle abruptamente y permite una mayor robustez.

Uso Típico
•	Validaciones: Antes de realizar operaciones que requieran entradas numéricas, isNumeric puede ser utilizado para validar las entradas del usuario.

•	Trabajo con Fechas: Cuando se necesita registrar la fecha actual o calcular diferencias entre fechas, los métodos getFechaActual, diferenciasDeFechas, y stringToDate facilitan estas tareas.

•	Comunicación: Para enviar notificaciones o información a través de correo electrónico, sendEmail puede ser integrado en procesos que requieran enviar mensajes a los usuarios.


# Clase LoanReportChart
La clase LoanReportChart en nuestro proyecto es un ejemplo de cómo podemos generar un reporte visual utilizando la biblioteca JFreeChart. Este reporte incluye gráficos de barras que muestran los libros más y menos prestados, así como los usuarios con más y menos préstamos. A continuación, te explico cómo funciona cada parte del código:

Generación de Gráfico
Creación de documento y página:
•	Se inicia con la creación de un objeto PDDocument y se añade una PDPage al documento.
Contenido del documento:

Utilizando PDPageContentStream, se agrega contenido al documento. Esto incluye texto e ilustraciones como líneas o rectángulos, lo que permite diseñar un documento estructurado y legible.
•	Se añade un título "Biblioteca Trinity" y un subtítulo "Reporte de Préstamo", utilizando diferentes tamaños de fuente para distinguir las secciones.
Información del libro:

Reglas de la biblioteca:
•	Se enumeran varias reglas de la biblioteca, presentadas en una lista que facilita su lectura.
Funcionalidades de escritura y formato:
Márgenes y líneas:

Manejo de texto:
•	Se emplea beginText() y endText() para escribir bloques de texto, y newLineAtOffset() para posicionar cada línea de texto en la página.
Finalización y guardado:
Cerrar contenido y documento:

Guardar el documento:
•	El documento se guarda en el sistema de archivos con el nombre "loan_report_styled.pdf".

Manejo de excepciones:
Excepciones de entrada/salida:
•	Se capturan y se imprimen en la consola para diagnóstico en caso de errores al crear o guardar el documento.

# Clase LoanReportPdf
La clase LoanReportPdf en nuestro proyecto es un ejemplo de cómo podemos generar un reporte en formato PDF utilizando la biblioteca PDFBox. Este reporte incluye información sobre un libro prestado y las reglas de la biblioteca asociadas al préstamo. Aquí te explico cómo funciona cada parte del código:

Generación de PDF
Creación de documento y página:
•	Comenzamos creando un objeto PDDocument, que es básicamente nuestro archivo PDF. Luego, añadimos una PDPage al documento, que será una página del PDF.

Contenido del documento:
•	Utilizamos PDPageContentStream para añadir contenido al documento. Esto incluye tanto texto como gráficos simples como líneas y rectángulos para estructurar mejor el documento.

Detalles específicos del contenido:
Encabezado:
•	Añadimos un título "Biblioteca Trinity" y un subtítulo "Reporte de Préstamo" en la parte superior de la página. Usamos diferentes tamaños de fuente para hacer que el título y el subtítulo destaquen y sean fáciles de identificar.

Información del libro:
•	Presentamos detalles del libro que ha sido prestado, como el título, autor, categoría, fecha de lanzamiento y cantidad de páginas. Esto le da al lector toda la información necesaria sobre el libro de un vistazo.

Reglas de la biblioteca:
•	Incluimos una lista de reglas de la biblioteca. Estas reglas aseguran que los usuarios sepan cómo manejar los libros y utilizar los recursos de la biblioteca correctamente.
Funcionalidades de escritura y formato:

Márgenes y líneas:
•	Dibujamos líneas para crear márgenes alrededor del contenido. Esto ayuda a mantener todo el texto organizado y fácil de leer.

Manejo de texto:
•	Usamos métodos como beginText() y endText() para manejar bloques de texto, y newLineAtOffset() para posicionar el texto en la página de manera precisa.

Finalización y guardado:
Cerrar contenido y documento:
•	Una vez que todo el contenido está añadido, cerramos el PDPageContentStream y luego guardamos el documento PDF en el sistema de archivos con el nombre "ReporteBibliotecaTrinity.pdf".

Guardar el documento:
•	Guardamos el documento para que el archivo PDF pueda ser accedido y leído más tarde.

Manejo de excepciones:
Excepciones de entrada/salida:
•	Capturamos cualquier excepción que pueda ocurrir durante la creación o guardado del documento y las imprimimos en la consola. Esto nos ayuda a diagnosticar y corregir cualquier problema.

Explicación General
La clase LoanReportPdf es súper útil para generar reportes en PDF. Básicamente, tomamos la información de un libro prestado y las reglas de la biblioteca y las ponemos en un documento PDF bien estructurado y fácil de leer. Usamos varias herramientas de PDFBox para añadir texto, dibujar líneas y añadir imágenes, asegurándonos de que el documento final se vea profesional y esté bien organizado. Además, manejamos cualquier error que pueda surgir durante el proceso para asegurarnos de que todo funcione sin problemas.

# Clase DefaultPaginationItemRender
La clase DefaultPaginationItemRender en nuestro proyecto es un ejemplo de cómo personalizar los botones de paginación en una interfaz gráfica utilizando Java Swing. 

Creación de Elementos de Paginación
1.	Método createPaginationItem:
•	Este método es el que se encarga de crear los botones de paginación. Dependiendo de si el botón es para ir a la página anterior, a la siguiente, o simplemente un número de página, se le añade un icono o texto específico.
•	Si es el botón de "anterior", le pone un icono de "Anterior".
•	Si es el botón de "siguiente", le pone un icono de "Siguiente".
•	Si es cualquier otro botón, le pone el valor que representa (por ejemplo, el número de página).
•	Si el botón no está habilitado (por ejemplo, si es la página actual), se le quita la capacidad de enfocarse.

2.	Método createButton:
•	Este método crea un nuevo botón (JButton). Aquí podrías personalizar el botón con más detalles si lo necesitaras.

3.	Método createPreviousIcon:
•	Este método define el icono o texto para el botón de "anterior". En este caso, simplemente devuelve el texto "Anterior".

4.	Método createNextIcon:
•	Este método define el icono o texto para el botón de "siguiente". En este caso, simplemente devuelve el texto "Siguiente".

Explicación General
La clase DefaultPaginationItemRender está diseñada para crear y personalizar los botones que usas para navegar entre páginas en una interfaz gráfica. La idea es que puedas tener botones con iconos o textos específicos para indicar acciones como "ir a la página anterior" o "ir a la página siguiente", además de los botones que representan números de página específicos.

# Interfaz EventPagination
La interfaz EventPagination en nuestro proyecto define un contrato para manejar los eventos de cambio de página en una aplicación que tiene paginación. 

Funcionalidad de la Interfaz
1.	Método pageChanged:
•	Este método se llama cuando hay un cambio de página. La idea es que cada vez que el usuario cambia de página, este método se ejecuta y hace lo que sea necesario para actualizar la vista o los datos que se están mostrando.
•	El parámetro page indica el número de la nueva página a la que se ha cambiado.

Explicación General
La interfaz EventPagination es súper simple pero muy útil. Básicamente, está diseñada para ser implementada por cualquier clase que necesite reaccionar cuando el usuario cambia de página en una interfaz con paginación. Piensa en ella como un contrato que asegura que cualquier clase que la implemente sabrá qué hacer cuando la página cambia.

# Clase Page
La clase Page en nuestro proyecto maneja la paginación, almacenando información crucial sobre la página actual, como si hay una página anterior o siguiente, los elementos de la página actual y el número total de páginas. Aquí te explico cómo funciona cada parte del código de una manera relajada.

Atributos de la Clase
1.	Página Actual (current):
•	Este atributo guarda el número de la página actual que se está mostrando.

2.	Página Anterior (previous):
•	Un booleano que indica si hay una página anterior disponible para navegar.

3.	Página Siguiente (next):
•	Un booleano que indica si hay una página siguiente disponible para navegar.

4.	Elementos de la Página (items):
•	Una lista que contiene los elementos que están presentes en la página actual.

5.	Total de Páginas (totalPage):
•	Este atributo guarda el número total de páginas disponibles.

Constructores
1.	Constructor con Parámetros:
•	Este constructor inicializa todos los atributos de la clase con los valores proporcionados al momento de la creación del objeto. Así puedes crear una página con todos sus detalles desde el principio.
2.	Constructor por Defecto:
•	Un constructor vacío que crea una instancia de Page sin inicializar los atributos. Es útil cuando quieres crear una página y establecer sus atributos más tarde.

Métodos Getter y Setter
•	Los métodos getter y setter permiten acceder y modificar los atributos de la clase. Por ejemplo, puedes usar getCurrent() para obtener el número de la página actual y setCurrent(int current) para establecerlo. Esto es útil para manejar la paginación de manera dinámica en tu aplicación.

Método toString
•	Este método proporciona una representación en forma de cadena de los atributos de la página actual, lo cual es útil para depuración y registro de datos. Básicamente, devuelve una cadena que incluye el número de la página actual, si hay una página anterior o siguiente, y una lista de los elementos de la página.

Clase Interna BreakLabel
•	BreakLabel es una clase interna que representa un marcador para dividir páginas. Tiene su propio atributo para el número de página y un método toString que devuelve "...", indicando un salto o interrupción en la paginación.

Explicación General
La clase Page está diseñada para facilitar la gestión de la paginación en aplicaciones que manejan grandes conjuntos de datos. Con esta clase, puedes fácilmente manejar y navegar entre diferentes páginas de datos, asegurándote de que siempre sabes qué página estás viendo, si puedes ir a la página anterior o siguiente, y cuáles son los elementos que se deben mostrar en la página actual. La clase también incluye un marcador (BreakLabel) para indicar saltos en la paginación, lo que es útil para interfaces de usuario complejas.

# Clase Pagination
La clase Pagination en nuestro proyecto maneja la lógica de paginación para una interfaz gráfica utilizando Java Swing. 

Funcionalidad Principal
1.	Renderizado de Items de Paginación:
•	Utiliza PaginationItemRender para crear y personalizar los botones de paginación, como "Anterior", "Siguiente" y los números de página.

2.	Eventos de Paginación:
•	Implementa una lista de EventPagination para manejar los eventos que ocurren cuando se cambia de página. Estos eventos permiten actualizar la vista o realizar otras acciones necesarias cada vez que se navega a una nueva página.

3.	Atributos Principales:
•	paginationItemRender: Es el renderizador usado para crear los botones de paginación.
•	events: Lista de eventos de paginación.
•	page: Objeto Page que contiene información sobre la página actual, total de páginas y los items de la página.

Métodos Clave
1.	Constructor:
•	Inicializa la clase y configura el renderizador por defecto (DefaultPaginationItemRender), además de establecer un diseño horizontal (BoxLayout).
2.	Método setPagegination:
•	Este método establece la página actual y el total de páginas. Si la página actual es mayor que el total de páginas, se ajusta al total de páginas.
3.	Método changePage:
•	Este método es el encargado de actualizar la interfaz gráfica cuando se cambia de página. Remueve todos los componentes actuales y añade los nuevos botones de paginación.
4.	Método paginate:
•	Este método se encarga de generar la lista de items que se mostrarán en la paginación. Incluye lógica para manejar los saltos (break labels) cuando hay muchas páginas.
5.	Método refresh:
•	Refresca la interfaz gráfica para asegurar que todos los cambios se reflejen correctamente.
6.	Método runEvent:
•	Ejecuta todos los eventos de paginación registrados, permitiendo que otras partes de la aplicación respondan al cambio de página.

Explicación General
La clase Pagination está diseñada para manejar la paginación de manera eficiente en una interfaz gráfica de Java Swing. Con esta clase, puedes navegar fácilmente entre diferentes páginas de datos, asegurándote de que siempre sabes en qué página estás y si puedes ir a la página anterior o siguiente. Los eventos de paginación permiten que otras partes de la aplicación respondan a los cambios de página, actualizando la vista o cargando nuevos datos según sea necesario.

# Interfaz PaginationItemRender
La interfaz PaginationItemRender en nuestro proyecto define cómo se deben crear y renderizar los botones de paginación en una interfaz gráfica utilizando Java Swing. 
Métodos de la Interfaz
1.	createPaginationItem:
•	Este método crea un botón de paginación específico basado en el valor proporcionado y si el botón es para ir a la página anterior, la siguiente, o si es un número de página. También toma en cuenta si el botón debe estar habilitado o no.

2.	createButton:
•	Este método crea un botón (JButton) simple, proporcionando una base que puede ser personalizada más adelante. Los parámetros indican el valor del botón, y si el botón es para ir a la página anterior o siguiente.

3.	createPreviousIcon:
•	Este método devuelve el icono o texto que se debe mostrar en el botón para ir a la página anterior. Esto puede ser un objeto Icon o un String.

4.	createNextIcon:
•	Este método devuelve el icono o texto que se debe mostrar en el botón para ir a la página siguiente. Similar al anterior, puede ser un objeto Icon o un String.

Explicación General
La interfaz PaginationItemRender está diseñada para proporcionar una forma flexible de crear y personalizar los botones de paginación en una aplicación. Cada método tiene un propósito específico para asegurar que los botones se creen y se personalicen de manera adecuada. 

# Clase ButtonUI
La clase ButtonUI en nuestro proyecto es responsable de personalizar la apariencia y comportamiento de los botones en una interfaz gráfica utilizando Java Swing. 

Funcionalidad Principal
1.	Atributos y Estado:
•	hover: Un booleano que indica si el mouse está sobre el botón.
•	button: Una referencia al botón (JButton) que está siendo personalizado.

Métodos Clave
1.	Método installUI:
•	Este método se llama cuando la interfaz de usuario (UI) se instala en un componente. Aquí, personalizamos el botón añadiendo un MouseListener para detectar cuando el mouse entra y sale del botón.
•	Cambia el cursor del botón a una mano (HAND_CURSOR) cuando el mouse está sobre él.
•	Configura el botón para que sea transparente (opaque a false), establece el color de texto a blanco y el color de fondo a un azul específico.
•	También añade un borde vacío alrededor del botón para darle algo de espacio interno.

2.	Método paint:
•	Este método se encarga de pintar el botón en la pantalla.
•	Si el botón está seleccionado o el mouse está sobre él (hover), crea un Graphics2D para dibujar con antialiasing.
•	Cambia el color del botón cuando el mouse está sobre él para proporcionar un efecto visual de "hover".
•	Si el botón está seleccionado, dibuja un rectángulo redondeado con un color específico.
•	Finalmente, llama al método paint de la clase base para pintar el botón de manera estándar.

Explicación General
La clase ButtonUI está diseñada para darle a los botones una apariencia moderna y responsiva en una aplicación Swing. Al personalizar la UI del botón, podemos hacer que los botones cambien de color cuando el mouse está sobre ellos, y proporcionar bordes y formas redondeadas para una mejor estética. Además, el cursor cambia a una mano cuando el usuario pasa el mouse sobre el botón, mejorando la experiencia del usuario.

# Clase FormLogin
La clase FormLogin en nuestro proyecto es una ventana de inicio de sesión para la interfaz de administración de la biblioteca. Utiliza Java Swing para crear y gestionar la interfaz gráfica. 

Funcionalidad Principal
1.	Constructor FormLogin:
•	Este es el constructor de la clase que se llama cuando creas una nueva instancia de FormLogin. Inicializa los componentes de la interfaz gráfica, establece la posición de la ventana al centro de la pantalla y configura el color del texto del campo de usuario.

2.	Método initComponents:
•	Este método se encarga de configurar todos los componentes de la interfaz, como etiquetas, campos de texto, botones, y sus propiedades. Es generado automáticamente por el Form Editor de NetBeans y no debe ser modificado manualmente.

3.	Métodos de Acción:
•	Estos métodos son llamados cuando el usuario interactúa con los componentes de la interfaz, como botones y campos de texto. Por ejemplo, cuando el usuario hace clic en el botón de inicio de sesión, se llama al método btnLogActionPerformed para manejar el evento de inicio de sesión.

Componentes Principales
1.	Panel Principal (jPanel1):
•	El panel principal que contiene todos los otros componentes de la interfaz.
2.	Campos de Texto:
•	jTextUser: Campo de texto para que el usuario ingrese su correo electrónico.
•	jTextPass: Campo de texto para que el usuario ingrese su contraseña.
3.	Botones:
•	btnLog: Botón para iniciar sesión.
•	btnGetInto: Botón para registrarse.
4.	Etiquetas:
•	lblTitle: Título del formulario de inicio de sesión.
•	lblUser: Etiqueta para el campo de usuario.
•	lblPassword: Etiqueta para el campo de contraseña.
•	lblShow: Etiqueta para mostrar la contraseña al pasar el mouse.

Métodos de Acción
1.	btnLogActionPerformed:
•	Este método se ejecuta cuando el usuario hace clic en el botón de iniciar sesión. Valida que los campos de correo y contraseña no estén vacíos, verifica las credenciales del usuario en la base de datos y, si son correctas, abre el panel de administración correspondiente (trabajador o administrador).
2.	btnGetIntoActionPerformed:
•	Este método se ejecuta cuando el usuario hace clic en el botón de registrarse. Oculta la ventana de inicio de sesión y muestra el formulario de registro.
3.	lblShowMouseEntered y lblShowMouseExited:
•	Estos métodos se ejecutan cuando el mouse entra y sale de la etiqueta lblShow, mostrando y ocultando la contraseña respectivamente.
4.	jTextUserMousePressed y jTextPassMousePressed:
•	Estos métodos se ejecutan cuando el usuario hace clic en los campos de texto, limpiando el texto de ayuda y configurando los colores de texto adecuados.
5.	jTextPassKeyTyped:
•	Este método limita la longitud de la contraseña a 8 caracteres.

Explicación General
La clase FormLogin proporciona una interfaz de usuario amigable para que los usuarios puedan iniciar sesión en la aplicación. Utiliza componentes visuales de Java Swing para crear un formulario de inicio de sesión simple y funcional. Los métodos de acción manejan los eventos del usuario, como hacer clic en botones y escribir en campos de texto, asegurando que las credenciales se verifiquen correctamente y que la interfaz se actualice según sea necesario.


# Clase Books
La clase Books es un componente de la interfaz gráfica de usuario (GUI) diseñado para manejar la visualización y gestión de libros en nuestra aplicación. Esta clase extiende de javax.swing.JPanel y está diseñada para integrarse dentro de un sistema más grande, probablemente un gestor de biblioteca.

Constructor y Métodos Iniciales
En el constructor Books(), inicializamos los componentes del panel, establecemos los estilos y cargamos los libros existentes desde la base de datos.

•	InitStyles(): Configura los estilos iniciales del panel, como el color de texto y estilos específicos de componentes como title y bookSearch.

•	LoadBooks(): Carga los libros desde la base de datos mediante DAOBooksImpl y los muestra en jTable1. Utiliza un modelo de tabla (DefaultTableModel) para añadir filas que representan libros.

Componentes de la Interfaz
El panel Books contiene varios botones y un campo de texto para la búsqueda, permitiendo interactuar con la lista de libros:

•	Botones (addButton, editButton, deleteButton): Permiten al usuario añadir, editar y eliminar libros. Estos botones están configurados para interactuar con la base de datos a través de DAOBooksImpl.

•	Campo de búsqueda (bookSearch): Permite al usuario introducir un término de búsqueda para filtrar los libros mostrados en la tabla.

Eventos de la Interfaz

•	addButtonActionPerformed: Llama a Dashboard.ShowJPanel(new UpBooks()) para mostrar el panel de añadir un nuevo libro.

•	editButtonActionPerformed: Edita el libro seleccionado en la tabla. Obtiene el ID del libro seleccionado y carga sus detalles para edición.

•	deleteButtonActionPerformed: Elimina los libros seleccionados en la tabla. Utiliza DAOBooksImpl para eliminar los registros en la base de datos y actualiza la tabla.

•	searchButtonActionPerformed: Filtra los libros mostrados en la tabla según el texto introducido en el campo de búsqueda. Actualiza la tabla para mostrar solo los libros que coinciden con la búsqueda.

Consideraciones de Implementación
1. Interacción con la base de datos: Utiliza DAOBooksImpl para todas las operaciones de la base de datos, asegurando que la lógica de acceso a datos está separada de la lógica de la interfaz de usuario.
2. Validación de entrada: En bookSearchKeyTyped, se asegura que sólo se puedan introducir caracteres numéricos, ideal para sistemas donde el ID del libro es numérico.

# Clase Lendings
La clase Lendings gestiona la interfaz y la lógica necesaria para el proceso de préstamo de libros en nuestra aplicación. Está diseñada para interactuar con varios componentes de la aplicación, incluyendo el acceso a datos a través de DAOs y la generación de documentos PDF.

Inicialización y Configuración
En el constructor Lendings(), inicializamos los componentes de la interfaz gráfica y configuramos los estilos visuales iniciales, además de ocultar ciertas etiquetas que sólo deben mostrarse bajo condiciones específicas:

•	InitStyles(): Establece los estilos visuales para los componentes, como colores y fuentes.

•	setVisibleLabels(boolean visible): Controla la visibilidad de las etiquetas de detalles del libro para mostrarlas solo cuando sea necesario.

Componentes de la Interfaz
La interfaz gráfica incluye campos de texto para ingresar el folio del usuario y el ID del libro, etiquetas para mostrar información del libro seleccionado, y botones para realizar acciones como "Prestar". También utiliza un panel (jPanel1) para organizar visualmente los componentes relacionados con los detalles del libro.
Eventos y Funcionalidad

•	buttonActionPerformed: Este método maneja la lógica cuando se presiona el botón de préstamo. Incluye validaciones de entrada, comprobación de la existencia y disponibilidad del libro y del usuario, y, si todo es correcto, procesa el préstamo del libro.
Integración con el Backend

•	DAOs: Utiliza DAOBooksImpl, DAOUsersImpl, y DAOLendingsImpl para interactuar con la base de datos y manejar la lógica de negocio relacionada con los libros, usuarios, y préstamos.

•	Generación de PDF: Utiliza PDFBox para generar un reporte en formato PDF que resume los detalles del préstamo.

•	Envío de Correos: Configura y envía un correo electrónico con detalles del préstamo adjuntando el reporte en PDF generado.

Generación y Envío de PDF
El método crearPdf() genera un documento PDF detallando el préstamo y las reglas asociadas. Luego, sendEmail() configura y envía este documento como un adjunto por correo electrónico, utilizando propiedades SMTP para la conexión.

Validaciones y Manejo de Errores
Las validaciones aseguran que solo se ingresen números en los campos del folio y ID del libro, y que ambos sean válidos y existan en la base de datos. También verifica que haya disponibilidad del libro seleccionado antes de permitir el préstamo.

# Clase Principal
La clase Principal actúa como un panel de bienvenida para nuestra aplicación, ofreciendo una interfaz inicial que muestra información útil sobre las funciones del sistema de gestión de la biblioteca. Aquí está la descripción detallada de cómo hemos estructurado esta clase y qué hace cada parte del código:

Constructor y Métodos Iniciales

En el constructor Principal(), llamamos a dos métodos fundamentales que configuran el panel:

•	initComponents(): Este método generado por el IDE (NetBeans) inicializa todos los componentes de la interfaz gráfica. Define el layout del panel, etiquetas, y otros componentes visuales. Está marcado para no ser modificado manualmente para evitar conflictos con el diseñador de formularios del IDE.
•	InitStyles(): Configura los estilos visuales para las etiquetas, ajustando propiedades como la fuente y el color. Esto asegura que el panel tenga un aspecto coherente y profesional.
Configuración de Estilo Visual
El método InitStyles() establece los estilos para las etiquetas dentro del panel. Utiliza propiedades de FlatLaf para definir clases de estilo y colores, lo que facilita la consistencia visual en toda la aplicación.

Descripción y Funcionalidades del Sistema
Dentro del panel Principal, varias etiquetas (jLabel2 hasta jLabel11) describen las características y funciones del sistema de gestión de la biblioteca, tales como:

•	Gestión de préstamos y devoluciones.

•	Registro y edición de usuarios y libros.

•	Eliminación de registros.

•	Generación de gráficos y envío de correos electrónicos con fichas de trámite.

Componentes de la Interfaz

•	bg: Es el panel principal que contiene todos los otros componentes.

•	image: Una etiqueta que muestra una imagen decorativa o representativa, cargada desde recursos internos.

•	Etiquetas de texto (jLabel1 a jLabel11): Proporcionan información sobre las funcionalidades del sistema y orientaciones generales.

Layout y Presentación

La disposición de los componentes se maneja a través de GroupLayout, que es flexible y potente para crear interfaces complejas. Este layout permite posicionar de manera precisa cada componente en el panel.
Uso del Panel Principal
Este panel es la primera pantalla que los usuarios ven al iniciar la aplicación. Proporciona una introducción clara a lo que pueden hacer dentro del sistema, orientándolos sobre cómo navegar y qué esperar de las diferentes funcionalidades disponibles.


# Clase Reports
La clase Reports es un panel que muestra informes relacionados con los préstamos de libros en la biblioteca. Aquí está la descripción detallada de su estructura y funcionalidad:
Constructor y Métodos Iniciales
El constructor Reports() inicializa el panel y carga los préstamos de libros al mismo tiempo.

•	initComponents(): Este método generado por el IDE (NetBeans) inicializa todos los componentes de la interfaz gráfica, incluyendo etiquetas, botones y tablas. Está marcado para no ser modificado manualmente para evitar conflictos con el diseñador de formularios del IDE.

•	InitStyles(): Configura los estilos visuales para el título del panel.

•	LoadLendings(): Carga los préstamos de libros desde la base de datos y los muestra en la tabla.

Carga de Préstamos
Este método carga los préstamos de libros desde la base de datos utilizando la implementación del DAO DAOLendingsImpl. Luego, actualiza la tabla para mostrar los préstamos.

Componentes de la Interfaz
•	bg: Es el panel principal que contiene todos los otros componentes.

•	title: El título del panel que indica que se trata de informes.

•	jButton2: Un botón que permite actualizar los informes.

•	jTable1: Una tabla que muestra los préstamos de libros, incluyendo información sobre el ID del usuario, el ID del libro, la fecha de salida y la fecha de entrega.

Uso del Panel Reports
Este panel proporciona una manera fácil para que los usuarios vean los préstamos de libros en la biblioteca. Pueden actualizar los informes con un solo clic del botón "Actualizar", lo que les permite mantenerse al día con la información más reciente sobre los préstamos.

# Clase Returns
La clase Returns en tu paquete de vistas gestiona la interfaz para la devolución de libros en la biblioteca, asegurando que cada transacción se registre adecuadamente y aplicando sanciones si es necesario. Aquí te detallo cómo está organizada y sus principales funcionalidades:

Constructor y Métodos Iniciales
En el constructor Returns(), se inicializan los componentes y se configuran los estilos iniciales, además de ocultar ciertas etiquetas hasta que sean necesarias.

•	InitStyles(): Establece los estilos visuales para los componentes, como colores y fuentes.

•	setVisibleLabels(boolean visible): Controla la visibilidad de las etiquetas de detalles del libro para mostrarlas solo cuando se verifica que el libro debe ser devuelto.

Componentes de la Interfaz

•	Etiquetas y Texto: Muestra la información relevante sobre los libros y usuarios. Los detalles del libro devuelto y del usuario son visualizados solo si el préstamo es verificado.

•	jPanel1: Agrupa visualmente los componentes relacionados con los detalles del libro.

•	Botones (button): Permiten ejecutar la devolución del libro.

Funcionalidad de Devolución
El botón "Devolver" inicia el proceso de devolución del libro:

•	Validación de Entradas: Verifica que los campos del folio del usuario y el ID del libro no estén vacíos y sean numéricos.

•	Obtención y Verificación de Datos: Utiliza los DAOs para verificar la existencia del usuario y del libro, así como la validez del préstamo.

•	Cálculo de Sanciones: Si el libro se devuelve tarde, se calculan las sanciones basadas en los días de retraso y se actualizan los registros del usuario.

Gestión de Sanciones
Si un libro se devuelve con retraso, se aplican sanciones monetarias y de registro, utilizando los valores predefinidos para calcular el total debido.

Visualización de Datos
•	setVisibleLabels(true): Muestra los detalles del libro si el préstamo está confirmado y listo para ser devuelto.

Uso y Funcionamiento
Esta clase es esencial para el módulo de gestión de la biblioteca, proporcionando una interfaz clara y funcional para las devoluciones. Ayuda a mantener un registro preciso de los movimientos de los libros y asegura que las políticas de la biblioteca sean respetadas mediante la aplicación de sanciones cuando sea necesario.

# Clase UpUsers
La clase UpUsers se utiliza para gestionar el registro y edición de usuarios en el sistema de una biblioteca. Proporciona una interfaz de usuario para introducir y modificar información de usuarios.
Constructores

1.	Constructor Predeterminado (UpUsers()): Utilizado para registrar un nuevo usuario.
2.	Constructor de Edición (UpUsers(com.mycompany.models.Users user)): Utilizado para editar un usuario existente. Recibe un objeto Users como parámetro con la información del usuario a editar.

Métodos y Funcionalidades

•	InitStyles(): Establece los estilos visuales de los componentes y carga los datos del usuario en los campos si está en modo de edición. Los placeholders de los campos de texto también se establecen aquí.

•	buttonActionPerformed(evt): Maneja la lógica para el botón de "Registrar" o "Guardar". Realiza validaciones de los campos y, dependiendo de si es un registro o edición, llama al método correspondiente del DAOUsers para registrar o modificar el usuario en la base de datos.

Componentes UI

•	Campos de Texto (JTextField): Para ingresar el nombre, apellidos, domicilio, y correo electrónico del usuario.

•	Botón (JButton): Para enviar la información del formulario a la base de datos. El texto del botón cambia dependiendo de si estás registrando un nuevo usuario o editando uno existente.

•	Etiquetas (JLabel): Indican qué información debe ser introducida en cada campo de texto.

Validaciones
Se realizan validaciones para asegurar que todos los campos estén llenos y que el correo electrónico tenga un dominio conocido. Además, se genera un código de verificación enviado por correo electrónico para validar la identidad del usuario.

Flujo de Trabajo

•	Para nuevos usuarios: El usuario llena los campos y presiona "Registrar". Si las validaciones son correctas, el usuario se añade a la base de datos.

•	Para editar usuarios: Los datos del usuario se cargan en los campos para que el usuario pueda modificarlos. Después de realizar los cambios y presionar "Guardar", si las validaciones son correctas, los cambios se guardan en la base de datos.

Uso y Funcionamiento
1. Esta clase es crucial para la gestión de usuarios en la biblioteca, permitiendo a los administradores mantener un control eficiente y efectivo sobre la información de los usuarios, facilitando tanto la incorporación de nuevos usuarios como la actualización de los existentes en el sistema. 

# Clase Users
La clase Users en Java se utiliza para gestionar la visualización y manipulación de usuarios en una interfaz de biblioteca. Permite buscar, agregar, editar y eliminar usuarios a través de una interfaz gráfica de usuario.

Funciones y Características

•	Visualización de Usuarios: Muestra una lista de usuarios en una tabla (jTable1), incluyendo ID, nombre, apellidos, domicilio y correo electrónico.

•	Buscar Usuarios: Permite buscar usuarios por nombre a través de un campo de texto (userSearch).

•	Agregar Nuevo Usuario: Abre un formulario para registrar un nuevo usuario.

•	Editar Usuario Existente: Permite modificar la información de un usuario seleccionado.

•	Eliminar Usuario: Elimina uno o más usuarios seleccionados de la base de datos.

Métodos Principales

•	InitStyles(): Configura los estilos visuales iniciales de los componentes de la interfaz.

•	LoadUsers(): Carga y muestra todos los usuarios en la tabla al iniciar la clase.

•	buttonActionPerformed Eventos: Gestiona las acciones de los botones para agregar, editar y eliminar usuarios.
Componentes UI

•	jTable1: Una tabla que muestra la lista de usuarios.

•	userSearch: Un campo de texto para introducir el nombre del usuario a buscar.

•	searchButton: Botón para iniciar la búsqueda.

•	addButton, editButton, deleteButton: Botones para agregar, editar y eliminar usuarios, respectivamente.
Interacción con el Backend

•	Utiliza la interfaz DAOUsers para interactuar con la base de datos y realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre la tabla de usuarios.

Flujo de Trabajo
1.	Carga de Usuarios: Al iniciar la clase, se cargan todos los usuarios disponibles en la base de datos y se muestran en la tabla.
2.	Buscar Usuarios: El usuario puede buscar específicamente por nombre usando el campo userSearch y el botón searchButton.
3.	Agregar Usuario: Al hacer clic en addButton, se abre el formulario UpUsers para ingresar los datos de un nuevo usuario.
4.	Editar Usuario: Seleccionando un usuario de la lista y haciendo clic en editButton, se carga la información del usuario en UpUsers para su edición.
5.	Eliminar Usuario: Se pueden seleccionar uno o más usuarios y eliminarlos usando el deleteButton.

Uso y Funcionamiento

Esta clase es esencial para la gestión de usuarios dentro del sistema de la biblioteca, proporcionando una interfaz fácil de usar para realizar todas las operaciones necesarias sobre los datos de los usuarios, lo que ayuda a mantener actualizada la información relevante y asegura el buen funcionamiento del sistema de gestión de la biblioteca.

# INSTALACION
 1. Descraga el archivo zip
![trrdfdf](https://github.com/FrancoMU214/Componente/assets/168498647/2a793a83-0244-467a-a65c-d69f93155c3d)

 2. Importa el proyecto en tu IDE preferido (NeatBeans o VS code).
 3. Asegurese de que el proyecto se compila sin errores para crear el .jar segun la version de java que disponga.

# USO
1. Verificaremos que la descarga se haya realizado exitosamente
![1](https://github.com/FrancoMU214/Componente/assets/168498647/d80cd365-740e-4b9c-9a53-41d8303db18c)
2. Extraeremos nuestro proyecto para obtener la carpeta necesaria
![Reproductor multimedia 29_04_2024 10_50_21 p  m](https://github.com/FrancoMU214/Componente/assets/168498647/9334b1eb-5754-4e34-ae04-62da5c88d985)
3. Ahora crearemos abriremos nuestro proyecto
![Reproductor multimedia 29_04_2024 10_50_39 p  m](https://github.com/FrancoMU214/Componente/assets/168498647/0ba6b7c0-ba68-4e8f-a59f-ec34d95da6c5)
4. Ahora seleccioanaremos el proyecto componentes
![Reproductor multimedia 29_04_2024 10_50_44 p  m](https://github.com/FrancoMU214/Componente/assets/168498647/bc4088ca-40eb-432c-b7ae-a3aa3ef0061c)
5. y ya, ahora podremos hacer uso del proyecto

# FUNCIONAMIENTO
Para cualquier duda pueden consultar el siguiente enlace que proporciona los pasos mas detallados: 

# CONTRIBUIR
En caso de querer contribuir a este proyecto, por favor sigue los siguientes pasos: 

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu característica o corrección de errores.
3. Haz tus cambios.
3. Envía un pull request.

# AUTORES
Jonathan Eliezer Martinez Miguel-Estudiante ITO - (Contacto: jonmartinez902@gmail.com)

Franco Matias Uziel-Estudiante ITO - (Contacto: cuentafranco214@gmail.com)

# AGRADECIMIENTO
1. Principalmente a los perritos(luka, leica) y periquito tuntun que estuvieron despiertos con nosotros todas las noches en las que se avanzaba con el proyecto.

2. A nosostros por acabar con el proyecto, antes de que el proyecto acabara con nostros.

3. A Dios.

4. A Adrian marcelo y la mole por sus videos en youtube (radar y hermanos de leche) que nos mantuvieron entretenidos esas tardes en donde no compilaban los codigos.

5. A mis intimos amigos Julion y Alfredito por 'Me da verguenza' y 'Volvera', iconicos PDALovers.

6. A gepetto, sin el cual este proyecto no veria la luz, asi tambien a mi compadre Toño.

7. A ella por darme animos siempre.

8. A ti por creer en nosotros.

Finalment m'agradaria demanar-te perdó míster, sempre vas donar el millor per al club i per a l'equip, llastimosament les formes van ser doloroses per ambdues parts, et desitjo el millor avui i sempre llegenda, aquesta serà casa teva per a l'eternitat, els carrers mai oblidaran a Xavier Hernández Creus, 6ràcies <3
