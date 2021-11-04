import {useDispatchForm} from "../../store/hooks";
import {wallOrdered} from "./actions"

export function WallComponent({ entity }: any) {
  const buildWall = useDispatchForm(wallOrdered, entity.id, "WALL")
  return (
    <div>
      Wall: {entity.quantity}<br />
      <button onClick ={buildWall}>Create wall</button>
    </div>
  );
}
