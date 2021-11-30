import { UpgradedAction, UPGRADED } from "./types";

export function upgraded(entityId: string): UpgradedAction {
  return {
    type: UPGRADED,
    entityId,
  };
}
