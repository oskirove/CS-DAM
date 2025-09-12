# Sistemas Informáticos - 1º DAM

## Índice
1. [Sistemas de numeración. Código Binario](#tema-1-sistemas-de-numeración-código-binario)
    - [Sistemas de Numeración](#sistemas-de-numeración)
    - [Código Binario](#código-binario)
    - [Conversiones de Unidades de Almacenamiento](#conversiones-de-unidades-de-almacenamiento)
2. [Arquitecturas de ordenadores. Memoria](#tema-2-arquitecturas-de-ordenadores-memoria)
    - [Arquitectura de Von Neumann](#arquitectura-de-von-neumann)
    - [Arquitectura de Harvard](#arquitectura-de-harvard)
    - [Comparación y Uso Actual](#comparación-y-uso-actual)
    - [Tipos de Memoria](#tipos-de-memoria)
3. [Hardware](#tema-3-hardware)
    - [Componentes Principales](#componentes-principales)
4. [Sistema de archivos. Particiones](#tema-4-sistema-de-archivos-particiones)
    - [Tipos de Sistemas de Archivos](#tipos-de-sistemas-de-archivos)
    - [Particiones](#particiones)
5. [Consola de Windows. Programación en batch](#tema-5-consola-de-windows-programación-en-batch)
    - [Comandos Básicos](#comandos-básicos)
    - [Comandos de Gestión de Archivos y Directorios](#comandos-de-gestión-de-archivos-y-directorios)
    - [Comandos de Información del Sistema](#comandos-de-información-del-sistema)
    - [Comandos de Red](#comandos-de-red)
    - [Comandos de Administración de Usuarios](#comandos-de-administración-de-usuarios)
    - [Comandos de Programación en Batch](#comandos-de-programación-en-batch)
    - [Programación en Batch](#programación-en-batch)
6. [Consola de Linux. Programación básica de scripts](#tema-6-consola-de-linux-programación-básica-de-scripts)
    - [Comandos Básicos](#comandos-básicos-1)
    - [Comandos de Gestión de Archivos y Directorios](#comandos-de-gestión-de-archivos-y-directorios-1)
    - [Comandos de Información del Sistema](#comandos-de-información-del-sistema-1)
    - [Comandos de Red](#comandos-de-red-1)
    - [Comandos de Administración de Usuarios](#comandos-de-administración-de-usuarios-1)
    - [Comandos de Programación en Bash](#comandos-de-programación-en-bash)
    - [Programación en Bash](#programación-en-bash)
7. [Configuración local de Windows](#tema-7-configuración-local-de-windows)
    - [Ajustes Comunes](#ajustes-comunes)
8. [Redes de ordenadores. IPs. Subnetting](#tema-8-redes-de-ordenadores-ips-subnetting)
    - [Modelos de Referencia](#modelos-de-referencia)
    - [Direccionamiento IP](#direccionamiento-ip)
    - [Subnetting](#subnetting)
    - [Protocolos de Red](#protocolos-de-red)

## Primera Evaluación

### Tema 1: Sistemas de numeración. Código Binario

Los sistemas de numeración son métodos para representar números. Los más comunes son el sistema decimal, binario, octal y hexadecimal.

#### Sistemas de Numeración

| Sistema | Base | Dígitos Utilizados |
|---------|------|--------------------|
| Decimal | 10   | 0-9                |
| Binario | 2    | 0, 1               |
| Octal   | 8    | 0-7                |
| Hexadecimal | 16 | 0-9, A-F          |

#### Código Binario

El código binario es la base de la informática. Cada bit puede ser 0 o 1.

>[!TIP]
> Para convertir de decimal a binario, divide el número por 2 y anota el residuo. Repite hasta que el cociente sea 0.

#### Conversiones de Unidades de Almacenamiento

**Bits y sus Múltiplos:**

| Unidad           | Equivalencia                  | Equivalencia en Base 2            |
|------------------|-------------------------------|-----------------------------------|
| 1 Bit            | 1 Bit                         | 1 Bit                             |
| 1 Kilobit (Kb)   | 1024 Bits                     | 2¹⁰ Bits                          |
| 1 Megabit (Mb)   | 1024 Kilobits                 | 2²⁰ Bits                          |
| 1 Gigabit (Gb)   | 1024 Megabits                 | 2³⁰ Bits                          |
| 1 Terabit (Tb)   | 1024 Gigabits                 | 2⁴⁰ Bits                          |

**Bytes y sus Múltiplos:**
| Unidad           | Equivalencia                  | Equivalencia en Base 2            | Equivalencia en Bits             |
| Unidad           | Equivalencia                  | Equivalencia en Base 2            | Equivalencia en Bits             |
|------------------|-------------------------------|-----------------------------------|----------------------------------|
| 1 Byte           | 8 Bits                        | 2³ Bits                           | 2³ Bits                          |
| 1 Kilobyte (KB)  | 1024 Bytes                    | 2¹⁰ Bytes                         | 2¹³ Bits                         |
| 1 Megabyte (MB)  | 1024 Kilobytes                | 2²⁰ Bytes                         | 2²³ Bits                         |
| 1 Gigabyte (GB)  | 1024 Megabytes                | 2³⁰ Bytes                         | 2³³ Bits                         |

### Tema 2: Arquitecturas de ordenadores. Memoria

La arquitectura de un ordenador define su estructura y funcionamiento. Existen dos arquitecturas principales: la arquitectura de Von Neumann y la arquitectura de Harvard.

#### Arquitectura de Von Neumann

La arquitectura de Von Neumann, propuesta por John von Neumann en 1945, es la base de la mayoría de los ordenadores actuales. En esta arquitectura, la memoria y los dispositivos de entrada/salida comparten el mismo bus de datos y direcciones.

**Características:**
- **Memoria Unificada:** Tanto los datos como las instrucciones se almacenan en la misma memoria.
- **Bus Único:** Un solo bus para datos e instrucciones.
- **Secuencialidad:** Las instrucciones se ejecutan de manera secuencial.

**Esquema:**

```
+-------------------+
| Unidad de Control |
+-------------------+
         |
         v
+-------------------+
| Unidad Aritmética |
| y Lógica (ALU)    |
+-------------------+
         |
         v
+-------------------+
| Memoria           |
| (Datos e          |
| Instrucciones)    |
+-------------------+
         |
         v
+-------------------+
| Dispositivos de   |
| Entrada/Salida    |
+-------------------+
```

#### Arquitectura de Harvard

La arquitectura de Harvard, desarrollada en la década de 1940 en la Universidad de Harvard, utiliza memorias separadas para datos e instrucciones, lo que permite un acceso simultáneo y más rápido.

**Características:**
- **Memoria Separada:** Datos e instrucciones se almacenan en memorias diferentes.
- **Buses Separados:** Buses independientes para datos e instrucciones.
- **Paralelismo:** Permite la ejecución paralela de instrucciones y acceso a datos.

**Esquema:**

```
+-------------------+
| Unidad de Control |
+-------------------+
         |
         v
+-------------------+
| Unidad Aritmética |
| y Lógica (ALU)    |
+-------------------+
         |
         v
+-------------------+       +-------------------+
| Memoria de        |       | Memoria de        |
| Instrucciones     |       | Datos             |
+-------------------+       +-------------------+
         |                         |
         v                         v
+-------------------+       +-------------------+
| Bus de            |       | Bus de            |
| Instrucciones     |       | Datos             |
+-------------------+       +-------------------+
         |                         |
         v                         v
+-------------------+       +-------------------+
| Dispositivos de   |       | Dispositivos de   |
| Entrada/Salida    |       | Entrada/Salida    |
+-------------------+       +-------------------+
```

#### Comparación y Uso Actual

- **Von Neumann:** Es la arquitectura más utilizada en los ordenadores personales y servidores debido a su simplicidad y eficiencia en la ejecución secuencial de instrucciones.
- **Harvard:** Se utiliza principalmente en sistemas embebidos y microcontroladores donde la velocidad y el paralelismo son cruciales.

En resumen, la arquitectura de Von Neumann ha perdurado en el tiempo y es la base de la mayoría de los sistemas informáticos actuales, mientras que la arquitectura de Harvard se emplea en aplicaciones específicas que requieren alta velocidad y eficiencia.


#### Tipos de Memoria

- **RAM (Memoria de Acceso Aleatorio)**: Volátil y rápida.
- **ROM (Memoria de Solo Lectura)**: No volátil y contiene el firmware.
- **Memoria Caché**: Rápida y pequeña, almacena datos temporales.

>[!NOTE]
> La memoria caché mejora significativamente el rendimiento del sistema.

### Tema 3: Hardware

El hardware se refiere a los componentes físicos del ordenador.

#### Componentes Principales

- **CPU (Unidad Central de Procesamiento)**: El cerebro del ordenador.
- **GPU (Unidad de Procesamiento Gráfico)**: Maneja gráficos y procesamiento paralelo.
- **Dispositivos de Entrada/Salida**: Teclado, ratón, monitor, etc.

### Tema 4: Sistema de archivos. Particiones

Un sistema de archivos organiza y almacena datos en un dispositivo de almacenamiento.

#### Tipos de Sistemas de Archivos

- **FAT32**: Compatible con muchos sistemas, pero con limitaciones de tamaño.
- **NTFS**: Sistema de archivos de Windows con soporte para permisos y cifrado.
- **EXT4**: Sistema de archivos de Linux, eficiente y robusto.

#### Particiones

Las particiones dividen un disco en secciones independientes.

>[!IMPORTANT]
> Realizar particiones adecuadas puede mejorar la organización y el rendimiento del sistema.

---

## Segunda Evaluación

### Tema 5: Consola de Windows. Programación en batch

La consola de Windows permite interactuar con el sistema operativo mediante comandos.

#### Comandos Básicos

- **dir**: Lista archivos y directorios.
    ```batch
    dir
    ```
- **cd**: Cambia el directorio actual.
    ```batch
    cd C:\Users
    ```
- **copy**: Copia archivos de un lugar a otro.
    ```batch
    copy file.txt D:\Backup
    ```
- **del**: Elimina archivos.
    ```batch
    del file.txt
    ```

#### Comandos de Gestión de Archivos y Directorios

- **mkdir**: Crea un nuevo directorio.
    ```batch
    mkdir NewFolder
    ```
- **rmdir**: Elimina un directorio.
    ```batch
    rmdir OldFolder
    ```
- **move**: Mueve archivos o directorios a una nueva ubicación.
    ```batch
    move file.txt D:\Documents
    ```

#### Comandos de Información del Sistema

- **systeminfo**: Muestra información detallada del sistema.
    ```batch
    systeminfo
    ```
- **tasklist**: Lista todos los procesos en ejecución.
    ```batch
    tasklist
    ```
- **taskkill**: Termina un proceso en ejecución.
    ```batch
    taskkill /IM notepad.exe /F
    ```

#### Comandos de Red

- **ipconfig**: Muestra la configuración de red del sistema.
    ```batch
    ipconfig
    ```
- **ping**: Verifica la conectividad con otro dispositivo de red.
    ```batch
    ping google.com
    ```
- **netstat**: Muestra estadísticas de red y conexiones activas.
    ```batch
    netstat -an
    ```

#### Comandos de Administración de Usuarios

- **net user**: Administra cuentas de usuario.
    ```batch
    net user username /add
    ```
- **net localgroup**: Administra grupos locales.
    ```batch
    net localgroup Administrators username /add
    ```

#### Comandos de Programación en Batch

- **set**: Establece variables de entorno.
    ```batch
    set PATH=C:\NewPath;%PATH%
    ```
- **echo**: Muestra mensajes en la consola.
    ```batch
    echo Hello, World!
    ```
- **pause**: Pausa la ejecución del script hasta que se presione una tecla.
    ```batch
    pause
    ```


#### Programación en Batch

Los scripts batch automatizan tareas en Windows.

##### Estructuras Básicas

- **Variables**: Las variables en batch se definen usando el comando `set`.
    ```batch
    set variable=value
    ```
    Ejemplo:
    ```batch
    set name=John
    set age=30
    echo %name%
    echo %age%
    ```

- **Condicionales**: `if condition (command)`
    ```batch
    if %age% GEQ 18 (
        echo You are an adult.
    )
    ```
    **Condicionales con else if**:
    ```batch
    if %age% LSS 18 (
        echo You are a minor.
    ) else if %age% GEQ 18 (
        echo You are an adult.
    )
    ```

- **Bucles for**: `for %%variable in (set) do command`
    ```batch
    for %%i in (1 2 3) do (
        echo Number: %%i
    )
    ```

- **Bucles while**: Batch no tiene un bucle `while` nativo, pero se puede simular con `goto`.
    ```batch
    set count=1
    :while
    if %count% LEQ 5 (
        echo Count: %count%
        set /a count+=1
        goto while
    )
    ```

- **Bucles do while**: Similar al `while`, se puede simular con `goto`.
    ```batch
    set count=1
    :do_while
    echo Count: %count%
    set /a count+=1
    if %count% LEQ 5 goto do_while
    ```

- **Switch case**: Batch no tiene un `switch` nativo, pero se puede simular con `goto`.
    ```batch
    set fruit=apple
    goto %fruit%

    :apple
    echo Apple pie
    goto end

    :banana
    echo Banana split
    goto end

    :end
    ```

##### Tipos de Operadores

- **Operadores Aritméticos**: `+ - * / %`
    ```batch
    set /a sum=10+5
    echo Sum: %sum%
    ```

- **Operadores de Comparación**: `== != LSS LEQ GTR GEQ`
    ```batch
    if %a% == %b% (
        echo a is equal to b
    )
    ```

- **Operadores Lógicos**: `&& || !`
    ```batch
    if %a% GTR 0 && %b% GTR 0 (
        echo Both a and b are positive
    )
    ```

>[!TIP]
> Utiliza `echo` para imprimir mensajes en la consola.

### Tema 6: Consola de Linux. Programación básica de scripts

La consola de Linux es una herramienta poderosa para administrar el sistema.

#### Comandos Básicos

- **ls**: Lista archivos y directorios.
    ```bash
    ls -l
    ```
- **cd**: Cambia el directorio actual.
    ```bash
    cd /home/user
    ```
- **cp**: Copia archivos.
    ```bash
    cp file.txt /backup/
    ```
- **rm**: Elimina archivos.
    ```bash
    rm file.txt
    ```

#### Comandos de Gestión de Archivos y Directorios

- **mkdir**: Crea un nuevo directorio.
    ```bash
    mkdir new_folder
    ```
- **rmdir**: Elimina un directorio vacío.
    ```bash
    rmdir old_folder
    ```
- **mv**: Mueve o renombra archivos y directorios.
    ```bash
    mv old_name.txt new_name.txt
    ```

#### Comandos de Información del Sistema

- **uname**: Muestra información del sistema.
    ```bash
    uname -a
    ```
- **df**: Muestra el uso del espacio en disco.
    ```bash
    df -h
    ```
- **top**: Muestra los procesos en ejecución.
    ```bash
    top
    ```

#### Comandos de Red

- **ifconfig**: Muestra la configuración de red.
    ```bash
    ifconfig
    ```
- **ping**: Verifica la conectividad con otro dispositivo de red.
    ```bash
    ping google.com
    ```
- **netstat**: Muestra estadísticas de red y conexiones activas.
    ```bash
    netstat -tuln
    ```

#### Comandos de Administración de Usuarios

- **useradd**: Crea un nuevo usuario.
    ```bash
    sudo useradd newuser
    ```
- **passwd**: Cambia la contraseña de un usuario.
    ```bash
    sudo passwd newuser
    ```
- **usermod**: Modifica una cuenta de usuario.
    ```bash
    sudo usermod -aG sudo newuser
    ```

#### Comandos de Programación en Bash

- **echo**: Muestra mensajes en la consola.
    ```bash
    echo "Hello, World!"
    ```
- **read**: Lee la entrada del usuario.
    ```bash
    read -p "Enter your name: " name
    ```
- **exit**: Termina un script.
    ```bash
    exit 0
    ```

#### Programación en Bash

Los scripts bash son esenciales para la automatización en Linux.

##### Estructuras Básicas

- **Variables**: `variable=value`
    ```bash
    name="John"
    ```
- **Condicionales**: `if [ condition ]; then command; fi`
    ```bash
    if [ "$name" == "John" ]; then echo "Hello, John!"; fi
    ```
- **Bucles**: `for variable in list; do command; done`
    ```bash
    for i in 1 2 3; do echo $i; done
    ```

>[!NOTE]
> Los scripts bash deben comenzar con `#!/bin/bash`.

#### Programación en Bash

Los scripts bash son esenciales para la automatización en Linux.

##### Estructuras Básicas

- **Variables**: Las variables en bash se pueden definir de varias maneras y pueden almacenar diferentes tipos de datos.

    - **Asignación Simple**: Se asigna un valor a una variable sin espacios alrededor del signo igual.
        ```bash
        name="John"
        age=30
        ```

    - **Asignación con Comillas**: Se pueden usar comillas simples o dobles para asignar valores que contienen espacios o caracteres especiales.
        ```bash
        greeting='Hello, World!'
        path="/home/user/Documents"
        ```

    - **Asignación con Comillas Dobles y Variables**: Las comillas dobles permiten la expansión de variables dentro de la cadena.
        ```bash
        user="Alice"
        welcome_message="Welcome, $user!"
        ```

    - **Asignación con Comillas Simples**: Las comillas simples no permiten la expansión de variables.
        ```bash
        user="Alice"
        welcome_message='Welcome, $user!'  # Esto imprimirá literalmente $user
        ```

    - **Asignación de Comandos**: Se puede asignar la salida de un comando a una variable usando la sintaxis de comillas invertidas o `$(...)`.
        ```bash
        current_date=$(date)
        current_directory=`pwd`
        ```

    - **Variables Posicionales**: Se utilizan para acceder a los argumentos pasados a un script.
        ```bash
        echo "First argument: $1"
        echo "Second argument: $2"
        ```

    - **Variables Especiales**: Bash tiene varias variables especiales predefinidas.
        ```bash
        echo "Script name: $0"  # Nombre del script
        echo "Number of arguments: $#"  # Número de argumentos
        echo "All arguments: $@"  # Todos los argumentos
        echo "Exit status of last command: $?"  # Estado de salida del último comando
        echo "Process ID of the script: $$"  # ID del proceso del script
        ```

    - **Variables de Entorno**: Se pueden exportar variables para que estén disponibles en los procesos hijos.
        ```bash
        export PATH="/usr/local/bin:$PATH"
        export EDITOR="vim"
        ```

    - **Variables de Solo Lectura**: Se pueden declarar variables como de solo lectura para evitar que se modifiquen.
        ```bash
        readonly pi=3.14159
        ```

    - **Eliminación de Variables**: Se pueden eliminar variables usando `unset`.
        ```bash
        unset name
        ```

    Ejemplos:
    ```bash
    # Asignación simple
    name="John"
    age=30

    # Asignación con comillas
    greeting="Hello, World!"
    path="/home/user/Documents"

    # Asignación de comandos
    current_date=$(date)
    current_directory=`pwd`

    # Variables posicionales
    echo "First argument: $1"
    echo "Second argument: $2"

    # Variables especiales
    echo "Script name: $0"
    echo "Number of arguments: $#"
    echo "All arguments: $@"
    echo "Exit status of last command: $?"
    echo "Process ID of the script: $$"

    # Variables de entorno
    export PATH="/usr/local/bin:$PATH"
    export EDITOR="vim"

    # Variables de solo lectura
    readonly pi=3.14159

    # Eliminación de variables
    unset name
    ```

- **Condicionales**: `if [ condition ]; then command; fi`
    ```bash
    if [ "$name" == "John" ]; then
        echo "Hello, John!"
    fi
    ```

- **Condicionales con else if**: `if [ condition ]; then command; elif [ condition ]; then command; else command; fi`
    ```bash
    if [ "$age" -lt 18 ]; then
        echo "You are a minor."
    elif [ "$age" -ge 18 ] && [ "$age" -lt 65 ]; then
        echo "You are an adult."
    else
        echo "You are a senior."
    fi
    ```

- **Bucles for**: `for variable in list; do command; done`
    ```bash
    for i in 1 2 3; do
        echo "Number: $i"
    done
    ```

- **Bucles while**: `while [ condition ]; do command; done`
    ```bash
    count=1
    while [ $count -le 5 ]; do
        echo "Count: $count"
        ((count++))
    done
    ```

- **Bucles until**: `until [ condition ]; do command; done`
    ```bash
    count=1
    until [ $count -gt 5 ]; do
        echo "Count: $count"
        ((count++))
    done
    ```

- **Switch case**: `case value in pattern) command ;; esac`
    ```bash
    fruit="apple"
    case $fruit in
        "apple")
            echo "Apple pie"
            ;;
        "banana")
            echo "Banana split"
            ;;
        *)
            echo "Unknown fruit"
            ;;
    esac
    ```

##### Tipos de Operadores

- **Operadores Aritméticos**: `+ - * / %`
    ```bash
    a=10
    b=5
    sum=$((a + b))
    echo "Sum: $sum"
    ```

- **Operadores de Comparación**: `-eq -ne -lt -le -gt -ge`
    ```bash
    if [ $a -eq $b ]; then
        echo "a is equal to b"
    fi
    ```

- **Operadores Lógicos**: `&& || !`
    ```bash
    if [ $a -gt 0 ] && [ $b -gt 0 ]; then
        echo "Both a and b are positive"
    fi
    ```

>[!NOTE]
> Los scripts bash deben comenzar con `#!/bin/bash`.

---

## Tercera Evaluación

### Tema 7: Configuración local de Windows

La configuración local de Windows incluye ajustes de sistema, red y seguridad.

#### Ajustes Comunes

- **Configuración de Red**: `ipconfig`, `netsh`
- **Administración de Usuarios**: `net user`, `control userpasswords2`

>[!IMPORTANT]
> Mantén tu sistema actualizado para evitar vulnerabilidades.

### Tema 8: Redes de ordenadores. IPs. Subnetting

Las redes de ordenadores permiten la comunicación entre dispositivos. A continuación, se profundiza en los conceptos de direccionamiento IP, subnetting y los modelos de referencia OSI y TCP/IP, así como en los protocolos más utilizados.

#### Modelos de Referencia

##### Modelo OSI (Open Systems Interconnection)

El modelo OSI es un marco conceptual que estandariza las funciones de un sistema de comunicación en siete capas distintas.

**Esquema del Modelo OSI:**

```
+-------------------+
| 7. Aplicación     |
+-------------------+
| 6. Presentación   |
+-------------------+
| 5. Sesión         |
+-------------------+
| 4. Transporte     |
+-------------------+
| 3. Red            |
+-------------------+
| 2. Enlace de Datos|
+-------------------+
| 1. Física         |
+-------------------+
```

##### Modelo TCP/IP

El modelo TCP/IP es un conjunto de protocolos de comunicación utilizados en Internet y redes similares. Tiene cuatro capas.

**Esquema del Modelo TCP/IP:**

```
+-------------------+
| 4. Aplicación     |
+-------------------+
| 3. Transporte     |
+-------------------+
| 2. Internet       |
+-------------------+
| 1. Acceso a Red   |
+-------------------+
```

#### Direccionamiento IP

El direccionamiento IP es fundamental para la comunicación en redes. Existen dos versiones principales de direcciones IP: IPv4 e IPv6.

##### IPv4

- **Definición**: IPv4 (Internet Protocol version 4) es la cuarta versión del Protocolo de Internet. Utiliza direcciones de 32 bits, lo que permite aproximadamente 4.3 mil millones de direcciones únicas.
- **Formato**: Las direcciones IPv4 se representan en notación decimal punteada, divididas en cuatro octetos (8 bits cada uno), separados por puntos. Ejemplo: `192.168.1.1`.
- **Clases de Direcciones IPv4**:
    - **Clase A**: Rango de `1.0.0.0` a `126.0.0.0`. Utilizado para redes muy grandes. Máscara de subred predeterminada: `255.0.0.0`.
    - **Clase B**: Rango de `128.0.0.0` a `191.255.0.0`. Utilizado para redes medianas. Máscara de subred predeterminada: `255.255.0.0`.
    - **Clase C**: Rango de `192.0.0.0` a `223.255.255.0`. Utilizado para redes pequeñas. Máscara de subred predeterminada: `255.255.255.0`.
    - **Clase D**: Rango de `224.0.0.0` a `239.255.255.255`. Utilizado para multicast.
    - **Clase E**: Rango de `240.0.0.0` a `255.255.255.255`. Reservado para uso futuro y experimental.

##### IPv6

- **Definición**: IPv6 (Internet Protocol version 6) es la versión más reciente del Protocolo de Internet. Utiliza direcciones de 128 bits, lo que permite una cantidad prácticamente ilimitada de direcciones únicas.
- **Formato**: Las direcciones IPv6 se representan en notación hexadecimal, divididas en ocho grupos de 16 bits, separados por dos puntos. Ejemplo: `2001:0db8:85a3:0000:0000:8a2e:0370:7334`.
- **Ventajas de IPv6**:
    - **Espacio de Direcciones**: Mucho mayor que IPv4.
    - **Autoconfiguración**: Soporte para autoconfiguración de direcciones.
    - **Seguridad**: Integración de IPsec para seguridad de red.
    - **Eficiencia**: Mejor enrutamiento y manejo de paquetes.

#### Subnetting

El subnetting es el proceso de dividir una red IP en subredes más pequeñas. Esto mejora la eficiencia del uso de direcciones IP y la gestión de la red.

##### Conceptos Básicos de Subnetting

- **Máscara de Subred**: Define qué parte de la dirección IP corresponde a la red y qué parte a los hosts. Ejemplo: `255.255.255.0`.
- **CIDR (Classless Inter-Domain Routing)**: Notación que especifica la máscara de subred con un sufijo que indica el número de bits de la red. Ejemplo: `192.168.1.0/24`.

##### Ejemplo de Subnetting

Supongamos que tenemos una red `192.168.1.0/24` y queremos dividirla en cuatro subredes.

1. **Determinar el Número de Subredes y Hosts**:
     - Necesitamos 4 subredes, lo que requiere 2 bits adicionales para la subred (2^2 = 4).
     - La nueva máscara de subred será `/26` (24 bits originales + 2 bits adicionales).

2. **Calcular las Subredes**:
     - Subred 1: `192.168.1.0/26` (Rango: `192.168.1.1` a `192.168.1.62`, Broadcast: `192.168.1.63`)
     - Subred 2: `192.168.1.64/26` (Rango: `192.168.1.65` a `192.168.1.126`, Broadcast: `192.168.1.127`)
     - Subred 3: `192.168.1.128/26` (Rango: `192.168.1.129` a `192.168.1.190`, Broadcast: `192.168.1.191`)
     - Subred 4: `192.168.1.192/26` (Rango: `192.168.1.193` a `192.168.1.254`, Broadcast: `192.168.1.255`)

>[!TIP]
> Utiliza calculadoras de subredes para simplificar el proceso de subnetting.


##### Tipos de Direcciones IP

- **Dirección de Red**: Identifica la red. Ejemplo: `192.168.1.0`.
- **Dirección de Broadcast**: Permite enviar datos a todos los dispositivos de la red. Ejemplo: `192.168.1.255`.
- **Dirección de Host**: Identifica un dispositivo específico en la red. Ejemplo: `192.168.1.1`.

##### Clasificación de Direcciones IP

- **Públicas**: Direcciones únicas en Internet. Ejemplo: `8.8.8.8`.
- **Privadas**: Direcciones utilizadas dentro de redes locales. Ejemplo: `192.168.0.0/16`, `10.0.0.0/8`, `172.16.0.0/12`.

#### Protocolos de Red

A continuación, se describen algunos de los protocolos más utilizados en redes de ordenadores:

- **ARP (Address Resolution Protocol)**: Resuelve direcciones IP a direcciones MAC en una red local.
- **TCP (Transmission Control Protocol)**: Protocolo orientado a la conexión que garantiza la entrega de datos en el mismo orden en que fueron enviados.
- **UDP (User Datagram Protocol)**: Protocolo no orientado a la conexión que permite el envío de datagramas sin garantía de entrega.
- **SSH (Secure Shell)**: Protocolo para acceder de forma segura a dispositivos remotos.
- **HTTP (Hypertext Transfer Protocol)**: Protocolo para la transferencia de documentos web.
- **HTTPS (HTTP Secure)**: Versión segura de HTTP que utiliza SSL/TLS para cifrar la comunicación.
- **FTP (File Transfer Protocol)**: Protocolo para la transferencia de archivos entre sistemas.
- **SMTP (Simple Mail Transfer Protocol)**: Protocolo para el envío de correos electrónicos.
- **DNS (Domain Name System)**: Sistema que traduce nombres de dominio a direcciones IP.
- **DHCP (Dynamic Host Configuration Protocol)**: Protocolo que asigna dinámicamente direcciones IP a dispositivos en una red.
- **ICMP (Internet Control Message Protocol)**: Protocolo utilizado para enviar mensajes de control y error en redes IP. Ejemplo: `ping`.
- **NTP (Network Time Protocol)**: Protocolo para sincronizar los relojes de los dispositivos en una red.
- **SNMP (Simple Network Management Protocol)**: Protocolo para la administración y monitoreo de dispositivos de red.
- **POP3 (Post Office Protocol 3)**: Protocolo para la recepción de correos electrónicos.
- **IMAP (Internet Message Access Protocol)**: Protocolo para acceder y gestionar correos electrónicos en un servidor.
