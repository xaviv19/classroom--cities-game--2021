export function MaterialWoodComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Wood: {entity.quantity}</div>;
}
