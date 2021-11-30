import { useAppSelector, useDispatchForm, useSelectRef } from "www/store/hooks";
import { builded } from "./actions";

export function BuilderComponent({ entity }: any) {
  const newNameRef = useSelectRef();
  const build = useDispatchForm(
    builded,
    entity.id,
    newNameRef,
    entity.containerId
  );
  if (!entity.buildeableBuildings) return null;

  return (
    <>
      <br />
      <label>
        Building type:
        <br />
        <select ref={newNameRef}>
          {entity.buildeableBuildings.map((type: any) => (
            <option key={type} value={type}>
              {type}
            </option>
          ))}
        </select>
      </label>
      <br />
      <button onClick={build}>Build</button>
      <br />
      <br />
    </>
  );
}
