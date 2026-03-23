package produtos;

public class Galpoes {
	public int galpaoId;
	public String nome;
	
	public Galpoes(int id, String nome){
		this.galpaoId = id;
		this.nome = nome;
	}

	@Override
	public String toString(){
		return "ID: " + galpaoId + " | Nome: " + nome; 
	}
}
