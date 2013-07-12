package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.internal.content.PackageMonitor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActivityChooserModel extends DataSetObservable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "BDD11A174105185D4DFC52160E3514BE", hash_generated_field = "A383B170605041BAE9B92E5ABD19A2C0")

    private final List<ActivityResolveInfo> mActivites = new ArrayList<ActivityResolveInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "A45D92F0F1E7DD7537AB0337C633B496", hash_generated_field = "CD99824E96948584D748917073F44E2A")

    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "C20064CA31FAD1327132178E6648B402", hash_generated_field = "DD3DAD2906BF0D253EBD93D8930F9D13")

    private final PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "0AC95AC99D05B1B82A91751B7AF9D262", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private String mHistoryFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.025 -0400", hash_original_field = "AB35EBBBAD6B54BD08B6B257BBB364A2", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "009B5E594BE56F87B3DDDC247536245A", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "5D5149323D264891E5B84C86B8D5566D", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "16353D6A786D24930B9B107BE61F2C9C", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "2EA85A36CC27F7C4832E5A8C4EBC1736", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_field = "669155EA4A74A2A42AAC5F61C77CAF5E", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.026 -0400", hash_original_method = "807F9125D161268ACCBF934F5F44F95B", hash_generated_method = "D4720E2BC3C9D66889563D801E8159FD")
    private  ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
    if(!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION))        
        {
            mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        } 
        else
        {
            mHistoryFileName = historyFileName;
        } 
        mPackageMonitor.register(mContext, true);
        
        
        
                
            
        
            
        
        
    }

    
        public static ActivityChooserModel get(Context context, String historyFileName) {
        synchronized (sRegistryLock) {
            ActivityChooserModel dataModel = sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
            dataModel.readHistoricalData();
            return dataModel;
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.027 -0400", hash_original_method = "E9FF7BF71184D5918A5528B39387C05B", hash_generated_method = "18CCE81ABD65A10D68A1CBBC40B99539")
    public void setIntent(Intent intent) {
        synchronized
(mInstanceLock)        {
    if(mIntent == intent)            
            {
                return;
            } 
            mIntent = intent;
            loadActivitiesLocked();
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.027 -0400", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "77ABD44B9D8F61CE9BB5AB6B101AB3AA")
    public Intent getIntent() {
        synchronized
(mInstanceLock)        {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_103879965 =             mIntent;
            var4DCF8E3D75AE0B94CDA94656DCE16BCE_103879965.addTaint(taint);
            return var4DCF8E3D75AE0B94CDA94656DCE16BCE_103879965;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.028 -0400", hash_original_method = "D90428775A0762F0AD6636514EC58022", hash_generated_method = "4CACBDD2C4D84EFF057084A3756B9AC1")
    public int getActivityCount() {
        synchronized
(mInstanceLock)        {
            int varEE9CF3CA592A4FE681A759B4BC597948_1184923941 = (mActivites.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209198310 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209198310;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.028 -0400", hash_original_method = "032146065CC1BA2D79ECD4CB63DFEC7F", hash_generated_method = "14B477620F2EB6009F8E501620CDE6DA")
    public ResolveInfo getActivity(int index) {
        addTaint(index);
        synchronized
(mInstanceLock)        {
ResolveInfo var16A1693659E349C4F10493D7FEF7AF3F_829195627 =             mActivites.get(index).resolveInfo;
            var16A1693659E349C4F10493D7FEF7AF3F_829195627.addTaint(taint);
            return var16A1693659E349C4F10493D7FEF7AF3F_829195627;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.028 -0400", hash_original_method = "1C6D65F5A71D312AA7F7882C56EDED0B", hash_generated_method = "B0D47389ACC18B8D7A817C9D472DE9B6")
    public int getActivityIndex(ResolveInfo activity) {
        addTaint(activity.getTaint());
        List<ActivityResolveInfo> activities = mActivites;
        final int activityCount = activities.size();
for(int i = 0;i < activityCount;i++)
        {
            ActivityResolveInfo currentActivity = activities.get(i);
    if(currentActivity.resolveInfo == activity)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1244482790 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156308952 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156308952;
            } 
        } 
        int varF059DD129FB8A61588D41BA6DF391A4E_576091437 = (INVALID_INDEX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865166633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865166633;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.029 -0400", hash_original_method = "2E1571A22B1C1279902BA9C2D35CCDAC", hash_generated_method = "B0E9A5ED63AB4F9A396283F5587CCCC4")
    public Intent chooseActivity(int index) {
        addTaint(index);
        ActivityResolveInfo chosenActivity = mActivites.get(index);
        ComponentName chosenName = new ComponentName(
                chosenActivity.resolveInfo.activityInfo.packageName,
                chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent = new Intent(mIntent);
        choiceIntent.setComponent(chosenName);
    if(mActivityChoserModelPolicy != null)        
        {
            Intent choiceIntentCopy = new Intent(choiceIntent);
            final boolean handled = mActivityChoserModelPolicy.onChooseActivity(this,
                    choiceIntentCopy);
    if(handled)            
            {
Intent var540C13E9E156B687226421B24F2DF178_1593986974 =                 null;
                var540C13E9E156B687226421B24F2DF178_1593986974.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1593986974;
            } 
        } 
        HistoricalRecord historicalRecord = new HistoricalRecord(chosenName,
                System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
        addHisoricalRecord(historicalRecord);
Intent varE44B24DC285915FA809667F86F15DD6A_167663593 =         choiceIntent;
        varE44B24DC285915FA809667F86F15DD6A_167663593.addTaint(taint);
        return varE44B24DC285915FA809667F86F15DD6A_167663593;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.029 -0400", hash_original_method = "56E3863DC4DFDE24EBD2068470DB48E1", hash_generated_method = "502DB08B7514528D4C4579AC10A6BA23")
    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        mActivityChoserModelPolicy = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.030 -0400", hash_original_method = "8C412D794940DE98F4AAE841092A3BC7", hash_generated_method = "EDE16968479F5E04E7A8A2FE6546F266")
    public ResolveInfo getDefaultActivity() {
        synchronized
(mInstanceLock)        {
    if(!mActivites.isEmpty())            
            {
ResolveInfo varF81D77FBBA6386BD228B5E33DB7741BD_1793684156 =                 mActivites.get(0).resolveInfo;
                varF81D77FBBA6386BD228B5E33DB7741BD_1793684156.addTaint(taint);
                return varF81D77FBBA6386BD228B5E33DB7741BD_1793684156;
            } 
        } 
ResolveInfo var540C13E9E156B687226421B24F2DF178_2034006306 =         null;
        var540C13E9E156B687226421B24F2DF178_2034006306.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2034006306;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.030 -0400", hash_original_method = "6293689B582FC8E5AF147BEE230A1B37", hash_generated_method = "15F0E289A9B211154D8D674740788F7E")
    public void setDefaultActivity(int index) {
        addTaint(index);
        ActivityResolveInfo newDefaultActivity = mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = mActivites.get(0);
        float weight;
    if(oldDefaultActivity != null)        
        {
            weight = oldDefaultActivity.weight - newDefaultActivity.weight
                + DEFAULT_ACTIVITY_INFLATION;
        } 
        else
        {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        } 
        ComponentName defaultName = new ComponentName(
                newDefaultActivity.resolveInfo.activityInfo.packageName,
                newDefaultActivity.resolveInfo.activityInfo.name);
        HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                System.currentTimeMillis(), weight);
        addHisoricalRecord(historicalRecord);
        
        
        
        
        
            
                
        
            
        
        
                
                
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.031 -0400", hash_original_method = "79A1B7D3C52D92BAB878ED8275782ED6", hash_generated_method = "5E09CEDE6A1BC09D58744FE19130CF12")
    private void readHistoricalData() {
        synchronized
(mInstanceLock)        {
    if(!mCanReadHistoricalData || !mHistoricalRecordsChanged)            
            {
                return;
            } 
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
    if(!TextUtils.isEmpty(mHistoryFileName))            
            {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
            } 
        } 
        
        
            
                
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.031 -0400", hash_original_method = "50EE1C88911FEE4E5E828FE89316C1B7", hash_generated_method = "F9F9116BB0F660C059BEE8B27B69F770")
    private void persistHistoricalData() {
        synchronized
(mInstanceLock)        {
    if(!mReadShareHistoryCalled)            
            {
                IllegalStateException var3FA515C78C3446B25BEB037F7FE64FCA_142800854 = new IllegalStateException("No preceding call to #readHistoricalData");
                var3FA515C78C3446B25BEB037F7FE64FCA_142800854.addTaint(taint);
                throw var3FA515C78C3446B25BEB037F7FE64FCA_142800854;
            } 
    if(!mHistoricalRecordsChanged)            
            {
                return;
            } 
            mHistoricalRecordsChanged = false;
            mCanReadHistoricalData = true;
    if(!TextUtils.isEmpty(mHistoryFileName))            
            {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
            } 
        } 
        
        
            
                
            
            
                
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.032 -0400", hash_original_method = "4FD548D8FB7638BF40234ABBB5D78544", hash_generated_method = "592C089D2F0A427487BA7B99F44C385B")
    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized
(mInstanceLock)        {
    if(mActivitySorter == activitySorter)            
            {
                return;
            } 
            mActivitySorter = activitySorter;
            sortActivities();
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.032 -0400", hash_original_method = "B440CA3B13B34DB5E9312802F4C1443D", hash_generated_method = "FBD868E3B4D7BB6ED10134AC201B4166")
    private void sortActivities() {
        synchronized
(mInstanceLock)        {
    if(mActivitySorter != null && !mActivites.isEmpty())            
            {
                mActivitySorter.sort(mIntent, mActivites,
                        Collections.unmodifiableList(mHistoricalRecords));
                notifyChanged();
            } 
        } 
        
        
            
                
                        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.033 -0400", hash_original_method = "1F530ED27C984DBDEEC1EB526F5DD126", hash_generated_method = "29231AB0663CC1A7BB0CADD53F6E0D6A")
    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized
(mInstanceLock)        {
    if(mHistoryMaxSize == historyMaxSize)            
            {
                return;
            } 
            mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        } 
        
        
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.033 -0400", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "A8FC30E53376B527FEB1470AA1C77A25")
    public int getHistoryMaxSize() {
        synchronized
(mInstanceLock)        {
            int var60A475C6BC545DF9382D60CA60C0AFD1_1953826610 = (mHistoryMaxSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144643831 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144643831;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.033 -0400", hash_original_method = "9F4BBC1AE7ECE6B5427CA6E0430F86F9", hash_generated_method = "547D80F9AB266804056BF9C99677CAA6")
    public int getHistorySize() {
        synchronized
(mInstanceLock)        {
            int varE99D5D1CE9ABD5BEC8AFB022AE600BF5_548844989 = (mHistoricalRecords.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358531586 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358531586;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.033 -0400", hash_original_method = "37F72BEA9084083CB35C7BD83368023D", hash_generated_method = "C5E6738DAFC973D5C650FCF6D89CF2D3")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.034 -0400", hash_original_method = "50B8FA4A00A0FC54414B26FDB0055015", hash_generated_method = "993D4CA8780B25022A1C9B1A5E7A4E31")
    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        addTaint(historicalRecord.getTaint());
        synchronized
(mInstanceLock)        {
            final boolean added = mHistoricalRecords.add(historicalRecord);
    if(added)            
            {
                mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            } 
            boolean varB60ED88355AC3F6898FD8A7AB1734D06_500519009 = (added);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481567760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481567760;
        } 
        
        
            
            
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.034 -0400", hash_original_method = "84DEA752877B716573664E1E2DB7F950", hash_generated_method = "2E7F3055A1DB03798BFC7C98F1F9C0BA")
    private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = mHistoricalRecords;
        final int pruneCount = choiceRecords.size() - mHistoryMaxSize;
    if(pruneCount <= 0)        
        {
            return;
        } 
        mHistoricalRecordsChanged = true;
for(int i = 0;i < pruneCount;i++)
        {
            HistoricalRecord prunedRecord = choiceRecords.remove(0);
    if(DEBUG)            
            {
            } 
        } 
        
        
        
        
            
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.035 -0400", hash_original_method = "CE097995E3DDE01957F3BEF111DCC08A", hash_generated_method = "CF49077B2CD7CD012AC125F34EB99385")
    private void loadActivitiesLocked() {
        mActivites.clear();
    if(mIntent != null)        
        {
            List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
for(int i = 0;i < resolveInfoCount;i++)
            {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                mActivites.add(new ActivityResolveInfo(resolveInfo));
            } 
            sortActivities();
        } 
        else
        {
            notifyChanged();
        } 
        
        
        
            
                
            
            
                
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.035 -0400", hash_original_method = "A58F8162E2D66FE48738B2459230A97A", hash_generated_method = "86325D14E5B34998F424D60739551EA2")
    private void pruneHistoricalRecordsForPackageLocked(String packageName) {
        addTaint(packageName.getTaint());
        boolean recordsRemoved = false;
        List<HistoricalRecord> historicalRecords = mHistoricalRecords;
for(int i = 0;i < historicalRecords.size();i++)
        {
            HistoricalRecord historicalRecord = historicalRecords.get(i);
            String recordPackageName = historicalRecord.activity.getPackageName();
    if(recordPackageName.equals(packageName))            
            {
                historicalRecords.remove(historicalRecord);
                recordsRemoved = true;
            } 
        } 
    if(recordsRemoved)        
        {
            mHistoricalRecordsChanged = true;
            sortActivities();
        } 
        
        
        
        
            
            
            
                
                
            
        
        
            
            
        
    }

    
    public final static class HistoricalRecord {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.036 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "E9F78AFB95D47915FCC3FF74E33CC6C3")

        public ComponentName activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.036 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

        public long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.036 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.036 -0400", hash_original_method = "1C86724BE7B708067898B3EC6CC9E920", hash_generated_method = "6A4D14D2B40550C038614A3DE96D1B4B")
        public  HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
            addTaint(weight);
            addTaint(time);
            addTaint(activityName.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.037 -0400", hash_original_method = "15F3A03D01E02908C99E8CDDD520EB93", hash_generated_method = "039A30ECAF845160B7B36EDE95851CB2")
        public  HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.037 -0400", hash_original_method = "4E1A48E49166529A0B7FC03866764063", hash_generated_method = "3FAD75EF41C960C867EC34CAF3AB4406")
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            int varB4A88417B3D0170D754C647C30B7216A_444501621 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144583827 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144583827;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.038 -0400", hash_original_method = "B85F0FF6FF50850EA2189DB29FD09D21", hash_generated_method = "7A23B1FF64E3029AF3CD3E64FF96061A")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(this == obj)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_699900856 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323444312 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_323444312;
            } 
    if(obj == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_930755937 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737871158 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737871158;
            } 
    if(getClass() != obj.getClass())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1114881774 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26004996 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_26004996;
            } 
            HistoricalRecord other = (HistoricalRecord) obj;
    if(activity == null)            
            {
    if(other.activity != null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_666115236 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548231778 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_548231778;
                } 
            } 
            else
    if(!activity.equals(other.activity))            
            {
                boolean var68934A3E9455FA72420237EB05902327_693832802 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078106528 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078106528;
            } 
    if(time != other.time)            
            {
                boolean var68934A3E9455FA72420237EB05902327_779162594 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518239596 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_518239596;
            } 
    if(Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1207296786 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702478615 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_702478615;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1996226709 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81008861 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_81008861;
            
            
                
            
            
                
            
            
                
            
            
            
                
                    
                
            
                
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.038 -0400", hash_original_method = "DE8206875FA4E924E296C5ACB6D7F3F2", hash_generated_method = "1DC543AC432A7720B92AE7943C1AC14C")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_1739663309 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1739663309.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1739663309;
            
            
            
            
            
            
            
            
        }

        
    }


    
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.038 -0400", hash_original_field = "C00A4654C3CFD33861C7CC1FD2D3713F", hash_generated_field = "42ACA7D028AD018D3FE2BFC3E32F6A75")

        public ResolveInfo resolveInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.038 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.038 -0400", hash_original_method = "FE163077B7530186AE819FA48AA47F8E", hash_generated_method = "5FF0866FAB3426E950C36794AFE28F97")
        public  ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.039 -0400", hash_original_method = "F192571EE56F5C4051616CB9861F74E4", hash_generated_method = "029280271B7E970D5FCE9549E031481E")
        @Override
        public int hashCode() {
            int var870AB715848EE80A9C18EC07E4D8B063_1149628024 = (31 + Float.floatToIntBits(weight));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56413215 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56413215;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.039 -0400", hash_original_method = "FF799F5AAE6D6CF88DAF4502D583A290", hash_generated_method = "F593113CF4EFB3D064C865C0A9B65B16")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(this == obj)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_697877547 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663467207 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_663467207;
            } 
    if(obj == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_870660888 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491740537 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_491740537;
            } 
    if(getClass() != obj.getClass())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1927762861 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645907023 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_645907023;
            } 
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
    if(Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))            
            {
                boolean var68934A3E9455FA72420237EB05902327_182784202 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197612815 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197612815;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_873462077 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59824851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_59824851;
            
            
                
            
            
                
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.040 -0400", hash_original_method = "05EB01A51A0727988F01FD1C25038E23", hash_generated_method = "4C212B877AE140F0EE45F00A6B109F85")
        public int compareTo(ActivityResolveInfo another) {
            addTaint(another.getTaint());
            int var7DDFDF7A874F602BD83F39F6B9E3E74A_980285156 = (Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658253279 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658253279;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.040 -0400", hash_original_method = "6B7079774B733597AE380820B7605540", hash_generated_method = "393239421081815C915D1E63F6497AE7")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_629620740 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_629620740.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_629620740;
            
            
            
            
            
            
            
        }

        
    }


    
    private final class DefaultSorter implements ActivitySorter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.040 -0400", hash_original_field = "607FF895363E04DFCB9D5664F60B57F0", hash_generated_field = "36A2609728A36E5BA82D7C988AE5AE60")

        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap<String, ActivityResolveInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.040 -0400", hash_original_method = "4BF496988E00827DD1484620E43167BF", hash_generated_method = "4BF496988E00827DD1484620E43167BF")
        public DefaultSorter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.043 -0400", hash_original_method = "1983622E810CF2F16D5FB85B8E79AAA7", hash_generated_method = "87227298B8387B4B0F38E66CEBDB753B")
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            addTaint(historicalRecords.getTaint());
            addTaint(activities.getTaint());
            addTaint(intent.getTaint());
            Map<String, ActivityResolveInfo> packageNameToActivityMap = mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            final int activityCount = activities.size();
for(int i = 0;i < activityCount;i++)
            {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = 0.0f;
                String packageName = activity.resolveInfo.activityInfo.packageName;
                packageNameToActivityMap.put(packageName, activity);
            } 
            final int lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight = 1;
for(int i = lastShareIndex;i >= 0;i--)
            {
                HistoricalRecord historicalRecord = historicalRecords.get(i);
                String packageName = historicalRecord.activity.getPackageName();
                ActivityResolveInfo activity = packageNameToActivityMap.get(packageName);
    if(activity != null)                
                {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                } 
            } 
            Collections.sort(activities);
    if(DEBUG)            
            {
for(int i = 0;i < activityCount;i++)
                {
                } 
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.044 -0400", hash_original_field = "16755C1D312376513A05EE549649A996", hash_generated_field = "80DD4E6EDFEAE82BDC0A595B5F72F371")

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    }


    
    private final class HistoryLoader implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.044 -0400", hash_original_method = "0F6CF60457783C48329031B15DA96823", hash_generated_method = "0F6CF60457783C48329031B15DA96823")
        public HistoryLoader ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.045 -0400", hash_original_method = "C7992FBC3712621E8BB422FE384E294B", hash_generated_method = "509C8A8C040F9DA96A6159D80E1D68A2")
        public void run() {
            FileInputStream fis = null;
            try 
            {
                fis = mContext.openFileInput(mHistoryFileName);
            } 
            catch (FileNotFoundException fnfe)
            {
    if(DEBUG)                
                {
                } 
                return;
            } 
            try 
            {
                XmlPullParser parser = Xml.newPullParser();
                parser.setInput(fis, null);
                int type = XmlPullParser.START_DOCUMENT;
                while
(type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG)                
                {
                    type = parser.next();
                } 
    if(!TAG_HISTORICAL_RECORDS.equals(parser.getName()))                
                {
                    XmlPullParserException var5FBDE362DFFC3C24BCC88AAC42CB95AA_879850502 = new XmlPullParserException("Share records file does not start with "
                            + TAG_HISTORICAL_RECORDS + " tag.");
                    var5FBDE362DFFC3C24BCC88AAC42CB95AA_879850502.addTaint(taint);
                    throw var5FBDE362DFFC3C24BCC88AAC42CB95AA_879850502;
                } 
                List<HistoricalRecord> readRecords = new ArrayList<HistoricalRecord>();
                while
(true)                
                {
                    type = parser.next();
    if(type == XmlPullParser.END_DOCUMENT)                    
                    {
                        break;
                    } 
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                    
                    {
                        continue;
                    } 
                    String nodeName = parser.getName();
    if(!TAG_HISTORICAL_RECORD.equals(nodeName))                    
                    {
                        XmlPullParserException varF3F51246E63940A674F24490F1D3073F_294848831 = new XmlPullParserException("Share records file not well-formed.");
                        varF3F51246E63940A674F24490F1D3073F_294848831.addTaint(taint);
                        throw varF3F51246E63940A674F24490F1D3073F_294848831;
                    } 
                    String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                    final long time = Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                    final float weight = Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                    HistoricalRecord readRecord = new HistoricalRecord(activity, time,
                            weight);
                    readRecords.add(readRecord);
    if(DEBUG)                    
                    {
                    } 
                } 
    if(DEBUG)                
                {
                } 
                synchronized
(mInstanceLock)                {
                    Set<HistoricalRecord> uniqueShareRecords = new LinkedHashSet<HistoricalRecord>(readRecords);
                    List<HistoricalRecord> historicalRecords = mHistoricalRecords;
                    final int historicalRecordsCount = historicalRecords.size();
for(int i = historicalRecordsCount - 1;i >= 0;i--)
                    {
                        HistoricalRecord historicalRecord = historicalRecords.get(i);
                        uniqueShareRecords.add(historicalRecord);
                    } 
    if(historicalRecords.size() == uniqueShareRecords.size())                    
                    {
                        return;
                    } 
                    historicalRecords.clear();
                    historicalRecords.addAll(uniqueShareRecords);
                    mHistoricalRecordsChanged = true;
                    mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.045 -0400", hash_original_method = "7B5BE6A8F3CF3144B75BD698B249F235", hash_generated_method = "0CE57F01674CAFE17F3300F39AA005DE")
            public void run() {
                pruneExcessiveHistoricalRecordsLocked();
                sortActivities();
                
                
                
            }
});
                } 
            } 
            catch (XmlPullParserException xppe)
            {
            } 
            catch (IOException ioe)
            {
            } 
            finally 
            {
    if(fis != null)                
                {
                    try 
                    {
                        fis.close();
                    } 
                    catch (IOException ioe)
                    {
                    } 
                } 
            } 
            
            
        }

        
    }


    
    private final class HistoryPersister implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.046 -0400", hash_original_method = "F652F13A8701B98B9D8C3619B90FF892", hash_generated_method = "F652F13A8701B98B9D8C3619B90FF892")
        public HistoryPersister ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.049 -0400", hash_original_method = "56491CDA5DB122242C8DDE4A7A87359C", hash_generated_method = "FC4CE5BEB4D60C7B3633314C0370992C")
        public void run() {
            FileOutputStream fos = null;
            List<HistoricalRecord> records = null;
            synchronized
(mInstanceLock)            {
                records = new ArrayList<HistoricalRecord>(mHistoricalRecords);
            } 
            try 
            {
                fos = mContext.openFileOutput(mHistoryFileName, Context.MODE_PRIVATE);
            } 
            catch (FileNotFoundException fnfe)
            {
                return;
            } 
            XmlSerializer serializer = Xml.newSerializer();
            try 
            {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);
                final int recordCount = records.size();
for(int i = 0;i < recordCount;i++)
                {
                    HistoricalRecord record = records.remove(0);
                    serializer.startTag(null, TAG_HISTORICAL_RECORD);
                    serializer.attribute(null, ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                    serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                    serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                    serializer.endTag(null, TAG_HISTORICAL_RECORD);
    if(DEBUG)                    
                    {
                    } 
                } 
                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();
    if(DEBUG)                
                {
                } 
            } 
            catch (IllegalArgumentException iae)
            {
            } 
            catch (IllegalStateException ise)
            {
            } 
            catch (IOException ioe)
            {
            } 
            finally 
            {
    if(fos != null)                
                {
                    try 
                    {
                        fos.close();
                    } 
                    catch (IOException e)
                    {
                    } 
                } 
            } 
            
            
        }

        
    }


    
    private final class DataModelPackageMonitor extends PackageMonitor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.050 -0400", hash_original_method = "7270678089AB03BAD6BBDC9C3DB17F70", hash_generated_method = "7270678089AB03BAD6BBDC9C3DB17F70")
        public DataModelPackageMonitor ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.050 -0400", hash_original_method = "C89F5C92B68E48D5DAFC93C690A3926A", hash_generated_method = "E306A83B5D5ECCC6744562B574EF6635")
        @Override
        public void onPackageAdded(String packageName, int uid) {
            
            addTaint(uid);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                loadActivitiesLocked();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.050 -0400", hash_original_method = "E08DC591D228402C0DBF164DF68C0AF4", hash_generated_method = "376D22EF41EB921C8D87080758BA8B82")
        @Override
        public void onPackageAppeared(String packageName, int reason) {
            
            addTaint(reason);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                loadActivitiesLocked();
            } 
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.051 -0400", hash_original_method = "A7BE115B10A66075A04B7082DDA7D411", hash_generated_method = "3DD87351A4166C3F8D12994C5ED5D241")
        @Override
        public void onPackageRemoved(String packageName, int uid) {
            
            addTaint(uid);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.051 -0400", hash_original_method = "31BBEB936625AC985495016944655B18", hash_generated_method = "94862DE920213039998047DC3EF605EF")
        @Override
        public void onPackageDisappeared(String packageName, int reason) {
            
            addTaint(reason);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } 
            
            
                
                
            
        }

        
    }


    
    public interface ActivityChooserModelClient {

        
        public void setActivityChooserModel(ActivityChooserModel dataModel);
    }
    
    public interface ActivitySorter {

        
        
        
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords);
    }
    
    public interface OnChooseActivityListener {

        
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.051 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "FA52ACD91A762EFB98C64E6F734C4D25", hash_generated_field = "C0E6428FC538C3E98CD4F3F3FD104AD3")

    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "00C1CCA963C81A7DDA58A626A1979DA3", hash_generated_field = "2F78BC6BF3EA40EEBFAAF4062888B202")

    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "3ADAAE105DC8F21BB7CBEC47C1D0DFF1", hash_generated_field = "B57E7DC30CE2B7036D338B99DE1C8F4A")

    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "E13990A37ACBE7F78BA9E552D603F5DB", hash_generated_field = "4F997BDD322ABDE394E143C88BE19902")

    private static final String ATTRIBUTE_ACTIVITY = "activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "B3485642830D4FB7BF523D4CAE813482", hash_generated_field = "4657BA7339C2DB58947DE9CCAAA8BCAF")

    private static final String ATTRIBUTE_TIME = "time";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "76190CA68A0DCC92E3A7C066E8CF1F70", hash_generated_field = "8399470D08376E2A59EAC9C79DB79A9E")

    private static final String ATTRIBUTE_WEIGHT = "weight";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "3618283F5DC227BE959D6205ABF93B15", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
        "activity_choser_model_history.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "47FB681069105B0255362C4BF4AB6E51", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "1B36629D46050C4AA3148B77E1702985", hash_generated_field = "450784023A27CD5EC5CEF077D5E372FC")

    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "AAFA76E029DEFAF3CD45DE63256FBD8F", hash_generated_field = "48D4985B801C29FF4FB9AF6C46ABE846")

    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "52CBB06050E39D454BA51CF00CA0F2D1", hash_generated_field = "5BDD81AF45C2360A5D0488EF180F0B0E")

    private static final String HISTORY_FILE_EXTENSION = ".xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "19F556E730E88DC545CC4ADD400592D6")

    private static final int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.052 -0400", hash_original_field = "2BB5CE89E396F79FD8627F7C142D6CEE", hash_generated_field = "922B32A26FF0AAB23FEB7772C78F88BB")

    private static final Object sRegistryLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.053 -0400", hash_original_field = "CBDE1B68888BEC0836ED7A9E864923C7", hash_generated_field = "BB4344C9185B0C58F3786BE4083DEBFE")

    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
}

