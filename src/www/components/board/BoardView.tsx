import React, { useMemo } from "react";
import { useSelector } from "react-redux";
import { getPlayerTotalReceivedFoodCount, listPlayers } from "www/ducks/game";
import { Hand } from "./Hand";
import { Pile } from "./Pile";
import { Squares } from "./Squares";
import { listSquareCards } from "www/ducks/cards";

function PlayerView({ player }: { player: string }) {
  const handCards = useSelector((s: any) =>
    listSquareCards(s, { player, square: 0 })
  );
  const count = useMemo(
    () => handCards.filter((c) => c.type === "material").length,
    [handCards]
  );

  const food = useSelector((s: any) =>
    getPlayerTotalReceivedFoodCount(s, { player })
  );

  return (
    <>
      <h3>Player: {player}</h3>
      <span data-testid={`player-${player}-total-food-counter`}>{food}</span>
      <span data-testid={`player-${player}-card-counter`}>{count}</span>
      <Squares player={player} key={player} />
      <Hand player={player} />
      <br />
    </>
  );
}

export function BoardView() {
  const players = useSelector(listPlayers);

  return (
    <div>
      <br />
      <Pile name="event" />
      <Pile name="buy-field" />
      <Pile name="buy-knight" />
      <Pile name="train" />
      <Pile name="build" />
      <hr />
      {players.map((player) => (
        <PlayerView player={player} key={player} />
      ))}
    </div>
  );
}
