import { Provider } from "react-redux";
import { HeaderWidget } from "./widgets/HeaderWidget";
import { ScreenStackWidget } from "./widgets/ScreenStackWidget";

export function App({ store }: { store: any }) {
  return (
    <Provider store={store}>
      <div>
        <HeaderWidget />
        <ScreenStackWidget />
      </div>
    </Provider>
  );
}
