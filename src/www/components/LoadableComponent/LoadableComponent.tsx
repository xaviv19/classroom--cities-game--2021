import { useMemo } from "react";
import { useAppSelector, useDispatchForm, useInputRef } from "www/store/hooks";
import { loadOrdered, unloadOrdered } from "./actions";
import { makeGetDockByLocation } from "../DockComponent/selectors";

export function LoadableComponent({ entity }: any) {
  const newLoadUnloadAmount = useInputRef();
  const getDockByLocation = useMemo(makeGetDockByLocation, []);
  const sourceEntityId = useAppSelector((state) =>
    getDockByLocation(state, entity)
  )?.id;
  const load = useDispatchForm(
    loadOrdered,
    entity.id,
    sourceEntityId,
    newLoadUnloadAmount
  );
  const unload = useDispatchForm(
    unloadOrdered,
    entity.id,
    sourceEntityId,
    newLoadUnloadAmount
  );

  return (
    <>
      <div>Load/unload amount: {entity.loadUnloadAmount}</div>
      <pre>{JSON.stringify(entity, null, 2)}</pre>
      <label>
        Load/unload amount:
        <input type="number" ref={newLoadUnloadAmount} />
      </label>
      <button onClick={load} disabled={entity.loadRequested}>
        Load
      </button>
      <button onClick={unload} disabled={entity.unloadRequested}>
        Unload
      </button>
    </>
  );
}
