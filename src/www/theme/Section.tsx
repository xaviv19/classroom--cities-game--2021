import { useStyle } from "./useStyle";

const sectionStyle = {
  backgroundColor: "#888",
  padding: ".5rem 1rem",
  margin: ".5rem 0",
};

export function Section({
  children,
  color = "lightgray",
}: {
  children: React.ReactNode;
  color?: string;
}) {
  const style = useStyle({ color }, sectionStyle);

  return <div style={style}>{children}</div>;
}
