import {ComponentWallActionTypes, ComponentWallState} from "./types";

export function componentWallReducer(
  state: ComponentWallState = null,
  action: ComponentWallActionTypes
) {
  switch (action.type) {
    default:
      return state;
  }
}
