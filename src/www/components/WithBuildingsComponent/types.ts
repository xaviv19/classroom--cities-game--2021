export type ComponentWithBuildingsState = null;

export const BUILD_ORDERED = "componentWithBuildings/BUILD_ORDERED";
export interface BuildOrderedAction {
  type: typeof BUILD_ORDERED;
  entityId: string;
  form: {
    buildingType: string;
  };
}

export type ComponentWithBuildingsActionTypes = BuildOrderedAction;
