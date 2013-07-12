package android.accessibilityservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface IAccessibilityServiceConnection extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.accessibilityservice.IAccessibilityServiceConnection
{
private static final java.lang.String DESCRIPTOR = "android.accessibilityservice.IAccessibilityServiceConnection";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.accessibilityservice.IAccessibilityServiceConnection asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.accessibilityservice.IAccessibilityServiceConnection))) {
return ((android.accessibilityservice.IAccessibilityServiceConnection)iin);
}
return new android.accessibilityservice.IAccessibilityServiceConnection.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setServiceInfo:
{
data.enforceInterface(DESCRIPTOR);
android.accessibilityservice.AccessibilityServiceInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.accessibilityservice.AccessibilityServiceInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.setServiceInfo(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByAccessibilityId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg3;
_arg3 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg4;
_arg4 = data.readLong();
float _result = this.findAccessibilityNodeInfoByAccessibilityId(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfosByViewText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg4;
_arg4 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg5;
_arg5 = data.readLong();
float _result = this.findAccessibilityNodeInfosByViewText(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg3;
_arg3 = data.readLong();
float _result = this.findAccessibilityNodeInfosByViewTextInActiveWindow(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg2;
_arg2 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg3;
_arg3 = data.readLong();
float _result = this.findAccessibilityNodeInfoByViewIdInActiveWindow(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeFloat(_result);
return true;
}
case TRANSACTION_performAccessibilityAction:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.view.accessibility.IAccessibilityInteractionConnectionCallback _arg4;
_arg4 = android.view.accessibility.IAccessibilityInteractionConnectionCallback.Stub.asInterface(data.readStrongBinder());
long _arg5;
_arg5 = data.readLong();
boolean _result = this.performAccessibilityAction(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.accessibilityservice.IAccessibilityServiceConnection
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setServiceInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}

public float findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByAccessibilityId, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public float findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityWindowId, int accessibilityViewId, int interractionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(interractionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfosByViewText, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public float findAccessibilityNodeInfosByViewTextInActiveWindow(java.lang.String text, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public float findAccessibilityNodeInfoByViewIdInActiveWindow(int viewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
float _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(viewId);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow, _data, _reply, 0);
_reply.readException();
_result = _reply.readFloat();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}

public boolean performAccessibilityAction(int accessibilityWindowId, int accessibilityViewId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(accessibilityWindowId);
_data.writeInt(accessibilityViewId);
_data.writeInt(action);
_data.writeInt(interactionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeLong(threadId);
mRemote.transact(Stub.TRANSACTION_performAccessibilityAction, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_setServiceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_findAccessibilityNodeInfoByAccessibilityId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_findAccessibilityNodeInfosByViewText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_findAccessibilityNodeInfosByViewTextInActiveWindow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_findAccessibilityNodeInfoByViewIdInActiveWindow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_performAccessibilityAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
public void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) throws android.os.RemoteException;

public float findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, int accessibilityViewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfosByViewText(java.lang.String text, int accessibilityWindowId, int accessibilityViewId, int interractionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfosByViewTextInActiveWindow(java.lang.String text, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public float findAccessibilityNodeInfoByViewIdInActiveWindow(int viewId, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;

public boolean performAccessibilityAction(int accessibilityWindowId, int accessibilityViewId, int action, int interactionId, android.view.accessibility.IAccessibilityInteractionConnectionCallback callback, long threadId) throws android.os.RemoteException;
}
