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

![Cuál es la diferencia entre up-casting y down-casting con respecto a la  variable de clase DOKRY Desarrollo](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Webservices.png/220px-Webservices.png)
