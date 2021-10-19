
public class Main {
	
	Apartamento ap = new Apartamento();
	Cliente cli = new Cliente();
	Funcionario fun = new Funcionario();
	Pagamento paga = new Pagamento();
	Locacao loca = new Locacao();

	public void RealizarLocacao() {
		
	}
	
	public void RegistrarVisita() {
		
	}
	
	public void GerenciarApart() {
		
	}
	
	public void GerenciarCliente() {
		
	}
	
	public void GerenciarFuncionario() {
		
	}
	
	public void GerenciarDevolucao() {
		
	}
		
	public String EmitirRelatioLoca() {
		return "O id da locacao e " + loca.getId();
	}
	
	public String EmitirRelatorioApart() {
		return "O apartamento de numero " + ap.getNumApart() +
				" Tem valor " + ap.getValorCond() +
				" E numero de quartos " + ap.getNumQuartos() +
				" E numero de banheiros "+ ap.getNumBanheiros() +
				" E numero de vagas na garagem " + ap.getVagasGaragem() +
				" E está no andar " + ap.getAndar();
	}
	
	public String EmitirRelatorioCliente() {
		return "O cliente " + cli.getNome() +
				" Mora no endereco " + cli.getEndereco() + 
				" E tem o rg" + cli.getRg();
	}
	
	public String EmitirRelatorioFunc() {
		
		return "O funcionario " + fun.getId() +
				" Tem o salario de " + fun.getSalario() +
				" E é do tipo " + fun.tipoFunc(fun);
	}
	
	public void Login() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		}
	
}
