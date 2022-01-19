package kh0114;

import java.net.Socket;
import java.util.Scanner;
// 주석달기
public class Client_SendThread_ReceiveThread_PerClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("연결한 IP ? ");
		String ip = sc.nextLine();
		System.out.println("사용한 별명은 ? ");
		String name = sc.nextLine();
		
		try {
			Socket socket = new Socket("127.0.0.1", 9002);
			// 클라이언트로부터 접속 기다림(9002 포트)
			ReceiveThread_PerClient rt = new ReceiveThread_PerClient(socket);
			SendThread_ReceiveThread_PerClient st =
					new SendThread_ReceiveThread_PerClient(socket, name);
			rt.start();
			st.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
