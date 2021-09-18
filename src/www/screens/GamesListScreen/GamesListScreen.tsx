import { useCallback } from "react";
import { useSelector } from "react-redux";
import { getGamesList } from "www/store/gamesList/selectors";
import { useAppDispatch } from "www/store/hooks";
import { screenPopped } from "www/widgets/ScreenStackWidget/actions";
import { GamesListItem } from "./GamesListItem";

export function GamesListScreen() {
  const list = useSelector(getGamesList);
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
