package com.example.rockpaperscissorsrock;

import java.io.IOException;
import java.net.UnknownHostException;

import com.example.javaclient.Client;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
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
		 
		 
		
		
		//enable alert()
		 WebChromeClient alerts=new WebChromeClient();
		 w.setWebChromeClient(alerts);
		
		 int port = 0;
		 String ip= "";
		 String playerName= "";
		 
		 
		 //create a new instance of extended client
		 AndroidClient c;
		 
		try {
			c = new AndroidClient(port,ip,playerName,w);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 w.setWebViewClient(new WebViewClient(){
			 @Override
			 public void onPageFinished(WebView view,String url){
				 GameThread t = new GameThread(c);
				 t.start();
			 }
		 });
		 
		//add it as a javascript interface to the WebView with global name gameClient
		 w.addJavascriptInterface(gameClient, "gameClient");
		
		//create a new thread with client instance as argument and start thread
		//GameThread g = new GameThread();
		//g.start(gameClient);
		

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
