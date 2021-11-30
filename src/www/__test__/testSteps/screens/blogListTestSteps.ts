import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";

export const blogListTestSteps: PostLineStep[] = [
  step(/Go to the Blog/, () => {
    screen.getByTestId("go-to-blog").click();
  }),
  step(/You should see at least (\d+) posts/, (line, match) => {
    const count = +match[1];

    expect(getAllBlogListItems().length).toBeGreaterThanOrEqual(count);
  }),
  step(/You should see the post "([^"]+)"/, (line, match) => {
    const title = match[1];

    expect(screen.getByText(title)).toBeInTheDocument();
  }),
  step(/The post "([^"]+)" should be the last post/, (line, match) => {
    const title = match[1];

    const allItems = getAllBlogListItems();
    const lastItem = allItems[allItems.length - 1];
    expect(lastItem).toHaveTextContent(title);
  }),
  step(/Click on the post "([^"]+)"/, (line, match) => {
    const title = match[1];

    const allItems = getAllBlogListItems();
    const theItem = allItems.find((item) => item.textContent?.includes(title));
    theItem?.click();
  }),
];

function getAllBlogListItems(): HTMLElement[] {
  return screen.getAllByTestId("blog-list-item");
}
