import { componentNamedReducer } from "./NamedComponent/reducers";
import { componentSailReducer } from "./SailComponent/reducers";

export const componentsReducers = {
  componentNamed: componentNamedReducer,
  componentSail: componentSailReducer,
};
