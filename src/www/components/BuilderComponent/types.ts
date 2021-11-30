export type ComponentBuilderState = null;

export const BUILDED = "componentBuilder/BUILDED";
export interface BuildedAction {
  type: typeof BUILDED;
  entityId: string;
  containerId: string;
  form: {
    buildingName: string;
  };
}

export type ComponentBuilderActionTypes = BuildedAction;
