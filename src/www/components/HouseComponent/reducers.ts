import {ComponentHouseActionTypes, ComponentHouseState} from "./types";

export function componentHouseReducer(
  state: ComponentHouseState = null,
  action: ComponentHouseActionTypes
) {
  switch (action.type) {
    default:
      return state;
  }
}
