import { getGame } from "www/store/game/selectors";
import { useAppSelector } from "www/store/hooks";

export function GameHeader() {
  const game = useAppSelector(getGame)!;
  const { gameName, creatorName } = game;

  return (
    <div data-testid="game-header">
      Game {gameName} created by {creatorName}
    </div>
  );
}
