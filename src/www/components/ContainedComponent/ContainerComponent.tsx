import { useMemo } from "react";
import { useSelector } from "react-redux";
import { EntityList } from "www/screens/EntityScreen/EntityList";
import { makeGetAllContainedByEntityId } from "./selectors";

export function ContainerComponent({ entity }: any) {
  const getContaineds = useMemo(makeGetAllContainedByEntityId, []);
  const containeds = useSelector((s) =>
    getContaineds(s, { entityId: entity.id })
  );

  if (!containeds.length) return null;

  return <EntityList entities={containeds} />;
}
