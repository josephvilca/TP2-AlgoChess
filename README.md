# AlgoChess

[![Build Status](https://travis-ci.org/tomasBustamante/Pokemon.svg?branch=master)](https://travis-ci.org/tomasBustamante/Pokemon) [![codecov](https://img.shields.io/codecov/c/github/dwyl/hapi-auth-jwt2.svg?maxAge=2592000)](https://codecov.io/gh/tomasBustamante/Pokemon)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2bc54b6684cc40eb8248b9dbba11d462)](https://app.codacy.com/app/tomasBustamante/Pokemon?utm_source=github.com&utm_medium=referral&utm_content=tomasBustamante/Pokemon&utm_campaign=Badge_Grade_Dashboard)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Ejemplo de código de modelado entre ataques de Pokemones con integración contínua.

## Instalación previa

Las únicas herramientas necesarias para trabajar en el proyecto son el entorno de desarrollo de Java ([JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)), [Apache Maven](https://maven.apache.org) para la construcción automatizada y Git para el control de versiones.

```console
$ sudo apt update
$ sudo apt install default-jdk maven git
```

Verificamos que se hayan instalado correctamente:

```console
$ javac -version
javac 11.0.4
$ mvn --version
Apache Maven 3.6.0
Maven home: /usr/share/maven
Java version: 11.0.4, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: es_AR, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-66-generic", arch: "amd64", family: "unix"
$ git --version
git version 2.17.1
```

## Procedimiento

El historial de construcciones en Travis puede verse [aquí](https://travis-ci.org/tomasBustamante/Pokemon/builds) y la medición de cobertura con CodeCov [aquí](https://codecov.io/gh/tomasBustamante/Pokemon).
