import { useMemo } from "react";
import { Section } from "www/theme/Section";
import {
  useAppSelector,
  useDispatchForm,
  useInputRef,
  useSelectRef,
} from "www/store/hooks";
import { loadOrdered, unloadOrdered } from "./actions";
import { makeGetDockByLocation } from "../DockComponent/selectors";

export function LoadableComponent({ entity }: any) {
  const newLoadUnloadAmountRef = useInputRef();
  const resourceRef = useSelectRef();
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
    <Section>
      <label>
        Load/unload amount:
        <br />
        <input type="number" ref={newLoadUnloadAmountRef} />
      </label>
      <br />
      <label>
        Resource:
        <br />
        <select ref={resourceRef}>
          {Object.keys(entity.resources).map((resource) => (
            <option key={resource} value={resource}>
              {resource}
            </option>
          ))}
        </select>
      </label>{" "}
      <button onClick={load} disabled={entity.loadRequested}>
        Load
      </button>
      <button onClick={unload} disabled={entity.unloadRequested}>
        Unload
      </button>
    </Section>
  );
}
