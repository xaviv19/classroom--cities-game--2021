import { Section } from "www/theme/Section";
import { useDispatchForm } from "www/store/hooks";
import { upgraded } from "./actions";

export function LeveledComponent({ entity }: any) {
  const build = useDispatchForm(upgraded, entity.id);
  if (!entity.level) return null;

  return (
    <Section>
      Level: {entity.level}. <button onClick={build}>Upgrade</button>
    </Section>
  );
}
