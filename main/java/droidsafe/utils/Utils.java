package droidsafe.utils;

import java.io.File;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;

import soot.jimple.NewExpr;
import soot.jimple.internal.JNewExpr;

/**
 * Class to store general utility methods.
 * 
 * @author mgordon
 *
 */
public class Utils {
	
	/**
	 * Given a file name with separators, convert them in to . so it is a legal class
	 * name.
	 */
	public static String fromFileToClass(String name) {
		return name.substring(0, name.length() - 6).replace(File.separatorChar, '.');
	}
	
	 /**
     * Given a jarFile, return a list of the classes contained in the jarfile
     * with . replacing /.
     */
    public static List<String> getClassesFromJar(JarFile jarFile) {
    	LinkedList<String> classes = new LinkedList<String>();
    	Enumeration allEntries = jarFile.entries();
    	
        while (allEntries.hasMoreElements()) {
            JarEntry entry = (JarEntry) allEntries.nextElement();
            String   name  = entry.getName();
            if (!name.endsWith(".class")) {
                continue;
            }

            String clsName = name.substring(0, name.length() - 6).replace('/', '.');
            classes.add(clsName);
        }
        
        return classes;
    }
    
    /**
     * Log an error with the given logger and exit the application with status 1.
     */
    public static void ERROR_AND_EXIT(Logger logger, String str, Object... args) {
    	logger.error(str, args);
    	System.exit(1);
    }
    
    
}
