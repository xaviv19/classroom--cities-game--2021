import { ListResources } from "./ListResources";

// TODO
export function ResourcedComponent({ entity }: any) {
  if (!entity.resources) return null;

  const { resources } = entity;
  const keys = Object.keys(resources);

  return (
    <ul>
      Resources:
      <ListResources resources={entity.resources} />
    </ul>
  );
}

function prettyPrint(name: string, resource: any) {
  return `${capitalize(name)}: ${resource.count}/${resource.maximum} (+${
    resource.roundIncrement
  })`;
}

function capitalize(name: string) {
  return name[0].toUpperCase() + name.slice(1);
}
