
### Escuela Colombiana de Ingeniería

### Procesos de Desarrollo de Software

### Desarrollo Dirigido por Pruebas + DIP + DI + Contenedores Livianos


#### Integrantes: Wilson Delgado - Juanita Oramas

## Introducción

Para este laboratorio se va a trabajar sobre un juego de ahorcado.
El sistema inicial de puntuación del juego comienza en 100 puntos y va descontando 10 puntos cada vez que se propone una letra incorrecta.

Se han propuesto 3 diferentes esquemas, los cuales se describen a continuación:

* OriginalScore: 
    * Es el esquema actual, se inicia con 100 puntos.
    * No se bonifican las letras correctas.
    * Se penaliza con 10 puntos con cada letra incorrecta.
    * El puntaje mínimo es 0.

* BonusScore: 
    * El juego inicia en 0 puntos.
    * Se bonifica con 10 puntos cada letra correcta.
    * Se penaliza con 5 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    
* PowerBonusScore:
    * El juego inicia en 0 puntos.
    * La $i-ésima$ letra correcta se bonifica con $5^i$.
    * Se penaliza con 8 puntos cada letra incorrecta.
    * El puntaje mínimo es 0
    * Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es
      500 .





### Parte I

1. Clone el proyecto (no lo descargue!).
   ![img.png](img/img.png)

2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.
![img_2.png](img/img_2.png)
3. Haga la especificación de los métodos calculateScore (de las tres
   variantes de GameScore), a partir de las especificaciones
   generales dadas anteriormente. Recuerde tener en cuenta: @pre,
   @pos, @param, @throws.
    ![img_3.png](img/img_3.png)
    ![img_4.png](img/img_4.png)
    ![img_5.png](img/img_5.png)

4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```

5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .
   ![img_6.png](img/img_6.png)

6. Teniendo en cuenta dichas especificaciones, en la clase donde se
   implementarán las pruebas (GameScoreTest), en los
   comentarios iniciales, especifique las clases de equivalencia para
   las tres variantes de GameScore, e identifique
   condiciones de frontera. 
    ![img_7.png](img/img_7.png)

7. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.
    * Para cada prueba se colocó cuál clase de equivalencia es entre paréntesis ejemplo: (Second Case)
    ![img_8.png](img/img_8.png)

8. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "implementación pruebas"
	```
    ![img_10.png](img/img_10.png)

9. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.
    ![img_9.png](img/img_9.png)
10. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```

11. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

```bash	
	git push <URL Repositorio>	
```


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

Incorpore el Contenedor Liviano Guice dentro del proyecto:

* Revise las dependencias necesarias en el pom.xml.
* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...
* Para lo anterior, [puede basarse en el ejemplo dado como
  referencia](https://github.com/PDSW-ECI/LightweighContainers_DepenendecyInjectionIntro-WordProcessor).
