export function QuantityComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Quantity: {entity.quantity}</div>;
}
