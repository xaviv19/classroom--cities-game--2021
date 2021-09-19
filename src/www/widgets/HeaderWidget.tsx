import { LinkTo } from "./LinkToWidget";
import { LoadingWidget } from "./LoadingWidget";

export function HeaderWidget() {
  return (
    <div>
      Header | <LinkTo name="login">Login</LinkTo>|{" "}
      <LinkTo name="addNextPlayer">Multiplayer</LinkTo>
      <LoadingWidget />
    </div>
  );
}
