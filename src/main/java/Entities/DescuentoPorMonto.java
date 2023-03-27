package Entities;

public class DescuentoPorMonto extends Descuento {

	public DescuentoPorMonto(String descripcion, Double valorDesc) {
		super(descripcion, valorDesc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getMontoDescuento(Double TotalCompra) {
		return this.getValorDesc();
	}

}
