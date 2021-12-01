import { useMemo } from "react";
import { Section } from "www/theme/Section";
import { EntityList } from "www/screens/EntityScreen/EntityList";
import { useAppSelector } from "www/store/hooks";
import { makeGetAllContainedByEntityId } from "./selectors";

export function ContainerComponent({ entity }: any) {
  const getContaineds = useMemo(makeGetAllContainedByEntityId, []);
  const containeds = useAppSelector((s) =>
    getContaineds(s, { entityId: entity.id })
  );

  if (!containeds.length) return null;

  return (
    <Section>
      Contents:
      <EntityList entities={containeds} />
    </Section>
  );
}
