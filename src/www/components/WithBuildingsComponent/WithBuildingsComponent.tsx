import { useDispatchForm, useInputRef } from "www/store/hooks";
import { buildOrdered } from "./actions";

export function WithBuildingsComponent({ entity }: any) {
  const build = useDispatchForm(buildOrdered, entity.id, "house");

  return (
    <div>
      Houses: {entity.buildingHouses}
      <br />
      <button onClick={build}>Build house</button>
      {entity.buildHouse && "(building house)"}
    </div>
  );
}
