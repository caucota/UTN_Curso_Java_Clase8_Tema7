package org.caucotafederico.Clase8Tema7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Entities.Carrito;
import Entities.Descuento;
import Entities.DescuentoPorMonto;
import Entities.DescuentoPorc;
import Entities.DescuentoPorcConTope;
import Entities.ItemCarrito;
import Entities.Persona;
import Entities.Producto;


public class App 
{
    public static void main( String[] args )
    {
		String[] itemCart = new String[3];
		Producto prodRead = new Producto("", 0.0);
		int cantidad = 0;
		Double totalCompra = 0.0;
		Double montoDescuento = 0.0;
		Descuento descuentoCarrito = null;
		if(args.length > 0) {
			if (args.length > 1) {
				montoDescuento = Double.parseDouble(args[1]);
			}
			
			if (args[0].toUpperCase().equals("DESCUENTO FIJO")) {
				descuentoCarrito = new DescuentoPorMonto(args[0].toUpperCase(), montoDescuento);
			};
			if (args[0].toUpperCase().equals("DESCUENTO PORCENTAJE")) {
				descuentoCarrito = new DescuentoPorc(args[0].toUpperCase(), montoDescuento);
			};
			if (args[0].toUpperCase().equals("DESCUENTO PORCENTAJE CON TOPE")) {
				descuentoCarrito = new DescuentoPorcConTope(args[0].toUpperCase(), montoDescuento, 10.0);
			};
		}
		if(descuentoCarrito == null) {
			descuentoCarrito = new DescuentoPorMonto("SIN DESCUENTO", 0.0);
		}
		Persona cliente = new Persona("Perez", "Juan", "1512455");
		Carrito carritoCompra = new Carrito(cliente);
		carritoCompra.setDesc(descuentoCarrito);
		montoDescuento = 0.0;
		
		try {
			for(String lines : Files.readAllLines(Paths.get("C:\\Users\\fcaucota\\eclipse-workspace\\Clase8Tema7\\src\\main\\java\\resources\\ListaItems.txt"))) {
				itemCart = lines.split("\t");
				cantidad = Integer.parseInt(itemCart[0]);
				prodRead = new Producto(itemCart[2].toString(), Double.parseDouble(itemCart[1]) );
				carritoCompra.appendItemCarito(new ItemCarrito(prodRead, cantidad));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalCompra = carritoCompra.calcularTotalSinDescuento();
		montoDescuento = carritoCompra.getDesc().getMontoDescuento(totalCompra);
		//System.out.println("Total: " + (totalCompra - montoDescuento));
		carritoCompra.mostrarCarrito();

    }
}
