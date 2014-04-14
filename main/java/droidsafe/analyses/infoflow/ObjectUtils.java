package droidsafe.analyses.infoflow;

import java.util.HashSet;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

import droidsafe.main.Config;

public class ObjectUtils {
    private static ObjectUtils v;

    public static void run() {
        v = new ObjectUtils();
    }

    public static ObjectUtils v() {
        return v;
    }

    SootField taint;
    Set<SootMethod> addTaints;
    Set<SootMethod> getTaints;
    Set<SootMethod> toTaints;

    private ObjectUtils() {
        SootClass klass = Scene.v().getSootClass("java.lang.Object");
        if (Config.v().strict) {
            assert klass != null;
        }
        taint = klass.getFieldByName("taint");
        if (Config.v().strict) {
            assert taint != null;
        }
        addTaints = new HashSet<SootMethod>();
        getTaints = new HashSet<SootMethod>();
        toTaints = new HashSet<SootMethod>();
        for (SootMethod method : klass.getMethods()) {
            if (method.getName().startsWith("addTaint")) {
                addTaints.add(method);
            } else if (method.getName().startsWith("getTaint")) {
                getTaints.add(method);
            } else if (method.getName().startsWith("toTaint")) {
                toTaints.add(method);
            }
        }
    }

    public boolean isAddTaint(SootMethod method) {
        return addTaints.contains(method);
    }

    public boolean isGetTaint(SootMethod method) {
        return getTaints.contains(method);
    }

    public boolean isToTaint(SootMethod method) {
        return toTaints.contains(method);
    }
}
