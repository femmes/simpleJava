import java.io.Console;


class helloworld  {

	public static helloworld hw = new helloworld();
	public static Console console = System.console();
	public static int[] array;
	public static int index=2;

	public static void main(String[] args) {
		hw.callMenu();
		// recursive fibonacci (functions calculate() n recursiveFib())
		//hw.recursiveFib(15);
	}

	public void callMenu(){
		String newString=hw.printMenu();
		hw.menuInput(newString);
	}
	public String printMenu(){
		System.out.println("\n------------------------------------------");
		System.out.println("|              Java Programs             |");
		System.out.println("------------------------------------------\n");
		System.out.println("1) Calculate the fibonacci sequence");
		System.out.println("2) Find Second Highest Number in an Array");
		String userInput = console.readLine("\nSelect a program or press q to exit: ");
		return userInput;
	}
	public void menuInput(String input){
		if(input.equals("q")){
			System.exit(0);
		}
		else if(input.equals("1")){
			String userinput = console.readLine("\nTo what degree do u want to calculate the fibonacci sequence: ");
			int[] newArray=hw.fibonacci(Integer.parseInt(userinput));
			for(int i=0; i<newArray.length;i++){
				if(i!=newArray.length-1){
					System.out.print(newArray[i]+", ");
				}
				else{
					System.out.print(newArray[i]+"\n");
				}
			}
			callMenu();
		}
		else if(input.equals("2")){
			String userinput = console.readLine("\nEnter digits seperated by spaces: ");
			String[] split = userinput.split("\\s+");
			int[] result = new int[split.length];
			for(int i=0; i<split.length; i++){
				result[i]=Integer.parseInt(split[i]);
			}
			System.out.println("Second Highest Number is: "+secondHighestNumber(result)+"\n");
			callMenu();
		}
	}
	public int[] fibonacci(int howBig){
		int n=0;
		int[] fibArray = new int[howBig];
		int newValue;
		if(n==0){
			fibArray[n]=0;
			n++;
		}
		if(n==1){
			fibArray[n]=1;
			n++;
		}
		for(; n<howBig; n++){
			newValue=fibArray[n-1]+fibArray[n-2];
			fibArray[n]=newValue;
		}
		return fibArray;
	}
	//recursive way
	public void recursiveFib(int value){
		array = new int[value];
		array[0]=0;
		array[1]=1;
		calculate(value, index);
	}
	public void calculate(int value, int index){
		if(index==value){
			return;
		}else{
			array[index]=array[index-1]+array[index-2];
			System.out.println(array[index]);
			calculate(value, ++index);
		}
	}
	/// 5 16 34 9 1 25
	public int secondHighestNumber(int[] numberArray){
		int oneNumber=0;
		int secondNumber=0;
		for(int i=0; i<numberArray.length; i++){
			if(oneNumber<numberArray[i]){
				System.out.println(oneNumber+" is less then "+ numberArray[i]);
				secondNumber=oneNumber;
				oneNumber=numberArray[i];
			}
			else if(secondNumber<numberArray[i]){
				secondNumber=numberArray[i];
			}
		}
		return secondNumber;
	}

	public String alphabeticOrder(String[] wordArray){
		
	}
}