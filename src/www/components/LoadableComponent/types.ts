export type ComponentLoadableState = null;

export const LOAD_ORDERED = "componentLoadable/LOAD_ORDERED";
export interface LoadOrderedAction {
  type: typeof LOAD_ORDERED;
  entityId: string;
  form: {
    dockId: string;
    loadUnloadAmount: number;
    resource: string;
  };
}

export const UNLOAD_ORDERED = "componentLoadable/UNLOAD_ORDERED";
export interface UnloadOrderedAction {
  type: typeof UNLOAD_ORDERED;
  entityId: string;
  form: {
    dockId: string;
    loadUnloadAmount: number;
    resource: string;
  };
}

export type ComponentLoadableActionTypes =
  | LoadOrderedAction
  | UnloadOrderedAction;
