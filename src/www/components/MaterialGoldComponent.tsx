export function MaterialGoldComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Gold: {entity.quantity}</div>;
}
