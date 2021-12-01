import { ListResources } from "./ListResources";

export function ResourcedComponent({ entity }: any) {
  if (!entity.resources) return null;

  return (
    <ul>
      Resources:
      <ListResources resources={entity.resources} />
    </ul>
  );
}
