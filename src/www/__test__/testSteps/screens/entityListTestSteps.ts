import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const entityListTestSteps: PostLineStep[] = [
  step(
    /"([^"]+)" should have (\d+) ([a-z]+)/,
    (line, [, owner, count, type]) => {
      var entities = getAllEntityListItemByContents([owner, type]);
      expect(entities).toHaveLength(+count);
    }
  ),
  step(
    /"([^"]+)" should have the "([^"]+)" ([a-z]+)/,
    (line, [, owner, name, type]) => {
      expect(
        getEntityListItemByContents([owner, type, name])
      ).toBeInTheDocument();
    }
  ),
  step(
    /Click on the "([^"]+)" ([a-z]+) "([^"]+)"/,
    (line, [, owner, type, name]) => {
      var item = getEntityListItemByContents([owner, type, name]);
      userEvent.click(item);
    }
  ),
];

function getAllEntityListItems(): HTMLElement[] {
  return screen.getAllByRole("listitem");
}

function getAllEntityListItemByContents(contents: string[]): HTMLElement[] {
  const allEntities = getAllEntityListItems();

  const result = allEntities.filter((entity) =>
    contents.every((match) => entity.textContent!.includes(match))
  );

  if (result.length === 0)
    throw new Error(
      `Could not find any entity in the games with "${contents.join(
        '"", "'
      )}".\n` +
        `Available items are:\n- ` +
        allEntities.map((g) => g.textContent).join("\n- ")
    );

  return result;
}

function getEntityListItemByContents(contents: string[]): HTMLElement {
  const allEntities = getAllEntityListItemByContents(contents);
  if (allEntities.length > 1)
    throw new Error(
      `Found more than one entity in the games with "${contents.join(
        '"", "'
      )}".\n` +
        `Available items are:\n- ` +
        allEntities.map((g) => g.textContent).join("\n- ")
    );

  return allEntities[0];
}
