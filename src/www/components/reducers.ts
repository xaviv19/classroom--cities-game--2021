import { componentBuilderReducer } from "./BuilderComponent/reducers";
import { componentLeveledReducer } from "./LeveledComponent/reducers";
import { componentLoadableReducer } from "./LoadableComponent/reducers";
import { componentNamedReducer } from "./NamedComponent/reducers";
import { componentSailReducer } from "./SailComponent/reducers";

export const componentsReducers = {
  componentBuilder: componentBuilderReducer,
  componentLeveled: componentLeveledReducer,
  componentLoadable: componentLoadableReducer,
  componentNamed: componentNamedReducer,
  componentSail: componentSailReducer,
};
