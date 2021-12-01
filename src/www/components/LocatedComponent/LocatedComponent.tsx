import { Section } from "www/theme/Section";

export function LocatedComponent({ entity }: any) {
  if (!entity.isLocated) return null;

  return <Section>Location: {entity.location}</Section>;
}
