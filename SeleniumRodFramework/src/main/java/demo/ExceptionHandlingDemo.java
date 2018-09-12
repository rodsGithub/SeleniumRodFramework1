package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			demo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			System.out.println("Whatever ***");
//			int i = 1/0;
//			System.out.println("\nCompleted");
//
//		}
//
//		catch(Exception anyname) {
//			System.out.println("I'm inside the catch block");
//			System.out.println("Message is : " + anyname.getMessage());
//			System.out.println("Cause is : " + anyname.getCause());
//			anyname.printStackTrace();
//			
//		}
//		finally {
//			System.out.println("I'm inside the finally block");
//		}
		

	}

	public static void demo() throws Exception {
		
			System.out.println("Whatever ***");
			throw new ArithmeticException("....not valid operation");
//			int i = 1/0;
//			System.out.println("\nCompleted");

	}

}
