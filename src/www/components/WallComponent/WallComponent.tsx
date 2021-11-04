import {useDispatchForm} from "../../store/hooks";
import {houseOrdered} from "./actions"

export function HouseComponent({ entity }: any) {
  const buildHouse = useDispatchForm(houseOrdered, entity.id, "HOUSE")
  return (
    <div>
      House: {entity.quantity}<br />
      <button onClick ={buildHouse}>Create house</button>
    </div>
  );
}
