import {
  WALL_ORDERED, WallOrderedAction,
} from "./types";

export function wallOrdered(
  entityId: string,
  type: string
): WallOrderedAction {
  return {
    type: WALL_ORDERED,
    entityId,
    form: {
      type
    },
  };
}

