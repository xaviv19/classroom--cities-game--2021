import { useCallback } from "react";
import { AppActionType } from "www/store";
import { useAppDispatch } from "www/store/hooks";

export function LinkDispatch({
  createAction,
  children,
  "data-testid": testId,
}: {
  createAction: () => AppActionType;
  children: React.ReactNode;
  "data-testid"?: string;
}) {
  const dispatch = useAppDispatch();
  const go = useCallback(
    () => dispatch(createAction()),
    [dispatch, createAction]
  );

  return (
    <span role="link" onClick={go} data-testid={testId}>
      {children}
    </span>
  );
}
