import { useMemo } from "react";
import { useAppSelector } from "www/store/hooks";
import { EntityList } from "../EntityScreen/EntityList";
import { GameHeader } from "./GameHeader";
import { makeSelectLocatedEntities } from "./selectors";

export function GameScreen() {
  const getAllGameEntities = useMemo(makeSelectLocatedEntities, []);
  const entities = useAppSelector(getAllGameEntities);

  return (
    <>
      <GameHeader />
      <main data-testid="screen-game">
        <h1>Game!</h1>
        <EntityList entities={entities} />
      </main>
    </>
  );
}
