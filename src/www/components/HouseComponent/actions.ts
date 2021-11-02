import {
  HOUSE_ORDERED, HouseOrderedAction,
} from "./types";

export function houseOrdered(
  entityId: string,
  type: string
): HouseOrderedAction {
  return {
    type: HOUSE_ORDERED,
    entityId,
    form: {
      type
    },
  };
}

