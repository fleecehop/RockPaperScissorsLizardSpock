package com.example.rockpaperscissorsrock;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.example.javaclient.Client;
import com.example.util.Message;

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
}
