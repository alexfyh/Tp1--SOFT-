public class Nodo {
	private int numero;
	private String operador;
	private Nodo siguiente;
	
	public Nodo(int numero, String operador){
		this.numero=numero;
		this.operador=operador;
		this.siguiente=null;
	}
	
	public void set_siguiente(Nodo siguiente)
	{
		this.siguiente=siguiente;
	}
	
	public int get_numero(){
		return numero;
	}
	
	public String get_operador(){
		return operador;
	}
	
	public Nodo get_siguiente(){
		return siguiente;
	}
	
	public void show_expresion(Nodo czo){
		Nodo actual;
		actual=czo;
		while(actual.siguiente!=null){
			System.out.print(actual.get_numero() + " " + actual.get_operador()+ " ");
			actual=actual.get_siguiente();
		}
		System.out.print( actual.get_numero()+" ");
	}
}
