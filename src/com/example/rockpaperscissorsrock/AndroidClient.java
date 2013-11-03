package com.example.rockpaperscissorsrock;
import java.io.IOException;
import java.net.UnknownHostException;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.example.javaclient.Client;

public class AndroidClient extends Client implements Runnable{
	WebView clientView;
	
	public AndroidClient(int port, String ip, String playerName, WebView view) throws UnknownHostException, IOException{
		super(port, ip, playerName);
		this.clientView = view;
	}
	
	@Override
	protected void displayWinner(Integer winner) {
		clientView.loadUrl("winner display");
	}
	
	@Override
	protected void displayPlayerNames() {
		clientView.loadUrl("player display");
	}
	
	@Override
	protected void displayScores(){
		clientView.loadUrl("score display");
	}

	@JavascriptInterface
	@Override
	public void sendMove(String move){
		super.sendMove(move);
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}
}
