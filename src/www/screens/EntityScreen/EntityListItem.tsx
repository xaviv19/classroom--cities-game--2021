import { useCallback } from "react";
import { useAppDispatch } from "www/store/hooks";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";

export function EntityListItem({ entity }: any) {
  const dispatch = useAppDispatch();
  const go = useCallback(
    () => dispatch(screenPushed("entity", entity.id)),
    [dispatch, entity]
  );

  const { type, name, owner, resources } = entity;
  let potatoEmoji = type === "ship" && resources?.potato.maximum > 0 ? "\ud83e\udd54" : "";

  return (
    <li
      onClick={go}
      data-testid="entity-list-item"
      style={{ textDecoration: "underline", cursor: "pointer" }}
    >
      {type}: {name }
      {owner && ` of ${owner}`}
      {potatoEmoji}
    </li>
  );
}
