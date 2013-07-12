package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.os.Handler;
import android.preference.Preference.OnPreferenceChangeInternalListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

class PreferenceGroupAdapter extends BaseAdapter implements OnPreferenceChangeInternalListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.624 -0400", hash_original_field = "60A1F576EA55DAAA9B029C3300F68D2D", hash_generated_field = "9E796A8BD15586231740457EF37FD47D")

    private PreferenceGroup mPreferenceGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.624 -0400", hash_original_field = "49E5F06342B9A756471C57C41582CFFB", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.625 -0400", hash_original_field = "B17D80C739620B94B645CF4C17A79E8D", hash_generated_field = "DA3004DA159CA709DF746F6CEC7DBE4F")

    private ArrayList<PreferenceLayout> mPreferenceLayouts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.625 -0400", hash_original_field = "0EA8349A74250C961790E8C2CB2711B0", hash_generated_field = "21E20E055E82593BC0F10B12A6DDF8CB")

    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.625 -0400", hash_original_field = "EC716D907E12FB2C66058C9510972CEE", hash_generated_field = "68E5BAC937AEA9D08E6032C8918801F2")

    private boolean mHasReturnedViewTypeCount = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.625 -0400", hash_original_field = "ACF05BEDD3E446A1812760F79FD88601", hash_generated_field = "8BB536959B4C4BC77100BFD82203560A")

    private volatile boolean mIsSyncing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.625 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_field = "A759A4E7184E3E83FC4B81BC91EB49E4", hash_generated_field = "6F8F5735F15B9F1306F9CF88A1481F4F")

    private Runnable mSyncRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_method = "64E55F1CB25012944C9000EFC5F6389C", hash_generated_method = "098280FA3EF6FEBB87417E5331607D15")
        public void run() {
            syncMyPreferences();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.626 -0400", hash_original_method = "B0DE4241F694B745A6B6018AB0FE0031", hash_generated_method = "2348D0E06D92E9723DB46FBB01A918CF")
    public  PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        mPreferenceGroup = preferenceGroup;
        mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        mPreferenceList = new ArrayList<Preference>();
        mPreferenceLayouts = new ArrayList<PreferenceLayout>();
        syncMyPreferences();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.641 -0400", hash_original_method = "47CAC8934A77F33A41B8A2FADE539715", hash_generated_method = "F3A53D7C099FEB4F6A2629ADC6016B62")
    private void syncMyPreferences() {
        synchronized
(this)        {
    if(mIsSyncing)            
            {
                return;
            } 
            mIsSyncing = true;
        } 
        List<Preference> newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        mPreferenceList = newPreferenceList;
        notifyDataSetChanged();
        synchronized
(this)        {
            mIsSyncing = false;
            notifyAll();
        } 
        
        
            
                
            
            
        
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.641 -0400", hash_original_method = "DB0831C85843D6D53F9495F3413A2CE3", hash_generated_method = "AC060DC7A703230347A68E0AE9FC84D9")
    private void flattenPreferenceGroup(List<Preference> preferences, PreferenceGroup group) {
        addTaint(group.getTaint());
        addTaint(preferences.getTaint());
        group.sortPreferences();
        final int groupSize = group.getPreferenceCount();
for(int i = 0;i < groupSize;i++)
        {
            final Preference preference = group.getPreference(i);
            preferences.add(preference);
    if(!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout())            
            {
                addPreferenceClassName(preference);
            } 
    if(preference instanceof PreferenceGroup)            
            {
                final PreferenceGroup preferenceAsGroup = (PreferenceGroup) preference;
    if(preferenceAsGroup.isOnSameScreenAsChildren())                
                {
                    flattenPreferenceGroup(preferences, preferenceAsGroup);
                } 
            } 
            preference.setOnPreferenceChangeInternalListener(this);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.642 -0400", hash_original_method = "B927BA6712254BD5B8D47CF220E79C5B", hash_generated_method = "75A5D5AB2B915CFA3C3CC8BDF11607CF")
    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout in) {
        addTaint(in.getTaint());
        addTaint(preference.getTaint());
        PreferenceLayout pl = in != null? in : new PreferenceLayout();
        pl.name = preference.getClass().getName();
        pl.resId = preference.getLayoutResource();
        pl.widgetResId = preference.getWidgetLayoutResource();
PreferenceLayout var08A2C4A72E6D9753FFB2150962070B4D_307211105 =         pl;
        var08A2C4A72E6D9753FFB2150962070B4D_307211105.addTaint(taint);
        return var08A2C4A72E6D9753FFB2150962070B4D_307211105;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.642 -0400", hash_original_method = "22004160B58BE5F5ED0505DF7AB89FF1", hash_generated_method = "76F09BBEB7638D778C7524FBBD4DA8B2")
    private void addPreferenceClassName(Preference preference) {
        addTaint(preference.getTaint());
        final PreferenceLayout pl = createPreferenceLayout(preference, null);
        int insertPos = Collections.binarySearch(mPreferenceLayouts, pl);
    if(insertPos < 0)        
        {
            insertPos = insertPos * -1 - 1;
            mPreferenceLayouts.add(insertPos, pl);
        } 
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.642 -0400", hash_original_method = "146D9A3F8F2485F6100744DF28993915", hash_generated_method = "1FD8154F32342696813197ADCDE37136")
    public int getCount() {
        int varC421430EA712BB31552DDD51082F5040_699238305 = (mPreferenceList.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115650367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115650367;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.642 -0400", hash_original_method = "B1551AF468D615637FECD6277399376D", hash_generated_method = "0FF0D95DE006051E5001AB5417DE74ED")
    public Preference getItem(int position) {
        addTaint(position);
    if(position < 0 || position >= getCount())        
        {
Preference var540C13E9E156B687226421B24F2DF178_154186857 =         null;
        var540C13E9E156B687226421B24F2DF178_154186857.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_154186857;
        }
Preference varC00C7940BC9F3D49E69E634FDBA25534_1220178936 =         mPreferenceList.get(position);
        varC00C7940BC9F3D49E69E634FDBA25534_1220178936.addTaint(taint);
        return varC00C7940BC9F3D49E69E634FDBA25534_1220178936;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.642 -0400", hash_original_method = "C2BB649F8AE8B2BA22DD6170BF8090F3", hash_generated_method = "2096C6E12E987E68F95B7F033E98138C")
    public long getItemId(int position) {
        addTaint(position);
    if(position < 0 || position >= getCount())        
        {
        long var846671D8A4B86FA5CCE80364B710CCB1_1516579500 = (ListView.INVALID_ROW_ID);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1317600522 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1317600522;
        }
        long var59A7DB87FD3D5E8E8EFFF8EDCCC92635_232723559 = (this.getItem(position).getId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_105606218 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_105606218;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "0A6038B272F94F277CAFD95B96B15A1A", hash_generated_method = "863A6EB348FA847FC912914EB0869608")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        final Preference preference = this.getItem(position);
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
    if(Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0)        
        {
            convertView = null;
        } 
View var120D4AB100F80F068E5DB1FAB11D521C_977085137 =         preference.getView(convertView, parent);
        var120D4AB100F80F068E5DB1FAB11D521C_977085137.addTaint(taint);
        return var120D4AB100F80F068E5DB1FAB11D521C_977085137;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "ED75A4DEF716F8048DFD61CCEF0A4510", hash_generated_method = "BC0F6C56BFC8A1DE02A9A1742B92B0AB")
    @Override
    public boolean isEnabled(int position) {
        addTaint(position);
    if(position < 0 || position >= getCount())        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2016415406 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730314148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_730314148;
        }
        boolean var9ED7D97E3459E2D24DE2FF96EC461932_2053772003 = (this.getItem(position).isSelectable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112873283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112873283;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "0CCB65086BCEEB0323D3B2CEE66D10D1")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_1975449717 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476912730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476912730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "C2E233D65C74168849EC7AB5F1A2D9C0", hash_generated_method = "91145FFBCBC5AF1D9C0E8E0FB2D9A366")
    public void onPreferenceChange(Preference preference) {
        
        addTaint(preference.getTaint());
        notifyDataSetChanged();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "96B325BF777CE525D2D64038C1261EF1", hash_generated_method = "7FED000FF54A66B7C90459DCE8D8A82C")
    public void onPreferenceHierarchyChange(Preference preference) {
        
        addTaint(preference.getTaint());
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.643 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "CDD9EDB699155CEDB6E7F08B99BF76F2")
    @Override
    public boolean hasStableIds() {
        boolean varB326B5062B2F0E69046810717534CB09_1280515804 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509829928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509829928;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_method = "95969FB891958AA0335CF8E62A1ABF37", hash_generated_method = "5E41F76C205E09D9C7EC3C90F5F6DD69")
    @Override
    public int getItemViewType(int position) {
        addTaint(position);
    if(!mHasReturnedViewTypeCount)        
        {
            mHasReturnedViewTypeCount = true;
        } 
        final Preference preference = this.getItem(position);
    if(preference.hasSpecifiedLayout())        
        {
            int varFEBA93B0789497EBEDEB09E7A2E12E05_1442414557 = (IGNORE_ITEM_VIEW_TYPE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325935801 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325935801;
        } 
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        int viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
    if(viewType < 0)        
        {
            int varFEBA93B0789497EBEDEB09E7A2E12E05_2054416999 = (IGNORE_ITEM_VIEW_TYPE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909461126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909461126;
        } 
        else
        {
            int varBE99FDADF4634E48B1DF67A9485E0784_1871875570 = (viewType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477381144 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477381144;
        } 
        
        
            
        
        
        
            
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_method = "C26A2133E7F568EC0AF4EC87BB082A79", hash_generated_method = "53FE4854999534652D505C61382BCEFD")
    @Override
    public int getViewTypeCount() {
    if(!mHasReturnedViewTypeCount)        
        {
            mHasReturnedViewTypeCount = true;
        } 
        int var929537438D74B8A936F7559129C853BD_1913023306 = (Math.max(1, mPreferenceLayouts.size()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261654755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261654755;
        
        
            
        
        
    }

    
    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_field = "C0179AEDB850805806A31BDC39510289", hash_generated_field = "D57D54CAC1273148C7462B42AF5839E3")

        private int resId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_field = "2888237166571D1285BA13E4324E3AEE", hash_generated_field = "C72CD28C67C0D0B9F30E5D9DB8173BFF")

        private int widgetResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_method = "12E8ADB8C3EE61AC77B7A82A93B07078", hash_generated_method = "12E8ADB8C3EE61AC77B7A82A93B07078")
        public PreferenceLayout ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_method = "0A98309F64E867E673B1B3CFC2DB79CE", hash_generated_method = "FA2BF7E4E5076CE460DBE6C8FD9BAA31")
        public int compareTo(PreferenceLayout other) {
            addTaint(other.getTaint());
            int compareNames = name.compareTo(other.name);
    if(compareNames == 0)            
            {
    if(resId == other.resId)                
                {
    if(widgetResId == other.widgetResId)                    
                    {
                        int varCFCD208495D565EF66E7DFF9F98764DA_1821046143 = (0);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947965703 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947965703;
                    } 
                    else
                    {
                        int var668428D0DDF44F2DC16828D31178E104_1742293022 = (widgetResId - other.widgetResId);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858139417 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858139417;
                    } 
                } 
                else
                {
                    int varD9EFFAD18764D32F3A83FDC89447722F_299230200 = (resId - other.resId);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718156059 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718156059;
                } 
            } 
            else
            {
                int var691C605F2A969CC09889E4C30F3161B2_1230089519 = (compareNames);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018244786 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018244786;
            } 
            
            
            
                
                    
                        
                    
                        
                    
                
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.644 -0400", hash_original_field = "81DE64C3C34751C325BA93388532677A", hash_generated_field = "3CD558471AD811C3362637174225D8B1")

    private static final String TAG = "PreferenceGroupAdapter";
}

