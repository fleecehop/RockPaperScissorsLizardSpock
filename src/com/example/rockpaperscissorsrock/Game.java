package com.example.rockpaperscissorsrock;

import java.io.IOException;

import com.example.javaclient.Client;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Game extends Activity  {

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 

		 super.onCreate(savedInstanceState); 
		 setContentView(R.layout.activity_game); 
		 WebView w=(WebView) findViewById(R.id.webView1); 
		 w.loadUrl("file:///android_assets/game.html");
		 
		 //create a default webview client
		 WebViewClient gameClient = new WebViewClient();
		 //create a new instance of extended client
		 Client c = new Client();
		
		
		 try {
			 //hardcode the client name
			 c.setPlayerName("webPlayer");
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		//add it as a javascript interface to the WebView with global name gameClient
		 w.addJavascriptInterface(gameClient, "gameClient");
		
		 //create a new thread with client instance as argument and start thread
		GameThread g = new GameThread();
		g.start(gameClient);
		

		}
	public class GameThread extends Thread {

	    public void run(WebViewClient gameClient) {
	        
	    }

		public void start(WebViewClient gameClient) {
			// TODO Auto-generated method stub
			run(gameClient);
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
