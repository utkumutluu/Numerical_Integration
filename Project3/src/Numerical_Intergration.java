import java.util.Scanner;

//-----------------------------------------//
// MATH226 - Numerical Methods for EE
// Project 03
//
// Name-Surname: Utku Mutlu
// Student ID: 041502031
//-----------------------------------------// 

public class Numerical_Intergration {

	public static void main(String[] args) {

		int selected_function_number; float k; float a; float b;
		float h;
		float x[] = new float[1000000];//I created very large x array
		float m = 0;//I created m for midpoint rule
		float t = 0;//I created t for trapezoid rule
		int rule,j;//I created rule for know which rule program use and I created j for midpoint and trapezoid rules' formulas

		System.out.println("Enter number of your function");
		System.out.println("1-)  f(x) = 4/(1+x^2)");
		System.out.println("2-)  f(x) = x^(1/2) * log(x)");
		Scanner input = new Scanner(System.in);//I took selected function number
		selected_function_number = input.nextInt();	


		System.out.println("Enter rule");
		System.out.println("1-)  midpoint");
		System.out.println("2-)  trapezoid");
		Scanner input2 = new Scanner(System.in);//I took selected rule
		rule = input2.nextInt();	

		System.out.println("Enter k value:");
		Scanner input3 = new Scanner(System.in);//I took k value
		k = input3.nextFloat();	

		System.out.println("Enter a value:");
		Scanner input4 = new Scanner(System.in);//I took a(min value of integral) value
		a = input4.nextFloat();

		System.out.println("Enter b value:");
		Scanner input5 = new Scanner(System.in);//I took b(max value of integral) value
		b = input5.nextFloat();
		if(a==0) {//if a is 0, I changed A is very closer value of 0. 
			a=(float) 0.0000000001;
		}

		if(a>=b) {//error line
			System.out.println("b must be greater than a");
		}
		else {// if b is greater than a, program starts
			h=(b-a)/k;// h formula

			for( j=0; j<=k; j++) {// create x[j] array using its formula
				x[j]=a + j*h;
			}
			if(rule==1) {// if user write 1 for rule , program start doing midpoint rule
				if(selected_function_number==1) {//doing first function
					for( j=1; j<=k; j++) {
						m=m+h*f(selected_function_number,(x[j-1]+x[j])/2);
					}
					System.out.println(m);
				}
				if(selected_function_number==2) {//doing second function
					if(x[j-1]/2+x[j]/2>0) {// it is for logaritm and square root rule
						for( j=1; j<=k; j++) {
							m=m+h*f(selected_function_number,(x[j-1]+x[j])/2);//midpoint rule formula
						}
						System.out.println(m);
					}
				}
			}
			else if(rule==2) {// if user write 12 for rule , program start doing trapezoid rule
				if(selected_function_number==1) {//doing first function
					for( j=1; j<=k; j++) {

						t=t+((x[j]-x[j-1])/2)*(f(selected_function_number,x[j-1])+f(selected_function_number,x[j]));
					}
					System.out.println(t);
				}
				if(selected_function_number==2) {//doing second function
					if(x[j-1]+x[j]>0) {
						for( j=1; j<=k; j++) {

							t=t+((x[j]-x[j-1])/2)*(f(selected_function_number,x[j-1])+f(selected_function_number,x[j]));// trapezoid rule formula

						}
					}
					System.out.println(t);
				}
			}
			else {
				System.out.println("select 1 or 2");
			}
		}
	}
	public static float f(int selected_function_number,  float x) {//this function works like f(x)
		float f =0; //I created f which is equal to selected function
		switch(selected_function_number) {// I choose function according to selected_function_number
		case 1:
			f= (float) (4/(1+Math.pow(x,2)));
			break;

		case 2:

			f= (float) (Math.pow(x,0.5) * Math.log(x));


			break;
		}
		return f;
	}
}


