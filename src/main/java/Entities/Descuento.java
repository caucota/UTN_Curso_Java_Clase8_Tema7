package Entities;

public abstract class Descuento {
	private String descripcion;
	private Double valorDesc;
	
	public Descuento(String descripcion, Double valorDesc) {
		this.descripcion = descripcion;
		this.valorDesc = valorDesc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getValorDesc() {
		return valorDesc;
	}
	public void setValorDesc(Double valorDesc) {
		this.valorDesc = valorDesc;
	}
	
	public abstract Double getMontoDescuento(Double TotalCompra);

}
