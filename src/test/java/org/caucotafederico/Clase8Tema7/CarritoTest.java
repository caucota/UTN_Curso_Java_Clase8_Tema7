package org.caucotafederico.Clase8Tema7;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Entities.Carrito;
import Entities.Descuento;
import Entities.DescuentoPorMonto;
import Entities.DescuentoPorc;
import Entities.DescuentoPorcConTope;
import Entities.ItemCarrito;
import Entities.Persona;
import Entities.Producto;

public class CarritoTest {

	@Test
	public void test1_probarTotalCarrito() {
		Producto prodTest = new Producto("", 0.0);
	
		Descuento descuentoCarrito = new DescuentoPorMonto("SIN DESCUENTO", 0.0);		
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		
		prodTest = new Producto("Pan", 25.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 1));
		prodTest = new Producto("Queso", 100.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 2));
		prodTest = new Producto("Leche", 85.5 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 6));

		Double rtdoEsperado = 738.0;

		
		assertEquals(rtdoEsperado, carritoCompra.calcularTotalConDescuento());
	
	}
	
	
	@Test
	public void test2_probarTotalCarrito() {
		Producto prodTest = new Producto("", 0.0);
	
		Descuento descuentoCarrito = new DescuentoPorMonto("SIN DESCUENTO", 0.0);		
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		
		prodTest = new Producto("Pan", 25.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 1));
		prodTest = new Producto("Queso", 100.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 2));
		prodTest = new Producto("Leche", 85.5 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 6));

		Double rtdoEsperado = 738.0;
		
		assertEquals(rtdoEsperado, carritoCompra.calcularTotalConDescuento());
	}
	
	@Test
	public void test3_probarConDescuentoFijo() {
		Producto prodTest = new Producto("", 0.0);
	
		Descuento descuentoCarrito = new DescuentoPorMonto("DESCUENTO FIJO", 80.0);		
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		
		prodTest = new Producto("Pan", 25.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 1));
		prodTest = new Producto("Queso", 100.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 2));
		prodTest = new Producto("Leche", 85.5 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 6));

		Double rtdoEsperado = 1140.0;
		
		assertEquals(rtdoEsperado, carritoCompra.calcularTotalConDescuento());
	}
	
	@Test
	public void test4_probarConDescuentoPorPorcentaje() {
		Producto prodTest = new Producto("", 0.0);
	
		Descuento descuentoCarrito = new DescuentoPorc("DESCUENTO PORCENTAJE", 10.0);		
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		
		prodTest = new Producto("Pan", 25.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 1));
		prodTest = new Producto("Queso", 100.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 2));
		prodTest = new Producto("Leche", 85.5 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 6));

		Double rtdoEsperado = 2400.0;

		
		assertEquals(rtdoEsperado, carritoCompra.calcularTotalConDescuento());

	}

	@Test
	public void test4_probarConDescuentoPorPorcentajeConTope() {
		Producto prodTest = new Producto("", 0.0);
	
		Descuento descuentoCarrito = new DescuentoPorcConTope("DESCUENTO PORCENTAJE CON TOPE", 10.0, 22.0);		
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		
		prodTest = new Producto("Pan", 25.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 1));
		prodTest = new Producto("Queso", 100.0 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 2));
		prodTest = new Producto("Leche", 85.5 );
		carritoCompra.appendItemCarito(new ItemCarrito(prodTest, 6));

		Double rtdoEsperado = 716.0;
		
		assertEquals(rtdoEsperado, carritoCompra.calcularTotalConDescuento());

	}

	
}
