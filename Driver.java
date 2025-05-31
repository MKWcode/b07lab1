import java.io.File;  // Import the File class
public class Driver { 
	
	public static void main(String [] args) { 
	
	Polynomial p = new Polynomial(); 
	double [] c1 = {3,5,4};
	int [] e1 = {3,5,4};
	Polynomial p1 = new Polynomial(c1,e1);
	double [] c2 = {6,6,-2,5};
	int [] e2 = {4,0,1,3};
	Polynomial p2 = new Polynomial(c2,e2);
	Polynomial s = p2.add(p1);
	for( int i=0;i<s.coefficients.length;i++){
		System.out.println("cs = "+s.coefficients[i]+" es= "+s.exponents[i]);
	}
	System.out.println("\n");
	double [] c3 = {6,5}; 
	int [] e3 = {0,3};
	Polynomial p3 = new Polynomial(c3,e3); 
	double [] c4 = {-2,-9}; 
	int [] e4 = {1,4};
	Polynomial p4 = new Polynomial(c4,e4);
	Polynomial q = p3.multiply(p4);
	for( int i=0;i<q.coefficients.length;i++){
		System.out.println("cs = "+q.coefficients[i]+" es= "+q.exponents[i]);
	}

	//opening a file
	File myFile = new File("test_file.txt");
	Polynomial n = new Polynomial(myFile);
	for( int i=0;i<n.coefficients.length;i++){
		System.out.println("cs = "+n.coefficients[i]+" es= "+n.exponents[i]);
	}
	/*
	Polynomial p = new Polynomial();
	System.out.println(p.evaluate(3)); 
	double [] c1 = {6,5}; 
	int [] e1 = {0,3};
	Polynomial p1 = new Polynomial(c1,e1); 
	double [] c2 = {-2,-9}; 
	int [] e2 = {1,4};
	Polynomial p2 = new Polynomial(c2,e2); 
	Polynomial s = p1.add(p2); 
	System.out.println("s(0.1) = " + s.evaluate(0.1)); 
	if(s.hasRoot(1)) 
		System.out.println("1 is a root of s"); 
	else 
		System.out.println("1 is not a root of s"); 
	*/
	}
	 
} 