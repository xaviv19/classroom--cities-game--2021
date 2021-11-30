import { componentBuilderMiddleware } from "./BuilderComponent/middleware";
import { componentLeveledMiddleware } from "./LeveledComponent/middleware";
import { componentLoadableMiddleware } from "./LoadableComponent/middleware";
import { componentNamedMiddleware } from "./NamedComponent/middleware";
import { componentSailMiddleware } from "./SailComponent/middleware";

export const componentsMiddlewares = [
  //
  componentBuilderMiddleware,
  componentLeveledMiddleware,
  componentLoadableMiddleware,
  componentNamedMiddleware,
  componentSailMiddleware,
];
