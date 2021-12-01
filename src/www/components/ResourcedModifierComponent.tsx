import { Section } from "www/theme/Section";

export function ResourcedModifierComponent({ entity }: any) {
  const { modifierResourceName, modifierRoundIncrement, modifierMaximum } =
    entity;
  if (!modifierResourceName) return null;

  return (
    <Section>
      Modifies the resource{" "}
      <span data-testid="resource-modifier-name">{modifierResourceName}</span>
      <br />
      {modifierRoundIncrement > 0 && (
        <>
          * Each round increments an additional:{" "}
          <span data-testid="resource-modifier-roundincrement">
            {modifierRoundIncrement}
          </span>
        </>
      )}{" "}
      {modifierMaximum > 0 && (
        <>
          * Maximum capacity increases in:{" "}
          <span data-testid="resource-modifier-maximum">{modifierMaximum}</span>
        </>
      )}
    </Section>
  );
}
