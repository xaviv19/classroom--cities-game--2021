import { useAppSelector } from "www/store/hooks";
import { nextPlayerChanged } from "www/store/multiplayer/actions";
import { getPlayer } from "www/store/player/selectors";
import { LinkDispatch } from "www/widgets/LinkDispatchWidget";

export function PlayerHeader() {
  const player = useAppSelector(getPlayer);
  if (!player) return null;

  return (
    <div data-testid="player-header">
      Player {player.playerName}.
      <LinkDispatch createAction={nextPlayerChanged}>Next</LinkDispatch>
    </div>
  );
}
