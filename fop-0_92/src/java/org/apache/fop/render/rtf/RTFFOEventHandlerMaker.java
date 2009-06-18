/*
 * Copyright 2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.rtf;

import java.io.OutputStream;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.fo.FOEventHandler;
import org.apache.fop.render.AbstractFOEventHandlerMaker;

/**
 * Maker class for RTF support.
 */
public class RTFFOEventHandlerMaker extends AbstractFOEventHandlerMaker {

    private static final String[] MIMES = new String[] {
        MimeConstants.MIME_RTF,
        MimeConstants.MIME_RTF_ALT1,
        MimeConstants.MIME_RTF_ALT2};
    
    
    /**
     * @see org.apache.fop.render.AbstractFOEventHandlerMaker
     * @param ua FOUserAgent
     * @param out OutputStream
     * @return created RTFHandler
     */
    public FOEventHandler makeFOEventHandler(FOUserAgent ua, OutputStream out) {
        return new RTFHandler(ua, out);
    }

    /**
     * @see org.apache.fop.render.AbstractFOEventHandlerMaker#needsOutputStream()
     * @return true, if an outputstream is needed
     */
    public boolean needsOutputStream() {
        return true;
    }

    /**
     * @see org.apache.fop.render.AbstractFOEventHandlerMaker#getSupportedMimeTypes()
     * @return array of MIME types
     */
    public String[] getSupportedMimeTypes() {
        return MIMES;
    }

}
