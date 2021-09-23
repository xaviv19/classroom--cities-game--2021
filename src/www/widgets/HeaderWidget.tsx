import { LinkTo } from "./LinkToWidget";
import { LoadingWidget } from "./LoadingWidget";
import { Bar } from "www/theme/Bar";
import { Spacer } from "www/theme/Spacer";

export function HeaderWidget() {
  return (
    <Bar>
      <LoadingWidget />
      City Game!
      <Spacer />
      <LinkTo name="login">Login</LinkTo>
      <span>&nbsp;|&nbsp;</span>
      <LinkTo name="addNextPlayer">Multiplayer</LinkTo>
    </Bar>
  );
}
