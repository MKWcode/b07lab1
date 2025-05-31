import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Polynomial{
	public double [] coefficients;
	public int [] exponents;

	public Polynomial(){
		coefficients = new double[1];
		exponents = new int[1];
		exponents[0]=0;
		

	}
	public Polynomial(double [] coefficients, int [] exponents){
		this.coefficients = new double[coefficients.length];
		for( int i=0; i < coefficients.length;i++){
			if( coefficients[i] !=0)
				this.coefficients[i]=coefficients[i];
		}
		this.exponents = new int[exponents.length];
		for( int i=0; i < exponents.length;i++){
			this.exponents[i]=exponents[i];
		}
		
		

	}
	public Polynomial(File file){
		String data;
		try {
        	Scanner scanner = new Scanner(file);
        	data = scanner.nextLine();
        	System.out.println(data);
		String[] separated_terms = data.split("[-\\+]");
		System.out.println(separated_terms.length);
		this.coefficients = new double [separated_terms.length];
		this.exponents = new int [separated_terms.length];
		int index=0;
		String[] terms = data.split("[+]");
		for(int i=0;i<terms.length;i++){
		if(terms[i].indexOf('-')!=-1){
			String[] more_terms = terms[i].split("[-]");
			System.out.println("adding minus");
			// adding the negative signs 
			for(int j=1;j<more_terms.length;j++){
				more_terms[j] = "-"+more_terms[j];
				System.out.println(more_terms[j]+"\n");
			}
			// adding values to the arrays
			for(int k=0;k<more_terms.length;k++){
				if(more_terms[k].length()==1){
					this.coefficients[index]=Double.parseDouble(more_terms[k]);
					this.exponents[index]=0;
					index++;
				}
				else{
					String[] numbers = more_terms[k].split("x");
					this.coefficients[index]=Double.parseDouble(numbers[0]);
					this.exponents[index]= Integer.parseInt(numbers[1]);
					index++;


				}
			}

		}
		else{
			if( terms[i].length()==1){
				this.coefficients[index]=Double.parseDouble(terms[i]);
				this.exponents[index]=0;
				index++;
			}
			else{
				String[] numbers = terms[i].split("x");
				this.coefficients[index]=Double.parseDouble(numbers[0]);
				this.exponents[index]= Integer.parseInt(numbers[1]);
				index++;
			}

		}
		System.out.println(terms[i]);

		}
		//System.out.println("checking");
		//for( int m=0; m<this.coefficients.length;m++){
			//System.out.println(this.coefficients[m]+"x"+this.exponents[m]+"\n");

		//}
      	scanner.close();
    	} catch (FileNotFoundException e) {
      	System.out.println("An error occurred.");
      	e.printStackTrace();
    	}
	
    }

	




	public int largest(int [] array){
		int max = 0;
		for(int i=0; i<array.length;i++){
			if(array[i]>max){
				max = array[i];	
			}

		}
		return max;

	}
	//It has a method named add that takes one argument of type Polynomial and returns the polynomial resulting from adding the calling object and the argument
	public Polynomial add(Polynomial second){
		int largest_exponent = 0;
		int i,j;
		if(largest(second.exponents)>= largest(this.exponents))
				largest_exponent = largest(second.exponents);
		else
			largest_exponent = largest(this.exponents);
		double [] intial_coefficients = new double[largest_exponent];
		int [] intial_exponents = new int[largest_exponent];

		// check which is longer
		
		if(this.coefficients.length<=second.coefficients.length){
			int index_in_second = 0;
			for( i=0;i<this.exponents.length;i++){
				for(j=0;j<second.exponents.length;j++){
					if(this.exponents[i] == second.exponents[j]){
						intial_coefficients[i]= second.coefficients[j]+this.coefficients[i];
						intial_exponents[i] = this.exponents[i];
						

					}
				}
				if(intial_coefficients[i]==0){
					intial_coefficients[i]=this.coefficients[i];
					intial_exponents[i] = this.exponents[i];
					
				}
			}
			
			
			while(i<largest_exponent && index_in_second<second.exponents.length){
				int already = 0;
				for( int m = 0; m<i;m++){
					if ( second.exponents[index_in_second] == intial_exponents[m]){
						already=1;
					}
				}
				
				if(already == 0){
					intial_coefficients[i]=second.coefficients[index_in_second];
					intial_exponents[i] = second.exponents[index_in_second];
					i++;
					index_in_second++;
				}
				else
					index_in_second++;

			}
			
			if(i<largest_exponent){
				double [] final_coefficients = new double [i];
				int [] final_exponents = new int [i];
				
				for(int k =0; k<final_coefficients.length;k++){
					final_coefficients[k] =intial_coefficients[k]; 
					final_exponents[k] = intial_exponents[k];
				}
				Polynomial result = new Polynomial(final_coefficients,final_exponents);
				return result;
				
			
			}
			else{
				Polynomial result = new Polynomial(intial_coefficients,intial_exponents);
				return result;

			}
		}
		
		else{
			largest_exponent = 0;
			if(largest(second.exponents)>= largest(this.exponents))
				largest_exponent = largest(second.exponents);
			else
				largest_exponent = largest(this.exponents);

			
			intial_coefficients = new double[largest_exponent];
			intial_exponents = new int[largest_exponent];
			i =0 ; j=0;
			int index_in_this;
			index_in_this =0;
			for( i=0;i<second.exponents.length;i++){
				for(j=0;j<this.exponents.length;j++){
					if(this.exponents[j] == second.exponents[i]){
						intial_coefficients[i]= second.coefficients[i]+this.coefficients[j];
						intial_exponents[i] = second.exponents[i];
						

					}
				}
				if(intial_coefficients[i]==0){
					intial_coefficients[i]=second.coefficients[i];
					intial_exponents[i] = second.exponents[i];
					

				}
			}
			
			while(i<largest_exponent && index_in_this<second.exponents.length){
				int already = 0;
				for( int m = 0; m<i;m++){
					if ( this.exponents[index_in_this] == intial_exponents[m]){
						already=1;
					}
				}
				
				if(already == 0){
					intial_coefficients[i]=this.coefficients[index_in_this];
					intial_exponents[i] = this.exponents[index_in_this];
					i++;
					index_in_this++;
				}
				else
					index_in_this++;

			}
			if(i<largest_exponent){
				double [] final_coefficients = new double [i];
				int [] final_exponents = new int [i];
				
				for(int k =0; k<final_coefficients.length;k++){
					final_coefficients[k] =intial_coefficients[k]; 
					final_exponents[k] = intial_exponents[k];
				}
				Polynomial result = new Polynomial(final_coefficients,final_exponents);
				return result;
				
			
			}
			else{
				Polynomial result = new Polynomial(intial_coefficients,intial_exponents);
				return result;

			}


		}
			
		

	}	
	

	//it has a method named evaluate that takes one argument of type double representing a value of x and evaluates the polynomial accordingly. 	
	public double evaluate(double x){
		double result=0;
		for( int i=0;i<this.coefficients.length;i++){
			result+=this.coefficients[i] * Math.pow(x,this.exponents[i]);

		}
		return result;
	}
	//It has a method named hasRoot that takes one argument of type double and determines whether this value is a root of the polynomial or not. Note that a root is a value of x for which the polynomial evaluates to zero.
	public boolean hasRoot(double root){
		return(evaluate(root)==0);
	} 


	// Add a method named multiply that takes one argument of type Polynomial and returns the polynomial resulting from multiplying the calling object and the argument. The resulting polynomial should not contain redundant exponents.
	public Polynomial multiply(Polynomial other){
		double [][] intial_coefficients = new double [this.exponents.length][other.exponents.length];
		int [][] intial_exponents = new int [this.exponents.length][other.exponents.length];
		
		for(int i =0; i<this.exponents.length; i++){
			int index_intial_array=0;
			for(int j=0; j<other.exponents.length;j++){
				intial_coefficients[i][index_intial_array] = this.coefficients[i]*other.coefficients[j];
				intial_exponents[i][index_intial_array] = this.exponents[i]+other.exponents[j];
				index_intial_array++;

			}
		}
		Polynomial p1 = new Polynomial(intial_coefficients[0],intial_exponents[0]);
		for(int k=1; k<this.exponents.length; k++){
			Polynomial p2 = new Polynomial(intial_coefficients[k],intial_exponents[k]);
			p1=p1.add(p2);
		}
		return p1;

	}




}