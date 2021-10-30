import {useDispatchForm} from "../store/hooks";
import {nameChanged} from "./NamedComponent/actions";

export function HouseComponent({ entity }: any) {
  return (
    <div>
      <div>House: {entity.quantity}</div>
      <button >Create House</button>
    </div>);
}
