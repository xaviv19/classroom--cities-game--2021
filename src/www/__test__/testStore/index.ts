import { createAppStore, AppStore } from "www/store";

let store: AppStore;
beforeEach(() => {
  store = createAppStore();
});

export function testGetStore() {
  return store;
}
