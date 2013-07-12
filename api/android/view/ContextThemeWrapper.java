package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;

public class ContextThemeWrapper extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.556 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.556 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.556 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.556 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.557 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "A52E6A8077E95A96382ABDDF2BE523D0")
    public  ContextThemeWrapper() {
        super(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.557 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "BB006EB06E8E607466055A931E2EFE9A")
    public  ContextThemeWrapper(Context base, int themeres) {
        super(base);
        mBase = base;
        mThemeResource = themeres;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.558 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "3DABDDC1F65B0CDB24F633535C22EB4F")
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.558 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "13B2E8C961E9362FDA33D1F57040A307")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        initializeTheme();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.558 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "A26F7FA8693DDA203B9D80375A0F9997")
    @Override
    public int getThemeResId() {
        int var1A7BE5C50406CFB30A072C422592257E_674012075 = (mThemeResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842574359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842574359;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.559 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "7FFCB92CDA37F350A048A6CC3AAEA2E6")
    @Override
    public Resources.Theme getTheme() {
    if(mTheme != null)        
        {
Resources.Theme var021DB673F568E8BD9EB3155CBE6DF295_1285287193 =             mTheme;
            var021DB673F568E8BD9EB3155CBE6DF295_1285287193.addTaint(taint);
            return var021DB673F568E8BD9EB3155CBE6DF295_1285287193;
        } 
        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();
Resources.Theme var021DB673F568E8BD9EB3155CBE6DF295_1193327070 =         mTheme;
        var021DB673F568E8BD9EB3155CBE6DF295_1193327070.addTaint(taint);
        return var021DB673F568E8BD9EB3155CBE6DF295_1193327070;
        
        
            
        
        
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.559 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "88DF4D9757F474699D7B5A8F899D3CE5")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
    if(LAYOUT_INFLATER_SERVICE.equals(name))        
        {
    if(mInflater == null)            
            {
                mInflater = LayoutInflater.from(mBase).cloneInContext(this);
            } 
Object varBB634655A97E6A29040AA54B59F0E4B4_2084223813 =             mInflater;
            varBB634655A97E6A29040AA54B59F0E4B4_2084223813.addTaint(taint);
            return varBB634655A97E6A29040AA54B59F0E4B4_2084223813;
        } 
Object varCEE83A4312F10FC75EECB5EAD4E09ED3_1165603900 =         mBase.getSystemService(name);
        varCEE83A4312F10FC75EECB5EAD4E09ED3_1165603900.addTaint(taint);
        return varCEE83A4312F10FC75EECB5EAD4E09ED3_1165603900;
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.559 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "E2663BE27D6C4E8C87CFAFE15029DEFE")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        
        addTaint(first);
        addTaint(resid);
        addTaint(theme.getTaint());
        theme.applyStyle(resid, true);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.560 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "6F51DC32008736AA454500B75DDF7DAC")
    private void initializeTheme() {
        final boolean first = mTheme == null;
    if(first)        
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
    if(theme != null)            
            {
                mTheme.setTo(theme);
            } 
        } 
        onApplyThemeResource(mTheme, mThemeResource, first);
        
        
        
            
            
            
                
            
        
        
    }

    
}

