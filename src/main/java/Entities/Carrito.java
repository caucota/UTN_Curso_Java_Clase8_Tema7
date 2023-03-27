package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrito {
	private Persona cliente;
	private Date fecha;
	private List<ItemCarrito> itemsCarrito;
	private Descuento desc;
	
	public Carrito(Persona cliente) {
		this.fecha = new Date();
		this.cliente = cliente;
		this.itemsCarrito = new ArrayList<ItemCarrito>();
	}

	public Carrito(Persona cliente, List<ItemCarrito> itemsCarrito, Descuento desc) {
		this.fecha = new Date();
		this.cliente = cliente;
		this.itemsCarrito = itemsCarrito;
		this.desc = desc;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public List<ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}


	public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}
	
	public void appendItemCarito(ItemCarrito unItemCarrito) {
		this.itemsCarrito.add(unItemCarrito);
		/*
		for(ItemCarrito itemdetalle : this.itemsCarrito) {
			System.out.println(itemdetalle.getProducto().getNombreProducto() + " Precio:" + itemdetalle.getProducto().getPrecio() + " Cantidad Appen " + itemdetalle.getCantidad());
		}
		*/
	}


	public Descuento getDesc() {
		return desc;
	}


	public void setDesc(Descuento desc) {
		this.desc = desc;
	}


	public Double calcularTotalSinDescuento() {
		Double total = 0.0;
		for(ItemCarrito unDetalle: itemsCarrito) {
			total = total + (unDetalle.getProducto().getPrecio() * unDetalle.getCantidad());  
//			System.out.println(unDetalle.getProducto().getNombreProducto() +  " Cant: " + unDetalle.getCantidad() + " Precio:" +  unDetalle.getProducto().getPrecio() ) ;
		}
		
		return total;
	}

	public Double calcularTotalConDescuento() {
		Double total = this.calcularTotalSinDescuento();
		total = total - this.getDesc().getMontoDescuento(total);		
		return total;
	}
	
	
	public void mostrarCarrito() {
		Double totalCarrito = calcularTotalSinDescuento();
		Double montoDescuento = this.getDesc().getMontoDescuento(totalCarrito);
		System.out.println("-------------------------");
		System.out.println("--- Carrito de Compra ---");
		System.out.println("-------------------------");
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Cliente: " + this.cliente);
		System.out.println("Descuento: " + this.desc.getDescripcion()+ ": " + this.desc.getValorDesc());
		System.out.println("-------------------------");
		mostrarDetalleCarrito();
		System.out.println("-------------------------");
		System.out.println("Total Compra:" + totalCarrito);
		System.out.println("Descuento $: " +  montoDescuento);
		System.out.println("Total a Pagar:" + (totalCarrito - montoDescuento) );
	}
	public void mostrarDetalleCarrito() {
		System.out.println("Detalle de Productos");
		for(ItemCarrito detalle: this.itemsCarrito ) {
			System.out.println(detalle.getProducto().getNombreProducto() +  " Cantidad:" + detalle.getCantidad() + " Total: " + detalle.getTotal());
		}
	}

}
