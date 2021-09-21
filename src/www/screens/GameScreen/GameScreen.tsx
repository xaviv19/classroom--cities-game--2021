import { useMemo } from "react";
import { makeGetAllGameEntities } from "www/store/game/selectors";
import { useAppSelector } from "www/store/hooks";
import { PlayerHeader } from "../PlayerScreen/PlayerHeader";
import { EntityList } from "../EntityScreen/EntityList";
import { GameHeader } from "./GameHeader";

export function GameScreen() {
  const getAllGameEntities = useMemo(makeGetAllGameEntities, []);
  const entities = useAppSelector(getAllGameEntities);

  return (
    <div>
      <PlayerHeader />
      <GameHeader />
      <h1>Game!</h1>
      <EntityList entities={entities} />
    </div>
  );
}
