import { useMemo } from "react";

const bgColors: any = {
  white: "#efe",
  lightgray: "#ded",
  gray: "#f88",
  success: "lightblue",
  danger: "#e58370",
};

export function useStyle({ color }: { color: string }, customStyle: any) {
  return useMemo(() => {
    const result: any = { ...customStyle };

    result.backgroundColor = bgColors[color];
    return result;
  }, [color, customStyle]);
}
