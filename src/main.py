import flet as ft
from Tabla import Tabla
import requests

#Llamando a la API
API_BASE = "http://localhost:8080/api/pedidos"  

def load_pedidos():
    try:
        response = requests.get(API_BASE)
        response.raise_for_status()  
        pedidos = response.json()    
        return response
    except requests.RequestException as e:
        print("Error al cargar pedidos:", e)
        return None

response = load_pedidos()



def get_detalles(e:ft.ControlEvent):
    
    id = e.control.data



def main(page: ft.Page):
    tabla=Tabla(page)
    tabla.cargar_datos_api(response=response)
    
  

    contenedor_centrado=ft.Container(content=tabla.build(),alignment=ft.Alignment(0,0))
    
    page.bgcolor="f5ebe0"
    page.add(contenedor_centrado)

ft.app(target=main)
