export function InformedComponent({ entity }: any) {
  return (
    <div>
      Wood: {entity.wood}
      <br />
      Stone: {entity.stone}
      <br />
      Iron: {entity.iron}
      <br />
      Trade Resources (active)
      <br />
      Buildings (active)
      <br />
      Troops (active)
      <br />
    </div>
  );
}
