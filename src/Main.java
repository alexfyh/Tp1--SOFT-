import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
	private static Scanner entrada;

	public static void main(String [] args){
		int primero;
		int segundo=0;
		int resultado;
		String operador=null;
		char op;
		Nodo comienzo=new Nodo(0,null);
		Nodo actual=new Nodo(0,null);
		entrada = new Scanner(System.in);
		String operacion=entrada.nextLine();
		
		StringTokenizer token=new StringTokenizer(operacion," ");
		
		String p = token.nextToken();
		
		primero=Integer.parseInt(p);
		resultado=primero;
		
		Boolean flag=false;
		
		while (token.hasMoreTokens()){
			if(flag==false){
				operador=token.nextElement().toString();
				comienzo=new Nodo(primero,operador);
				actual=comienzo;
				flag=true;
			}
			else{
				operador=token.nextElement().toString();
				actual.set_siguiente(new Nodo(segundo,operador));
				actual=actual.get_siguiente();
			}
			p=token.nextElement().toString();
			if(p!=null) segundo=Integer.parseInt(p);
			else break;
			
			op=operador.charAt(0);
			
			switch(op){
			case '+':
				resultado=resultado+segundo;
				break;
			case '-':
				resultado=resultado-segundo;
				break;
			default:
				break;
			}
			
		}
		
		actual.set_siguiente(new Nodo(segundo,operador));
		actual=actual.get_siguiente();
		comienzo.show_expresion(comienzo);
		System.out.print("= "+resultado);
	}
}
