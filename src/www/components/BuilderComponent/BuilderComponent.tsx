import { Section } from "www/theme/Section";
import { useDispatchForm, useSelectRef } from "www/store/hooks";
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
    <Section>
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
      </label>{" "}
      <button onClick={build}>Build</button>
    </Section>
  );
}
