// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tesseract;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.leptonica.*;
import static org.bytedeco.leptonica.global.lept.*;

import static org.bytedeco.tesseract.global.tesseract.*;

@Opaque @Properties(inherit = org.bytedeco.tesseract.presets.tesseract.class)
public class ParagraphModel extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public ParagraphModel() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ParagraphModel(Pointer p) { super(p); }
}
