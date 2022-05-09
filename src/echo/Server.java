package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		//서버 소켓 객체 생성
		ServerSocket serverSocket = new ServerSocket();
		
		serverSocket.bind(new InetSocketAddress("", 10001)); //(ip, port)"
		//ip 주소는 cmd>ipconfig 통해서 확인
		//ip는 문자열임
		//재부팅시 ip주소가 변경될 수도 있기 때문에, 그때그때 확인해 줄 것
		//포트 번호는 본인이 정하면 되지만, 타인과 겹치면 안됨ㅋㅋ
		
		System.out.println("<서버시작>");
		System.out.println("================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		
		//////반복시작//////
		
		while(true) {
			Socket socket = serverSocket.accept();
		
			
			
			//쓰레드-출장보내기(출장가서 스트림 보강하고 대화해라!)
			Thread thread = new ServerThread(socket);
			thread.start();
		}
		
		
		///////반복종료///////
		
		/*
		
		System.out.println("===========================");
		System.out.println("<서버종료>");

		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
		*/
	}

}
