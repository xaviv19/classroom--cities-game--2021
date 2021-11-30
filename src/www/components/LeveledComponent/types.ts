export type ComponentLeveledState = null;

export const UPGRADED = "componentLeveled/UPGRADED";
export interface UpgradedAction {
  type: typeof UPGRADED;
  entityId: string;
}

export type ComponentLeveledActionTypes = UpgradedAction;
