import { componentLoadableReducer } from "./LoadableComponent/reducers";
import { componentNamedReducer } from "./NamedComponent/reducers";
import { componentSailReducer } from "./SailComponent/reducers";
import {componentHouseReducer} from "./HouseComponent/reducers";

export const componentsReducers = {
  componentLoadable: componentLoadableReducer,
  componentNamed: componentNamedReducer,
  componentSail: componentSailReducer,
  componentHouse: componentHouseReducer,

};
