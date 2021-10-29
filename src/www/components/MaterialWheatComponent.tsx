export function MaterialWheatComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Wheat: {entity.quantity}</div>;
}
