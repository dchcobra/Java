# LEARNING SQL

Lo que he hecho para poder probar el codigo SQL ha sido irme a Oracle Live SQL ya que ellos te ofrecen una herramienta con distantan bases de datos donde puedes hacer consultas a tablas que ya tienen creadas
https://livesql.oracle.com/apex/f?p=590:1:628067647231::NO:::

## LESSON 2 - SELECT

Muestra todas las columnas de la tabla hr.jobs

```sql 
SELECT * 
FROM hr.jobs; 
```
Muestra unicamente la columna job_title

```sql 
SELECT job_title 
FROM hr.jobs;
```
Muestra solo las columnas job_id y job_title de la tabla hr.jobs

```sql 
SELECT job_id, job_title 
FROM hr.jobs;
```
Seleccionamos los 5 primeros trabajos, en oracle esta obsoleto LIMIT y se usa FETCH NEXT * ROWS ONLY, https://stackoverflow.com/questions/470542/how-do-i-limit-the-number-of-rows-returned-by-an-oracle-query-after-ordering

```sql 
/* SQL 
SELECT * 
FROM hr.jobs  
LIMIT 5;
*/

SELECT * 
FROM hr.jobs  
FETCH NEXT 5 ROWS ONLY;
```

## LESSON 3 - SORTING DATA

### ORDER BY

Ordenamos la tabla que nos muestra por el job_title primero de manera A-Z, y luego lo ordenamos al reves Z-A

```sql
SELECT * 
FROM hr.jobs 
ORDER BY job_title ASC;

SELECT * 
FROM hr.jobs 
ORDER BY job_title DESC;
```

Ordenamos la tabla que nos muestra primeropor el MIN_SALARY de la A-Z,
si algun dato tiene el mismo MIN_SALARY lo que hace es que ordena por el 
JOB_TITLE de manera de la Z-A 

```sql
SELECT * 
FROM hr.jobs 
ORDER BY MIN_SALARY , JOB_TITLE DESC;
```

## LESSON 4 - FILTERING DATA

```sql
SELECT * 
FROM hr.jobs 
ORDER BY MIN_SALARY , JOB_TITLE DESC;
```

Mostramos todo de la tabla hr.jobs que tengan como valor de MIN_SALARY 2500

```sql
SELECT * 
FROM hr.jobs 
WHERE MIN_SALARY = '2500';
```

Mostramos todo de la tabla hr.jobs que tengan como valor de MIN_SALARY entre 2500 y 4500

```sql
SELECT * 
FROM hr.jobs 
WHERE MIN_SALARY between 2500 and 4500;
```

Mostramos de la tabla hr.jobs que tengan como valor de MIN_SALARY NULL (no tengan valor)

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY IS NULL;
```

## LESSON 5 - ADVANCED FILTERING DATA

Mostramos de la tabla hr.jobs que tengan como valor de MIN_SALARY 4200 y el nombre de JOB_TITLE sea Accountant

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY = 4200 AND JOB_TITLE = 'Accountant';
```

Mostramos de la tabla hr.jobs que tengan como valor de MIN_SALARY 4200 o que tengan de nombre en JOB_TITLE Accountant

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY = 4200 OR JOB_TITLE = 'Accountant';
```

Si quieres forzar niveles a la hora de evaluar utiliza (), es decir si quieres hacer que por ejemplo se sumen dos numeros y después que se multiplique por 2

```
(2+2) * 4 = 16
2 + 2 * 4 = 10
```

Mostramos de la tabla hr.jobs que tengan como valor de MIN_SALARY 4200 y 5500

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY IN (4200, 5500)
ORDER BY MIN_SALARY ASC;
```

Mostramos de la tabla hr.jobs todos menos los que tengan como valor de MIN_SALARY 2500

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY IN (4200, 5500)
ORDER BY MIN_SALARY ASC;
```

## LESSON 6 - FILTERING WITH LIKE

Mostramos de la tabla hr.jobs todos los que tengan como valor de MIN_SALARY que empiecen por 2 (2000, 2500, 25000, 200000)

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY LIKE '2%'
ORDER BY MIN_SALARY ASC;
```

Mostramos de la tabla hr.jobs todos menos los que tengan como valor de MIN_SALARY que empiecen por 2 (2000, 2500, 25000, 200000)

```sql
SELECT * 
FROM hr.jobs
WHERE MIN_SALARY NOT LIKE '2%'
ORDER BY MIN_SALARY ASC;
```

## LESSON 8 - CONCATENATION

Unimos la columna MIN_SALARY y MAX_SALARY y le asignamos un apodo (RANGE_SALARY), despues ordenamos por MIN_SALARY

ORACLE
```sql
SELECT JOB_ID, CONCAT(MIN_SALARY ,CONCAT( ' - ',  MAX_SALARY)) AS RANGE_SALARY
FROM hr.jobs
ORDER BY MIN_SALARY;
```

SQL
```sql
SELECT JOB_ID, MIN_SALARY + ' - ' +  MAX_SALARY AS RANGE_SALARY
FROM hr.jobs
ORDER BY MIN_SALARY;
``` 

## LESSON 9 - FUNCTIONS MANIPULATIONS

FUNCION MINUSCULAS
```sql
SELECT LOWER(JOB_ID)
FROM hr.jobs
ORDER BY MIN_SALARY;
``` 

FUNCION MAYÚSCULAS
```sql
SELECT UPPER(JOB_ID)
FROM hr.jobs
ORDER BY MIN_SALARY;
``` 

DATE

INSERTAR IMG DATE.png

Mostramos el valor de la tabla que tenga en END_DATE el año 19
ORACLE
```sql
SELECT *
FROM hr.JOB_HISTORY
WHERE to_number(to_char(END_DATE, 'YY')) = 19;
```

SQL
```sql
SELECT *
FROM hr.JOB_HISTORY
WHERE YEAR(END_DATE) = 19;
```

OTHER FUNCTIONS
```sql
MIN()
MAX()
COUNT()
AVG()
```

## LESSON 10 - GROUPING DATA

Mostramos el numero de trabajos que tienen el mismo MIN_SALARY

```sql
SELECT MIN_SALARY, COUNT(*) AS JOBS_SAME_SALARY
FROM hr.jobs
GROUP BY MIN_SALARY;
```

Mostramos el numero de trabajos que tienen el mismo MIN_SALARY pero teniendo más de 1 trabajo

```sql
SELECT COUNT(*) AS JOBS_SAME_SALARY, MIN_SALARY
FROM hr.jobs
GROUP BY MIN_SALARY
HAVING COUNT(*) > 1;
```

## LESSON 11 - SUBQUERIES

### SUBQUERIE EN EL WHERE

Mostramos todo de la tabla de hr.jobs que tengan en la tabla hr.job_history el DEPARTMENT_ID = 110

```sql
SELECT *
FROM hr.jobs
WHERE job_id in (SELECT job_id
                 FROM hr.JOB_HISTORY
                 WHERE DEPARTMENT_ID = 110);
```

### SUBQUERIE EN EL SELECT (FIELD)

Mostramos de la tabla de hr.jobs el job_id y el job_title y hacemos una columna donde nos dice el numero de filas que hay en job_history

```sql
SELECT  JOB_ID, JOB_TITLE,
        (SELECT COUNT(*)
         FROM hr.job_history
         WHERE JOB_ID = JOB_ID) AS COUNT_JOB_HISTORY
FROM hr.jobs;
```

## LESSON 12 - JOINING TABLES

INSERTAR IMAGEN JOIN.png

### SIMPLE JOIN

Mostramos el job_id y el job_title de hr.jobs y el employee_od de hr.job_history

```sql
SELECT  jobs.JOB_ID, jobs.JOB_TITLE, history.EMPLOYEE_ID
FROM hr.jobs jobs, hr.job_history history
WHERE jobs.JOB_ID = history.JOB_ID;
```

 ### JOIN WITH MULTIPLE TABLES

Mostramos el job_id y job_title de hr.jobs y el employee_id de hr.job_history del que haya hecho un trabajo y esta guardado en hr.job_history

```sql
SELECT  jobs.JOB_ID, jobs.JOB_TITLE, history.EMPLOYEE_ID
FROM hr.jobs jobs, hr.job_history history, hr.employees emp
WHERE jobs.JOB_ID = history.JOB_ID
AND emp.EMPLOYEE_ID = history.EMPLOYEE_ID;
```

## LESSON 13 - ADVANCES JOINS

Mostramos el job_id y job_title de hr.jobs y el employee_id de hr.job_history del que haya hecho un trabajo y esta guardado en hr.job_history con JOB_ID de IT_PROG

```sql
SELECT  jobs.JOB_ID, jobs.JOB_TITLE, history.EMPLOYEE_ID
FROM hr.jobs jobs, hr.job_history history, hr.employees emp
WHERE jobs.JOB_ID = history.JOB_ID
AND emp.EMPLOYEE_ID = history.EMPLOYEE_ID
AND jobs.JOB_ID = 'IT_PROG';
```


### LEFT OUTER JOIN

Muestra los valores de la tabla hr.jobs y si hay valores relacionados con ellos en hr.job_history los muestra (si no hay devuelve null)

```sql
SELECT  jobs.JOB_ID, jobs.JOB_TITLE, history.EMPLOYEE_ID
FROM hr.jobs jobs LEFT OUTER JOIN hr.job_history history on jobs.JOB_ID = history.JOB_ID;
```

Hace lo mismo que el anterior pero con la tabla de hr.job_history a hr.jobs

### RIGHT OUTER JOIN
```sql
SELECT  jobs.JOB_ID, jobs.JOB_TITLE, history.EMPLOYEE_ID
FROM hr.jobs jobs RIGHT OUTER JOIN hr.job_history history on jobs.JOB_ID = history.JOB_ID;
```

## LESSON 14 - COMBINING QUERIES

### UNION

Hace dos consultas distintas a la misma tabla y la ejecuta a la vez

```sql
SELECT JOB_ID, JOB_TITLE
FROM HR.JOBS
WHERE JOB_ID = 'AC_ACCOUNT'
UNION -- Puedes poner all y se duplicaran algunas entradas
SELECT JOB_ID, JOB_TITLE
FROM HR.JOBS
WHERE JOB_TITLE = 'Programmer';
```

## LESSON 15 - INSERTING DATA

### INSERT INTO

Primero creamos una tabla de ejemplo

```sql
CREATE TABLE david (
    ID NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(15) NOT NULL,
    job VARCHAR2(10),
    birthdate DATE,
    hiredate DATE
);
```

Una vez creada la tabla insertamos dentro los valores

```sql
INSERT INTO david
VALUES (1, 'DAVID', 'PROGRAMMER', DATE '2001-10-01', CURRENT_DATE);

INSERT INTO david
VALUES (2, 'NEREA', 'DOCTOR', DATE '1994-04-15', CURRENT_DATE);
```

### INSERT INTO SELECT
Primero creamos una tabla

```sql
CREATE TABLE davidcp (
    ID NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(15) NOT NULL,
    job VARCHAR2(10),
    birthdate DATE,
    hiredate DATE
);
```

Ahora insertamos los datos cogiendolos de la tabla creada anteriormenteç

```sql
INSERT INTO davidcp SELECT * FROM david;
```

## LESSON 16 - UPDATING AND DELETING DATA

### UPDATE

Actualizamos la informacion del id 1

```sql
UPDATE davidcp SET nombre = 'CASTILLA' where id = 1;
SELECT * FROM davidcp;
```

### DELETE 

Eliminamos la informacion del id 1

````sql
DELETE FROM davidcp where id = 1;
SELECT * FROM davidcp;
```

## LESSON 17 - UPDATING AND DELETING DATA

### ALTER TABLE

#### WITH DROP

Eliminamos la columna hiredate de la tabla davidcp

```sql
ALTER TABLE davidcp DROP COLUMN hiredate;
```

#### WITH ADD

Añadimos una columna nueva y la convertimos en primary key

```sql
ALTER TABLE davidcp ADD num NUMBER(5);
ALTER TABLE davidcp ADD CONSTRAINT PRIMARY KEY (num);
```

