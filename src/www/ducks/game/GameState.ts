interface PlayerState {
  name: string;
}

export interface GameState {
  game: {
    gameName: string;
    currentPlayerName: string;
    round: number;
    players: { [name: string]: PlayerState };
  };
}
