import { myCreatedGamesListed } from "www/store/gamesList/actions";
import { LinkTo } from "www/widgets/LinkToWidget";
import { LinkDispatch } from "www/widgets/LinkDispatchWidget";
import { PlayerHeader } from "./PlayerHeader";

export function PlayerScreen() {
  return (
    <div>
      <PlayerHeader />
      <h1>Welcome player!</h1>
      <LinkTo name="createGame">Create game</LinkTo>
      <br />
      <LinkDispatch createAction={myCreatedGamesListed}>
        My created games
      </LinkDispatch>
    </div>
  );
}
