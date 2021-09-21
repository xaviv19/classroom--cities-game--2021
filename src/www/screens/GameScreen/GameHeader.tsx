import { roundEnded } from "www/store/game/actions";
import { getGame } from "www/store/game/selectors";
import { useAppSelector } from "www/store/hooks";
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
      <LinkDispatch createAction={roundEnded}>End Round</LinkDispatch> | Game{" "}
      {gameName} created by {creatorName}, round {roundNumber}
    </div>
  );
}
