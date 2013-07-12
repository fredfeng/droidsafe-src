package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.InetAddress;

public final class StructGroupReq {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.940 -0400", hash_original_field = "58BB6CEF7E5B3002DB833E8A83DC0440", hash_generated_field = "A455D75F586868F1FEF5A4B336E5E17D")

    public int gr_interface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.940 -0400", hash_original_field = "42B32413A950F02842364B7D18771792", hash_generated_field = "EF4F7D94FD71F04B44672F9CF0D0F3A0")

    public InetAddress gr_group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.940 -0400", hash_original_method = "4D71F3877768E92734212FD10E1F3346", hash_generated_method = "5AF7044220FB4FCA67A8D725E0E8AA92")
    public  StructGroupReq(int gr_interface, InetAddress gr_group) {
        this.gr_interface = gr_interface;
        this.gr_group = gr_group;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.941 -0400", hash_original_method = "7C7A6CFDA39E9F15601C4EC14F339026", hash_generated_method = "82252F4BF0F77B4BE93B82AAE7EAC942")
    @Override
    public String toString() {
String varC22313FE41AB4DFD72436E790656802F_1467771974 =         "StructGroupReq[gr_interface=" + gr_interface + ",gr_group=" + gr_group + "]";
        varC22313FE41AB4DFD72436E790656802F_1467771974.addTaint(taint);
        return varC22313FE41AB4DFD72436E790656802F_1467771974;
        
        
    }

    
}

