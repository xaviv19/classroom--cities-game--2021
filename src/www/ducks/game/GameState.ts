interface PlayerState {
  name: string;
  totalReceivedFoodCount: number;
}

export interface GameState {
  game: {
    gameName: string;
    currentPlayerName: string;
    round: number;
    players: { [name: string]: PlayerState };
    scenario: {
      name: string;
      values: { [key: string]: string };
    };
  };
}
