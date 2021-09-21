import { useAppSelector, useDispatchForm, useInputRef } from "www/store/hooks";
import { getPlayerName } from "www/store/player/selectors";
import { nameChanged } from "./actions";

export function NamedComponent({ entity }: any) {
  const currentPlayer = useAppSelector(getPlayerName);
  const newNameRef = useInputRef();
  const changeName = useDispatchForm(nameChanged, entity.id, newNameRef);
  if (entity.owner !== currentPlayer) return null;

  return (
    <>
      <label>
        New name
        <input ref={newNameRef} />
      </label>
      <button onClick={changeName}>Change name</button>
    </>
  );
}
