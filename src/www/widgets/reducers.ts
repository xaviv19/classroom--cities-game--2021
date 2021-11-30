import { widgetLoadingReducer } from "./LoadingWidget/reducers";
import { widgetScreenStackReducer } from "./ScreenStackWidget/reducers";

export const widgetsReducers = {
  widgetLoading: widgetLoadingReducer,
  widgetScreenStack: widgetScreenStackReducer,
};
