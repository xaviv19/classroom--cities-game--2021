import { useCallback } from "react";
import { getGamesList } from "www/store/gamesList/selectors";
import { useAppDispatch, useAppSelector } from "www/store/hooks";
import { screenPopped } from "www/widgets/ScreenStackWidget/actions";
import { GamesListItem } from "./GamesListItem";

export function GamesListScreen() {
  const list = useAppSelector(getGamesList);
  const dispatch = useAppDispatch();
  const cancel = useCallback(() => dispatch(screenPopped()), [dispatch]);

  if (!list) return null;

  return (
    <div>
      <h1>Games List!</h1>
      <div>{JSON.stringify(list)}</div>
      <ul>
        {list.map((item) => (
          <GamesListItem
            key={item.gameName + "#" + item.creatorName}
            item={item}
          />
        ))}
      </ul>
      <button onClick={cancel}>Cancel</button>
    </div>
  );
}
