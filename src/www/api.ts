export async function apiGet(url: string): Promise<any> {
  const response = await fetch(url);
  const data = await response.json();
  return data;
}

export async function apiPost(
  url: string,
  data: any,
  options: any = {}
): Promise<any> {
  const newOptions = {
    ...options,
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  };

  const response = await fetch(url, newOptions);
  const body = await response.json();

  return body;
}
