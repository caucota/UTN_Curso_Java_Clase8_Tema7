package Entities;

public class DescuentoPorcConTope extends DescuentoPorc{
	private Double topeFijo = 0.0;

	public DescuentoPorcConTope(String descripcion, Double porcentajeDesc, Double topeMaximoFijo) {
		super(descripcion, porcentajeDesc);
		// TODO Auto-generated constructor stub
		topeFijo = topeMaximoFijo;
	}
	
	public Double getTopeFijo() {
		return topeFijo;
	}

	public void setTopeFijo(Double topeFijo) {
		this.topeFijo = topeFijo;
	}
	
	public Double getMontoDescuento(Double TotalCompra) {
		Double montoDesc = 0.0;
		montoDesc = super.getMontoDescuento(TotalCompra);
		if (topeFijo > 0 && montoDesc > topeFijo) {
			montoDesc = topeFijo;
			super.setValorDesc(montoDesc);
		}
		return montoDesc;
		
	}


}
