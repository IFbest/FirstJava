package kh1216;

public class Ex07 {
	public static void main(String[] args) {		
        if (args.length>0){
            for (int i = 0; i< args.length; i++)
                System.out.print(" "+ args[i]);
            if (args[0].equals("-h"))
                System.out.print("HELP");
        }// args[0].equals에 -h 있을 때 조건
    }
}//run configuration - Argument tap - -h one two