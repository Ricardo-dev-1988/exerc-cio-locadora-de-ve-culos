package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;
	
	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FATURA:\n" + "Pagamento basico: R$ " + String.format("%.2f", basicPayment));
		sb.append("\nImposto: R$ " + String.format("%.2f", tax));
		sb.append("\nPagamento total: R$ " + String.format("%.2f", getTotalPayment()));
		return sb.toString();
	}	
}
