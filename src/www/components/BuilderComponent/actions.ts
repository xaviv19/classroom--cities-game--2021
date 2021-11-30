import { BuildedAction, BUILDED } from "./types";

export function builded(
  entityId: string,
  buildingName: string,
  containerId: string
): BuildedAction {
  return {
    type: BUILDED,
    entityId,
    containerId,
    form: {
      buildingName,
    },
  };
}
