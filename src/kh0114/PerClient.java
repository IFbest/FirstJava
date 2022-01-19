package kh0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClient extends Thread {
	static List<PrintWriter> list = 
			Collections.synchronizedList(new ArrayList<>());
	// 동시에 작업안함 synchronized
	
	Socket client;
	PrintWriter pw; // 연결 통로 Writer
	
	public PerClient(Socket client) throws IOException {
		this.client = client;
		pw = new PrintWriter(client.getOutputStream());
		list.add(pw);
	}
	public void run() {
		String name = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			name = br.readLine();
			sendAll('#' + name + "님이 입장 하셨습니다.");
			while(true) {
				String msg = br.readLine();
				if(msg == null)
					break;
				sendAll(name + ">" + msg);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(pw);
			sendAll("#" + name + "님이 퇴장하셨습니다.");
			try {
				client.close();
			} catch (Exception e) {
			}
		}
	}
	void sendAll(String msg) {
		for(PrintWriter p : list) {
			p.println(msg);
			p.flush();
		}
	}
}
