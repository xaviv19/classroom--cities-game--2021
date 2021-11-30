import { LinkTo } from "www/widgets/LinkToWidget";

export function WelcomeScreen() {
  return (
    <main data-testid="screen-welcome">
      <h1>Welcome to the game!</h1>
      <LinkTo name="signup">Sign up</LinkTo>
    </main>
  );
}
