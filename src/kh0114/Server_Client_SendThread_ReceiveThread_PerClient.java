package kh0114;

import java.net.ServerSocket;
import java.net.Socket;

// 주석달기
public class Server_Client_SendThread_ReceiveThread_PerClient {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9002);
			while(true) {
				Socket client = ss.accept();
				PerClient pc = new PerClient(client);
				pc.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}