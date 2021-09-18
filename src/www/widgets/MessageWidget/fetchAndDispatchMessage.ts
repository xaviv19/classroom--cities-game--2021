import { AppDispatch } from "www/store";
import { messageShown } from "./actions";

export async function fetchAndDispatchMessage(
  url: Parameters<typeof fetch>[0],
  options: Parameters<typeof fetch>[1],
  dispatch: AppDispatch
): Promise<any> {
  const response = await fetch(url, options);

  const body = await response.json();
  if (typeof body.message === "string") {
    dispatch(messageShown(body.message, body.isError));
  }

  return body;
}
