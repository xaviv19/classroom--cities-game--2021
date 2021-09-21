import { componentLoadableMiddleware } from "./LoadableComponent/middleware";
import { componentNamedMiddleware } from "./NamedComponent/middleware";

export const componentsMiddlewares = [
  //
  componentLoadableMiddleware,
  componentNamedMiddleware,
];
