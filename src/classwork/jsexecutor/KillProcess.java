package classwork.jsexecutor;

import java.io.IOException;

public class KillProcess {
	public static void killDrivers() throws Exception{
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
	}
	

}
