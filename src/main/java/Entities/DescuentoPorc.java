package Entities;

public class DescuentoPorc extends Descuento {

	public DescuentoPorc(String descripcion, Double porcentajeDesc) {
		super(descripcion, porcentajeDesc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getMontoDescuento(Double TotalCompra) {
		// TODO Auto-generated method stub
		return TotalCompra * this.getValorDesc() / 100;
		
	}

}
