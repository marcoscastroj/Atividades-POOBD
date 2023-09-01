import requests
import json

url = "https://api.nasa.gov/insight_weather/?api_key=DEMO_KEY&feedtype=json&ver=1.0"
response = requests.get(url)
data = response.json()

if "sol_keys" in data:
    sol_keys = data["sol_keys"]
    selected_sols = sol_keys[:4]

    selected_data = {
        "sol_keys": selected_sols,
        "validity_checks": data["validity_checks"],
    }

    for sol in selected_sols:
        selected_data[sol] = data[sol]

    output_file = "nasa_insight_weather.json"
    with open(output_file, "w") as json_file:
        json.dump(selected_data, json_file, indent=4)

    print(f"Dados convertidos e salvos em {output_file}")
else:
    print("Não foram encontrados dados disponíveis.")
