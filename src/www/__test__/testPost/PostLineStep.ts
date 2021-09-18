import { PostLine } from "./PostLine";

export class PostLineStep {
  #matchRe: RegExp;
  #run: (
    postLine: PostLine,
    match: Exclude<ReturnType<string["match"]>, null>
  ) => void;

  constructor(
    matchRe: RegExp,
    run: (
      postLine: PostLine,
      match: Exclude<ReturnType<string["match"]>, null>
    ) => void | Promise<void>
  ) {
    this.#matchRe = matchRe;
    this.#run = run;
  }

  matches(postLine: PostLine): boolean {
    return postLine.match(this.#matchRe) != null;
  }

  async run(postLine: PostLine) {
    var match = postLine.match(this.#matchRe);
    return this.#run(postLine, match!);
  }

  toPrettyString(): any {
    return `/${this.#matchRe.source}/ ${this.#run.toString()}`;
  }
}

export const step = (
  matchRe: RegExp,
  run: (
    postLine: PostLine,
    match: Exclude<ReturnType<string["match"]>, null>
  ) => void
): PostLineStep => {
  return new PostLineStep(matchRe, run);
};
