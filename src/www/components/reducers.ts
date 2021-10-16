import { componentLoadableReducer } from "./LoadableComponent/reducers";
import { componentNamedReducer } from "./NamedComponent/reducers";
import { componentSailReducer } from "./SailComponent/reducers";
import { componentWithBuildingsReducer } from "./WithBuildingsComponent/reducers";

export const componentsReducers = {
  componentLoadable: componentLoadableReducer,
  componentNamed: componentNamedReducer,
  componentSail: componentSailReducer,
  componentWithBuildings: componentWithBuildingsReducer,
};
