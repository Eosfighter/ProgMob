
import java.util.Scanner;

public class Funcionario extends Pessoa{
	
	private String id;
	private String salario;
	private String carga;
	private String tipo;
	
	public String tipoFunc(Funcionario f) {
		Scanner x = new Scanner(System.in);
		System.out.println("Digite 1 para funcionario mensal e qualquer outra coisa para semanal");
		int x1 = x.nextInt();

		if(x1 == 1) {
			return this.tipo = "Funcionário Mensal";
		}
		else 
			
		return this.tipo = "Funcionário Semanal";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}

}
