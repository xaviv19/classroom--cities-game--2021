import {
  LoadOrderedAction,
  LOAD_ORDERED,
  UnloadOrderedAction,
  UNLOAD_ORDERED,
} from "./types";

export function loadOrdered(
  entityId: string,
  dockId: string,
  loadUnloadAmount: number,
  resource: string
): LoadOrderedAction {
  return {
    type: LOAD_ORDERED,
    entityId,
    form: {
      dockId,
      loadUnloadAmount: +loadUnloadAmount,
      resource,
    },
  };
}

export function unloadOrdered(
  entityId: string,
  dockId: string,
  loadUnloadAmount: number,
  resource: string
): UnloadOrderedAction {
  return {
    type: UNLOAD_ORDERED,
    entityId,
    form: {
      dockId,
      loadUnloadAmount: +loadUnloadAmount,
      resource,
    },
  };
}
