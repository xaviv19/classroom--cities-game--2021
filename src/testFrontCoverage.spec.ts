import path from "path";
import fs from "fs";

interface CoverageElement {
  GROUP: string;
  PACKAGE: string;
  CLASS: string;
  INSTRUCTION_MISSED: number;
  INSTRUCTION_COVERED: number;
  BRANCH_MISSED: number;
  BRANCH_COVERED: number;
  LINE_MISSED: number;
  LINE_COVERED: number;
  COMPLEXITY_MISSED: number;
  COMPLEXITY_COVERED: number;
  METHOD_MISSED: number;
  METHOD_COVERED: number;
}

test("backend has an acceptable coverage", () => {
  const report = readJacocoReport()
    .filter(({ PACKAGE }) => !PACKAGE.includes(".blog"))
    .filter(
      ({ PACKAGE, CLASS }) =>
        PACKAGE !== "com.drpicox.game" && CLASS !== "Application"
    )
    .filter(({ CLASS }) => !CLASS.startsWith("Unsafe"));

  const uncovereds = report.filter(
    (element) =>
      element.INSTRUCTION_MISSED > 0 ||
      element.BRANCH_MISSED > 0 ||
      element.LINE_MISSED > 0 ||
      element.METHOD_MISSED > 0
  );

  if (uncovereds.length > 0) {
    throw new Error(
      `Backend is not fully covered, missing coverage is at:` +
        uncovereds.map(
          ({ GROUP, PACKAGE, CLASS }) => `\n- ${PACKAGE}.${CLASS}`
        ) +
        `\nHint: If the missing coverage comes from a mocked class, rename that class to Unsafe, example:\n      rename "${uncovereds[0].CLASS}" to "Unsafe${uncovereds[0].CLASS}"`
    );
  }
  expect(uncovereds.length).toBe(0);
});

function readJacocoReport(): CoverageElement[] {
  var coverage: CoverageElement[] = [];

  const fullName = path.join(
    __dirname,
    "..",
    "target",
    "site",
    "jacoco",
    "jacoco.csv"
  );

  const content = fs.readFileSync(fullName, { encoding: "utf8" });
  const lines = content.split("\n");
  const header = lines[0].split(",");
  const data = lines.slice(1);
  data.forEach((line) => {
    const values = line.split(",");
    if (values.length !== header.length) return;
    const element: CoverageElement = {} as unknown as CoverageElement;
    header.forEach((key, index) => {
      element[key] = values[index];
    });
    coverage.push(element);
  });

  return coverage;
}
