package com.imakerhub;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 创建服务器，并启动．
 */
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;

	public static void main(String[] args) {
		
		Server ser = new Server();
		ser.start();


	}
	/**
	 * 启动方法
	 */
	
	public void start(){
		try {
			server = new ServerSocket(8888);
			

			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 接收客户端
	 */
	
	private void receive(){
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length() > 0){
				sb.append(msg);
				sb.append("\r\n");
				if(msg == null){
					break;
				}

			}
			String requestInfo = sb.toString().trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止方法
	 */
	public void stop(){
		
	}


}
