package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class FragmentManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.774 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.774 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "A28196A7539EB4773FC251805052B93D")
    @Deprecated
    public FragmentTransaction openTransaction() {
FragmentTransaction var0C52C1DD23EDCBCDDE04269B6A21160A_1800670013 =         beginTransaction();
        var0C52C1DD23EDCBCDDE04269B6A21160A_1800670013.addTaint(taint);
        return var0C52C1DD23EDCBCDDE04269B6A21160A_1800670013;
        
        
    }

    
    public abstract boolean executePendingTransactions();

    
    public abstract Fragment findFragmentById(int id);

    
    public abstract Fragment findFragmentByTag(String tag);

    
    public abstract void popBackStack();

    
    public abstract boolean popBackStackImmediate();

    
    public abstract void popBackStack(String name, int flags);

    
    public abstract boolean popBackStackImmediate(String name, int flags);

    
    public abstract void popBackStack(int id, int flags);

    
    public abstract boolean popBackStackImmediate(int id, int flags);

    
    public abstract int getBackStackEntryCount();

    
    public abstract BackStackEntry getBackStackEntryAt(int index);

    
    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    public abstract void putFragment(Bundle bundle, String key, Fragment fragment);

    
    public abstract Fragment getFragment(Bundle bundle, String key);

    
    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment f);

    
    public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);

    
        @DSModeled(DSC.SAFE)
    public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }

    
    public interface BackStackEntry {
        
        public int getId();

        
        public String getName();

        
        public int getBreadCrumbTitleRes();

        
        public int getBreadCrumbShortTitleRes();

        
        public CharSequence getBreadCrumbTitle();

        
        public CharSequence getBreadCrumbShortTitle();
    }
    
    public interface OnBackStackChangedListener {
        
        public void onBackStackChanged();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.777 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.777 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.777 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.777 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.777 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.778 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.778 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2568BE2895A47284FDBA56B39C3C2603")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_643803641 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271343765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271343765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.778 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "47E7D112A1A5E715EE53E5F5D06C9F8F")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.778 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
}

interface FragmentContainer {
    public View findViewById(int id);
}
final class FragmentManagerImpl extends FragmentManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.779 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.779 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "4716918018B597B9E2482B529B6BAD4A")

    FragmentContainer mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "D9437984C8B60662ED185FA42AA3938D")

    Fragment mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.780 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "9126D3C716AC852A46D1963380A0CE0E")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.781 -0400", hash_original_method = "70ACCC725CBD51E4B696A7DF31DD0DB0", hash_generated_method = "F78E183FC76910FE3ECFA49C795666BF")
    private void throwException(RuntimeException ex) {
        addTaint(ex.getTaint());
        LogWriter logw = new LogWriter(TAG);
        PrintWriter pw = new PrintWriter(logw);
    if(mActivity != null)        
        {
            try 
            {
                mActivity.dump("  ", null, pw, new String[] { });
            } 
            catch (Exception e)
            {
            } 
        } 
        else
        {
            try 
            {
                dump("  ", null, pw, new String[] { });
            } 
            catch (Exception e)
            {
            } 
        } 
        ex.addTaint(taint);
        throw ex;
        
        
        
        
        
        
            
                
            
                
            
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.782 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "2EF2976798B89015119AAC873E25310A")
    @Override
    public FragmentTransaction beginTransaction() {
FragmentTransaction var693A23640A091F7A17064797B040A100_746965462 =         new BackStackRecord(this);
        var693A23640A091F7A17064797B040A100_746965462.addTaint(taint);
        return var693A23640A091F7A17064797B040A100_746965462;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.782 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "AC22CF8E45C9CC1F4BA5D023C645C345")
    @Override
    public boolean executePendingTransactions() {
        boolean var4856074EF8DA58D94BE6E89BEEA5036C_1667750727 = (execPendingActions());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391419440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391419440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.783 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "D61DE240C8D6A11CDE1B7A7A9AB596AB")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.783 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
        @Override
        public void run() {
            popBackStackState(mActivity.mHandler, null, -1, 0);
            
            
        }
}, false);
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.783 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "BCC37ECA086384C02B294EC307E403C2")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean var9954826F15E8D28E4DBF1B5D9A7FCE6F_68047328 = (popBackStackState(mActivity.mHandler, null, -1, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426784440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_426784440;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.784 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "0811AD31B9BB2B480BA5171EA79C4A3E")
    @Override
    public void popBackStack(final String name, final int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.784 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
        @Override
        public void run() {
            popBackStackState(mActivity.mHandler, name, -1, flags);
            
            
        }
}, false);
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.785 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "138D4B07412F238E82C8739A92264DEF")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        checkStateLoss();
        executePendingTransactions();
        boolean varA92FEAD33A189EAD0299E8FE391444CD_2130934612 = (popBackStackState(mActivity.mHandler, name, -1, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64936443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_64936443;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.785 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "9A291A70E655C9749E29F4893D5C3EC3")
    @Override
    public void popBackStack(final int id, final int flags) {
        addTaint(flags);
        addTaint(id);
    if(id < 0)        
        {
            IllegalArgumentException var9E36F4D6900BCA3CCA42D845F29CB5B0_1508732674 = new IllegalArgumentException("Bad id: " + id);
            var9E36F4D6900BCA3CCA42D845F29CB5B0_1508732674.addTaint(taint);
            throw var9E36F4D6900BCA3CCA42D845F29CB5B0_1508732674;
        } 
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.785 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
        @Override
        public void run() {
            popBackStackState(mActivity.mHandler, null, id, flags);
            
            
        }
}, false);
        
        
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.786 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "252E96B764D20DFEDA037E25F5809EFB")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        checkStateLoss();
        executePendingTransactions();
    if(id < 0)        
        {
            IllegalArgumentException var9E36F4D6900BCA3CCA42D845F29CB5B0_738657140 = new IllegalArgumentException("Bad id: " + id);
            var9E36F4D6900BCA3CCA42D845F29CB5B0_738657140.addTaint(taint);
            throw var9E36F4D6900BCA3CCA42D845F29CB5B0_738657140;
        } 
        boolean varDBA39B5EE3A31103A5F0342C6B326731_886951267 = (popBackStackState(mActivity.mHandler, null, id, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382302901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382302901;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.786 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "A0F2F04D09266F18F61BFB533A40B777")
    @Override
    public int getBackStackEntryCount() {
        int var6DAE2CE6A7F553D663688107A90FA4CC_611950872 = (mBackStack != null ? mBackStack.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372980782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372980782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.787 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "97694A22198F60574795E0B02DC8517D")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        addTaint(index);
BackStackEntry var74F933A734514BD5EE40CF9077B41749_327815235 =         mBackStack.get(index);
        var74F933A734514BD5EE40CF9077B41749_327815235.addTaint(taint);
        return var74F933A734514BD5EE40CF9077B41749_327815235;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.787 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "F3449B7B6237A3D0492048F76360807C")
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        addTaint(listener.getTaint());
    if(mBackStackChangeListeners == null)        
        {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        } 
        mBackStackChangeListeners.add(listener);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.787 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "61303AE4BE82E0861B28C3954E733BCB")
    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        addTaint(listener.getTaint());
    if(mBackStackChangeListeners != null)        
        {
            mBackStackChangeListeners.remove(listener);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.788 -0400", hash_original_method = "3F35630659DD6C09B78E73F7BD07330C", hash_generated_method = "E358D82FE83F56DFF25219B88EF3C7FE")
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(key.getTaint());
        addTaint(bundle.getTaint());
    if(fragment.mIndex < 0)        
        {
            throwException(new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        } 
        bundle.putInt(key, fragment.mIndex);
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.788 -0400", hash_original_method = "4CDB8119120F20E16B511E77159C27B3", hash_generated_method = "CEFC1D3D0DC75650C03D3FAD883E2137")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        addTaint(key.getTaint());
        addTaint(bundle.getTaint());
        int index = bundle.getInt(key, -1);
    if(index == -1)        
        {
Fragment var540C13E9E156B687226421B24F2DF178_1253413248 =             null;
            var540C13E9E156B687226421B24F2DF178_1253413248.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1253413248;
        } 
    if(index >= mActive.size())        
        {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        } 
        Fragment f = mActive.get(index);
    if(f == null)        
        {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        } 
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_992319781 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_992319781.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_992319781;
        
        
        
            
        
        
            
                    
        
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.789 -0400", hash_original_method = "D25922C7B1DBFD38B1587BBC1D3E9AF4", hash_generated_method = "C820D068D1096BB55B15ED947475CCEB")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        addTaint(fragment.getTaint());
    if(fragment.mIndex < 0)        
        {
            throwException( new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        } 
    if(fragment.mState > Fragment.INITIALIZING)        
        {
            Bundle result = saveFragmentBasicState(fragment);
Fragment.SavedState varDF3960AB579B5B5C742EF8D42A1CE853_1304665608 =             result != null ? new Fragment.SavedState(result) : null;
            varDF3960AB579B5B5C742EF8D42A1CE853_1304665608.addTaint(taint);
            return varDF3960AB579B5B5C742EF8D42A1CE853_1304665608;
        } 
Fragment.SavedState var540C13E9E156B687226421B24F2DF178_837028328 =         null;
        var540C13E9E156B687226421B24F2DF178_837028328.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_837028328;
        
        
            
                    
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.789 -0400", hash_original_method = "809378480DC9ABFE56F2FAE2E163A583", hash_generated_method = "7C3C4EA719A1C138CC17FEE13002AFEA")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
    if(mParent != null)        
        {
            DebugUtils.buildShortClassTag(mParent, sb);
        } 
        else
        {
            DebugUtils.buildShortClassTag(mActivity, sb);
        } 
        sb.append("}}");
String var2460B846747F8B22185AD8BE722266A5_835445110 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_835445110.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_835445110;
        
        
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.791 -0400", hash_original_method = "69E4EB9F72755E8BD358E210AC6CFB24", hash_generated_method = "989BE1DCEDB356F78BBF3EF20F5C78C9")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        String innerPrefix = prefix + "    ";
        int N;
    if(mActive != null)        
        {
            N = mActive.size();
    if(N > 0)            
            {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
for(int i=0;i<N;i++)
                {
                    Fragment f = mActive.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f);
    if(f != null)                    
                    {
                        f.dump(innerPrefix, fd, writer, args);
                    } 
                } 
            } 
        } 
    if(mAdded != null)        
        {
            N = mAdded.size();
    if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Added Fragments:");
for(int i=0;i<N;i++)
                {
                    Fragment f = mAdded.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                } 
            } 
        } 
    if(mCreatedMenus != null)        
        {
            N = mCreatedMenus.size();
    if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Fragments Created Menus:");
for(int i=0;i<N;i++)
                {
                    Fragment f = mCreatedMenus.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                } 
            } 
        } 
    if(mBackStack != null)        
        {
            N = mBackStack.size();
    if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Back Stack:");
for(int i=0;i<N;i++)
                {
                    BackStackRecord bs = mBackStack.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(bs.toString());
                    bs.dump(innerPrefix, fd, writer, args);
                } 
            } 
        } 
        synchronized
(this)        {
    if(mBackStackIndices != null)            
            {
                N = mBackStackIndices.size();
    if(N > 0)                
                {
                    writer.print(prefix);
                    writer.println("Back Stack Indices:");
for(int i=0;i<N;i++)
                    {
                        BackStackRecord bs = mBackStackIndices.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(bs);
                    } 
                } 
            } 
    if(mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0)            
            {
                writer.print(prefix);
                writer.print("mAvailBackStackIndices: ");
                writer.println(Arrays.toString(mAvailBackStackIndices.toArray()));
            } 
        } 
    if(mPendingActions != null)        
        {
            N = mPendingActions.size();
    if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Pending Actions:");
for(int i=0;i<N;i++)
                {
                    Runnable r = mPendingActions.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(r);
                } 
            } 
        } 
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mActivity=");
        writer.println(mActivity);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(mContainer);
    if(mParent != null)        
        {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(mParent);
        } 
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(mCurState);
        writer.print(" mStateSaved=");
        writer.print(mStateSaved);
        writer.print(" mDestroyed=");
        writer.println(mDestroyed);
    if(mNeedMenuInvalidate)        
        {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(mNeedMenuInvalidate);
        } 
    if(mNoTransactionsBecause != null)        
        {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(mNoTransactionsBecause);
        } 
    if(mAvailIndices != null && mAvailIndices.size() > 0)        
        {
            writer.print(prefix);
            writer.print("  mAvailIndices: ");
            writer.println(Arrays.toString(mAvailIndices.toArray()));
        } 
        
        
    }

    
        static Animation makeOpenCloseAnimation(Context context, float startScale,
            float endScale, float startAlpha, float endAlpha) {
        AnimationSet set = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(startScale, endScale, startScale, endScale,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        scale.setInterpolator(DECELERATE_QUINT);
        scale.setDuration(ANIM_DUR);
        set.addAnimation(scale);
        AlphaAnimation alpha = new AlphaAnimation(startAlpha, endAlpha);
        alpha.setInterpolator(DECELERATE_CUBIC);
        alpha.setDuration(ANIM_DUR);
        set.addAnimation(alpha);
        return set;
    }

    
        static Animation makeFadeAnimation(Context context, float start, float end) {
        AlphaAnimation anim = new AlphaAnimation(start, end);
        anim.setInterpolator(DECELERATE_CUBIC);
        anim.setDuration(ANIM_DUR);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.796 -0400", hash_original_method = "1D86F34E1479CAC948F0E54CF5418376", hash_generated_method = "8F8F5A2AF26CC22B867EC84912098BB7")
     Animation loadAnimation(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(enter);
        addTaint(transit);
        addTaint(fragment.getTaint());
        Animation animObj = fragment.onCreateAnimation(transit, enter,
                fragment.mNextAnim);
    if(animObj != null)        
        {
Animation varD2C3244304F8F6616E0E174A4084F820_1586795795 =             animObj;
            varD2C3244304F8F6616E0E174A4084F820_1586795795.addTaint(taint);
            return varD2C3244304F8F6616E0E174A4084F820_1586795795;
        } 
    if(fragment.mNextAnim != 0)        
        {
            Animation anim = AnimationUtils.loadAnimation(mActivity, fragment.mNextAnim);
    if(anim != null)            
            {
Animation var6E2178F33F884BED37C5DEBCD18F9A96_1467466696 =                 anim;
                var6E2178F33F884BED37C5DEBCD18F9A96_1467466696.addTaint(taint);
                return var6E2178F33F884BED37C5DEBCD18F9A96_1467466696;
            } 
        } 
    if(transit == 0)        
        {
Animation var540C13E9E156B687226421B24F2DF178_1496560412 =             null;
            var540C13E9E156B687226421B24F2DF178_1496560412.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1496560412;
        } 
        int styleIndex = transitToStyleIndex(transit, enter);
    if(styleIndex < 0)        
        {
Animation var540C13E9E156B687226421B24F2DF178_2109617440 =             null;
            var540C13E9E156B687226421B24F2DF178_2109617440.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2109617440;
        } 
switch(styleIndex){
        case ANIM_STYLE_OPEN_ENTER:
Animation var276C06FC17F5FF9F0FF5EAD4A48362C9_1238502525 =         makeOpenCloseAnimation(mActivity, 1.125f, 1.0f, 0, 1);
        var276C06FC17F5FF9F0FF5EAD4A48362C9_1238502525.addTaint(taint);
        return var276C06FC17F5FF9F0FF5EAD4A48362C9_1238502525;
        case ANIM_STYLE_OPEN_EXIT:
Animation var635DD9E418A713155BF3E65B80324A80_1203767563 =         makeOpenCloseAnimation(mActivity, 1.0f, .975f, 1, 0);
        var635DD9E418A713155BF3E65B80324A80_1203767563.addTaint(taint);
        return var635DD9E418A713155BF3E65B80324A80_1203767563;
        case ANIM_STYLE_CLOSE_ENTER:
Animation var222A48FD3247D701484A971C1B5C9668_1434180648 =         makeOpenCloseAnimation(mActivity, .975f, 1.0f, 0, 1);
        var222A48FD3247D701484A971C1B5C9668_1434180648.addTaint(taint);
        return var222A48FD3247D701484A971C1B5C9668_1434180648;
        case ANIM_STYLE_CLOSE_EXIT:
Animation var4F229A8E17C0C23CE0CCEE3A983ED7C5_402975079 =         makeOpenCloseAnimation(mActivity, 1.0f, 1.075f, 1, 0);
        var4F229A8E17C0C23CE0CCEE3A983ED7C5_402975079.addTaint(taint);
        return var4F229A8E17C0C23CE0CCEE3A983ED7C5_402975079;
        case ANIM_STYLE_FADE_ENTER:
Animation varEAB8B32CE4CE36EA6025A19566FC181F_340683488 =         makeFadeAnimation(mActivity, 0, 1);
        varEAB8B32CE4CE36EA6025A19566FC181F_340683488.addTaint(taint);
        return varEAB8B32CE4CE36EA6025A19566FC181F_340683488;
        case ANIM_STYLE_FADE_EXIT:
Animation var61308AA345158F2C39F16F21D18CDC25_990074156 =         makeFadeAnimation(mActivity, 1, 0);
        var61308AA345158F2C39F16F21D18CDC25_990074156.addTaint(taint);
        return var61308AA345158F2C39F16F21D18CDC25_990074156;
}    if(transitionStyle == 0 && mActivity.getWindow() != null)        
        {
            transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
        } 
    if(transitionStyle == 0)        
        {
Animation var540C13E9E156B687226421B24F2DF178_83982685 =             null;
            var540C13E9E156B687226421B24F2DF178_83982685.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_83982685;
        } 
Animation var540C13E9E156B687226421B24F2DF178_1834055647 =         null;
        var540C13E9E156B687226421B24F2DF178_1834055647.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1834055647;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.797 -0400", hash_original_method = "53A703CAB9B91DDAE05ABF1E3656A1E0", hash_generated_method = "0268928ADB927F87E1B334E515E7C338")
    public void performPendingDeferredStart(Fragment f) {
        addTaint(f.getTaint());
    if(f.mDeferStart)        
        {
    if(mExecutingActions)            
            {
                mHavePendingDeferredStart = true;
                return;
            } 
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0, false);
        } 
        
        
            
                
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.809 -0400", hash_original_method = "F13A9F8BA98A34618DEF4155010BA2F5", hash_generated_method = "244F926A347AE64E91B2328DD99CD588")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle,
            boolean keepActive) {
        addTaint(keepActive);
        addTaint(transitionStyle);
        addTaint(transit);
        addTaint(newState);
    if((!f.mAdded || f.mDetached) && newState > Fragment.CREATED)        
        {
            newState = Fragment.CREATED;
        } 
    if(f.mRemoving && newState > f.mState)        
        {
            newState = f.mState;
        } 
    if(f.mDeferStart && f.mState < Fragment.STARTED && newState > Fragment.STOPPED)        
        {
            newState = Fragment.STOPPED;
        } 
    if(f.mState < newState)        
        {
    if(f.mFromLayout && !f.mInLayout)            
            {
                return;
            } 
    if(f.mAnimatingAway != null)            
            {
                f.mAnimatingAway = null;
                moveToState(f, f.mStateAfterAnimating, 0, 0, true);
            } 
switch(f.mState){
            case Fragment.INITIALIZING:
    if(DEBUG){ }    if(f.mSavedFragmentState != null)            
            {
                f.mSavedViewState = f.mSavedFragmentState.getSparseParcelableArray(
                                FragmentManagerImpl.VIEW_STATE_TAG);
                f.mTarget = getFragment(f.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG);
    if(f.mTarget != null)                
                {
                    f.mTargetRequestCode = f.mSavedFragmentState.getInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, 0);
                } 
                f.mUserVisibleHint = f.mSavedFragmentState.getBoolean(
                                FragmentManagerImpl.USER_VISIBLE_HINT_TAG, true);
    if(!f.mUserVisibleHint)                
                {
                    f.mDeferStart = true;
    if(newState > Fragment.STOPPED)                    
                    {
                        newState = Fragment.STOPPED;
                    } 
                } 
            } 
            f.mActivity = mActivity;
            f.mParentFragment = mParent;
            f.mFragmentManager = mParent != null
                            ? mParent.mChildFragmentManager : mActivity.mFragments;
            f.mCalled = false;
            f.onAttach(mActivity);
    if(!f.mCalled)            
            {
                SuperNotCalledException var3B21D72FE3B78DA21309B053881BE5E5_558128182 = new SuperNotCalledException("Fragment " + f
                                + " did not call through to super.onAttach()");
                var3B21D72FE3B78DA21309B053881BE5E5_558128182.addTaint(taint);
                throw var3B21D72FE3B78DA21309B053881BE5E5_558128182;
            } 
    if(f.mParentFragment == null)            
            {
                mActivity.onAttachFragment(f);
            } 
    if(!f.mRetaining)            
            {
                f.performCreate(f.mSavedFragmentState);
            } 
            f.mRetaining = false;
    if(f.mFromLayout)            
            {
                f.mView = f.performCreateView(f.getLayoutInflater(
                                f.mSavedFragmentState), null, f.mSavedFragmentState);
    if(f.mView != null)                
                {
                    f.mInnerView = f.mView;
                    f.mView = NoSaveStateFrameLayout.wrap(f.mView);
    if(f.mHidden)                    
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } 
                else
                {
                    f.mInnerView = null;
                } 
            } 
            case Fragment.CREATED:
    if(newState > Fragment.CREATED)            
            {
    if(DEBUG){ }    if(!f.mFromLayout)                
                {
                    ViewGroup container = null;
    if(f.mContainerId != 0)                    
                    {
                        container = (ViewGroup)mContainer.findViewById(f.mContainerId);
    if(container == null && !f.mRestored)                        
                        {
                            throwException(new IllegalArgumentException(
                                            "No view found for id 0x"
                                            + Integer.toHexString(f.mContainerId) + " ("
                                            + f.getResources().getResourceName(f.mContainerId)
                                            + ") for fragment " + f));
                        } 
                    } 
                    f.mContainer = container;
                    f.mView = f.performCreateView(f.getLayoutInflater(
                                    f.mSavedFragmentState), container, f.mSavedFragmentState);
    if(f.mView != null)                    
                    {
                        f.mInnerView = f.mView;
                        f.mView = NoSaveStateFrameLayout.wrap(f.mView);
    if(container != null)                        
                        {
                            Animation anim = loadAnimation(f, transit, true,
                                            transitionStyle);
    if(anim != null)                            
                            {
                                f.mView.startAnimation(anim);
                            } 
                            container.addView(f.mView);
                        } 
    if(f.mHidden)                        
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } 
                    else
                    {
                        f.mInnerView = null;
                    } 
                } 
                f.performActivityCreated(f.mSavedFragmentState);
    if(f.mView != null)                
                {
                    f.restoreViewState(f.mSavedFragmentState);
                } 
                f.mSavedFragmentState = null;
            } 
            case Fragment.ACTIVITY_CREATED:
            case Fragment.STOPPED:
    if(newState > Fragment.STOPPED)            
            {
    if(DEBUG){ }                f.performStart();
            } 
            case Fragment.STARTED:
    if(newState > Fragment.STARTED)            
            {
    if(DEBUG){ }                f.mResumed = true;
                f.performResume();
                f.mSavedFragmentState = null;
                f.mSavedViewState = null;
            } 
}
        } 
        else
    if(f.mState > newState)        
        {
switch(f.mState){
            case Fragment.RESUMED:
    if(newState < Fragment.RESUMED)            
            {
    if(DEBUG){ }                f.performPause();
                f.mResumed = false;
            } 
            case Fragment.STARTED:
    if(newState < Fragment.STARTED)            
            {
    if(DEBUG){ }                f.performStop();
            } 
            case Fragment.STOPPED:
    if(newState < Fragment.STOPPED)            
            {
    if(DEBUG){ }                f.performReallyStop();
            } 
            case Fragment.ACTIVITY_CREATED:
    if(newState < Fragment.ACTIVITY_CREATED)            
            {
    if(DEBUG){ }    if(f.mView != null)                
                {
    if(!mActivity.isFinishing() && f.mSavedViewState == null)                    
                    {
                        saveFragmentViewState(f);
                    } 
                } 
                f.performDestroyView();
    if(f.mView != null && f.mContainer != null)                
                {
                    Animation anim = null;
    if(mCurState > Fragment.INITIALIZING && !mDestroyed)                    
                    {
                        anim = loadAnimation(f, transit, false,
                                        transitionStyle);
                    } 
    if(anim != null)                    
                    {
                        final Fragment fragment = f;
                        f.mAnimatingAway = f.mView;
                        f.mStateAfterAnimating = newState;
                        anim.setAnimationListener(new AnimationListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.804 -0400", hash_original_method = "ADB37ED087A6B8FD09A7637E04A46959", hash_generated_method = "D4E741AD38CFCD8C66F7F7C330EF18D9")
        @Override
        public void onAnimationEnd(Animation animation) {
            
            addTaint(animation.getTaint());
    if(fragment.mAnimatingAway != null)            
            {
                fragment.mAnimatingAway = null;
                moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0, false);
            } 
            
            
                                            
                                            
                                                    
                                        
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.805 -0400", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "58C626A9D98C5CFBF993A93EFEF59553")
        @Override
        public void onAnimationRepeat(Animation animation) {
            
            addTaint(animation.getTaint());
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.805 -0400", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "E455F4DC332660DC5ADFD15AC2AD6C17")
        @Override
        public void onAnimationStart(Animation animation) {
            
            addTaint(animation.getTaint());
            
        }
});
                        f.mView.startAnimation(anim);
                    } 
                    f.mContainer.removeView(f.mView);
                } 
                f.mContainer = null;
                f.mView = null;
                f.mInnerView = null;
            } 
            case Fragment.CREATED:
    if(newState < Fragment.CREATED)            
            {
    if(mDestroyed)                
                {
    if(f.mAnimatingAway != null)                    
                    {
                        View v = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        v.clearAnimation();
                    } 
                } 
    if(f.mAnimatingAway != null)                
                {
                    f.mStateAfterAnimating = newState;
                    newState = Fragment.CREATED;
                } 
                else
                {
    if(DEBUG){ }    if(!f.mRetaining)                    
                    {
                        f.performDestroy();
                    } 
                    f.mCalled = false;
                    f.onDetach();
    if(!f.mCalled)                    
                    {
                        SuperNotCalledException varA1E86A4AD3397A3A1F40BAC562CFC4E0_2143397082 = new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                        varA1E86A4AD3397A3A1F40BAC562CFC4E0_2143397082.addTaint(taint);
                        throw varA1E86A4AD3397A3A1F40BAC562CFC4E0_2143397082;
                    } 
    if(!keepActive)                    
                    {
    if(!f.mRetaining)                        
                        {
                            makeInactive(f);
                        } 
                        else
                        {
                            f.mActivity = null;
                            f.mFragmentManager = null;
                        } 
                    } 
                } 
            } 
}
        } 
        f.mState = newState;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.813 -0400", hash_original_method = "253ACA6E8863F76AC823063DED921CB5", hash_generated_method = "56F34721617E29762767CD0271D99AB6")
     void moveToState(Fragment f) {
        addTaint(f.getTaint());
        moveToState(f, mCurState, 0, 0, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.813 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "53B9318E7A6D27AF1F540337F095D441")
     void moveToState(int newState, boolean always) {
        addTaint(always);
        addTaint(newState);
        moveToState(newState, 0, 0, always);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.814 -0400", hash_original_method = "5BD27BFF276D517E1379D91A3F7AF343", hash_generated_method = "8451C23CD4CCB9CC51E57C5DBD9BE9DA")
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        addTaint(always);
        addTaint(transitStyle);
        addTaint(transit);
    if(mActivity == null && newState != Fragment.INITIALIZING)        
        {
            IllegalStateException varC7A3C53EE722E6B94E737EE4538375FA_1309852191 = new IllegalStateException("No activity");
            varC7A3C53EE722E6B94E737EE4538375FA_1309852191.addTaint(taint);
            throw varC7A3C53EE722E6B94E737EE4538375FA_1309852191;
        } 
    if(!always && mCurState == newState)        
        {
            return;
        } 
        mCurState = newState;
    if(mActive != null)        
        {
            boolean loadersRunning = false;
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
    if(f != null)                
                {
                    moveToState(f, newState, transit, transitStyle, false);
    if(f.mLoaderManager != null)                    
                    {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    } 
                } 
            } 
    if(!loadersRunning)            
            {
                startPendingDeferredFragments();
            } 
    if(mNeedMenuInvalidate && mActivity != null && mCurState == Fragment.RESUMED)            
            {
                mActivity.supportInvalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.815 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "DA1D2CEA990D2C426A9BF529124CB3B6")
     void startPendingDeferredFragments() {
    if(mActive == null)        
        return;
for(int i=0;i<mActive.size();i++)
        {
            Fragment f = mActive.get(i);
    if(f != null)            
            {
                performPendingDeferredStart(f);
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.816 -0400", hash_original_method = "47E8AE46DB9C6E9F4895918BFF9C77EF", hash_generated_method = "8AF906A64B39554F8DC748B1AA0175C8")
     void makeActive(Fragment f) {
        addTaint(f.getTaint());
    if(f.mIndex >= 0)        
        {
            return;
        } 
    if(mAvailIndices == null || mAvailIndices.size() <= 0)        
        {
    if(mActive == null)            
            {
                mActive = new ArrayList<Fragment>();
            } 
            f.setIndex(mActive.size(), mParent);
            mActive.add(f);
        } 
        else
        {
            f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1), mParent);
            mActive.set(f.mIndex, f);
        } 
    if(DEBUG){ }
        
        
            
        
        
            
                
            
            
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.817 -0400", hash_original_method = "2838DA3381C6FA665FE83DACB606EE48", hash_generated_method = "39B16E081B43E73E73331AD1338ACECE")
     void makeInactive(Fragment f) {
        addTaint(f.getTaint());
    if(f.mIndex < 0)        
        {
            return;
        } 
    if(DEBUG){ }        mActive.set(f.mIndex, null);
    if(mAvailIndices == null)        
        {
            mAvailIndices = new ArrayList<Integer>();
        } 
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateSupportFragment(f.mWho);
        f.initState();
        
        
            
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.818 -0400", hash_original_method = "A7004D7E770917F1698CC4D8DC4A636A", hash_generated_method = "7A2BD5CA790ADF2CD083408150230389")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        addTaint(moveToStateNow);
    if(mAdded == null)        
        {
            mAdded = new ArrayList<Fragment>();
        } 
    if(DEBUG){ }        makeActive(fragment);
    if(!fragment.mDetached)        
        {
    if(mAdded.contains(fragment))            
            {
                IllegalStateException varF8622297B19FD38FB90DFF83821629C6_1231893376 = new IllegalStateException("Fragment already added: " + fragment);
                varF8622297B19FD38FB90DFF83821629C6_1231893376.addTaint(taint);
                throw varF8622297B19FD38FB90DFF83821629C6_1231893376;
            } 
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
    if(fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } 
    if(moveToStateNow)            
            {
                moveToState(fragment);
            } 
        } 
        
        
            
        
        
        
        
            
                
            
            
            
            
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.820 -0400", hash_original_method = "13B3CB0CAD8C045C67262987362B8EBE", hash_generated_method = "B892B2B64588741F86AB08F708C75035")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
    if(DEBUG){ }        final boolean inactive = !fragment.isInBackStack();
    if(!fragment.mDetached || inactive)        
        {
    if(mAdded != null)            
            {
                mAdded.remove(fragment);
            } 
    if(fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle, false);
        } 
        
        
        
        
            
                
            
            
                
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.820 -0400", hash_original_method = "BED4301A21B487BD6D143A374885F309", hash_generated_method = "45302BF89AA3F40CB3528EA7AE45D526")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        addTaint(fragment.getTaint());
    if(DEBUG){ }    if(!fragment.mHidden)        
        {
            fragment.mHidden = true;
    if(fragment.mView != null)            
            {
                Animation anim = loadAnimation(fragment, transition, false,
                        transitionStyle);
    if(anim != null)                
                {
                    fragment.mView.startAnimation(anim);
                } 
                fragment.mView.setVisibility(View.GONE);
            } 
    if(fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.onHiddenChanged(true);
        } 
        
        
        
            
            
                
                        
                
                    
                
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.821 -0400", hash_original_method = "5884A689188772E4B067D85FA0FE2485", hash_generated_method = "1C17D4C00A40496FFBAA3CF2F8AC9E7C")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        addTaint(fragment.getTaint());
    if(DEBUG){ }    if(fragment.mHidden)        
        {
            fragment.mHidden = false;
    if(fragment.mView != null)            
            {
                Animation anim = loadAnimation(fragment, transition, true,
                        transitionStyle);
    if(anim != null)                
                {
                    fragment.mView.startAnimation(anim);
                } 
                fragment.mView.setVisibility(View.VISIBLE);
            } 
    if(fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.onHiddenChanged(false);
        } 
        
        
        
            
            
                
                        
                
                    
                
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.822 -0400", hash_original_method = "8ADA384A2A804F3DB8950E51751AE080", hash_generated_method = "07E1DCC0618AAA0D51BE548BF2130014")
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
    if(DEBUG){ }    if(!fragment.mDetached)        
        {
            fragment.mDetached = true;
    if(fragment.mAdded)            
            {
    if(mAdded != null)                
                {
    if(DEBUG){ }                    mAdded.remove(fragment);
                } 
    if(fragment.mHasMenu && fragment.mMenuVisible)                
                {
                    mNeedMenuInvalidate = true;
                } 
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle, false);
            } 
        } 
        
        
        
            
            
                
                    
                    
                
                
                    
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.824 -0400", hash_original_method = "C689EB45F7FDDB493496798809CCC982", hash_generated_method = "9E880E04903EE58ED0F965F2BDBD80EF")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
    if(DEBUG){ }    if(fragment.mDetached)        
        {
            fragment.mDetached = false;
    if(!fragment.mAdded)            
            {
    if(mAdded == null)                
                {
                    mAdded = new ArrayList<Fragment>();
                } 
    if(mAdded.contains(fragment))                
                {
                    IllegalStateException varF8622297B19FD38FB90DFF83821629C6_1466244668 = new IllegalStateException("Fragment already added: " + fragment);
                    varF8622297B19FD38FB90DFF83821629C6_1466244668.addTaint(taint);
                    throw varF8622297B19FD38FB90DFF83821629C6_1466244668;
                } 
    if(DEBUG){ }                mAdded.add(fragment);
                fragment.mAdded = true;
    if(fragment.mHasMenu && fragment.mMenuVisible)                
                {
                    mNeedMenuInvalidate = true;
                } 
                moveToState(fragment, mCurState, transition, transitionStyle, false);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.825 -0400", hash_original_method = "369BBF881289C60802E9A80BDB6F1062", hash_generated_method = "4A6FC8FDC29727AEA562CA409251E0D9")
    public Fragment findFragmentById(int id) {
        addTaint(id);
    if(mAdded != null)        
        {
for(int i=mAdded.size()-1;i>=0;i--)
            {
                Fragment f = mAdded.get(i);
    if(f != null && f.mFragmentId == id)                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1023743270 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1023743270.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1023743270;
                } 
            } 
        } 
    if(mActive != null)        
        {
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
    if(f != null && f.mFragmentId == id)                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1184155807 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1184155807.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1184155807;
                } 
            } 
        } 
Fragment var540C13E9E156B687226421B24F2DF178_1486477344 =         null;
        var540C13E9E156B687226421B24F2DF178_1486477344.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1486477344;
        
        
            
                
                
                    
                
            
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.828 -0400", hash_original_method = "A116F7F22C8FEEEBB3418EA3417C69EB", hash_generated_method = "66B02631F5FD44D7C3302E345A33AD87")
    public Fragment findFragmentByTag(String tag) {
        addTaint(tag.getTaint());
    if(mAdded != null && tag != null)        
        {
for(int i=mAdded.size()-1;i>=0;i--)
            {
                Fragment f = mAdded.get(i);
    if(f != null && tag.equals(f.mTag))                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_191397611 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_191397611.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_191397611;
                } 
            } 
        } 
    if(mActive != null && tag != null)        
        {
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
    if(f != null && tag.equals(f.mTag))                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_2094519547 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_2094519547.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_2094519547;
                } 
            } 
        } 
Fragment var540C13E9E156B687226421B24F2DF178_886500933 =         null;
        var540C13E9E156B687226421B24F2DF178_886500933.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_886500933;
        
        
            
                
                
                    
                
            
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.830 -0400", hash_original_method = "9082D0FF97F62C4058EE52B6A6365151", hash_generated_method = "D642FC1D981FCB23634EFC6430BD27F7")
    public Fragment findFragmentByWho(String who) {
        addTaint(who.getTaint());
    if(mActive != null && who != null)        
        {
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
    if(f != null && (f=f.findFragmentByWho(who)) != null)                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1744525335 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1744525335.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1744525335;
                } 
            } 
        } 
Fragment var540C13E9E156B687226421B24F2DF178_1326360001 =         null;
        var540C13E9E156B687226421B24F2DF178_1326360001.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1326360001;
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.830 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4ED50B60C88995B651D3272013ABE56D")
    private void checkStateLoss() {
    if(mStateSaved)        
        {
            IllegalStateException var23A2D8DE9FCE1D4473820F88EF278183_1738292358 = new IllegalStateException(
                    "Can not perform this action after onSaveInstanceState");
            var23A2D8DE9FCE1D4473820F88EF278183_1738292358.addTaint(taint);
            throw var23A2D8DE9FCE1D4473820F88EF278183_1738292358;
        } 
    if(mNoTransactionsBecause != null)        
        {
            IllegalStateException varD5A6267DF986948EB71369DC13B836F0_1115334577 = new IllegalStateException(
                    "Can not perform this action inside of " + mNoTransactionsBecause);
            varD5A6267DF986948EB71369DC13B836F0_1115334577.addTaint(taint);
            throw varD5A6267DF986948EB71369DC13B836F0_1115334577;
        } 
        
        
            
                    
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.831 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "69AC7F3599FD83AAC8D6D1B2BAC5286B")
    public void enqueueAction(Runnable action, boolean allowStateLoss) {
        addTaint(allowStateLoss);
        addTaint(action.getTaint());
    if(!allowStateLoss)        
        {
            checkStateLoss();
        } 
        synchronized
(this)        {
    if(mActivity == null)            
            {
                IllegalStateException var49610257A997B6EC5B28B22BBA4534E2_1068239836 = new IllegalStateException("Activity has been destroyed");
                var49610257A997B6EC5B28B22BBA4534E2_1068239836.addTaint(taint);
                throw var49610257A997B6EC5B28B22BBA4534E2_1068239836;
            } 
    if(mPendingActions == null)            
            {
                mPendingActions = new ArrayList<Runnable>();
            } 
            mPendingActions.add(action);
    if(mPendingActions.size() == 1)            
            {
                mActivity.mHandler.removeCallbacks(mExecCommit);
                mActivity.mHandler.post(mExecCommit);
            } 
        } 
        
        
            
        
        
            
                
            
            
                
            
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.832 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "4DA47C29EBDA1EF304D8D4827D3D65B1")
    public int allocBackStackIndex(BackStackRecord bse) {
        addTaint(bse.getTaint());
        synchronized
(this)        {
    if(mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0)            
            {
    if(mBackStackIndices == null)                
                {
                    mBackStackIndices = new ArrayList<BackStackRecord>();
                } 
                int index = mBackStackIndices.size();
    if(DEBUG){ }                mBackStackIndices.add(bse);
                int var6A992D5529F459A44FEE58C733255E86_1437102949 = (index);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139471397 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139471397;
            } 
            else
            {
                int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
    if(DEBUG){ }                mBackStackIndices.set(index, bse);
                int var6A992D5529F459A44FEE58C733255E86_224809148 = (index);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166340974 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166340974;
            } 
        } 
        
        
            
                
                    
                
                
                
                
                
            
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.833 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "B84519E754B96726FC67860D93265690")
    public void setBackStackIndex(int index, BackStackRecord bse) {
        addTaint(bse.getTaint());
        addTaint(index);
        synchronized
(this)        {
    if(mBackStackIndices == null)            
            {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            } 
            int N = mBackStackIndices.size();
    if(index < N)            
            {
    if(DEBUG){ }                mBackStackIndices.set(index, bse);
            } 
            else
            {
                while
(N < index)                
                {
                    mBackStackIndices.add(null);
    if(mAvailBackStackIndices == null)                    
                    {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    } 
    if(DEBUG){ }                    mAvailBackStackIndices.add(N);
                    N++;
                } 
    if(DEBUG){ }                mBackStackIndices.add(bse);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.833 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "BADE6125AC1A3E42ECD0633B6FD273F9")
    public void freeBackStackIndex(int index) {
        addTaint(index);
        synchronized
(this)        {
            mBackStackIndices.set(index, null);
    if(mAvailBackStackIndices == null)            
            {
                mAvailBackStackIndices = new ArrayList<Integer>();
            } 
    if(DEBUG){ }            mAvailBackStackIndices.add(index);
        } 
        
        
            
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.835 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "B8CEF59634E81EC750F2E99B9EB1E303")
    public boolean execPendingActions() {
    if(mExecutingActions)        
        {
            IllegalStateException var61DF877DA999CC3CF0E0D581264CFF4D_41209683 = new IllegalStateException("Recursive entry to executePendingTransactions");
            var61DF877DA999CC3CF0E0D581264CFF4D_41209683.addTaint(taint);
            throw var61DF877DA999CC3CF0E0D581264CFF4D_41209683;
        } 
    if(Looper.myLooper() != mActivity.mHandler.getLooper())        
        {
            IllegalStateException var40716AFC80613C23595006B91BE64761_1580577682 = new IllegalStateException("Must be called from main thread of process");
            var40716AFC80613C23595006B91BE64761_1580577682.addTaint(taint);
            throw var40716AFC80613C23595006B91BE64761_1580577682;
        } 
        boolean didSomething = false;
        while
(true)        
        {
            int numActions;
            synchronized
(this)            {
    if(mPendingActions == null || mPendingActions.size() == 0)                
                {
                    break;
                } 
                numActions = mPendingActions.size();
    if(mTmpActions == null || mTmpActions.length < numActions)                
                {
                    mTmpActions = new Runnable[numActions];
                } 
                mPendingActions.toArray(mTmpActions);
                mPendingActions.clear();
                mActivity.mHandler.removeCallbacks(mExecCommit);
            } 
            mExecutingActions = true;
for(int i=0;i<numActions;i++)
            {
                mTmpActions[i].run();
                mTmpActions[i] = null;
            } 
            mExecutingActions = false;
            didSomething = true;
        } 
    if(mHavePendingDeferredStart)        
        {
            boolean loadersRunning = false;
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
    if(f != null && f.mLoaderManager != null)                
                {
                    loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                } 
            } 
    if(!loadersRunning)            
            {
                mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            } 
        } 
        boolean var5E507AE975F73329F3FD0F0DC8E6DE07_932921450 = (didSomething);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831525738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831525738;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.836 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "48F7B93763F7745B9B8D7EDBE4BD21AF")
     void reportBackStackChanged() {
    if(mBackStackChangeListeners != null)        
        {
for(int i=0;i<mBackStackChangeListeners.size();i++)
            {
                mBackStackChangeListeners.get(i).onBackStackChanged();
            } 
        } 
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.837 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "F851EE881748A573E0434BC86BF3F067")
     void addBackStackState(BackStackRecord state) {
        addTaint(state.getTaint());
    if(mBackStack == null)        
        {
            mBackStack = new ArrayList<BackStackRecord>();
        } 
        mBackStack.add(state);
        reportBackStackChanged();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.838 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "AD6C5643FDBC64C14D66F0302A4911B8")
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
        addTaint(flags);
        addTaint(id);
        addTaint(name.getTaint());
        addTaint(handler.getTaint());
    if(mBackStack == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1962060793 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151774755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_151774755;
        } 
    if(name == null && id < 0 && (flags&POP_BACK_STACK_INCLUSIVE) == 0)        
        {
            int last = mBackStack.size()-1;
    if(last < 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_499432838 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1266347259 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1266347259;
            } 
            final BackStackRecord bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } 
        else
        {
            int index = -1;
    if(name != null || id >= 0)            
            {
                index = mBackStack.size()-1;
                while
(index >= 0)                
                {
                    BackStackRecord bss = mBackStack.get(index);
    if(name != null && name.equals(bss.getName()))                    
                    {
                        break;
                    } 
    if(id >= 0 && id == bss.mIndex)                    
                    {
                        break;
                    } 
                    index--;
                } 
    if(index < 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1462254730 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485055301 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_485055301;
                } 
    if((flags&POP_BACK_STACK_INCLUSIVE) != 0)                
                {
                    index--;
                    while
(index >= 0)                    
                    {
                        BackStackRecord bss = mBackStack.get(index);
    if((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex))                        
                        {
                            index--;
                            continue;
                        } 
                        break;
                    } 
                } 
            } 
    if(index == mBackStack.size()-1)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1562653078 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082249472 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082249472;
            } 
            final ArrayList<BackStackRecord> states = new ArrayList<BackStackRecord>();
for(int i=mBackStack.size()-1;i>index;i--)
            {
                states.add(mBackStack.remove(i));
            } 
            final int LAST = states.size()-1;
for(int i=0;i<=LAST;i++)
            {
    if(DEBUG){ }                states.get(i).popFromBackStack(i == LAST);
            } 
            reportBackStackChanged();
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1237791761 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313169602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313169602;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.840 -0400", hash_original_method = "4601075007D50CE0BCD1D759D668CB84", hash_generated_method = "6D6CBE34B10F2C1044794CB3940362EE")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> fragments = null;
    if(mActive != null)        
        {
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
    if(f != null && f.mRetainInstance)                
                {
    if(fragments == null)                    
                    {
                        fragments = new ArrayList<Fragment>();
                    } 
                    fragments.add(f);
                    f.mRetaining = true;
                    f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
    if(DEBUG){ }
                } 
            } 
        } 
ArrayList<Fragment> varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1529973126 =         fragments;
        varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1529973126.addTaint(taint);
        return varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1529973126;
        
        
        
            
                
                
                    
                        
                    
                    
                    
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.841 -0400", hash_original_method = "AB64A806E53952D63B221B8A02A39B9D", hash_generated_method = "8CFAD10F48C37D1DD9C233DA8D2A7FE2")
     void saveFragmentViewState(Fragment f) {
        addTaint(f.getTaint());
    if(f.mInnerView == null)        
        {
            return;
        } 
    if(mStateArray == null)        
        {
            mStateArray = new SparseArray<Parcelable>();
        } 
        else
        {
            mStateArray.clear();
        } 
        f.mInnerView.saveHierarchyState(mStateArray);
    if(mStateArray.size() > 0)        
        {
            f.mSavedViewState = mStateArray;
            mStateArray = null;
        } 
        
        
            
        
        
            
        
            
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.842 -0400", hash_original_method = "4EAE6A1450E2744D0D17A0CBB3487A4E", hash_generated_method = "5AA4A565B91159AF6406D9D44D8E90A7")
     Bundle saveFragmentBasicState(Fragment f) {
        addTaint(f.getTaint());
        Bundle result = null;
    if(mStateBundle == null)        
        {
            mStateBundle = new Bundle();
        } 
        f.performSaveInstanceState(mStateBundle);
    if(!mStateBundle.isEmpty())        
        {
            result = mStateBundle;
            mStateBundle = null;
        } 
    if(f.mView != null)        
        {
            saveFragmentViewState(f);
        } 
    if(f.mSavedViewState != null)        
        {
    if(result == null)            
            {
                result = new Bundle();
            } 
            result.putSparseParcelableArray(
                    FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        } 
    if(!f.mUserVisibleHint)        
        {
    if(result == null)            
            {
                result = new Bundle();
            } 
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        } 
Bundle varDC838461EE2FA0CA4C9BBB70A15456B0_1733309568 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1733309568.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1733309568;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.847 -0400", hash_original_method = "10343325EA0A9B349A8A31D89021E4C8", hash_generated_method = "1A6FA92AEFDDCE509E53A23534579920")
     Parcelable saveAllState() {
        execPendingActions();
    if(HONEYCOMB)        
        {
            mStateSaved = true;
        } 
    if(mActive == null || mActive.size() <= 0)        
        {
Parcelable var540C13E9E156B687226421B24F2DF178_1452449336 =             null;
            var540C13E9E156B687226421B24F2DF178_1452449336.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1452449336;
        } 
        int N = mActive.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
for(int i=0;i<N;i++)
        {
            Fragment f = mActive.get(i);
    if(f != null)            
            {
    if(f.mIndex < 0)                
                {
                    throwException(new IllegalStateException(
                            "Failure saving state: active " + f
                            + " has cleared index: " + f.mIndex));
                } 
                haveFragments = true;
                FragmentState fs = new FragmentState(f);
                active[i] = fs;
    if(f.mState > Fragment.INITIALIZING && fs.mSavedFragmentState == null)                
                {
                    fs.mSavedFragmentState = saveFragmentBasicState(f);
    if(f.mTarget != null)                    
                    {
    if(f.mTarget.mIndex < 0)                        
                        {
                            throwException(new IllegalStateException(
                                    "Failure saving state: " + f
                                    + " has target not in fragment manager: " + f.mTarget));
                        } 
    if(fs.mSavedFragmentState == null)                        
                        {
                            fs.mSavedFragmentState = new Bundle();
                        } 
                        putFragment(fs.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG, f.mTarget);
    if(f.mTargetRequestCode != 0)                        
                        {
                            fs.mSavedFragmentState.putInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG,
                                    f.mTargetRequestCode);
                        } 
                    } 
                } 
                else
                {
                    fs.mSavedFragmentState = f.mSavedFragmentState;
                } 
    if(DEBUG){ }
            } 
        } 
    if(!haveFragments)        
        {
    if(DEBUG){ }Parcelable var540C13E9E156B687226421B24F2DF178_1934096694 =             null;
            var540C13E9E156B687226421B24F2DF178_1934096694.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1934096694;
        } 
        int[] added = null;
        BackStackState[] backStack = null;
    if(mAdded != null)        
        {
            N = mAdded.size();
    if(N > 0)            
            {
                added = new int[N];
for(int i=0;i<N;i++)
                {
                    added[i] = mAdded.get(i).mIndex;
    if(added[i] < 0)                    
                    {
                        throwException(new IllegalStateException(
                                "Failure saving state: active " + mAdded.get(i)
                                + " has cleared index: " + added[i]));
                    } 
    if(DEBUG){ }
                } 
            } 
        } 
    if(mBackStack != null)        
        {
            N = mBackStack.size();
    if(N > 0)            
            {
                backStack = new BackStackState[N];
for(int i=0;i<N;i++)
                {
                    backStack[i] = new BackStackState(this, mBackStack.get(i));
    if(DEBUG){ }
                } 
            } 
        } 
        FragmentManagerState fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
Parcelable var7CFA6661E623A7ACE6CCCD8D42B74674_1687932146 =         fms;
        var7CFA6661E623A7ACE6CCCD8D42B74674_1687932146.addTaint(taint);
        return var7CFA6661E623A7ACE6CCCD8D42B74674_1687932146;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.855 -0400", hash_original_method = "83508419770250A244151298D1C277A7", hash_generated_method = "D3869E7CC7CC1D10378D0F03DE4B4B16")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        addTaint(nonConfig.getTaint());
        addTaint(state.getTaint());
    if(state == null)        
        return;
        FragmentManagerState fms = (FragmentManagerState)state;
    if(fms.mActive == null)        
        return;
    if(nonConfig != null)        
        {
for(int i=0;i<nonConfig.size();i++)
            {
                Fragment f = nonConfig.get(i);
    if(DEBUG){ }                FragmentState fs = fms.mActive[f.mIndex];
                fs.mInstance = f;
                f.mSavedViewState = null;
                f.mBackStackNesting = 0;
                f.mInLayout = false;
                f.mAdded = false;
                f.mTarget = null;
    if(fs.mSavedFragmentState != null)                
                {
                    fs.mSavedFragmentState.setClassLoader(mActivity.getClassLoader());
                    f.mSavedViewState = fs.mSavedFragmentState.getSparseParcelableArray(
                            FragmentManagerImpl.VIEW_STATE_TAG);
                } 
            } 
        } 
        mActive = new ArrayList<Fragment>(fms.mActive.length);
    if(mAvailIndices != null)        
        {
            mAvailIndices.clear();
        } 
for(int i=0;i<fms.mActive.length;i++)
        {
            FragmentState fs = fms.mActive[i];
    if(fs != null)            
            {
                Fragment f = fs.instantiate(mActivity, mParent);
    if(DEBUG){ }                mActive.add(f);
                fs.mInstance = null;
            } 
            else
            {
                mActive.add(null);
    if(mAvailIndices == null)                
                {
                    mAvailIndices = new ArrayList<Integer>();
                } 
    if(DEBUG){ }                mAvailIndices.add(i);
            } 
        } 
    if(nonConfig != null)        
        {
for(int i=0;i<nonConfig.size();i++)
            {
                Fragment f = nonConfig.get(i);
    if(f.mTargetIndex >= 0)                
                {
    if(f.mTargetIndex < mActive.size())                    
                    {
                        f.mTarget = mActive.get(f.mTargetIndex);
                    } 
                    else
                    {
                        f.mTarget = null;
                    } 
                } 
            } 
        } 
    if(fms.mAdded != null)        
        {
            mAdded = new ArrayList<Fragment>(fms.mAdded.length);
for(int i=0;i<fms.mAdded.length;i++)
            {
                Fragment f = mActive.get(fms.mAdded[i]);
    if(f == null)                
                {
                    throwException(new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]));
                } 
                f.mAdded = true;
    if(DEBUG){ }    if(mAdded.contains(f))                
                {
                    IllegalStateException var5BC08CE4CC7883538CF6B88A9F67F203_984690259 = new IllegalStateException("Already added!");
                    var5BC08CE4CC7883538CF6B88A9F67F203_984690259.addTaint(taint);
                    throw var5BC08CE4CC7883538CF6B88A9F67F203_984690259;
                } 
                mAdded.add(f);
            } 
        } 
        else
        {
            mAdded = null;
        } 
    if(fms.mBackStack != null)        
        {
            mBackStack = new ArrayList<BackStackRecord>(fms.mBackStack.length);
for(int i=0;i<fms.mBackStack.length;i++)
            {
                BackStackRecord bse = fms.mBackStack[i].instantiate(this);
    if(DEBUG)                
                {
                    LogWriter logw = new LogWriter(TAG);
                    PrintWriter pw = new PrintWriter(logw);
                    bse.dump("  ", pw, false);
                } 
                mBackStack.add(bse);
    if(bse.mIndex >= 0)                
                {
                    setBackStackIndex(bse.mIndex, bse);
                } 
            } 
        } 
        else
        {
            mBackStack = null;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.859 -0400", hash_original_method = "6B9797EDFBB2C38037CA64E1EEB36778", hash_generated_method = "919EE96851B14260DB92FB23CB60375B")
    public void attachActivity(FragmentActivity activity,
            FragmentContainer container, Fragment parent) {
    if(mActivity != null)        
        {
        IllegalStateException var32B9641AA4056F45F29BFF8F22758351_1939718486 = new IllegalStateException("Already attached");
        var32B9641AA4056F45F29BFF8F22758351_1939718486.addTaint(taint);
        throw var32B9641AA4056F45F29BFF8F22758351_1939718486;
        }
        mActivity = activity;
        mContainer = container;
        mParent = parent;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.860 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.861 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.861 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.862 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.862 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.862 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.863 -0400", hash_original_method = "A6766C0F069AFB58F0A12165F2E095FC", hash_generated_method = "2DD793A778E88D54EE3A335BA8F3FB22")
    public void dispatchStop() {
        mStateSaved = true;
        moveToState(Fragment.STOPPED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.863 -0400", hash_original_method = "DCD943307D69805205EE4AFFC6D1EFE3", hash_generated_method = "89E0EF721C47E2DF40831E82789D0DE5")
    public void dispatchReallyStop() {
        moveToState(Fragment.ACTIVITY_CREATED, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.863 -0400", hash_original_method = "69F58A9B4E2F72C0D627B376DB1A1CDC", hash_generated_method = "7C0C65D29ADA12A03B42DDDA4BE52A2A")
    public void dispatchDestroyView() {
        moveToState(Fragment.CREATED, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.864 -0400", hash_original_method = "92EF0F88C8A3B3CDE2712CBD7D916058", hash_generated_method = "4183A75BEA237931F279EC68B16055AF")
    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
        mContainer = null;
        mParent = null;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.864 -0400", hash_original_method = "3F9069EC8564151620B164A5CADDDD85", hash_generated_method = "9D9F91C10771F338FFF2BFE5D9EA19E6")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        addTaint(newConfig.getTaint());
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
                    f.performConfigurationChanged(newConfig);
                } 
            } 
        } 
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.865 -0400", hash_original_method = "423006F51D0218BAC00AF0FAAABB2869", hash_generated_method = "9BBDEC9E08C2DDA39855DECF57386082")
    public void dispatchLowMemory() {
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
                    f.performLowMemory();
                } 
            } 
        } 
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.867 -0400", hash_original_method = "E04D4A6462A884A432217EF1D5562FD6", hash_generated_method = "A037B7C381FC99E621B3C485B7613272")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        addTaint(inflater.getTaint());
        addTaint(menu.getTaint());
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
    if(f.performCreateOptionsMenu(menu, inflater))                    
                    {
                        show = true;
    if(newMenus == null)                        
                        {
                            newMenus = new ArrayList<Fragment>();
                        } 
                        newMenus.add(f);
                    } 
                } 
            } 
        } 
    if(mCreatedMenus != null)        
        {
for(int i=0;i<mCreatedMenus.size();i++)
            {
                Fragment f = mCreatedMenus.get(i);
    if(newMenus == null || !newMenus.contains(f))                
                {
                    f.onDestroyOptionsMenu();
                } 
            } 
        } 
        mCreatedMenus = newMenus;
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1455843766 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734468213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734468213;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.868 -0400", hash_original_method = "39A1BE180E5A6D21A2BE9889A37AE1EE", hash_generated_method = "2B8E052F4504C851AF99D83245BC558F")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        addTaint(menu.getTaint());
        boolean show = false;
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
    if(f.performPrepareOptionsMenu(menu))                    
                    {
                        show = true;
                    } 
                } 
            } 
        } 
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1951854068 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354893894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354893894;
        
        
        
            
                
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.870 -0400", hash_original_method = "40C97B67F40ABFD093891951534367FF", hash_generated_method = "81C4611042D4385A129485D6E895E83D")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        addTaint(item.getTaint());
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
    if(f.performOptionsItemSelected(item))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_206756686 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763739789 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763739789;
                    } 
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1884131171 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161430229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161430229;
        
        
            
                
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.871 -0400", hash_original_method = "61E677AAD1D9B7A657F2B5668ED52005", hash_generated_method = "6F878489E7C670F536839A12F243B0F8")
    public boolean dispatchContextItemSelected(MenuItem item) {
        addTaint(item.getTaint());
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
    if(f.performContextItemSelected(item))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1858291020 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619111897 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619111897;
                    } 
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1685558195 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372986738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372986738;
        
        
            
                
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.872 -0400", hash_original_method = "6CB4593DD4D25806442B1A7EB0939595", hash_generated_method = "FBE17855B7CCA4D0B91C54EC777513AF")
    public void dispatchOptionsMenuClosed(Menu menu) {
        addTaint(menu.getTaint());
    if(mAdded != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
    if(f != null)                
                {
                    f.performOptionsMenuClosed(menu);
                } 
            } 
        } 
        
        
            
                
                
                    
                
            
        
    }

    
        @DSModeled(DSC.SAFE)
    public static int reverseTransit(int transit) {
        int rev = 0;
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_CLOSE;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                break;
        }
        return rev;
    }

    
        @DSModeled(DSC.SAFE)
    public static int transitToStyleIndex(int transit, boolean enter) {
        int animAttr = -1;
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                animAttr = enter ? ANIM_STYLE_OPEN_ENTER : ANIM_STYLE_OPEN_EXIT;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                animAttr = enter ? ANIM_STYLE_CLOSE_ENTER : ANIM_STYLE_CLOSE_EXIT;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                animAttr = enter ? ANIM_STYLE_FADE_ENTER : ANIM_STYLE_FADE_EXIT;
                break;
        }
        return animAttr;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.872 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.872 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "F97D1635AABE57FB12E9B1B2518064C6", hash_generated_field = "47802C2B46813E58B899D23FD9DC343B")

    static final boolean HONEYCOMB = android.os.Build.VERSION.SDK_INT >= 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")

    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "6C95BC8E2A60A9F4236FBFC95395E3A2", hash_generated_field = "3A10D2877F43112AA0B7A6A8433E95CB")

    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "D8281C96E9514BF04DE392578617576C", hash_generated_field = "1618232FF2C96BF54619A71799992CCF")

    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "D10DC5918CDE7E82CA9095D02FEF8A0C", hash_generated_field = "50DFC5BE4E88ED2E03493326FAE40E99")

    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "838B2B5AA8359A71F94BB598DD8FD304", hash_generated_field = "0650545F9518BF159E5600383DFE2395")

    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "1A243DE04BDCF448B42B90B6C7D09AB2", hash_generated_field = "71044A5396C27203930538888DCB79FC")

    static final int ANIM_DUR = 220;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "260F4A8077B41158EE5084820597CDFE", hash_generated_field = "7BB089DC1B8A242E88755BDA8C8238B9")

    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "519D0B58F7134135D9F630C9958BA2A5", hash_generated_field = "3C4C6A69EA30C5B582DE8DD757B46311")

    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "809B49B33A269DC9ED63B13FAE899E5D", hash_generated_field = "B289F5FCA54C37F25FF23F46A1D8D232")

    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.873 -0400", hash_original_field = "B7C90BEFCC36650797B1A5C0EAE37430", hash_generated_field = "913DA58C0421DE752A939A21044C5DD0")

    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.874 -0400", hash_original_field = "E8EC520365F556FDD343EE5BF52DC8EF", hash_generated_field = "6EE14C70EFD271C2B32055938BC50C20")

    public static final int ANIM_STYLE_FADE_ENTER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.874 -0400", hash_original_field = "BDA176AA41F039DA1615DEC8A570C95D", hash_generated_field = "F489982675E5C10DFACA93BE86E50D4D")

    public static final int ANIM_STYLE_FADE_EXIT = 6;
}

