
import java.util.Scanner;

public class Pagamento {

	private String tipo;
	private double valor;
	
	public String tipoPagamento() {
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a forma de pagamento [debito, credito ou dinheiro] ");
		String x1 = x.next();

		if(x1 == "debito") {
			return this.tipo = "debito";
		}
		else if(x1 == "credito") {
			return this.tipo = "credito";
		}
		else
			return this.tipo = "dinheiro";
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}
