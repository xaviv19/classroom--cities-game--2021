import { useAppSelector } from "www/store/hooks";
import { getPlayer } from "www/store/player/selectors";

export function PlayerHeader() {
  const player = useAppSelector(getPlayer);
  if (!player) return null;

  return <div data-testid="player-header">Player {player.playerName}.</div>;
}
