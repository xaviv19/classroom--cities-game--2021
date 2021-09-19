import {
  myCreatedGamesListed,
  myPlayingGamesListed,
} from "www/store/gamesList/actions";
import { LinkTo } from "www/widgets/LinkToWidget";
import { LinkDispatch } from "www/widgets/LinkDispatchWidget";
import { PlayerHeader } from "./PlayerHeader";
import { PlayerFriendGames } from "./PlayerFriendGames";

export function PlayerScreen() {
  return (
    <div>
      <PlayerHeader />
      <h1>Welcome player!</h1>
      <LinkTo name="createGame">Create game</LinkTo>
      <br />
      <LinkDispatch createAction={myPlayingGamesListed}>
        My playing games
      </LinkDispatch>
      <LinkDispatch createAction={myCreatedGamesListed}>
        My created games
      </LinkDispatch>

      <PlayerFriendGames />
    </div>
  );
}
