const API_BASE = "/api/pedidos";
document.getElementById("btnLoad").addEventListener("click", () => {
  loadPedidos();
});

async function loadPedidos() {
  const res = await fetch(API_BASE);
  if (!res.ok) {
    alert("Error cargando pedidos");
    return;
  }
  const pedidos = await res.json();
  const tbody = document.querySelector("#pedidosTable tbody");
  tbody.innerHTML = "";
  pedidos.forEach(p => {
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${p.fechaPedido}</td><td>${p.clienteNombre}</td><td>$${p.total.toLocaleString('es-ES', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</td>
      <td><span class="icon" data-id="${p.id}">🔍</span></td>`;
    tbody.appendChild(tr);
  });
  
  document.querySelectorAll(".icon").forEach(el => {
    el.addEventListener("click", (ev) => {
      const id = ev.currentTarget.getAttribute("data-id");
      if (id)
        showDetalle(parseInt(id));
    });
  });
}

async function showDetalle(id) {
  const res = await fetch(`${API_BASE}/${id}`);
  if (!res.ok) {
    alert("Pedido no encontrado");
    return;
  }
  const p = await res.json();
  const ul = document.getElementById("productosList");
  ul.innerHTML = "";

 
  const productosAgrupados = {};

  // Agrupar los productos
  p.productos.forEach(prod => {
   
    const precio = parseFloat(prod.precio);

    if (isNaN(precio)) {
      console.error(`Producto inválido: ${prod.nombre} con precio: ${prod.precio}`);
      return; 
    }

  
    if (productosAgrupados[prod.nombre]) {
      productosAgrupados[prod.nombre].cantidad += 1;
      productosAgrupados[prod.nombre].precioTotal += precio;
    } else {
      
      productosAgrupados[prod.nombre] = {
        cantidad: 1,
        precioTotal: precio
      };
    }
  });

  // Mostrar los productos agrupados
  for (const [nombre, datos] of Object.entries(productosAgrupados)) {
    const li = document.createElement("li");
    li.innerHTML = `<b class="griseaso">${nombre}</b> ${datos.cantidad} x <b class="azul">$${datos.precioTotal.toLocaleString('es-ES', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</b>`;
    ul.appendChild(li);
  }

}
