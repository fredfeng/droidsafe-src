package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.Reader;
import org.xml.sax.SAXException;

public interface Scanner {

	

	public void scan(Reader r, ScanHandler h) throws IOException, SAXException;

	

	public void resetDocumentLocator(String publicid, String systemid);

	

	public void startCDATA();

	}
