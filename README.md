# SofkaUChallenge
# English

This project was created as a technical challenge from SofkaU.

## Installation and required software

For this project I used IntelliJ as an IDE and used an Ubuntu terminal for excecution, if you are using Windows I highly suggest you download Ubuntu 18.04 LTS.
On the Ubuntu terminal use the following commands to install gradle:

```bash
sudo snap install gradle  --classic
```
Also remember to have Java already installed.

Open IntelliJ and open the project, It will automatically download all dependencies and do an initial build, it may take a few minutes.

## Usage

Once you have downloaded this project, open IntelliJ and run the project and then, on the Ubuntu terminal, type in the following command:
```bash
curl --request POST localhost:8080/game
```
Back on IntelliJ, on the "Run" tab, It will show the options for the game and you shall interact with it.

## Database

I run a h2 database, which means that on each run of the application the database creates itself, if you want to see the complete database and do querys go to [database](http://localhost:8080/h2-console), username = sa, no password needed.

At first the database's table will be empty. However, when you start to interact with the application by creating questions and so on, you will be able to see their content in it.

## UML Model

![](https://github.com/jricaur1/SofkaUChallenge/blob/main/Challenge.png)

# Español

Este proyecto fue creado como reto técnico para SofkaU.

## Instalación y software requerido

Para este proyecto se usó IntelliJ como IDE y se usó una terminal Ubuntu para ejecución, si está usando Windows sugiero que descargue Ubuntu 18.04 LTS.
En la terminal de Ubuntu use el siguiente comando para instalar gradle:

```bash
sudo snap install gradle  --classic
```
Tenga encuenta también que debe tener Java instalado previamente.

Abra IntelliJ y abra el proyecto, automaticamente se descargarán todas las dependencias y se hará el build inicial, puede tomar unos minutos.

## Uso

Una vez descargado el proyecto, abra IntelliJ y corra el proyecto, luego en la terminal de Ubuntu ejecute el siguiente comando:

```bash
curl --request POST localhost:8080/game
```

Luego, en IntelliJ, en la pestaña "Run", aparecerán las opciones para que pueda interactuar con el juego.

## Base de datos

Yo uso una base de datos h2, esto significa que en cada ejecución de la aplicación la base de datos se crea a sí misma, si quiere ver la base de datos completa y ejecutar querys entre a la [base de datos](http://localhost:8080/h2-console), username = sa, no requiere contraseña.

Al principio la base de datos estará vacía. Sin embargo, cuando empiece a interactuar con la aplicación para crear preguntas o jugar, podrá ver el contenido de cada tabla.


## Modelo UML

![](https://github.com/jricaur1/SofkaUChallenge/blob/main/Challenge.png)


