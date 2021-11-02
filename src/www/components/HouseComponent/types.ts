export type ComponentHouseState = null;


export const HOUSE_ORDERED = "componentHouse/HOUSE_ORDERED";
export interface HouseOrderedAction{
  type: typeof HOUSE_ORDERED
  entityId: String;
  form: {
    type: string;
  };
}

export type ComponentHouseActionTypes = HouseOrderedAction;
