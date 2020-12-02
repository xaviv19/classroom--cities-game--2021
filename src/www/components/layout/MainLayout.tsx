import React from "react";
import { CurrentView } from "../views/CurrentView";
import { MainHeader } from "./MainHeader";

export function MainLayout() {
  return (
    <div>
      <MainHeader />
      <CurrentView />
    </div>
  );
}
