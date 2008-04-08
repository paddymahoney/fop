/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id: $ */

package org.apache.fop.render.afp.modca;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.fop.render.afp.modca.triplets.FullyQualifiedNameTriplet;
import org.apache.fop.render.afp.tools.BinaryUtils;

/**
 * The Map Data Resource structured field specifies resources that are
 * required for presentation.
 */
public class MapDataResource extends AbstractStructuredAFPObject {
    /**
     * Static default generated name reference
     */
    private static final String DEFAULT_NAME = "MDR00001";

    /**
     * Main constructor
     * @param obj a map data resource for a given structured AFP object
     */
    public MapDataResource(AbstractStructuredAFPObject obj) {
        String fqName = obj.getFullyQualifiedName();
        if (fqName != null) {
            super.setFullyQualifiedName(
                FullyQualifiedNameTriplet.TYPE_BEGIN_RESOURCE_OBJECT_REF,
                FullyQualifiedNameTriplet.FORMAT_CHARSTR, fqName);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void writeStart(OutputStream os) throws IOException {
        super.writeStart(os);
        
        // RGLength
        byte[] len = BinaryUtils.convert(8 + getTripletDataLength(), 2);
        byte[] data = new byte[] {
            0x5A, // Structured field identifier
            len[0], // Length byte 1
            len[1], // Length byte 2
            (byte) 0xD3, // Structured field id byte 1
            (byte) 0xAB, // Structured field id byte 2
            (byte) 0xC3, // Structured field id byte 3
            0x00, // Flags
            0x00, // Reserved
            0x00  // Reserved
        };
        os.write(data);
    }
}