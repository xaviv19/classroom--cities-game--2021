import { makeGetAllGameEntities } from "www/store/game/selectors";
import { createSelector } from "reselect";

export function makeSelectLocatedEntities() {
  const getAllGameEntities = makeGetAllGameEntities();
  return createSelector(getAllGameEntities, (entities) =>
    entities?.filter((e) => e.isLocated)
  );
}
