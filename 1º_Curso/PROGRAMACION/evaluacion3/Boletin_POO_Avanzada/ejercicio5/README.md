Se desea realizar un gestor de cuerpos celestes. Para ello se pide generar el
siguiente esquema de clases:
a) Clase Astro:
• Con propiedades privadas nombre (String) y radio (double).
• Al guardar el nombre lo hará en mayúsculas y eliminando posibles espacios
en los extremos del nombre.
• Habrá una sobrecarga del get con un parámetro tipo carácter que devuelve el
nombre con sus letras separadas por ese caracter. Por ejemplo si se llama
getNombre('_') a un astro denominado “SOL” devuelve “S_O_L”.
• Al guardar el radio se comprueba que sea positivo, si no fuera así lanza la
excepción RadioNegativoException creada por ti.
• Sobreescribe equals de forma que se considera que dos astros son iguales si
son iguales sus nombres y además son de la misma clase.
• Sobreescribe toString de forma que devuelva el nombre según getNombre y
el radio con 2 decimales.

b) Clase Planeta:
• Hereda de Astro y dispone de una propiedad privada booleana denominada
gaseoso con set y get.
• Otra propiedad pública que será una colección de Astros que serán los
satélites.
• Tendrá dos constructores, uno que inicialice los miembros nombre, radio y
gaseoso con parámetros y la colección de satélites vacía.
• El otro constructor sin parámetros que inicializa a “” nombre, 0 radio y false
la propiedad gaseoso llamando al primer constructor.
c) En el programa principal (Mételo en otra clase y package distintos a las clases
anteriores) se crea una colección de Astros y el siguiente menú:
• Añade Planeta: Pregunta si es gaseoso y pide el nombre y radio. También
pregunta cantidad de lunas y se introducirán sus nombres y radios.
• Añade otro astro: Pide su nombre y radio.
• Mostrar datos: Muestra toda la colección detectando si es Astro o Planeta
para mostrar todos sus datos. En el caso de Astro simplemente llama a
toString() y lo muestra, en el caso de Planetas muestra todos los datos y en
particular llamando a getNombre con parámetro ‘.’
• Elimina repetidos. Busca Astros/Planetas iguales (aprovecha el
equals/indexOf/lastIndexOf ) y elimina todas las apariciones menos la
primera.
• Salir. Como siempre no sale de la aplicaci ón hasta que se selecciona esta
opción.