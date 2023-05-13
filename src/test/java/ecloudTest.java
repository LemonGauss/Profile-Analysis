import com.chinamobile.cmss.sdk.ocr.ECloudDefaultClient;
import com.chinamobile.cmss.sdk.ocr.IECloudClient;
import com.chinamobile.cmss.sdk.ocr.http.constant.Region;
import com.chinamobile.cmss.sdk.ocr.http.signature.Credential;
import org.junit.Test;

public class ecloudTest {
    @Test
    public void eCloudOCR(){
        //用户鉴权对象
        String user_ak = "27bcb9b27d274482ad5a2609d2283889";
        String user_sk = "af3f36dc25184ffe85ba0a902875d472";
        Credential credential = new Credential(user_ak,  user_sk);
        IECloudClient client = new ECloudDefaultClient(credential, Region.POOL_SZ);


    }
}
