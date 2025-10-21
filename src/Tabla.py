import flet as ft


class Tabla():
    def __init__(self,page):
        
            self.tabla=ft.DataTable(columns=[
                ft.DataColumn(ft.Text("Fecha de Pedido")),
                ft.DataColumn(ft.Text("Nombre")),
                ft.DataColumn(ft.Text("Total"), numeric=True),
                ft.DataColumn(ft.Text("Detalle Compra")),
            ])
           
            self.contenedor = ft.Container(
                content=None,
                padding=5,
                bgcolor="white",
                border_radius=10,
               
            shadow=ft.BoxShadow(
                spread_radius=1,
                blur_radius=15,
                color=ft.Colors.GREY_300,
                offset=ft.Offset(0, 0),
                blur_style=ft.ShadowBlurStyle.OUTER,
            )
            
            )

            self.contenedorInfo =ft.Container(
                padding=20,
                #bgcolor="grey200",
                content=ft.Text(value="click Derecho sobre icono para ver detalles" ,weight="bold",size=20,color="grey600"))
            

    
    def cargar_datos_api(self,response):
        from IconButton import IconBtn
        respuesta = response.json()
        self.tabla.rows = []
        i = 0
        
        for r in respuesta:
            btn = IconBtn()
            i+=1
            btn.set_id(i)
            fp  = ft.DataCell(ft.Text(r['fechaPedido']))
            cn  = ft.DataCell(ft.Text(r['clienteNombre']))
            to = ft.DataCell(ft.Text(f"{r['total']:,.2f}"))
            btnc = ft.DataCell(ft.IconButton(icon_color="#F98948",icon=ft.Icons.CONTENT_PASTE_SEARCH,data=i,on_click=self.mostrarDetalle))
           
            
            self.tabla.rows.append(
                ft.DataRow(cells=[fp,cn,to,btnc])
            )
            
    @staticmethod       
    def show_detalle(pedido_id):
        import requests
        try:
            url = f"http://localhost:8080/api/pedidos/{pedido_id}"
            response = requests.get(url)
            response.raise_for_status()
            pedido = response.json()
            return pedido
        except requests.RequestException as e:
            print(f"Error al cargar detalle del pedido {pedido_id}:", e)
            return None
        
    def mostrarDetalle(self, e: ft.ControlEvent):
        id = e.control.data
        detalle = self.show_detalle(id)

        productos = detalle.get('productos', [])
        agrupados = {}

        # Agrupar productos
        for prod in productos:
            nombre = prod['nombre']
            precio = float(prod['precio'])  

            if nombre in agrupados:
                agrupados[nombre]['cantidad'] += 1
                agrupados[nombre]['total'] += precio
            else:
                agrupados[nombre] = {'cantidad': 1, 'total': precio}

        # Crear lista de textos para mostrar
        lista_controls = []
        for nombre, datos in agrupados.items():
            cantidad = datos['cantidad']
            total = datos['total']
            texto = f"{nombre} x {cantidad} - ${total:,.2f}"
            lista_controls.append(ft.Text(texto, size=15, color="grey700",weight="bold"))

        self.contenedorInfo.content = ft.Column(controls=lista_controls)
        self.contenedorInfo.update()
    
    def build(self):
        
         self.contenedor.content=ft.Column(auto_scroll=True,controls=[self.tabla,self.contenedorInfo])
         return self.contenedor