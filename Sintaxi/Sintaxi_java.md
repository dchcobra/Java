# JAVA

## CREACIÓN DE UNA CLASE

### CLASE PÚBLICA

```JAVA
public class NameClass {
	public static void main(String[] args) {
	}
}
```

## ASIGNACIÓN DE VARIABLES

### CHAR

```java
char name_var = "H"; //Pregintar si va con 2comillas o con 1comilla
```

Almacena un único carácter introducido.

```java
char name_var = 'A';
```

Almacena el código ASCII del carácter introducido.

### STRING

```java
String name_var = "Introducir frase";
```

Almacena la frase que le introduzcas.

### BOOLEAN

```java
boolean name_var = True;
```

Almacena en la variable True or False.

### INTEGER

```java
int name_var = 10;
```

Almacena números enteros (-2,147,483,648 to 2,147,483,647).

### FLOAT

```java
float name_var = 1.3;
```

Almacena números con decimales, hasta 7 dígitos decimales.

### DOUBLE

```java
double name_var = 1.2332;
```

Almacena números con decimales, hasta 15 números decimales.

### BYTE

```java
byte name_var = 8;
```

Almacena dígitos enteros (-128 to 127).

### SHORT

 ```java
short name_var = 64;
 ```

Almacena dígitos enteros (-32,768 to 32,767).

### LONG

```java
long name_var = 231241241;
```

Almacena dígitos enteros (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807).

## MOSTRAR POR PANTALLA

### PRINTNL

```java
System.out.println("Hola");
System.out.println("Mundo");
```

Muestra por pantalla la STRING que le introduzcas, si le introduces mas STRINGS lo separara por líneas.

### PRINT

```java
System.out.print("Hola");
System.out.print("Mundo");
```

Muestra por pantalla las STRINGS que introduzcas en una sola línea.

### STRING.FORMAT("text", args)

```java
String var1 = "texto"
String var2 = "David"
String output = String.format("Este %s es una prueba de %s ", var1, var2)
System.out.println(output);
```

Lo que permite esto es muestra el valor de un texto y ir poniendo %s que nos permitirá mostrar el valor de las variables que le pasemos de manera ordenada

## CONCATENAR SENTENCIAS

```java
System.out.println("El valor es: " + var + "el otro valor es: " + var);
```

Para poder unir se ha de utilizar el símbolo +.

## CREACION DE UN OBJETO

```java
Scanner name_object = new Scanner(System.in); //Crea un objecto Scanner
```

Creación de un objeto.

## ENTRADA DE DATOS

### IMPORTAR SCANNER

```java
import java.util.Scanner;
```

Importamos el Scanner para poder pedir datos al usuario.

### ENTRADA ENTEROS

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra un numero entero: ");
num = lector.nextInt(); //Lee los enteros del usaurio
```

### ENTRADA CADENA DE TEXTO

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextLine(); //Lee el string del usuario
```

### ENTRADA BOOLEAN

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextBoolean(); //Lee el Boolean del usuario
```

### ENTRADA BYTE

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextByte(); //Lee los bytes del usuario
```

### ENTRADA DOUBLE

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextDouble(); //Lee el Double del usuario
```

### ENTRADA FLOAT

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextFloat(); //Lee el Float del usuario
```

### ENTRADA LONG

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextLong(); //Lee el Long del usuario
```

### ENTRADA SHORT

```java
Scanner lector = new Scanner(System.in); //Creación del objecto lector
System.out.println("Entra una frase: ");
cadena = lector.nextShort(); //Lee el Short del usuario
```

### RESTABLECER LOS INPUT 

Esto se utiliza cuando pones un input de tipo STRING y anteriormente has hecho otro input

```java
lector.nextLine(); 
```

## OPERADORES RELACIONALES

### IGUAL

```java
2 == 2
```

### DIFERENTE

```java
2 != 1
```

### MAYOR QUE

```java
9 > 3
```

### MENOR QUE

```java
3 < 9
```

### MAYOR O  IGUAL QUE

```java
8 >= 3
```

### MENOR O IGUAL QUE

```java
3 <= 8
```

## OPERADORES LOGICOS

### AND

```java
&&
```

![image-20200215012136824](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20200215012136824.png)

### OR

```java
||
```

![](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20200215012554143.png)

### NOT

```java
!
```

![image-20200215012657299](C:\Users\David\AppData\Roaming\Typora\typora-user-images\image-20200215012657299.png)

## TERNARY OPERATORS

Los ternary operators sirven para hacer if/else de manera mas rápida en una linea

Ejemplo:

```java
return one == null ? two == null : one.equals(two);
```

El ejemplo anterior nos devuelve si el objeto one es igual a null entonces nos devuelve two == null si no one.equals(two). 

TRADUCIDO SERIA:

```java
   if (one == null) {
       return two == null;
    } else {
      return one.equals(two)}
```

## ARRAYS

## CREACION DE UNA ARRAY

```java
float [] nom_array = new float[100];
```



### INTRODUCIR VALORES EN UNA ARRAY

#### AÑADIR CON FOR

```python
float[] notas = new float[4];

for (int i = 0; i < notas.length; i++) {
    System.out.println("Introduce un numero: ");
    notas[i] = lector.nextInt(); 
}
```

#### AÑADIR CON WHILE

```python
float[] notas = new float[4];

int j = 0;
while(j<notas.length) {
    System.out.println("Introduce un numero: ");
    notas[j] = lector.nextFloat(); 
}
```

#### AÑADIR CON DO-WHILE

```python
float[] notas = new float[4];

do {
    System.out.println("Introduce un numero: ");
    notas[j] = lector.nextFloat();
    j ++;
} while (j<notas.length);
```



## CONDICIONALES

### IF-ELIF-ELSE

```java
int a = 3;
int b = 3;
if(a > b) {
    System.out.println("El numero " + a + " es mas grande que el numero " + b);
} else if (a == b) {
    System.out.println("El numero " + a + " es igual que el numero " + b);
} else {
    System.out.println("El numero " + b + " es mas grande que el numero " + a);
}
```

### SWITCH-CASE

```java
int Dia = 5;
String DiaString = "";
switch (Dia) {
    case 1: DiaString = "Lunes";
        break;
    case 2: DiaString = "Martes";
        break;
    case 3: DiaString = "Miercoles";
        break;
    case 4: DiaString = "Jueves";
        break;
    case 5: DiaString = "Viernes";
        break;
    case 6: DiaString = "Sabado";
        break;
    case 7: DiaString = "Domingo";
        break;
} System.out.println(DiaString);
```

## BUCLES

### WHILE

```JAVA
int i = 0;
while (i < 5) {
  System.out.println("El numero es: " + i);
  i++;
}
```

### DO-WHILE

```java
int i = 0;
do {
  System.out.println(i);
  i++;
}
while (i < 5);
```

### FOR

```java
for (int i = 0; i < 5; i = i + 2) {
    System.out.println(i);
```

### FOR-EACH (FOR en una lista)

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
```

HACER QUE UNA VARIABLE NUNCA SE PUEDA CAMBIAR

```java
public static final double name_var = 20;
```

la palabra final hace que no puedas cambiar el valor de la variable

## TRY - EXCEPT en java

```JAVA
int num = 0;
boolean valid = false;
Scanner sc = new Scanner(System.in);
//Comprobamos que introduzca siempre numeros, mientras que no introduzca numeros le saldra error y le volvera a pedir
do {
    System.out.println("Numero: ");
    if (sc.hasNextInt()) {
        num = sc.nextInt();
        valid = true;
    } else {
        System.out.println("ERROR");
        sc.nextLine(); //sirve para reiniciar"
    }
} while(valid == false);
```

## FUNCIONES PREDETERMINADAS DE JAVA

```java
math.pow(num,elevado) // Calcula las operaciones de num * xveces
```

```java
math.sqrt(num) // Calcula la raiz cuadrada del numero
```

```java
math.PI // Valor exacto del numero PI
```



## MATRICES

### DECLARACION

```java
int [][]array = new int[10][5]; // Al poner dos lo que hace es que tenga filas y columnas
```

### ITERAR EN UNA LISTA

```java
for (int i = 0 ; i < v.length ; i++) {
    for (int j = 0 ; j < v[i].length; j++) {

    }
}
```



## FUNCIONAMIENTO DE FUNCIONES

Cuando le introducimos una variable principal (STR, INT, FLOAT...) a la hora de llamar a una función lo que hacemos es que le enviamos el valor no la variable en si. Esto significa que si hacemos cambios de esa variable dentro de la función no modificara el valor de fuera de la variable.

Cuando esto se hace con listas se envía la variable en si, no solamente los valores.



## TERMINOS BASICOS (OBJETOS)

### UPCAST /  DOWNCAST

![Cuál es la diferencia entre up-casting y down-casting con respecto a la  variable de clase DOKRY Desarrollo](https://sofes.miximages.com/java/Lkn0S.png)

### SUPERCLASS =  BASE CLASS / SUBCLASS

Clase principal de la cual de ella salen subclases, la cual hereda su estado y comportamiento para añadir comportamientos únicos

### OVERRIDING

Característica que permite crear nuevas versiones para la superclass con una firma del método idéntica al método de la superclass

### OVERLOADING

Es la característica que permite crear mas de un método con el mismo nombre pero con distintas firmas

### EXTENDS

Palabra para crear una subclase que hereda de la superclass

### IMPLEMENTS 

Palabra para crear clases definidas por la interfaz

### ABSTRACT 

Tipo de clase que define métodos parciales o utilizar subclases para definir un método

Palabra para definir la firma del método de subclases

### INSTANCEOF

Palabra que determina del objecto el tipo

### POLYMORPHISM

La habilidad de trabajar con objetos indistintamente (sin que importe la diferencia)

### OBJECTOS

La siguiente URL están todos los métodos que se pueden utilizar para los objetos.

```URL 
https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
```

## EXCEPCIONES

¿Que son las excepciones en Java?

Las excepciones son: 

- Los fallos o paradas que pueden ocurrir en el programa
- Errores
- Falta alguna cosa o llega a ser inaccesible
- Errores que no son lógicos
- Los errores que son tanto esperados como no esperados 

```java
try {
  //  Block of code to try
}
catch(Exception e) {
  //  Block of code to handle errors
}
```
Devuelve que hay un tipo de error, se pone al final de bloque de try
```java
try {
    System.out.println("Please enter another integer");
	int z = Integer.parseInt(input.nextLine());
	System.out.println(x / z);
	//Devuelve que hay algun error
	throw new IllegalArgumentException(); }
```

# WEB SERVICES

Un servicio web es una tecnologia que utilza un conjunto de protocolos 
y estandartes para cambiar información entre distintas aplicaciones 
a traves de él (servicio web).
Distintos softwares pueden intercambiar información a traves de él 
aunque esten escritos en distintos lenguajes.
Estos servicios han de seguir la arquitectura de W3C/OASIS.

## ARQUITECTURA

Esta arquitectura esta dividida en 3 partes:
- Proveedor de servicio web
- El que pide el servicio web
- El publicador

![Web Services](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Webservices.png/220px-Webservices.png)

### SOAP (Simple Object Access Protocol)

Es un protocolo estandar qe define como dos objetos de distintos procesos 
pueden comunicarse gracias a intercambios de informacion por XML.

ESTRUCTURA SOAP:
1. Envelope (*): Raiz de la estructura, identificador del mensaje SOAP
2. Header: Mecanismo de extension, permite enviar informacion de como 
procesarse el mensaje
3. Body (*): Contiene información relativa a la llamada y respuesta (cuerpo del mensaje, donde se encuentra la informacion)
4. Fault: Informacion relativa a errores que se hayan producido durante el procesado del mensaje.

![SOAP STRUCTURE](data:image/jpeg;base64,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)


### RESTFUL
