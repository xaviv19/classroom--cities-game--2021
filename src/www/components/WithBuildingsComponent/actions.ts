import { BuildOrderedAction, BUILD_ORDERED } from "./types";

export function buildOrdered(
  entityId: string,
  buildingType: string
): BuildOrderedAction {
  return {
    type: BUILD_ORDERED,
    entityId,
    form: {
      buildingType,
    },
  };
}
