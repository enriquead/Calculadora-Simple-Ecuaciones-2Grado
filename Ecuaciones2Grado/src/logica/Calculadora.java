package logica;

import java.text.DecimalFormat;

public class Calculadora {
	
	private Double r1;
	private Double r2;
	
	private final static DecimalFormat df = new DecimalFormat("#.000"); 
	
	public Calculadora(){
		this.r1=new Double(0);
		this.r2=new Double(0);
	}
	public String getRootA(double a,double b, double c){
		r1=((-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a));
		if(r1.isNaN()){
			return ("Solución no real");
		}
		
		return df.format(r1);
	}
	public String getRootB(double a,double b, double c){
		r2=((-b-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a));
		if(r2.isNaN()){
			return ("Solución no real");
		}
		return df.format(r2);
	}

}
