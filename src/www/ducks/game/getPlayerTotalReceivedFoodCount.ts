import { GameState } from "./GameState";

export function getPlayerTotalReceivedFoodCount(
  state: GameState,
  { player }: { player: string }
): number {
  return state.game.players[player].totalReceivedFoodCount;
}
