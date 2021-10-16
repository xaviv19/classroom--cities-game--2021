import { componentLoadableMiddleware } from "./LoadableComponent/middleware";
import { componentNamedMiddleware } from "./NamedComponent/middleware";
import { componentSailMiddleware } from "./SailComponent/middleware";
import { componentWithBuildingsMiddleware } from "./WithBuildingsComponent/middleware";

export const componentsMiddlewares = [
  //
  componentLoadableMiddleware,
  componentNamedMiddleware,
  componentSailMiddleware,
  componentWithBuildingsMiddleware,
];
