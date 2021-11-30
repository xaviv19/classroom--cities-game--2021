import { useAppSelector } from "www/store/hooks";
import { getCurrentScreenId } from "www/widgets/ScreenStackWidget/selectors";
import { getEntityById } from "www/store/game/selectors";
import { GameHeader } from "../GameScreen/GameHeader";
import { EntityComponents } from "./EntityComponents";

export function EntityScreen() {
  const entityId = useAppSelector(getCurrentScreenId)!;
  const entity = useAppSelector((s) => getEntityById(s, { entityId }))!;
  if (!entity) return null;

  return (
    <div>
      <GameHeader />
      <main data-testid="screen-entity">
        <h1 data-testid="screen-entity-title">
          {entity.name} {entity.type} of {entity.owner}
        </h1>
        <EntityComponents entity={entity} />
      </main>
    </div>
  );
}
