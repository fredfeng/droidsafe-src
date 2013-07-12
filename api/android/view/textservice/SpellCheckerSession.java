package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import com.android.internal.textservice.ITextServicesSessionListener;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import java.util.LinkedList;
import java.util.Queue;

public class SpellCheckerSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.641 -0400", hash_original_field = "86570ADBC3157007B47DF3D9431125CE", hash_generated_field = "215C075D2F430DB54F33624A6C82B697")

    private InternalListener mInternalListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.641 -0400", hash_original_field = "8CEE743DC82226DD3EB73C8E69CF1A2D", hash_generated_field = "8A90A5ED4421EBC06ED5ABE0A5E545CF")

    private ITextServicesManager mTextServicesManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.641 -0400", hash_original_field = "39FF95092622BD6CB719CE066A7DAC80", hash_generated_field = "8BD978FCE75E98316AE251167020704C")

    private SpellCheckerInfo mSpellCheckerInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.641 -0400", hash_original_field = "8640C114B06EC6CB26C9CC567BCB7DB9", hash_generated_field = "176942745531278FA64A2AB945858D54")

    private SpellCheckerSessionListenerImpl mSpellCheckerSessionListenerImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.641 -0400", hash_original_field = "5A0767397ACD1B3D359BC84DD1623F53", hash_generated_field = "F9475A87EA4B82BC2225BE133534833A")

    private boolean mIsUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.642 -0400", hash_original_field = "FE3DA9B782403BB93B37A12C5BE57239", hash_generated_field = "35B5C20FF96DA114561FBB67E788A05C")

    private SpellCheckerSessionListener mSpellCheckerSessionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "F31C044CAEC6C694941601486644A901", hash_generated_field = "717D500B8155D92BDA4533EDDFF8F419")

    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_method = "D344BABB0D35462B4470990692E141D9", hash_generated_method = "68AF14A458510A80CC95B3C4EF0AAC31")
        @Override
        public void handleMessage(Message msg) {
            
            handleOnGetSuggestionsMultiple((SuggestionsInfo[]) msg.obj);
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.643 -0400", hash_original_method = "EAC7F16E5AF219F835F940B08638A4A9", hash_generated_method = "CBFE7CE5E43D662CBED881B13D3AEEFF")
    public  SpellCheckerSession(
            SpellCheckerInfo info, ITextServicesManager tsm, SpellCheckerSessionListener listener) {
    if(info == null || listener == null || tsm == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1595006021 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1595006021.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1595006021;
        } 
        mSpellCheckerInfo = info;
        mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(mHandler);
        mInternalListener = new InternalListener(mSpellCheckerSessionListenerImpl);
        mTextServicesManager = tsm;
        mIsUsed = true;
        mSpellCheckerSessionListener = listener;
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.643 -0400", hash_original_method = "682777EA87EC108D0C062651A6723A7E", hash_generated_method = "8DCB54E89B1B68F07EF8E3EEF728644C")
    public boolean isSessionDisconnected() {
        boolean varB67DC46ACA36C27390A3501048D3ED84_1140053432 = (mSpellCheckerSessionListenerImpl.isDisconnected());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639919855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639919855;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.643 -0400", hash_original_method = "DA550B703A137477375C51611DE4E664", hash_generated_method = "F63225B5CF99E0750E6461B3496B22A9")
    public SpellCheckerInfo getSpellChecker() {
SpellCheckerInfo var3986F7CD42F0461C45907E6E93ED4397_991115069 =         mSpellCheckerInfo;
        var3986F7CD42F0461C45907E6E93ED4397_991115069.addTaint(taint);
        return var3986F7CD42F0461C45907E6E93ED4397_991115069;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.644 -0400", hash_original_method = "1E56CD8E935972828D8D1226463A945B", hash_generated_method = "6218E4D03A97D2D067BC5C2A6B63B5D3")
    public void cancel() {
        mSpellCheckerSessionListenerImpl.cancel();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.644 -0400", hash_original_method = "3C04EB6043568EF1F63B84FA07955DCB", hash_generated_method = "741AD9C71CF7AEAFA40A093BD5DD8A50")
    public void close() {
        mIsUsed = false;
        try 
        {
            mSpellCheckerSessionListenerImpl.close();
            mTextServicesManager.finishSpellCheckerService(mSpellCheckerSessionListenerImpl);
        } 
        catch (RemoteException e)
        {
        } 
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.644 -0400", hash_original_method = "F1103B1469D8B0C12963D001E1ED8F44", hash_generated_method = "6779E02B59F6B5C4C4009E002834AF3D")
    public void getSuggestions(TextInfo textInfo, int suggestionsLimit) {
        addTaint(suggestionsLimit);
        addTaint(textInfo.getTaint());
        getSuggestions(new TextInfo[] {textInfo}, suggestionsLimit, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.645 -0400", hash_original_method = "748B76866E07D81600FB5AF9FEF1E977", hash_generated_method = "F8126D2FE713A21701B3301568B978A4")
    public void getSuggestions(
            TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
        addTaint(sequentialWords);
        addTaint(suggestionsLimit);
        addTaint(textInfos[0].getTaint());
    if(DBG)        
        {
        } 
        mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(
                textInfos, suggestionsLimit, sequentialWords);
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.645 -0400", hash_original_method = "9106E435C4B71E55E27749112B6B4B2E", hash_generated_method = "6261983BA69111B6358811AA1B0BBC03")
    private void handleOnGetSuggestionsMultiple(SuggestionsInfo[] suggestionInfos) {
        addTaint(suggestionInfos[0].getTaint());
        mSpellCheckerSessionListener.onGetSuggestions(suggestionInfos);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.646 -0400", hash_original_method = "59AD6E7808D10F8FF29E63144F2BA4F1", hash_generated_method = "4A1790F673068DADA3C7E1B074B4C4E8")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    if(mIsUsed)        
        {
            close();
        } 
        
        
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.646 -0400", hash_original_method = "EB5F65A578EB2CF49F3B6FAEDD6A03A1", hash_generated_method = "6E73CA9BC3E01E72AB2E60239D9B9C1E")
    public ITextServicesSessionListener getTextServicesSessionListener() {
ITextServicesSessionListener var7A9AC5CB3CFF90180D6952883712FBEC_1402889722 =         mInternalListener;
        var7A9AC5CB3CFF90180D6952883712FBEC_1402889722.addTaint(taint);
        return var7A9AC5CB3CFF90180D6952883712FBEC_1402889722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.646 -0400", hash_original_method = "49E439EC4CF52AA024CAA5A403E07C82", hash_generated_method = "2F7E1B3D12EEA82D9B42FF27517AF972")
    public ISpellCheckerSessionListener getSpellCheckerSessionListener() {
ISpellCheckerSessionListener var820AE1A05D9F7D1D7D422F5929FB9AB9_93984612 =         mSpellCheckerSessionListenerImpl;
        var820AE1A05D9F7D1D7D422F5929FB9AB9_93984612.addTaint(taint);
        return var820AE1A05D9F7D1D7D422F5929FB9AB9_93984612;
        
        
    }

    
    private static class SpellCheckerSessionListenerImpl extends ISpellCheckerSessionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.646 -0400", hash_original_field = "7D6A0A9D0A2350E3DD5674858B5F5E74", hash_generated_field = "80580ADD9DAA18B004F014E5F19E4509")

        private final Queue<SpellCheckerParams> mPendingTasks = new LinkedList<SpellCheckerParams>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_field = "F0214A3C00D73DBD06320E7A6B947430", hash_generated_field = "026997BD1DDC69199AFE6E4BEDBC44D9")

        private boolean mOpened;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_field = "2B349CEE8DE64D628AA7509FB64BA5BA", hash_generated_field = "E82EEC699A95F9ABD3944094C573C41F")

        private ISpellCheckerSession mISpellCheckerSession;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "13A4D1B0812E091348BEDE1E713E2CC3")

        private HandlerThread mThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_field = "D1B24D7340F6738BAF47F74032B8981B", hash_generated_field = "CF39ABD0CA2280D07CFEF67D1D5B6BD0")

        private Handler mAsyncHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.647 -0400", hash_original_method = "45646CFDAE5B6949F64A7BA4C2829D13", hash_generated_method = "24A0ED9CB92314817C155971217375CB")
        public  SpellCheckerSessionListenerImpl(Handler handler) {
            mOpened = false;
            mHandler = handler;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.648 -0400", hash_original_method = "FF3B1A32D02DE5F870E94EBAC6E0CDD1", hash_generated_method = "836DF91E7D75EF5DA76A50F84254C4C2")
        private void processTask(ISpellCheckerSession session, SpellCheckerParams scp,
                boolean async) {
            addTaint(async);
            addTaint(scp.getTaint());
            addTaint(session.getTaint());
    if(async || mAsyncHandler == null)            
            {
switch(scp.mWhat){
                case TASK_CANCEL:
    if(DBG)                
                {
                } 
                try 
                {
                    session.onCancel();
                } 
                catch (RemoteException e)
                {
                } 
                break;
                case TASK_GET_SUGGESTIONS_MULTIPLE:
    if(DBG)                
                {
                } 
                try 
                {
                    session.onGetSuggestionsMultiple(scp.mTextInfos,
                                    scp.mSuggestionsLimit, scp.mSequentialWords);
                } 
                catch (RemoteException e)
                {
                } 
                break;
                case TASK_CLOSE:
    if(DBG)                
                {
                } 
                try 
                {
                    session.onClose();
                } 
                catch (RemoteException e)
                {
                } 
                break;
}
            } 
            else
            {
                scp.mSession = session;
                mAsyncHandler.sendMessage(Message.obtain(mAsyncHandler, 1, scp));
            } 
    if(scp.mWhat == TASK_CLOSE)            
            {
                synchronized
(this)                {
                    mISpellCheckerSession = null;
                    mHandler = null;
    if(mThread != null)                    
                    {
                        mThread.quit();
                    } 
                    mThread = null;
                    mAsyncHandler = null;
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.650 -0400", hash_original_method = "469ADA81CD5459833AC5296525D5CDB7", hash_generated_method = "571CDC4BB35AC50B954503799C0C41F6")
        public synchronized void onServiceConnected(ISpellCheckerSession session) {
            
            synchronized
(this)            {
                mISpellCheckerSession = session;
    if(session.asBinder() instanceof Binder && mThread == null)                
                {
                    mThread = new HandlerThread("SpellCheckerSession",
                            Process.THREAD_PRIORITY_BACKGROUND);
                    mThread.start();
                    mAsyncHandler = new Handler(mThread.getLooper()) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.650 -0400", hash_original_method = "B5DD0FD72BD82B68026C922D83082837", hash_generated_method = "9F0EA283B845A2D0BEF7EDE3BA603C63")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                SpellCheckerParams scp = (SpellCheckerParams)msg.obj;
                processTask(scp.mSession, scp, true);
                
                
                
            }
};
                } 
                mOpened = true;
            } 
    if(DBG)            
            Log.d(TAG, "onServiceConnected - Success");
            while
(!mPendingTasks.isEmpty())            
            {
                processTask(session, mPendingTasks.poll(), false);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.650 -0400", hash_original_method = "BB59E0E202ED795E2DB7DAEC1471EA7A", hash_generated_method = "B9F5BF7650E2FC9AAB8342E0E87E62E8")
        public void cancel() {
    if(DBG)            
            {
            } 
            processOrEnqueueTask(new SpellCheckerParams(TASK_CANCEL, null, 0, false));
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.651 -0400", hash_original_method = "1A7565B677D156EAC1FA51ED11F842F1", hash_generated_method = "7249BA0564811D4FFD9B0ECF37DE6E7E")
        public void getSuggestionsMultiple(
                TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
            addTaint(sequentialWords);
            addTaint(suggestionsLimit);
            addTaint(textInfos[0].getTaint());
    if(DBG)            
            {
            } 
            processOrEnqueueTask(
                    new SpellCheckerParams(TASK_GET_SUGGESTIONS_MULTIPLE, textInfos,
                            suggestionsLimit, sequentialWords));
            
            
                
            
            
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.651 -0400", hash_original_method = "09E8016792D99DD9284F914495CA50D8", hash_generated_method = "431C52B7BFC5AABB0517890C4669AA1E")
        public void close() {
    if(DBG)            
            {
            } 
            processOrEnqueueTask(new SpellCheckerParams(TASK_CLOSE, null, 0, false));
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.651 -0400", hash_original_method = "C74449D517ED376786ADEE83EFA902AD", hash_generated_method = "EBD97ADE232D8783FA3D1BA19FE4507F")
        public boolean isDisconnected() {
            boolean var54E1480729898C5F1743C88D3F4A1642_1409992390 = (mOpened && mISpellCheckerSession == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026433541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026433541;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.652 -0400", hash_original_method = "A1EA0918B68CB66F258D8DAFDFEA4BA7", hash_generated_method = "21C5B6F3747336A2E36103F23C6D3AEC")
        private void processOrEnqueueTask(SpellCheckerParams scp) {
            addTaint(scp.getTaint());
    if(DBG)            
            {
                Log.d(TAG, "process or enqueue task: " + mISpellCheckerSession);
            } 
            ISpellCheckerSession session;
            synchronized
(this)            {
                session = mISpellCheckerSession;
    if(session == null)                
                {
                    SpellCheckerParams closeTask = null;
    if(scp.mWhat == TASK_CANCEL)                    
                    {
                        while
(!mPendingTasks.isEmpty())                        
                        {
                            final SpellCheckerParams tmp = mPendingTasks.poll();
    if(tmp.mWhat == TASK_CLOSE)                            
                            {
                                closeTask = tmp;
                            } 
                        } 
                    } 
                    mPendingTasks.offer(scp);
    if(closeTask != null)                    
                    {
                        mPendingTasks.offer(closeTask);
                    } 
                    return;
                } 
            } 
            processTask(session, scp, false);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.652 -0400", hash_original_method = "DF368CC1EE007FCF3291FF75FA752896", hash_generated_method = "5528E791653C08E57DAA0076F90230CB")
        @Override
        public void onGetSuggestions(SuggestionsInfo[] results) {
            
            addTaint(results[0].getTaint());
            synchronized
(this)            {
    if(mHandler != null)                
                {
                    mHandler.sendMessage(Message.obtain(mHandler,
                            MSG_ON_GET_SUGGESTION_MULTIPLE, results));
                } 
            } 
            
            
                
                    
                            
                
            
        }

        
        private static class SpellCheckerParams {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_field = "8DF9C1B98F3FE85ADC76D8B400B4D01B", hash_generated_field = "F09CAB29E7BAE43BF7E77A878670CC58")

            public int mWhat;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_field = "7E516B1E896534705378D53CF9BF9CF2", hash_generated_field = "DAA029989DD6BF11DD3BC920E196ED55")

            public TextInfo[] mTextInfos;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_field = "0CA5BC3E48B36251F8F264EA70A4DECB", hash_generated_field = "B21FF32FEA333D87A21520C6D4E3EF59")

            public int mSuggestionsLimit;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_field = "4D65BBDDCEEF9F1BB19CD30E920514EF", hash_generated_field = "08DB8A4CE5692C4135CEE1F25739ED9F")

            public boolean mSequentialWords;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "8B16E6760DA40F3D8F2C1AF94B738DDB")

            public ISpellCheckerSession mSession;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.653 -0400", hash_original_method = "51C4C688A5D55FCA95337D97DFAD7FEA", hash_generated_method = "D8F47CCA6BE71DC8399AA902ECFB9936")
            public  SpellCheckerParams(int what, TextInfo[] textInfos, int suggestionsLimit,
                    boolean sequentialWords) {
                mWhat = what;
                mTextInfos = textInfos;
                mSuggestionsLimit = suggestionsLimit;
                mSequentialWords = sequentialWords;
                
                
                
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_field = "9164A23498D5DA2BE2FE2F43F41E1099", hash_generated_field = "BE9BEF2E614EC9685F259E9E598AC103")

        private static final int TASK_CANCEL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_field = "0E0075303B69C4231C05D1FB9E4C88CD", hash_generated_field = "629AED697CE0562C66D82D65B1590931")

        private static final int TASK_GET_SUGGESTIONS_MULTIPLE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_field = "26F416BE553D6EA84F6AD974236B9C5A", hash_generated_field = "A12CF43E741DD4386EE1F2A24ECC8454")

        private static final int TASK_CLOSE = 3;
    }


    
    private static class InternalListener extends ITextServicesSessionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_field = "2FFB711A8F0FFE714BB32E90D46A7077", hash_generated_field = "4AF693C96983678B5C0CB0A41FA9F14D")

        private SpellCheckerSessionListenerImpl mParentSpellCheckerSessionListenerImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_method = "4338D10CD0AFB882F60E57AC8CDB914E", hash_generated_method = "A8F051AD092B8DFA0B4C78897CB98223")
        public  InternalListener(SpellCheckerSessionListenerImpl spellCheckerSessionListenerImpl) {
            mParentSpellCheckerSessionListenerImpl = spellCheckerSessionListenerImpl;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_method = "822E3A88968051EE65AD939CBD482992", hash_generated_method = "DE267A5A5C18F8D865715C189996BDF6")
        @Override
        public void onServiceConnected(ISpellCheckerSession session) {
            
            addTaint(session.getTaint());
    if(DBG)            
            {
            } 
            mParentSpellCheckerSessionListenerImpl.onServiceConnected(session);
            
            
                
            
            
        }

        
    }


    
    public interface SpellCheckerSessionListener {
        
        public void onGetSuggestions(SuggestionsInfo[] results);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.654 -0400", hash_original_field = "B002EAB02F1BA66E9105869E0E0ACAD8", hash_generated_field = "4A5080C7337BFD6CD37522D5F3819A2D")

    private static final String TAG = SpellCheckerSession.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.655 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.655 -0400", hash_original_field = "DE263946A17D09A511E31C46FC626103", hash_generated_field = "2DCFEB5D1F4AC60E1FC375E60A3273B1")

    public static final String SERVICE_META_DATA = "android.view.textservice.scs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.655 -0400", hash_original_field = "AE33B60E566A7AC88EA961A4B17471A8", hash_generated_field = "9025B4E9C2670D7F8726B2FD382C594F")

    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE = 1;
}

