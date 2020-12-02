import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { css } from "emotion";
import { listPileCards } from "www/ducks/cards";
import { playSelectedCard } from "www/ducks/selectedCard";
import { Cards } from "./Cards";

const pileClassName = css`
  background: blueviolet;
  display: inline-block;
  height: 3rem;
  width: 8rem;
  box-sizing: border-box;
  color: white;
  border: solid white 1px;
  text-align: center;
  overflow: hidden;
  white-space: nowrap;
  cursor: pointer;
`;

export function Pile({ name }: { name: string }) {
  const dispatch = useDispatch();
  const cards = useSelector((s: any) => listPileCards(s, { pile: name }));
  const pile = () => dispatch(playSelectedCard(name));

  return (
    <div className={pileClassName} data-testid={`pile-${name}`} onClick={pile}>
      {name}
      <Cards cards={cards} />
    </div>
  );
}
