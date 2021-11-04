export type ComponentWallState = null;


export const WALL_ORDERED = "componentWall/WALL_ORDERED";
export interface WallOrderedAction{
  type: typeof WALL_ORDERED
  entityId: String;
  form: {
    type: string;
  };
}

export type ComponentWallActionTypes = WallOrderedAction;
