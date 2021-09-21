import { gameRefreshed, roundEnded } from "www/store/game/actions";
import { getGame } from "www/store/game/selectors";
import { useAppSelector } from "www/store/hooks";
import { ButtonDispatch } from "www/widgets/ButtonDispatchWidget";
import { LinkDispatch } from "www/widgets/LinkDispatchWidget";
import { screenPopped } from "www/widgets/ScreenStackWidget/actions";
import { getCurrentScreenName } from "www/widgets/ScreenStackWidget/selectors";

export function GameHeader() {
  const isGameScreen = useAppSelector(getCurrentScreenName) === "game";
  const game = useAppSelector(getGame)!;
  const { gameName, creatorName, roundNumber } = game;

  return (
    <div data-testid="game-header">
      {!isGameScreen && (
        <>
          <LinkDispatch createAction={screenPopped}>« Back</LinkDispatch>
        </>
      )}{" "}
      <ButtonDispatch createAction={roundEnded}>End Round</ButtonDispatch> |{" "}
      <ButtonDispatch createAction={gameRefreshed}>Refresh</ButtonDispatch> |
      Game {gameName} created by {creatorName}, round {roundNumber}
    </div>
  );
}
