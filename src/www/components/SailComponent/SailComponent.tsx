import { useDispatchForm, useInputRef } from "www/store/hooks";
import { sailOrdered, haltOrdered } from "./actions";

export function SailComponent({ entity }: any) {
  const destinationLocationRef = useInputRef();
  const sail = useDispatchForm(sailOrdered, entity.id, destinationLocationRef);
  const halt = useDispatchForm(haltOrdered, entity.id);

  return (
    <div>
      {entity.destinationSail && (
        <div>Destination location: {entity.destinationLocation} (sailing).</div>
      )}
      <label>
        Destination location:
        <input type="number" ref={destinationLocationRef} />
      </label>
      <button onClick={sail}>Sail</button>
      <button onClick={halt}>Halt</button>
    </div>
  );
}
