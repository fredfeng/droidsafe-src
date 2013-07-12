package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class ValueAnimator extends Animator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.447 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

    long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.448 -0400", hash_original_field = "21F0A5E67D578B871CE4890BB4301938", hash_generated_field = "4E1645CE3651AE4D866A4E97769672FC")

    long mSeekTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.448 -0400", hash_original_field = "C36D028293D9AEB21CE372B528F12B7D", hash_generated_field = "25D0DF5A7C1B0B40E8B3204C90423678")

    private boolean mPlayingBackwards = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.449 -0400", hash_original_field = "24FDF63EDEAC7BEE43B5C4C5591E8865", hash_generated_field = "4C9D53155FF73BA27011D6E7DB3AD10B")

    private int mCurrentIteration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.449 -0400", hash_original_field = "C2F7E02BDA00B17A8F988AB57AA22BF9", hash_generated_field = "8A50A9EB094A19AFEFAE9DD764A21B61")

    private float mCurrentFraction = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.450 -0400", hash_original_field = "CC68149CDA21F68465AA90F07F5D95CC", hash_generated_field = "E6BC29DFE32B95A7746A3240D4908F49")

    private boolean mStartedDelay = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.450 -0400", hash_original_field = "4990509A1CCCA8D89E912983C67DFF20", hash_generated_field = "99C0D1839DB2E0976F6365DA96527AB3")

    private long mDelayStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.451 -0400", hash_original_field = "9950F1CC6304A23A1DF3E99C55CB4013", hash_generated_field = "8F8CC3CA50EF97884C628BBEA63AE150")

    int mPlayingState = STOPPED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.451 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.451 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.452 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "D7228C282593CDC77734D668B23541D3")

    boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.452 -0400", hash_original_field = "278AF3A57BE580604E764F8A9A2B780D", hash_generated_field = "7C681C473ED41389A77BB70A2C4D72CE")

    private long mDuration = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.452 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.453 -0400", hash_original_field = "7400544E99BDB4AB399DABF03F346DE6", hash_generated_field = "86BE2F843C53DE337B277203FC4ABA75")

    private int mRepeatCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.453 -0400", hash_original_field = "31336EA85735F5B517DD430F87691118", hash_generated_field = "D8AE514964A82408D2EBFBBF132AAE13")

    private int mRepeatMode = RESTART;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.453 -0400", hash_original_field = "ED64FCC69138AB0D151E83CCFCFE975A", hash_generated_field = "42D7E84F8F4EF4F62C2A90763184E4DB")

    private TimeInterpolator mInterpolator = sDefaultInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.454 -0400", hash_original_field = "6141FE189AA3625489E2AE5CC67F512B", hash_generated_field = "413346BD5600531FF965862127DA0D01")

    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.454 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "E200C2BDFC70B9C579B8C490F170F688")

    PropertyValuesHolder[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.454 -0400", hash_original_field = "DEA90B16C4F0F78E79C71A2F9BB8975C", hash_generated_field = "AF5FC8A22004016791392366FC7AA458")

    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.455 -0400", hash_original_method = "17A6701FB198CD0BD584AB7A0EFE3839", hash_generated_method = "1E0F7AE0C295B96E8122202378305CF8")
    public  ValueAnimator() {
        
    }

    
        public static ValueAnimator ofInt(int... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(values);
        return anim;
    }

    
        public static ValueAnimator ofFloat(float... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setFloatValues(values);
        return anim;
    }

    
        public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setValues(values);
        return anim;
    }

    
        public static ValueAnimator ofObject(TypeEvaluator evaluator, Object... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.460 -0400", hash_original_method = "67525E8968A6999074D725B8947CD2FE", hash_generated_method = "840C50568D669C49D42DBBC4BD0B87A6")
    public void setIntValues(int... values) {
        addTaint(values[0]);
    if(values == null || values.length == 0)        
        {
            return;
        } 
    if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", values)});
        } 
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setIntValues(values);
        } 
        mInitialized = false;
        
        
            
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.462 -0400", hash_original_method = "D733778AA31410A94B9571EEAAECBB30", hash_generated_method = "EC1BE9E5174C66E7E3C126FE709D39BD")
    public void setFloatValues(float... values) {
        addTaint(values[0]);
    if(values == null || values.length == 0)        
        {
            return;
        } 
    if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("", values)});
        } 
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setFloatValues(values);
        } 
        mInitialized = false;
        
        
            
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.466 -0400", hash_original_method = "AAE460ECCCBF6E694CF45A2F7BA85BA5", hash_generated_method = "E6D9D19A4A8B4660D7A3CC2A8886183F")
    public void setObjectValues(Object... values) {
        addTaint(values[0].getTaint());
    if(values == null || values.length == 0)        
        {
            return;
        } 
    if(mValues == null || mValues.length == 0)        
        {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject("",
                    (TypeEvaluator)null, values)});
        } 
        else
        {
            PropertyValuesHolder valuesHolder = mValues[0];
            valuesHolder.setObjectValues(values);
        } 
        mInitialized = false;
        
        
            
        
        
            
                    
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.471 -0400", hash_original_method = "D9E3FD9EEAA02CD647DC7AEFD5007E3A", hash_generated_method = "1A154C130D5833B4D25F9C35C150A8A3")
    public void setValues(PropertyValuesHolder... values) {
        int numValues = values.length;
        mValues = values;
        mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
for(int i = 0;i < numValues;++i)
        {
            PropertyValuesHolder valuesHolder = (PropertyValuesHolder) values[i];
            mValuesMap.put(valuesHolder.getPropertyName(), valuesHolder);
        } 
        mInitialized = false;
        
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.475 -0400", hash_original_method = "78A6AA7AD01513781B120BCE5DC9E156", hash_generated_method = "419E7F98BDE9E44C05A6D1D54EB7C874")
    public PropertyValuesHolder[] getValues() {
PropertyValuesHolder[] varC2D5F196132EC24FFA86AC8D1AA44E77_982857520 =         mValues;
        varC2D5F196132EC24FFA86AC8D1AA44E77_982857520.addTaint(taint);
        return varC2D5F196132EC24FFA86AC8D1AA44E77_982857520;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.477 -0400", hash_original_method = "1534ECD6905850E5B269582384A75673", hash_generated_method = "3E463660AB5DD139F7F83CC8C8CC70BA")
     void initAnimation() {
    if(!mInitialized)        
        {
            int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
            {
                mValues[i].init();
            } 
            mInitialized = true;
        } 
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.481 -0400", hash_original_method = "622DE942E3334D786E7FE8DBF49B30DE", hash_generated_method = "52A9FA4D243654DC96BA37B2781E0615")
    public ValueAnimator setDuration(long duration) {
    if(duration < 0)        
        {
            IllegalArgumentException varBE9004E8E8C014F966F457353E164ECE_1499348473 = new IllegalArgumentException("Animators cannot have negative duration: " +
                    duration);
            varBE9004E8E8C014F966F457353E164ECE_1499348473.addTaint(taint);
            throw varBE9004E8E8C014F966F457353E164ECE_1499348473;
        } 
        mDuration = duration;
ValueAnimator var72A74007B2BE62B849F475C7BDA4658B_535080888 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_535080888.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_535080888;
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.484 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "B0008CA48251C0102D6104ADBDEC897F")
    public long getDuration() {
        long var25395741BFE51A7D136A5C7109AAD2D8_477302160 = (mDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2105598765 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2105598765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.487 -0400", hash_original_method = "9366966ECC70650E5B5651EBD3539ED0", hash_generated_method = "4AF7C071D2C46B74489D753479B8B317")
    public void setCurrentPlayTime(long playTime) {
        initAnimation();
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
    if(mPlayingState != RUNNING)        
        {
            mSeekTime = playTime;
            mPlayingState = SEEKED;
        } 
        mStartTime = currentTime - playTime;
        animationFrame(currentTime);
        
        
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.490 -0400", hash_original_method = "68655250B160F78BB8C6212DC5765131", hash_generated_method = "18B343F9373D544226EA08C24AC4EFD3")
    public long getCurrentPlayTime() {
    if(!mInitialized || mPlayingState == STOPPED)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_310554420 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_86813762 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_86813762;
        } 
        long var1C9200772E158560032A9CF9D62296E6_181225707 = (AnimationUtils.currentAnimationTimeMillis() - mStartTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_596380164 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_596380164;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.492 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "380F1904300FC1C509654EAEC385AD90")
    public long getStartDelay() {
        long varD6348B0CF9AA194EA8CCE71E8A2B9F80_1626494213 = (mStartDelay);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_639420299 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_639420299;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.494 -0400", hash_original_method = "84D20D1DEBEAE9C7FDE98EA5D287F4D2", hash_generated_method = "FAC2ECF430C77C663A5F61FD6D4BD7CA")
    public void setStartDelay(long startDelay) {
        this.mStartDelay = startDelay;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static long getFrameDelay() {
        return sFrameDelay;
    }

    
        @DSModeled(DSC.SAFE)
    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.497 -0400", hash_original_method = "3CBE561BBB42AB3DB3CAF9B67D05776D", hash_generated_method = "227DF9E672CCD5422077F14446CCF7DA")
    public Object getAnimatedValue() {
    if(mValues != null && mValues.length > 0)        
        {
Object var96E4E04F2DBCC1050469FEE260A62C55_429494356 =             mValues[0].getAnimatedValue();
            var96E4E04F2DBCC1050469FEE260A62C55_429494356.addTaint(taint);
            return var96E4E04F2DBCC1050469FEE260A62C55_429494356;
        } 
Object var540C13E9E156B687226421B24F2DF178_1618094301 =         null;
        var540C13E9E156B687226421B24F2DF178_1618094301.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1618094301;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.498 -0400", hash_original_method = "2B530B2B81FC1FAD77C53EC8863AE50E", hash_generated_method = "52889FE6A89B403B2378E9047EA091A1")
    public Object getAnimatedValue(String propertyName) {
        addTaint(propertyName.getTaint());
        PropertyValuesHolder valuesHolder = mValuesMap.get(propertyName);
    if(valuesHolder != null)        
        {
Object varAFFF70B2CAFA3E6D7FA10FCE336E53FD_687706607 =             valuesHolder.getAnimatedValue();
            varAFFF70B2CAFA3E6D7FA10FCE336E53FD_687706607.addTaint(taint);
            return varAFFF70B2CAFA3E6D7FA10FCE336E53FD_687706607;
        } 
        else
        {
Object var540C13E9E156B687226421B24F2DF178_731539930 =             null;
            var540C13E9E156B687226421B24F2DF178_731539930.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_731539930;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.500 -0400", hash_original_method = "4F2FB0A315DAA7A8B07A49F4FCE27399", hash_generated_method = "7098540AE96AF889E34ED53706CB0331")
    public void setRepeatCount(int value) {
        mRepeatCount = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.501 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "45E624BCE1671BA7DF01316B2B964C53")
    public int getRepeatCount() {
        int varF545692334BC1E20E53D9FB0B2CFFF33_388752286 = (mRepeatCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383119172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383119172;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.504 -0400", hash_original_method = "C33D7F87842C98944308EC1438B3A8A7", hash_generated_method = "57CCF83DF3B3AF7C69315FCAF2E9D050")
    public void setRepeatMode(int value) {
        mRepeatMode = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.505 -0400", hash_original_method = "081205714C0DCBE8DC8471C6BC7C6458", hash_generated_method = "9A04543EACF1F1F02B362228CA67E6A2")
    public int getRepeatMode() {
        int var0F7262183FEB856E4BA3C1C837CA6BEF_1989222356 = (mRepeatMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872634867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872634867;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.507 -0400", hash_original_method = "D2A8BFD752ECF80FCD3BD03F5B9AF68A", hash_generated_method = "F5DF283E858755CDAEB721BA0CC692BD")
    public void addUpdateListener(AnimatorUpdateListener listener) {
        addTaint(listener.getTaint());
    if(mUpdateListeners == null)        
        {
            mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        } 
        mUpdateListeners.add(listener);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.509 -0400", hash_original_method = "ABC42C9D08D6EB9E3E04E4FD12636CA0", hash_generated_method = "727A59C99A773D4DBFCFB8B89B4F5FDD")
    public void removeAllUpdateListeners() {
    if(mUpdateListeners == null)        
        {
            return;
        } 
        mUpdateListeners.clear();
        mUpdateListeners = null;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.512 -0400", hash_original_method = "E6D135867EE130F9CB4EA2C9507FABF5", hash_generated_method = "460F58AC30DF7CC9753B21D1A676C90F")
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        addTaint(listener.getTaint());
    if(mUpdateListeners == null)        
        {
            return;
        } 
        mUpdateListeners.remove(listener);
    if(mUpdateListeners.size() == 0)        
        {
            mUpdateListeners = null;
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.519 -0400", hash_original_method = "AF77FCDF6C80D02141639AFD7587863F", hash_generated_method = "86B19D29986EF8F2B261A5E66138DDBA")
    @Override
    public void setInterpolator(TimeInterpolator value) {
    if(value != null)        
        {
            mInterpolator = value;
        } 
        else
        {
            mInterpolator = new LinearInterpolator();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.523 -0400", hash_original_method = "69CBD09EBE4A4B5ECD6AD8540DB7CFD0", hash_generated_method = "83D8B5D98D7E7743EDC319400C92B095")
    public TimeInterpolator getInterpolator() {
TimeInterpolator var9FA301F6AF154FEBBB2C7439D021F894_1324407040 =         mInterpolator;
        var9FA301F6AF154FEBBB2C7439D021F894_1324407040.addTaint(taint);
        return var9FA301F6AF154FEBBB2C7439D021F894_1324407040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.527 -0400", hash_original_method = "BC30F1B6BC4F20E2E98ADFB4EC800F88", hash_generated_method = "94AF827F9943E9B9457C1AE5564931ED")
    public void setEvaluator(TypeEvaluator value) {
        addTaint(value.getTaint());
    if(value != null && mValues != null && mValues.length > 0)        
        {
            mValues[0].setEvaluator(value);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.532 -0400", hash_original_method = "4B39A931455D340382CCAC7898FAB8D3", hash_generated_method = "56B1E576E65F5C748FAF190739A0A775")
    private void start(boolean playBackwards) {
    if(Looper.myLooper() == null)        
        {
            AndroidRuntimeException var3B9A5F7965EADDC4E032B0DEF8CC9EF0_1257741092 = new AndroidRuntimeException("Animators may only be run on Looper threads");
            var3B9A5F7965EADDC4E032B0DEF8CC9EF0_1257741092.addTaint(taint);
            throw var3B9A5F7965EADDC4E032B0DEF8CC9EF0_1257741092;
        } 
        mPlayingBackwards = playBackwards;
        mCurrentIteration = 0;
        mPlayingState = STOPPED;
        mStarted = true;
        mStartedDelay = false;
        sPendingAnimations.get().add(this);
    if(mStartDelay == 0)        
        {
            setCurrentPlayTime(getCurrentPlayTime());
            mPlayingState = STOPPED;
            mRunning = true;
    if(mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
                {
                    tmpListeners.get(i).onAnimationStart(this);
                } 
            } 
        } 
        AnimationHandler animationHandler = sAnimationHandler.get();
    if(animationHandler == null)        
        {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        } 
        animationHandler.sendEmptyMessage(ANIMATION_START);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.535 -0400", hash_original_method = "0E699EAEE0E759B00B92DBAE6A0AB7E1", hash_generated_method = "CF8459FD9743EB11F57C1D75490D5091")
    @Override
    public void start() {
        start(false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.537 -0400", hash_original_method = "5EC046ABFAD295E5D2C88DB1426702CD", hash_generated_method = "14832CD21DEAFA14199F64C586BF729E")
    @Override
    public void cancel() {
    if(mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this))        
        {
    if(mRunning && mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
for(AnimatorListener listener : tmpListeners)
                {
                    listener.onAnimationCancel(this);
                } 
            } 
            endAnimation();
        } 
        
        
                
            
                
                        
                
                    
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.540 -0400", hash_original_method = "55C31F194BE33B60E19FAC66D36F0F3B", hash_generated_method = "3CEA854E15F475C7E2DA87F0F63E851A")
    @Override
    public void end() {
    if(!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this))        
        {
            mStartedDelay = false;
            startAnimation();
        } 
        else
    if(!mInitialized)        
        {
            initAnimation();
        } 
    if(mRepeatCount > 0 && (mRepeatCount & 0x01) == 1)        
        {
            animateValue(0f);
        } 
        else
        {
            animateValue(1f);
        } 
        endAnimation();
        
        
            
            
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.547 -0400", hash_original_method = "80FBC5A625B4BAB80C578CF39CB5DA5B", hash_generated_method = "D90ED6A8203CD77FC4D67FB2F23E1CC0")
    @Override
    public boolean isRunning() {
        boolean varE27E27F5F002F0FDCE1EB5428F097D74_1580465969 = ((mPlayingState == RUNNING || mRunning));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677103720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677103720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.550 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "FFDE914DD26B049860283DBE9F34BC3C")
    @Override
    public boolean isStarted() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_140953005 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_751430076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_751430076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.555 -0400", hash_original_method = "45B2842BAB0EB46941DD63C0EA48CBA2", hash_generated_method = "B3BFE4AA1FB6781B8FB37B94ACB7BFCD")
    public void reverse() {
        mPlayingBackwards = !mPlayingBackwards;
    if(mPlayingState == RUNNING)        
        {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            long currentPlayTime = currentTime - mStartTime;
            long timeLeft = mDuration - currentPlayTime;
            mStartTime = currentTime - timeLeft;
        } 
        else
        {
            start(true);
        } 
        
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.560 -0400", hash_original_method = "634DE70818167FA9FFDD8CDDE693BD3B", hash_generated_method = "4D46B15480B7C7634D8BC9E980BB3039")
    private void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        mPlayingState = STOPPED;
    if(mRunning && mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationEnd(this);
            } 
        } 
        mRunning = false;
        mStarted = false;
        
        
        
        
        
        
            
                    
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.563 -0400", hash_original_method = "45B9B57EC5A2CFD523C0E84592BD9EAC", hash_generated_method = "4F59FA0AFF03E77C61AD689FEB69C3B8")
    private void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
    if(mStartDelay > 0 && mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationStart(this);
            } 
        } 
        
        
        
        
            
                    
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.571 -0400", hash_original_method = "33DF90BAA846BB88E01B9C85165D068C", hash_generated_method = "3D81F9FA4E321CD778B1B1D3EE9C1A7C")
    private boolean delayedAnimationFrame(long currentTime) {
    if(!mStartedDelay)        
        {
            mStartedDelay = true;
            mDelayStartTime = currentTime;
        } 
        else
        {
            long deltaTime = currentTime - mDelayStartTime;
    if(deltaTime > mStartDelay)            
            {
                mStartTime = currentTime - (deltaTime - mStartDelay);
                mPlayingState = RUNNING;
                boolean varB326B5062B2F0E69046810717534CB09_1104652872 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741007903 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_741007903;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1360145533 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655112361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655112361;
        
        
            
            
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.579 -0400", hash_original_method = "101420F61878798EE86197F974BCAB89", hash_generated_method = "50D18611BAB525284DB9EE642C70EC53")
     boolean animationFrame(long currentTime) {
        boolean done = false;
    if(mPlayingState == STOPPED)        
        {
            mPlayingState = RUNNING;
    if(mSeekTime < 0)            
            {
                mStartTime = currentTime;
            } 
            else
            {
                mStartTime = currentTime - mSeekTime;
                mSeekTime = -1;
            } 
        } 
switch(mPlayingState){
        case RUNNING:
        case SEEKED:
        float fraction = mDuration > 0 ? (float)(currentTime - mStartTime) / mDuration : 1f;
    if(fraction >= 1f)        
        {
    if(mCurrentIteration < mRepeatCount || mRepeatCount == INFINITE)            
            {
    if(mListeners != null)                
                {
                    int numListeners = mListeners.size();
for(int i = 0;i < numListeners;++i)
                    {
                        mListeners.get(i).onAnimationRepeat(this);
                    } 
                } 
    if(mRepeatMode == REVERSE)                
                {
                    mPlayingBackwards = mPlayingBackwards ? false : true;
                } 
                mCurrentIteration += (int)fraction;
                fraction = fraction % 1f;
                mStartTime += mDuration;
            } 
            else
            {
                done = true;
                fraction = Math.min(fraction, 1.0f);
            } 
        } 
    if(mPlayingBackwards)        
        {
            fraction = 1f - fraction;
        } 
        animateValue(fraction);
        break;
}        boolean var6B2DED51D81A4403D8A4BD25FA1E57EE_1457354640 = (done);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_100928421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_100928421;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.582 -0400", hash_original_method = "7C3735DD08F0E37DA76BAA97A1C3802E", hash_generated_method = "1B6418DFAD62C51F5C1C9E6F4C617EF8")
    public float getAnimatedFraction() {
        float var5F20A1465612BD819887B170448FB3F7_34008341 = (mCurrentFraction);
                float var546ADE640B6EDFBC8A086EF31347E768_2008122308 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2008122308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.587 -0400", hash_original_method = "64FBD5BD2598ED0D273DFF76320B41E6", hash_generated_method = "FB36DCFD773AFE8A9379BFE836403D00")
     void animateValue(float fraction) {
        fraction = mInterpolator.getInterpolation(fraction);
        mCurrentFraction = fraction;
        int numValues = mValues.length;
for(int i = 0;i < numValues;++i)
        {
            mValues[i].calculateValue(fraction);
        } 
    if(mUpdateListeners != null)        
        {
            int numListeners = mUpdateListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                mUpdateListeners.get(i).onAnimationUpdate(this);
            } 
        } 
        
        
        
        
        
            
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.598 -0400", hash_original_method = "E24942BE7DE3A089D4AA1F8054FFC13E", hash_generated_method = "345127B5ED5779A73748518A3A1534E7")
    @Override
    public ValueAnimator clone() {
        final ValueAnimator anim = (ValueAnimator) super.clone();
    if(mUpdateListeners != null)        
        {
            ArrayList<AnimatorUpdateListener> oldListeners = mUpdateListeners;
            anim.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
            int numListeners = oldListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                anim.mUpdateListeners.add(oldListeners.get(i));
            } 
        } 
        anim.mSeekTime = -1;
        anim.mPlayingBackwards = false;
        anim.mCurrentIteration = 0;
        anim.mInitialized = false;
        anim.mPlayingState = STOPPED;
        anim.mStartedDelay = false;
        PropertyValuesHolder[] oldValues = mValues;
    if(oldValues != null)        
        {
            int numValues = oldValues.length;
            anim.mValues = new PropertyValuesHolder[numValues];
            anim.mValuesMap = new HashMap<String, PropertyValuesHolder>(numValues);
for(int i = 0;i < numValues;++i)
            {
                PropertyValuesHolder newValuesHolder = oldValues[i].clone();
                anim.mValues[i] = newValuesHolder;
                anim.mValuesMap.put(newValuesHolder.getPropertyName(), newValuesHolder);
            } 
        } 
ValueAnimator var6E2178F33F884BED37C5DEBCD18F9A96_594407949 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_594407949.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_594407949;
        
        
    }

    
        public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    
        public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.603 -0400", hash_original_method = "533F41B1624628F4A2CEF95F44B8AA6B", hash_generated_method = "631865ECCD318BCDE0FAC4A55BF85E46")
    @Override
    public String toString() {
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
    if(mValues != null)        
        {
for(int i = 0;i < mValues.length;++i)
            {
                returnVal += "\n    " + mValues[i].toString();
            } 
        } 
String var74D8482D05AF02514EABC315066E6806_894764978 =         returnVal;
        var74D8482D05AF02514EABC315066E6806_894764978.addTaint(taint);
        return var74D8482D05AF02514EABC315066E6806_894764978;
        
        
        
            
                
            
        
        
    }

    
    private static class AnimationHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.604 -0400", hash_original_method = "2DEE4CFD7471B34E056063BEAD8FACC4", hash_generated_method = "2DEE4CFD7471B34E056063BEAD8FACC4")
        public AnimationHandler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.609 -0400", hash_original_method = "52F201F0F7E1BD7680ACD711BB668600", hash_generated_method = "3B1FDE5ACEB670FE3D2CAAF47833AF64")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            boolean callAgain = true;
            ArrayList<ValueAnimator> animations = sAnimations.get();
            ArrayList<ValueAnimator> delayedAnims = sDelayedAnims.get();
switch(msg.what){
            case ANIMATION_START:
            ArrayList<ValueAnimator> pendingAnimations = sPendingAnimations.get();
    if(animations.size() > 0 || delayedAnims.size() > 0)            
            {
                callAgain = false;
            } 
            while
(pendingAnimations.size() > 0)            
            {
                ArrayList<ValueAnimator> pendingCopy = (ArrayList<ValueAnimator>) pendingAnimations.clone();
                pendingAnimations.clear();
                int count = pendingCopy.size();
for(int i = 0;i < count;++i)
                {
                    ValueAnimator anim = pendingCopy.get(i);
    if(anim.mStartDelay == 0)                    
                    {
                        anim.startAnimation();
                    } 
                    else
                    {
                        delayedAnims.add(anim);
                    } 
                } 
            } 
            case ANIMATION_FRAME:
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            ArrayList<ValueAnimator> readyAnims = sReadyAnims.get();
            ArrayList<ValueAnimator> endingAnims = sEndingAnims.get();
            int numDelayedAnims = delayedAnims.size();
for(int i = 0;i < numDelayedAnims;++i)
            {
                ValueAnimator anim = delayedAnims.get(i);
    if(anim.delayedAnimationFrame(currentTime))                
                {
                    readyAnims.add(anim);
                } 
            } 
            int numReadyAnims = readyAnims.size();
    if(numReadyAnims > 0)            
            {
for(int i = 0;i < numReadyAnims;++i)
                {
                    ValueAnimator anim = readyAnims.get(i);
                    anim.startAnimation();
                    anim.mRunning = true;
                    delayedAnims.remove(anim);
                } 
                readyAnims.clear();
            } 
            int numAnims = animations.size();
            int i = 0;
            while
(i < numAnims)            
            {
                ValueAnimator anim = animations.get(i);
    if(anim.animationFrame(currentTime))                
                {
                    endingAnims.add(anim);
                } 
    if(animations.size() == numAnims)                
                {
                    ++i;
                } 
                else
                {
                    --numAnims;
                    endingAnims.remove(anim);
                } 
            } 
    if(endingAnims.size() > 0)            
            {
for(i = 0;i < endingAnims.size();++i)
                {
                    endingAnims.get(i).endAnimation();
                } 
                endingAnims.clear();
            } 
    if(callAgain && (!animations.isEmpty() || !delayedAnims.isEmpty()))            
            {
                sendEmptyMessageDelayed(ANIMATION_FRAME, Math.max(0, sFrameDelay -
                            (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
            } 
            break;
}
            
            
        }

        
    }


    
    public static interface AnimatorUpdateListener {
        
        void onAnimationUpdate(ValueAnimator animation);

    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.611 -0400", hash_original_field = "19C300A967EA25F9D559F955E00792C9", hash_generated_field = "7F6E8414A42B0168ECE0452ABB40B4B9")

    private static final long DEFAULT_FRAME_DELAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.613 -0400", hash_original_field = "0D7E68A8285D57CCE4D86E51B69846C6", hash_generated_field = "B6DA4DB1E039ECF48740CF743117C6A2")

    static final int ANIMATION_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.614 -0400", hash_original_field = "E6CA3E401C4A7A7E6AF52E70B57FDFB1", hash_generated_field = "0D77E46A646010DDC0F6082111BE5EAF")

    static final int ANIMATION_FRAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.615 -0400", hash_original_field = "94992C68B07F926E36FA460B8902EACC", hash_generated_field = "689C0CFD849BED6433C2577D385AF415")

    static final int STOPPED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.617 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "8330C184A03CB39DDF37800BA8B3C69E")

    static final int RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.619 -0400", hash_original_field = "0F6D75AE6BB844EFE3A8E4551071CD49", hash_generated_field = "FA3F6B2AADC08540A334E2962EC190BC")

    static final int SEEKED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.621 -0400", hash_original_field = "B4A7D055BAB8301E2C8667A28C9D013B", hash_generated_field = "298BE37EE0C7369286A3ABAA61580A61")

    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<AnimationHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_field = "3C37B16155D9D4A0309FE675F3A94C61", hash_generated_field = "F04351AD4592C7F63B7E9F5094FD300A")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.159 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "30984E86954B4487FB1FB1FDC9319F03")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_248712503 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_248712503 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_248712503.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_248712503;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_field = "3CAB4DC1D9F9A2C4E0E643C552FB8B5A", hash_generated_field = "1698E605B6DA07A41E58FD2F922706B0")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.161 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "4FF2FD37465665796C1B58FB56AB965F")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1102750751 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1102750751 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1102750751.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1102750751;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_field = "1ACEA9A643A2CAF5FE528C380BB8CF14", hash_generated_field = "EB1F31AE16C005A08187EF8034F10324")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.165 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "02005CDE0FB40562043DE6CBF2865DD9")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_750130945 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_750130945 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_750130945.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_750130945;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_field = "DE94AD3F45FD0B9D4CDA700DC5CD404B", hash_generated_field = "53E069A69435EAC1CC36D6839EADCA67")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.167 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "7346F25FDFB97A2663CECFE8F4D83A73")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1291337822 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1291337822 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1291337822.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1291337822;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.169 -0400", hash_original_field = "255441D2B8970E34EB230C059292860D", hash_generated_field = "D2EEA5B8BD4B8D7168D2B5C9CE01B11F")

    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:13.168 -0400", hash_original_method = "A1919B9D7E2CF94D5A8714BDB3972703", hash_generated_method = "1D39BB2D8E01B1E6514960600C7DFC2B")
        @Override
        protected ArrayList<ValueAnimator> initialValue() {
            ArrayList<ValueAnimator> varB4EAC82CA7396A68D541C85D26508E83_1528695003 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1528695003 = new ArrayList<ValueAnimator>();
            varB4EAC82CA7396A68D541C85D26508E83_1528695003.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1528695003;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.624 -0400", hash_original_field = "CAB4CFDA656A41124CB58DC84DFC5E60", hash_generated_field = "C580F5E9382C56D07696899D4103886B")

    private static final TimeInterpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.625 -0400", hash_original_field = "524C52C0A1E88CDA180A0F7AA6118606", hash_generated_field = "7E9EFDBC560251144B1ABA6A3E58FAA3")

    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.626 -0400", hash_original_field = "15DEFED28FFB599464BB68C200695E4F", hash_generated_field = "81564E463CF700876869857891E00106")

    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.626 -0400", hash_original_field = "645DD1C3FAB37420AA3AF59AEC271373", hash_generated_field = "B136BC014A7EC92E31D514350E48B057")

    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.627 -0400", hash_original_field = "5F06E0F5187ED0CBFC4EF9E7B4D64EDE", hash_generated_field = "9FE7B7E5ED52768DD1C53DC895EC1A0D")

    public static final int RESTART = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.628 -0400", hash_original_field = "6BAA62FAC35E1F188A65C74FED662C34", hash_generated_field = "6790E6439C0E7615743240DF9A7C010E")

    public static final int REVERSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:34.629 -0400", hash_original_field = "5E2F9BDAA8CE14DD954BF40FD55E2AF3", hash_generated_field = "285D35A4B336A34C53955AE44424AC64")

    public static final int INFINITE = -1;
}

