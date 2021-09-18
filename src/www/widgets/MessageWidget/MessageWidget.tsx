import { useCallback } from "react";
import { useAppDispatch, useAppSelector } from "www/store/hooks";
import { messageDismissed } from "./actions";
import { getMessage } from "./selectors";

export function MessageWidget() {
  const dispatch = useAppDispatch();
  const dismiss = useCallback(() => dispatch(messageDismissed()), [dispatch]);
  const message = useAppSelector(getMessage);
  if (!message) return null;

  return (
    <div role="alert" className={message.isError ? "error" : ""}>
      {message.text}
      <button onClick={dismiss}>dismiss</button>
    </div>
  );
}
