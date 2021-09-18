import { useDispatchForm, useInputRef } from "www/store/hooks";
import { signedUp } from "www/store/player/actions";

export function SignUpScreen() {
  const playerNameRef = useInputRef();
  const passwordRef = useInputRef();
  const singUp = useDispatchForm(signedUp, playerNameRef, passwordRef);

  return (
    <div>
      <h1>Sign up!</h1>

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
