package myexercise.captcha;

	import com.DeathByCaptcha.AccessDeniedException;
	import com.DeathByCaptcha.Captcha;
	import com.DeathByCaptcha.Client;
	import com.DeathByCaptcha.SocketClient;
	import com.DeathByCaptcha.HttpClient;
	
/*need to add the Deathbycaptcha api to install then only i can run this code
 * 
 * 
 */
public class readingCaptcha {


	/* Put your DeathByCaptcha account username and password here.
	   Use HttpClient for HTTP API. */
	Client client = (Client)new SocketClient(username, password);
	try {
	    double balance = client.getBalance();

	    /* Put your CAPTCHA file name, or file object, or arbitrary input stream,
	       or an array of bytes, and optional solving timeout (in seconds) here: */
	    Captcha captcha = client.decode(captchaFileName, timeout);
	    if (null != captcha) {
	        /* The CAPTCHA was solved; captcha.id property holds its numeric ID,
	           and captcha.text holds its text. */
	        System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);

	        if (/* check if the CAPTCHA was incorrectly solved */) {
	            client.report(captcha);
	        }
	    }
	} catch (AccessDeniedException e) {
	    /* Access to DBC API denied, check your credentials and/or balance */
	}