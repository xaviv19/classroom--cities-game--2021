export function MaterialStoneComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Stone: {entity.quantity}</div>;
}
