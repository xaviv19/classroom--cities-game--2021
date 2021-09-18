import { useDispatchForm, useInputRef } from "www/store/hooks";
import { loggedIn } from "www/store/player/actions";

export function LoginScreen() {
  const playerNameRef = useInputRef();
  const passwordRef = useInputRef();
  const singUp = useDispatchForm(loggedIn, playerNameRef, passwordRef);

  return (
    <div>
      <h1>Log In!</h1>

      <label>
        Player name
        <input ref={playerNameRef} />
      </label>

      <label>
        Password
        <input ref={passwordRef} type="password" />
      </label>

      <button onClick={singUp}>Signup</button>
    </div>
  );
}
