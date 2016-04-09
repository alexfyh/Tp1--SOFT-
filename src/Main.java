import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
	private static Scanner entrada;

	public static void main(String [] args){
		float primero;
		float segundo=0;
		float resultado;
		String operador=null;
		char op;
		Nodo comienzo=new Nodo(0,null);
		Nodo actual=new Nodo(0,null);
		entrada = new Scanner(System.in);
		String operacion=entrada.nextLine();
		
		StringTokenizer token=new StringTokenizer(operacion," ");
		
		String p = token.nextToken();
		
		primero=Float.valueOf(p);
		resultado=primero;
		p=token.nextElement().toString();
		operador=p;
		
		if((operador.charAt(0)=='+')||(operador.charAt(0)=='-')){
			boolean flag=false;
			
			while (token.hasMoreTokens()){
				if(flag==false){
					comienzo=new Nodo(primero,operador);
					actual=comienzo;
					flag=true;
				}
				else{
					p=token.nextElement().toString();
					operador=p;
					actual.set_siguiente(new Nodo(segundo,operador));
					actual=actual.get_siguiente();
				}
				
				if(token.hasMoreTokens()){
					p=token.nextElement().toString();
					segundo=Float.valueOf(p);
				}
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
		else{
			p=token.nextElement().toString();
			if(p!=null) segundo=Float.valueOf(p);
			op=operador.charAt(0);
			
			switch(op){
			case'*':
				resultado=primero*segundo;
				System.out.print(primero+" * "+segundo+" = "+resultado);
				break;
			case'/':
				resultado=primero/segundo;
				System.out.print(primero+" / "+segundo+" = "+resultado);
				break;
			case'%':
				resultado=(primero*segundo)/100;
				System.out.print(primero+" % "+segundo+" = "+resultado);
				break;
			default:
				System.out.print("La operacion ingresada no es valida\n");
				break;
			}
			
		}
	
		
	
	}
}