import { Section } from "www/theme/Section";
import { ListResources } from "./ListResources";

export function ResourcedComponent({ entity }: any) {
  if (!entity.resources) return null;

  return (
    <Section>
      Resources:
      <ListResources resources={entity.resources} />
    </Section>
  );
}
