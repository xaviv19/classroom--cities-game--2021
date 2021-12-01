import { useAppSelector, useDispatchForm, useInputRef } from "www/store/hooks";
import { Section } from "www/theme/Section";
import { getGame } from "www/store/game/selectors";
import { nameChanged } from "./actions";

export function NamedComponent({ entity }: any) {
  const currentPlayer = useAppSelector(getGame)?.playerName;
  const newNameRef = useInputRef();
  const changeName = useDispatchForm(nameChanged, entity.id, newNameRef);
  if (entity.owner !== currentPlayer) return null;

  return (
    <Section>
      <label>
        New name:
        <br />
        <input ref={newNameRef} />
      </label>{" "}
      <button onClick={changeName}>Change name</button>
    </Section>
  );
}
