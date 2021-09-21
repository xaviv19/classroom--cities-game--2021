import { useAppSelector } from "www/store/hooks";
import { getCurrentScreenId } from "www/widgets/ScreenStackWidget/selectors";
import { getEntityById } from "www/store/game/selectors";
import { PlayerHeader } from "../PlayerScreen/PlayerHeader";
import { GameHeader } from "../GameScreen/GameHeader";
import { EntityComponents } from "www/components/EntityComponents";

export function EntityScreen() {
  const entityId = useAppSelector(getCurrentScreenId)!;
  const entity = useAppSelector((s) => getEntityById(s, { entityId }))!;

  return (
    <div>
      <PlayerHeader />
      <GameHeader />
      <h1>
        Entity {entity.type} {entity.name} of {entity.owner}
      </h1>
      <EntityComponents entity={entity} />
    </div>
  );
}
