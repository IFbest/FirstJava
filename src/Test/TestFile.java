package Test;

public class TestFile {
	public static void main(String[] args) {
		String str = "ABCD/DEFGH";
		String result = str.substring(str.lastIndexOf("/"));
		System.out.println(result); 
    }
 }