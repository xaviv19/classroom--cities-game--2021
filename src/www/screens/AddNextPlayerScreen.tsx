import { useCallback } from "react";
import { useAppDispatch, useDispatchForm, useInputRef } from "www/store/hooks";
import { nextPlayerAdded } from "www/store/multiplayer/actions";
import { screenPopped } from "www/widgets/ScreenStackWidget/actions";

export function AddNextPlayerScreen() {
  const playerNameRef = useInputRef();
  const passwordRef = useInputRef();
  const add = useDispatchForm(nextPlayerAdded, playerNameRef, passwordRef);
  const dispatch = useAppDispatch();
  const cancel = useCallback(() => dispatch(screenPopped()), [dispatch]);

  return (
    <div>
      <h1>Add next player!</h1>

      <label>
        Next player name
        <input ref={playerNameRef} />
      </label>

      <label>
        Next player password
        <input ref={passwordRef} type="password" />
      </label>

      <button onClick={add}>Join Next</button>
      <button onClick={cancel}>Cancel</button>
    </div>
  );
}
