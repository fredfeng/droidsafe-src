package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.test.mock.MockApplication;
import java.lang.reflect.Field;
import java.util.Random;

public abstract class ServiceTestCase<T extends Service> extends AndroidTestCase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "ABE707345597563360502B5433C70932", hash_generated_field = "637B9F6ABC3AC96EB3EB7681C795A33D")

    Class<T> mServiceClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "A0F03383C9D11CB5B436FDD418A9C4FE", hash_generated_field = "F1477828250C5BEBE602BC5EA1713A2E")

    private Context mSystemContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "F3295512C5A15A7E1E4BE8A38300F691")

    private T mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "00340BEB7C5E3B4E822B30E801E29ABB", hash_generated_field = "BDC91FBBED9ED66C312CB510184D92A5")

    private boolean mServiceAttached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "2A83F589A0EB8FE1589DEC446A463CE2", hash_generated_field = "F0F3484542642FB72C170742CF175167")

    private boolean mServiceCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "F535E359764397C8365B2A00171D1DB2", hash_generated_field = "6B66D148B1E37EBE59F99F9D0E5A992C")

    private boolean mServiceStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "9E4511323F8DCE82F58F6089D1655613", hash_generated_field = "912B0BEA2990419429548895171B2F0A")

    private boolean mServiceBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.185 -0400", hash_original_field = "10B1014B326606E09E39CA12F4E9358B", hash_generated_field = "05A1A5A41A6AA7DC7317478E19978B0B")

    private Intent mServiceIntent = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.186 -0400", hash_original_field = "E5AC35A5BD46D7D9458034CDAA0AA902", hash_generated_field = "A4722B4D674B9B46CA8EAF04E1307521")

    private int mServiceId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.186 -0400", hash_original_method = "1F3B37EA8E1B8B1054B69DFECCE45A51", hash_generated_method = "85D06AB636C51DA0CBB69DAD45C7DC56")
    public  ServiceTestCase(Class<T> serviceClass) {
        mServiceClass = serviceClass;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.186 -0400", hash_original_method = "E1B67BA0E23B118C6146D406450E84BD", hash_generated_method = "9DCCD76B43746B1E4E8F286E8B04044B")
    public T getService() {
T var72B03849F9527CD4AC8A54AA9B97A48C_62614018 =         mService;
        var72B03849F9527CD4AC8A54AA9B97A48C_62614018.addTaint(taint);
        return var72B03849F9527CD4AC8A54AA9B97A48C_62614018;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.187 -0400", hash_original_method = "268090C8258F440561CAD8495BE839CE", hash_generated_method = "0B1DFFD09D79A0B8CCFEFA7B01A3D28A")
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mSystemContext = getContext();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.187 -0400", hash_original_method = "896172C51C066B5F037A8F2C24487B23", hash_generated_method = "3A3FFDB8C7966FAF0BC7DD0D8F96D9C3")
    protected void setupService() {
        mService = null;
        try 
        {
            mService = mServiceClass.newInstance();
        } 
        catch (Exception e)
        {
            assertNotNull(mService);
        } 
    if(getApplication() == null)        
        {
            setApplication(new MockApplication());
        } 
        mService.attach(
                getContext(),
                null,               
                mServiceClass.getName(),
                null,               
                getApplication(),
                null                
                );
        assertNotNull(mService);
        mServiceId = new Random().nextInt();
        mServiceAttached = true;
        
        
        
            
        
            
        
        
            
        
        
                
                
                
                
                
                
                
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.188 -0400", hash_original_method = "21E4CB4FCD74533F799D23D47E90F5B7", hash_generated_method = "5A760F06291C41012D1BBC881FFEC8B6")
    protected void startService(Intent intent) {
        addTaint(intent.getTaint());
    if(!mServiceAttached)        
        {
            setupService();
        } 
        assertNotNull(mService);
    if(!mServiceCreated)        
        {
            mService.onCreate();
            mServiceCreated = true;
        } 
        mService.onStartCommand(intent, 0, mServiceId);
        mServiceStarted = true;
        
        
            
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.189 -0400", hash_original_method = "9243E940E5DBFB4305A53445C0DB5EAA", hash_generated_method = "9B7E711ACBFCFF19ACB5E38E6A546EA8")
    protected IBinder bindService(Intent intent) {
    if(!mServiceAttached)        
        {
            setupService();
        } 
        assertNotNull(mService);
    if(!mServiceCreated)        
        {
            mService.onCreate();
            mServiceCreated = true;
        } 
        mServiceIntent = intent.cloneFilter();
        IBinder result = mService.onBind(intent);
        mServiceBound = true;
IBinder varDC838461EE2FA0CA4C9BBB70A15456B0_1498803600 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1498803600.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1498803600;
        
        
            
        
        
        
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.189 -0400", hash_original_method = "7A2B90C413225D42DADFD4030FEDB024", hash_generated_method = "FE7C79667A2B4983986594DE8F221D5F")
    protected void shutdownService() {
    if(mServiceStarted)        
        {
            mService.stopSelf();
            mServiceStarted = false;
        } 
        else
    if(mServiceBound)        
        {
            mService.onUnbind(mServiceIntent);
            mServiceBound = false;
        } 
    if(mServiceCreated)        
        {
            mService.onDestroy();
        } 
        
        
            
            
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.190 -0400", hash_original_method = "87D1D2444773B04D6FA2D1565794C0F5", hash_generated_method = "40ECAA34A3B22375EB9D9CA4239B98D3")
    @Override
    protected void tearDown() throws Exception {
        shutdownService();
        mService = null;
        scrubClass(ServiceTestCase.class);
        super.tearDown();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.190 -0400", hash_original_method = "3567B69292EF80C03794348A9036011F", hash_generated_method = "4107DD9EC38CBD3CCF4928F6835C3F78")
    public void setApplication(Application application) {
        mApplication = application;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.191 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "78547C6E1E536CEF3581957E99767FAC")
    public Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_1156666010 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_1156666010.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_1156666010;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.191 -0400", hash_original_method = "20F2DC85F18376CDF1A7B2B9DA0C85A8", hash_generated_method = "20EABC9CCD510673D89CC90A7880DF3E")
    public Context getSystemContext() {
Context var8C7F00BBFA5D714A8F742FB231BABCE9_1028013276 =         mSystemContext;
        var8C7F00BBFA5D714A8F742FB231BABCE9_1028013276.addTaint(taint);
        return var8C7F00BBFA5D714A8F742FB231BABCE9_1028013276;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.191 -0400", hash_original_method = "109B8E506FBC3D7FBEA1E1B742558961", hash_generated_method = "9C1732A8190F999B54BCFE6180E9C491")
    public void testServiceTestCaseSetUpProperly() throws Exception {
        setupService();
        assertNotNull("service should be launched successfully", mService);
        
        
        
    }

    
}

