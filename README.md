## Examen LS2 2021-12

Benvingut!

- Quin és el teu nom?
  ________________________________________

- Modifica el `pom.xml` i concatena pel davant el teu usuari 
  de GitHub al artifactId


## Membres del grup:

- Quins son els membres del grup?

  -
  -
  -
  -
  -

Deploy path:

- url to heroku running

## Checklist

Abans d'entregar verifica que:

[ ] Modifica el fitxer `pom.xml` i concatena
pel davant el teu usuari de GitHub al artifactId

[ ] Commiteja i pushea sovint segons les regles de l'enunciat

[ ] Comprova el Coverage

## Setup

There are two applications:

- Java Spring JPA backend (run in 8080)
- React Redux frontend (run in 3000)

Setup Java BackEnd:

- Install Java v11

- Open the project with IntelliJ  
  (it will install all maven dependencies)

Manual Java Backend:

- Execute `./mvnw test`

Setup Javascript BackEnd:

- Install node v14 amd yarn

- Execute `yarn`

## Develop Run

- Run the com.drpicox.game.Application from intellij
  - use `-ea -client -Xverify:none -noverify` for faster test run
- Run `yarn start` from command line
- Open the browser in `http://localhost:3000`
  (the react opens a proxy with the backend and uses actual services)

React editor:

- Recommended Visual Studio Code
- Recommended extensions:
  - EditorConfig for VS Code
  - ESLint
  - Prettier

## Run Tests

Run tests frequently. Do not forget to check Code Coverage.
First build and run backend tests, then run frontend tests.
Frontend tests will not pass unless backend tests pass before.
Remember that in front end, you can select a specific test by writing
a part of it in the command line, ex:

```bash
$ yarn test "2021-12-15_"
```

1. Backend:

- Run `./mvnw test`
- Verify the JaCoCo coverage reports (see target/site/jacoco/jacoco.csv)

2. Frontend:

- Run `CI=1 yarn test -i --testTimeout 20000 --coverage`
