export function ResourcedModifierComponent({ entity }: any) {
  const { modifierResourceName, modifierRoundIncrement, modifierMaximum } =
    entity;
  if (!modifierResourceName) return null;

  return (
    <div>
      Modifies the resource
      <span data-testid="resource-modifier-name">{modifierResourceName}</span>,
      each round increments more:{" "}
      <span data-testid="resource-modifier-roundincrement">
        {modifierRoundIncrement}
      </span>
      and the maximum increases:{" "}
      <span data-testid="resource-modifier-maximum">{modifierMaximum}</span>
    </div>
  );
}
