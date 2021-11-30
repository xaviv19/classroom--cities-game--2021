import { useCallback, useMemo } from "react";
import { useAppDispatch, useAppSelector } from "www/store/hooks";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";
import { ListResources } from "../ResourcedComponent/ListResources";
import { makeGetDockByLocation } from "./selectors";

export function DockedComponent({ entity }: any) {
  const getDockByLocation = useMemo(makeGetDockByLocation, []);
  const dock = useAppSelector((state) => getDockByLocation(state, entity));
  const dispatch = useAppDispatch();
  const seeTheDock = useCallback(
    () => dispatch(screenPushed("entity", dock.id)),
    [dock, dispatch]
  );

  // TODO: remove entity.isDock?
  if (entity.isDock || !dock) return null;

  return (
    <div>
      <ul>
        Dock Resources:
        <ListResources resources={dock.resources} prefixTestId="dock-" />
      </ul>
      Docked at: {dock.type} {dock.name} of {dock.owner}
      &nbsp;
      <button onClick={seeTheDock}>See the dock</button>.
    </div>
  );
}
