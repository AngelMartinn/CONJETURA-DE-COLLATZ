# CONJETURA DE COLLATZ

### Autores ✍️
https://github.com/JSalmon11

https://github.com/AngelMartinn

## Introducción 📍

Existe un problema matemático, todavía sin resolver, caracterizado tanto por su dificultad como 
por su inutilidad, conocido como el problema 3x+1.
Consideremos las siguientes reglas:
    1. Partimos de un número natural mayor o igual que 1.
    2. Si el número es impar, se multiplica por 3 y se le suma 1.
    3. Si el número es par, se divide entre 2.
    4. Volvemos al paso 2.
    
Por ejemplo, si elegimos como semilla el número 11, la secuencia obtenida al aplicar las reglas 
anteriores es la siguiente:
    11 – 34 – 17 – 52 – 26 – 13 – 40 – 20 – 10 – 5 – 16 – 8 – 4 – 2 – 1 – 4 – 2 – 1 – 4 – 2 – 1 ...
    
Se han explorado al menos los primeros 264 números naturales, y en todos los casos se alcanza el 
ciclo 4 – 2 – 1. Existe la hipótesis no demostrada (y ése es el problema matemático abierto) de que
todos los números naturales mayores que 2 convergen al ciclo anterior. En ningún caso se ha 
encontrado un ciclo diferente (esto no ocurre con los números negativos).

Resulta interesante la exploración de la longitud de la secuencia de números a partir de la semilla 
inicial hasta alcanzar el número 1 (que indefectiblemente desemboca en el ciclo 4 – 2 – 1), así 
como el número más alto que se alcanza a partir de dicha semilla.

## Comenzando 🚀

Puedes decargar el código y ejecutarlo en el IDE Java que quieras.

### Pre-requisitos 📋

-Un IDE de programación Java, el programa está hecho en NetbBeans, por lo que sería la mejor opción para ejecutarlo en tu pc sin problemas.

-Mínimo la versión 8 de Java, el programa usa el Jdk 1.8.

### Instalación 🔧

Puedes decargar el código o el proyecto entero.
En ambos casos si usas un IDE distinto de NetBeans deberás revisar por si pudiera dar problemas con la codificación UTF8, aunque hemos intentado no usar tildes ni ñ para evitar ese error.

## Ejecución ⚙️

Al ejecutar el rpograma se pide el número de hilos que quieres utilizar, el método de reparto entre los hilos y el inicio y el fin del rango de números a calcular.

Un ejemplo sería:
```
Bienvenido al programa calculadora de casos del Teorema 3x+1
Que cantiad de hilos quiere utilizar
4
Que metodo quieres utilizar:
 	 DeUnoEnUno-1                                       Los hilos van piddiendo números a la clase de datos y van calculando sus secuencias.
	 SubIntervalos-2                                    Los hilos piden un rango de números y cada uno trabaja con ese rango.
2
Dime el inicio de las semillas a calcular
1
Por ultimo dime el final de las semillas a calcular
100001
```
Salida del ejemplo:
```
Tiempo de procesado: 976 milisegundos
Semilla de la mayor secuencia encontrada: 77031
Longitud de la secuencia de 77031: 350
Secuencia de 77031: 77031-231094-115547-346642-173321-519964-259982-129991-389974-194987-584962-292481-877444-438722-219361-658084-329042-164521-493564-246782-123391-370174-185087-555262-277631-832894-416447-1249342-624671-1874014-937007-2811022-1405511-4216534-2108267-6324802-3162401-9487204-4743602-2371801-7115404-3557702-1778851-5336554-2668277-8004832-4002416-2001208-1000604-500302-250151-750454-375227-1125682-562841-1688524-844262-422131-1266394-633197-1899592-949796-474898-237449-712348-356174-178087-534262-267131-801394-400697-1202092-601046-300523-901570-450785-1352356-676178-338089-1014268-507134-253567-760702-380351-1141054-570527-1711582-855791-2567374-1283687-3851062-1925531-5776594-2888297-8664892-4332446-2166223-6498670-3249335-9748006-4874003-14622010-7311005-21933016-10966508-5483254-2741627-8224882-4112441-12337324-6168662-3084331-9252994-4626497-13879492-6939746-3469873-10409620-5204810-2602405-7807216-3903608-1951804-975902-487951-1463854-731927-2195782-1097891-3293674-1646837-4940512-2470256-1235128-617564-308782-154391-463174-231587-694762-347381-1042144-521072-260536-130268-65134-32567-97702-48851-146554-73277-219832-109916-54958-27479-82438-41219-123658-61829-185488-92744-46372-23186-11593-34780-17390-8695-26086-13043-39130-19565-58696-29348-14674-7337-22012-11006-5503-16510-8255-24766-12383-37150-18575-55726-27863-83590-41795-125386-62693-188080-94040-47020-23510-11755-35266-17633-52900-26450-13225-39676-19838-9919-29758-14879-44638-22319-66958-33479-100438-50219-150658-75329-225988-112994-56497-169492-84746-42373-127120-63560-31780-15890-7945-23836-11918-5959-17878-8939-26818-13409-40228-20114-10057-30172-15086-7543-22630-11315-33946-16973-50920-25460-12730-6365-19096-9548-4774-2387-7162-3581-10744-5372-2686-1343-4030-2015-6046-3023-9070-4535-13606-6803-20410-10205-30616-15308-7654-3827-11482-5741-17224-8612-4306-2153-6460-3230-1615-4846-2423-7270-3635-10906-5453-16360-8180-4090-2045-6136-3068-1534-767-2302-1151-3454-1727-5182-2591-7774-3887-11662-5831-17494-8747-26242-13121-39364-19682-9841-29524-14762-7381-22144-11072-5536-2768-1384-692-346-173-520-260-130-65-196-98-49-148-74-37-112-56-28-14-7-22-11-34-17-52-26-13-40-20-10-5-16-8-4-2-1
Numero maximo alcanzado: 1570824736
No existe nuevo bucle.
```

## Construido con 🛠️

* [NetBeans](https://netbeans.apache.org/download/index.html) - El IDE usado
* [Java 8(jdk1.8)](https://www.java.com/es/download/ie_manual.jsp) - Versión de Java utilizada
