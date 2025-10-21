import requests

API_BASE = "http://localhost:8080/api/pedidos"  # cambia esto por tu URL real

def load_pedidos():
    try:
        response = requests.get(API_BASE)
        response.raise_for_status()  # lanza excepción si el estado no es 2xx
        pedidos = response.json()    # convierte el JSON a un dict o list
        return pedidos
    except requests.RequestException as e:
        print("Error al cargar pedidos:", e)
        return None

def show_detalle(pedido_id):
    try:
        url = f"{API_BASE}/{pedido_id}"
        response = requests.get(url)
        response.raise_for_status()
        pedido = response.json()
        return pedido
    except requests.RequestException as e:
        print(f"Error al cargar detalle del pedido {pedido_id}:", e)
        return None

# Ejemplo de uso:
if __name__ == "__main__":
    pedidos = load_pedidos()
    print(len(pedidos))
    if pedidos:
        for p in pedidos:
            print(f"{p['fechaPedido']} - {p['clienteNombre']} - ${p['total']:,.2f}")

        # Mostrar detalle del primer pedido
        primer_id = pedidos[0]['id']
        detalle = show_detalle(primer_id)
        if detalle:
            print("\nDetalle del pedido:")
            for prod in detalle['productos']:
                print(f"- {prod['nombre']}: ${prod['precio']}")
