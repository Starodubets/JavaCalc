package CalcLogic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalcAPI
{
	public static int Calc(int a,int b,String op)
	{

		String opp = "+-/*";
		if( opp.indexOf(op.charAt(0)) == -1 )
			throw new IllegalArgumentException();
		if( op.charAt(0) == '/' && b == 0 )
			throw new ArithmeticException();
		int answ=0;
		
		String url = "http://localhost/ForSelenium/count.php?";
		
		if(op == "+")
			op = "%2b";
		
		String req = "num1="+a+"&num2="+b+"&opr="+op;

		try 
		{
			URL obj = new URL(url+req);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) 
			{
				response.append(inputLine);
				
			}
			
			in.close();
			
			answ = Integer.parseInt(response.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}		

		/*
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		/*
		switch(op)
		{
		case "+":
			answ=a+b;
			break;
		case "-":
			answ=a-b;
			break;
		case "*":
			answ=a*b;
			break;
		case "/":
			answ=a/b;
			break;
		}
		*/
		return answ;
	}
}
