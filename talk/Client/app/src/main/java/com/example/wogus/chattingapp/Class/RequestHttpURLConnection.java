package com.example.wogus.chattingapp.Class;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wogus on 2019-08-06.
 */

public class RequestHttpURLConnection {
	public String request(String serverURL,String postParameters){
		try {
			URL url = new URL(serverURL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setReadTimeout(5000);
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoInput(true);
			httpURLConnection.connect();

			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(postParameters.getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();

			int responseStatusCode = httpURLConnection.getResponseCode();

			InputStream inputStream;
			if(responseStatusCode == HttpURLConnection.HTTP_OK) {
				inputStream = httpURLConnection.getInputStream();
			}
			else{
				inputStream = httpURLConnection.getErrorStream();
			}

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder sb = new StringBuilder();
			String line;

			while((line = bufferedReader.readLine()) != null){
				sb.append(line);
			}
			bufferedReader.close();
			return sb.toString().trim();

		} catch (Exception e) {
			return null;
		}
	}
}
