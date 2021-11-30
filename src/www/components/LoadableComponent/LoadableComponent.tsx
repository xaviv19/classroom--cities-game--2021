import { useMemo } from "react";
import { useAppSelector, useDispatchForm, useInputRef } from "www/store/hooks";
import { loadOrdered, unloadOrdered } from "./actions";
import { makeGetDockByLocation } from "../DockComponent/selectors";

export function LoadableComponent({ entity }: any) {
  const newLoadUnloadAmountRef = useInputRef();
  const resourceRef = useInputRef();
  const getDockByLocation = useMemo(makeGetDockByLocation, []);
  const dockId = useAppSelector((state) =>
    getDockByLocation(state, entity)
  )?.id;
  const load = useDispatchForm(
    loadOrdered,
    entity.id,
    dockId,
    newLoadUnloadAmountRef,
    resourceRef
  );
  const unload = useDispatchForm(
    unloadOrdered,
    entity.id,
    dockId,
    newLoadUnloadAmountRef,
    resourceRef
  );

  if (!entity.isLoadable) return null;

  return (
    <>
      <div>Load/unload amount: {entity.loadUnloadAmount}</div>
      <label>
        Load/unload amount:
        <input type="number" ref={newLoadUnloadAmountRef} />
      </label>
      <label>
        Resource:
        <input ref={resourceRef} />
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
