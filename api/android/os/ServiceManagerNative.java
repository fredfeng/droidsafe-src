package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.586 -0400", hash_original_method = "9F01F56EAD98DCCF5588838D591C9215", hash_generated_method = "85C73BFA46F2172E7BBE49D58C0ED876")
    public  ServiceManagerNative() {
        attachInterface(this, descriptor);
        
        
    }

    
        static public IServiceManager asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IServiceManager in =
            (IServiceManager)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }
        return new ServiceManagerProxy(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.587 -0400", hash_original_method = "77391B19BF1D318FBD43A52170DD3D86", hash_generated_method = "99DC29E2348917D5DFF727EB45D9200B")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        try 
        {
switch(code){
            case IServiceManager.GET_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = getService(name);
                reply.writeStrongBinder(service);
                boolean varB326B5062B2F0E69046810717534CB09_1473875338 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971192109 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_971192109;
            } 
            case IServiceManager.CHECK_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = checkService(name);
                reply.writeStrongBinder(service);
                boolean varB326B5062B2F0E69046810717534CB09_1183576905 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676520155 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676520155;
            } 
            case IServiceManager.ADD_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = data.readStrongBinder();
                addService(name, service);
                boolean varB326B5062B2F0E69046810717534CB09_1196665419 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244795385 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_244795385;
            } 
            case IServiceManager.LIST_SERVICES_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String[] list = listServices();
                reply.writeStringArray(list);
                boolean varB326B5062B2F0E69046810717534CB09_1369340193 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670172369 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670172369;
            } 
            case IServiceManager.SET_PERMISSION_CONTROLLER_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                IPermissionController controller = IPermissionController.Stub.asInterface(
                                data.readStrongBinder());
                setPermissionController(controller);
                boolean varB326B5062B2F0E69046810717534CB09_1585661111 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453002976 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453002976;
            } 
}
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_153251968 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980743587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_980743587;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.588 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "909DA47A6E93E26B8C8B4AAA4CF9E502")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1204088105 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1204088105.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1204088105;
        
        
    }

    
}

class ServiceManagerProxy implements IServiceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.588 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.589 -0400", hash_original_method = "84032B28A83A581245FB022389F526C9", hash_generated_method = "9C93C75DE81E92FB068744B3E68A0310")
    public  ServiceManagerProxy(IBinder remote) {
        mRemote = remote;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.589 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "65C7437968AD34D5AE269BE3E5F8247B")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1238041937 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1238041937.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1238041937;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.590 -0400", hash_original_method = "02C17092CC4D0E934B4324BDE37272C4", hash_generated_method = "6CE10861B12392AFEA1EF6E2857563B0")
    public IBinder getService(String name) throws RemoteException {
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(GET_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
IBinder varE3C074C8A98249A08331B334269AEB91_1062963677 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1062963677.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1062963677;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.591 -0400", hash_original_method = "5C8E64034E0715CC0FF2A576ACC0AB5A", hash_generated_method = "5DEE7D8D48D9A73AA0540467DE18A95E")
    public IBinder checkService(String name) throws RemoteException {
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(CHECK_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
IBinder varE3C074C8A98249A08331B334269AEB91_874068531 =         binder;
        varE3C074C8A98249A08331B334269AEB91_874068531.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_874068531;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.591 -0400", hash_original_method = "5E591506D5DD50AD56DFCE9C7D5E988A", hash_generated_method = "3E3A623CDA01464FE8B3824D9E7CA1FC")
    public void addService(String name, IBinder service) throws RemoteException {
        addTaint(service.getTaint());
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        data.writeStrongBinder(service);
        mRemote.transact(ADD_SERVICE_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.592 -0400", hash_original_method = "FC27781B3E4C3CFB72E5AC6A897CA1D1", hash_generated_method = "2C55E9E4A2E11CE0583C98269A1D3706")
    public String[] listServices() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        mRemote.transact(LIST_SERVICES_TRANSACTION, data, reply, 0);
        String[] list = reply.readStringArray();
        reply.recycle();
        data.recycle();
String[] varED12C351C2E8CA4F85F097DDC7E77B4D_1191697422 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1191697422.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1191697422;
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.593 -0400", hash_original_method = "8A24F25196050E86CC22CCEE8401DF5F", hash_generated_method = "8AEB568954A68ABA39DE5824232BDB43")
    public void setPermissionController(IPermissionController controller) throws RemoteException {
        addTaint(controller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeStrongBinder(controller.asBinder());
        mRemote.transact(SET_PERMISSION_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
        
        
        
        
        
        
        
        
    }

    
}

