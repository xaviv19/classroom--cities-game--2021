export function MaterialIronComponent({ entity }: any) {
  if (!entity.quantity) return null;
  return <div>Iron: {entity.quantity}</div>;
}
