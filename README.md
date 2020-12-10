## Examen Practica LS2 2020/21

El teu nom:

Usuari de GitHub:

Nom del grup:

## Membres del grup:

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
pel davant el teu usuari de GitHub al artifacId

[ ] Commiteja i pushea sovint

[ ] Comprova el Coverage

## Preguntes-Pista

Obre el `basic.properties` i responte:

1. Que es `squares.count` ?
   Que succeeix si val 1?

2. Que son el `limit.hand.*` ?
   Que succeeix si \*=food val 1?
   Quina issue(nom del post) l'introdueix?

3. Que son els `pile.*.accepts` ?
   Que succeeix si _=buy-field val `event`?
   Que succeeix si _=event val `event-grain,event-sheep` ?
   Quina issue(nom del post) l'introdueix?

4. Quina es la diferencia entre `pile.square.own.accepts`
   i `pile.square.foe.accepts` ?
   Que succeeix si s'intercanvien els valors?
   Quina issue(nom del post) l'introdueix?

5. Que son els `card.material.*` ?
   I els `cards.worker.* ` ?
   I els `cards.building.* ` ?
   Quina issue(nom del post) l'introdueix?

6. Que son els `train.*.*` ?
   Quina issue(nom del post) l'introdueix?
   Quina clase el llegeix i que fa amb ell ?

7. Que son els `build.*.*` ?
   Quina issue(nom del post) l'introdueix?
   Quina clase el llegeix i que fa amb ell ?

Sobre el blogpost `2020-12-08_farmers_and_hay`:

- Quins nou tipus de carta afegeix?
- Quins canvis fa a `basic.properties`?
- Quines RoundRules afegeix?
- Que fa cada RoundRule?

Sobre el blogpost `2020-12-11_cities`:

- Quins nou tipus de carta afegeix?
- Quins canvis fa a `basic.properties`?
- Quines RoundRules afegeix?
- Que fa cada RoundRule?

Sobre els workers:

- Com crearies un nou tipus de worker al joc?
- Com faries al worker treballar?

Sobre els buildings:

- Com crearies un nou tipus de building al joc?
- Com faries que el bulding tingui una funcionalitat al joc?

Sobre el Front, que és i que fà el `ducks/alert` ?

- Que fa el `notifyError` ?
- Que fa el `replaceAlert` ?
- Quin parametre rep el `replaceAlert` ?
- Que es mostra per la pantalla ?
- Que fà el `dismissAlert` ?
- Qui fa dispatch del `dismissAlert` ?

## Setup

There are two applications:

- Java Spring JPA backend (run in 8080)
- React Redux frontend (run in 3000)

The deploy merges both into one single war.

Setup Java BackEnd:

- Install Java v11

- Open the project with IntelliJ  
  (it will install all maven dependencies)

Manual Java Backend:

- Execute `./mvnw test`

Setup Javascript BackEnd:

- Install node v14 i yarn

- Execute `yarn install`

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
Remember that in front end, you can select a specific test by writting
a part of it in the command line, ex:

```bash
$ yarn test -i 2020-12-17
```

1. Backend:

- Run `./mvnw test`
- Verify the JaCoCo coverage reports (see target/site/jacoco/jacoco.csv)

2. Frontend:

- Run `CI=1 yarn test -i --coverage --coveragePathIgnorePatterns 'src/www/__test__'`
