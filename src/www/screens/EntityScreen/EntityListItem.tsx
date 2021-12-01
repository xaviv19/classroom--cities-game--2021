import { useCallback } from "react";
import { useAppDispatch } from "www/store/hooks";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";

export function EntityListItem({ entity }: any) {
  const dispatch = useAppDispatch();
  const go = useCallback(
    () => dispatch(screenPushed("entity", entity.id)),
    [dispatch, entity]
  );

  const { type, name, owner } = entity;

  return (
    <li
      onClick={go}
      data-testid="entity-list-item"
      style={{ textDecoration: "underline", cursor: "pointer" }}
    >
      {type}: {name}
      {owner && ` of ${owner}`}
    </li>
  );
}
