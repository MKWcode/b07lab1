public class Polynomial{
	double [] coefficients;

	public Polynomial(){
		coefficients = new double[1];
		coefficients[0]=0;

	}
	public Polynomial(double [] coefficients){
		this.coefficients = new double[coefficients.length];
		for( int i=0; i < coefficients.length;i++){
			this.coefficients[i]=coefficients[i];
		}
		

	}
	//It has a method named add that takes one argument of type Polynomial and returns the polynomial resulting from adding the calling object and the argument
	public Polynomial add(Polynomial second){
		
		// check which is longer
		if(this.coefficients.length<=second.coefficients.length){
			Polynomial result = new Polynomial(second.coefficients);
			//result.coefficients = new double[second.coefficients.length];
			int i;
			for(i=0;i<this.coefficients.length;i++){
				result.coefficients[i]= result.coefficients[i]+this.coefficients[i];
				
			}
			return result;
			/*
			while(i<second.coefficients.length){
				result.coefficients[i]=second.coefficients[i];
				i++;
			}
			*/
		}
		else{
			Polynomial result = new Polynomial(this.coefficients);
			int i;
			//result.coefficients = new double[this.coefficients.length];
			for(i=0;i<second.coefficients.length;i++){
				result.coefficients[i]= result.coefficients[i]+second.coefficients[i];
				
			}
			return result;
			/*
			while(i<this.coefficients.length){
				result.coefficients[i]=this.coefficients[i];
				i++;
			}
			*/
		}
		

	}	
	

	//it has a method named evaluate that takes one argument of type double representing a value of x and evaluates the polynomial accordingly. 	
	public double evaluate(double x){
		double result=0;
		for( int i=0;i<this.coefficients.length;i++){
			result+=this.coefficients[i] * Math.pow(x, i);

		}
		return result;
	}
	//It has a method named hasRoot that takes one argument of type double and determines whether this value is a root of the polynomial or not. Note that a root is a value of x for which the polynomial evaluates to zero.
	public boolean hasRoot(double root){
		return(evaluate(root)==0);
	} 






}