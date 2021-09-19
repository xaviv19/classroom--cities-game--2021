import { PlayerHeader } from "../PlayerScreen/PlayerHeader";
import { GameHeader } from "./GameHeader";

export function GameScreen() {
  return (
    <div>
      <PlayerHeader />
      <GameHeader />
      <h1>Game!</h1>
    </div>
  );
}
