import { GamesListItem as GLI } from "www/store/gamesList/types";

export function GamesListItem({ item }: { item: GLI }) {
  return (
    <li>
      Game {item.gameName} by {item.creatorName}
    </li>
  );
}
