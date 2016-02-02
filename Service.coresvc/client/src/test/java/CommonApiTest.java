


import org.junit.Assert;
import org.junit.Test;

import com.iflytek.epdcloud.epsp.client.EpspClientFactory;
import com.pandora.sparkfamily.base.api.DemoApi;

public class CommonApiTest {

	@Test
	public void testGetConfig() {
	    DemoApi.Iface commonApi = EpspClientFactory.createDemoApi();
		try {
		    String result = commonApi.getIndex("1");
		    System.out.println(result);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
}
