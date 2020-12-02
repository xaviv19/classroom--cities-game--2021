import React from "react";
import { Square } from "./Square";

export function Squares({ player }: { player: string }) {
  return (
    <div>
      <Square player={player} square={1} />
      <Square player={player} square={2} />
      <Square player={player} square={3} />
      <Square player={player} square={4} />
      <Square player={player} square={5} />
    </div>
  );
}
