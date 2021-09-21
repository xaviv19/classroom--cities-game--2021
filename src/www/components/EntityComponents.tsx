import { Components } from "./index";

export function EntityComponents({ entity }: { entity: any }) {
  return (
    <>
      {Components.map((Component: any, index) => (
        <Component key={index} entity={entity} />
      ))}
    </>
  );
}
