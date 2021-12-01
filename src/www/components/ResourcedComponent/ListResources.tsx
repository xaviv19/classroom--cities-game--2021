export function ListResources({ resources, prefixTestId = "" }: any) {
  return (
    <ul>
      {Object.keys(resources).map((name: string) => (
        <li key={name} data-testid={`${prefixTestId}resource-${name}`}>
          {prettyPrint(name, resources[name])}
        </li>
      ))}
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
