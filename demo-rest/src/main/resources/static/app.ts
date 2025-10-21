const API_BASE = "/api/pedidos";

interface ProductoDTO {
  nombre: string;
  precio: number;
}

interface PedidoDTO {
  id: number;
  clienteNombre: string;
  productos: ProductoDTO[];
  fechaPedido: string;
  total: number;
}

document.getElementById("btnLoad")!.addEventListener("click", () => {
  loadPedidos();
});

async function loadPedidos() {
  const res = await fetch(API_BASE);
  if (!res.ok) {
    alert("Error cargando pedidos");
    return;
  }
  const pedidos: PedidoDTO[] = await res.json();
  const tbody = document.querySelector("#pedidosTable tbody")!;
  tbody.innerHTML = "";
  pedidos.forEach(p => {
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${p.fechaPedido}</td><td>${p.clienteNombre}</td><td>$${p.total.toFixed(2)}</td>
      <td><span class="icon" data-id="${p.id}">🔍</span></td>`;
    tbody.appendChild(tr);
  });
  document.querySelectorAll(".icon").forEach(el => {
    el.addEventListener("click", (ev) => {
      const id = (ev.currentTarget as HTMLElement).getAttribute("data-id");
      if (id) showDetalle(parseInt(id));
    });
  });
}

async function showDetalle(id: number) {
  const res = await fetch(`${API_BASE}/${id}`);
  if (!res.ok) {
    alert("Pedido no encontrado");
    return;
  }
  const p: PedidoDTO = await res.json();
  const ul = document.getElementById("productosList")!;
  ul.innerHTML = "";
  p.productos.forEach(prod => {
    const li = document.createElement("li");
    li.textContent = `${prod.nombre} - $${prod.precio.toFixed(2)}`;
    ul.appendChild(li);
  });
}
