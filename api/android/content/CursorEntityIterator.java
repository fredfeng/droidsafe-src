package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;
import android.os.RemoteException;

public abstract class CursorEntityIterator implements EntityIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.150 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.150 -0400", hash_original_field = "42C51B2F76146A5EC92C9811D57ACF10", hash_generated_field = "A6BB6E42C38AE7C525A0832B55750D8F")

    private boolean mIsClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.151 -0400", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "B0CDFD30A5D8289392A197569989206F")
    public  CursorEntityIterator(Cursor cursor) {
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
        
        
        
        
    }

    
    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.152 -0400", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "951F0B6D32287F57132CBA7037CE2942")
    public final boolean hasNext() {
    if(mIsClosed)        
        {
            IllegalStateException var994C5FDCB689CD476D720223C1A2E97C_1392251958 = new IllegalStateException("calling hasNext() when the iterator is closed");
            var994C5FDCB689CD476D720223C1A2E97C_1392251958.addTaint(taint);
            throw var994C5FDCB689CD476D720223C1A2E97C_1392251958;
        } 
        boolean varA900E63D2652380A0AE5EC5450C680D1_907053977 = (!mCursor.isAfterLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743442562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743442562;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.153 -0400", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "44D4AC1BDEA2EE4D9AF5F0C05E83EEF6")
    public Entity next() {
    if(mIsClosed)        
        {
            IllegalStateException var12E76C3A9A7CEE219DB8C76087FF564B_656516136 = new IllegalStateException("calling next() when the iterator is closed");
            var12E76C3A9A7CEE219DB8C76087FF564B_656516136.addTaint(taint);
            throw var12E76C3A9A7CEE219DB8C76087FF564B_656516136;
        } 
    if(!hasNext())        
        {
            IllegalStateException varE20C7FA15E48B005588D91906DC67B5F_1350683974 = new IllegalStateException("you may only call next() if hasNext() is true");
            varE20C7FA15E48B005588D91906DC67B5F_1350683974.addTaint(taint);
            throw varE20C7FA15E48B005588D91906DC67B5F_1350683974;
        } 
        try 
        {
Entity var89A776ACF604CF5B8BF8FB402D39F0BE_476195013 =             getEntityAndIncrementCursor(mCursor);
            var89A776ACF604CF5B8BF8FB402D39F0BE_476195013.addTaint(taint);
            return var89A776ACF604CF5B8BF8FB402D39F0BE_476195013;
        } 
        catch (RemoteException e)
        {
            RuntimeException varA9C8EAB58C0973C3C3455840A2CBB98C_744357115 = new RuntimeException("caught a remote exception, this process will die soon", e);
            varA9C8EAB58C0973C3C3455840A2CBB98C_744357115.addTaint(taint);
            throw varA9C8EAB58C0973C3C3455840A2CBB98C_744357115;
        } 
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.154 -0400", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "EB7C1BC92835ED2AFADA70D51FAC1993")
    public void remove() {
        UnsupportedOperationException var3507AD2E5185A524A543CF22C0250BAC_113463133 = new UnsupportedOperationException("remove not supported by EntityIterators");
        var3507AD2E5185A524A543CF22C0250BAC_113463133.addTaint(taint);
        throw var3507AD2E5185A524A543CF22C0250BAC_113463133;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.154 -0400", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "688EED22A1F5FB9B134DB53FA840ED43")
    public final void reset() {
    if(mIsClosed)        
        {
            IllegalStateException var47A5740EFD7F765F130EF9990EDEC229_1405883229 = new IllegalStateException("calling reset() when the iterator is closed");
            var47A5740EFD7F765F130EF9990EDEC229_1405883229.addTaint(taint);
            throw var47A5740EFD7F765F130EF9990EDEC229_1405883229;
        } 
        mCursor.moveToFirst();
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.155 -0400", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "4EAE44561F6A9A4148F17AEFFAA1FF15")
    public final void close() {
    if(mIsClosed)        
        {
            IllegalStateException varC011F9740FCC2D0357D3F5533DD6D908_1771050521 = new IllegalStateException("closing when already closed");
            varC011F9740FCC2D0357D3F5533DD6D908_1771050521.addTaint(taint);
            throw varC011F9740FCC2D0357D3F5533DD6D908_1771050521;
        } 
        mIsClosed = true;
        mCursor.close();
        
        
            
        
        
        
    }

    
}

