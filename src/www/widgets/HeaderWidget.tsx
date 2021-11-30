import { LinkTo } from "./LinkToWidget";
import { LinkDispatch } from "./LinkDispatchWidget";
import { LoadingWidget } from "./LoadingWidget";
import { Bar } from "www/theme/Bar";
import { Spacer } from "www/theme/Spacer";
import { blogPushed } from "www/screens/BlogScreen/actions";
import { useDispatchForm, useInputRef } from "www/store/hooks";
import { gamePlayed } from "www/store/game/actions";

export function HeaderWidget() {
  const playerNameRef = useInputRef();
  const play = useDispatchForm(gamePlayed, playerNameRef);

  return (
    <Bar>
      <LoadingWidget />
      City Game!
      <Spacer />
      <LinkTo name="welcome">Welcome</LinkTo>
      <span>&nbsp;|&nbsp;</span>
      <LinkDispatch createAction={blogPushed} data-testid="go-to-blog">
        Blog
      </LinkDispatch>
      <Spacer />
      <input ref={playerNameRef} data-testid="input-player-name" />
      <button data-testid="button-play" onClick={play}>
        Play
      </button>
    </Bar>
  );
}
