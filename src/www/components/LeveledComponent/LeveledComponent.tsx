import { useDispatchForm } from "www/store/hooks";
import { upgraded } from "./actions";

export function LeveledComponent({ entity }: any) {
  const build = useDispatchForm(upgraded, entity.id);
  if (!entity.level) return null;

  return (
    <div>
      Level: {entity.level}.
      <br />
      <button onClick={build}>Upgrade</button>
    </div>
  );
}
