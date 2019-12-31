// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_cudastereo;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;

import static org.bytedeco.opencv.global.opencv_cudastereo.*;


/////////////////////////////////////////
// StereoBeliefPropagation

/** \brief Class computing stereo correspondence using the belief propagation algorithm. :
<p>
The class implements algorithm described in \cite Felzenszwalb2006 . It can compute own data cost
(using a truncated linear model) or use a user-provided data cost.
<p>
\note
   StereoBeliefPropagation requires a lot of memory for message storage:
    <p>
    <pre>{@code \[width \_ step  \cdot height  \cdot ndisp  \cdot 4  \cdot (1 + 0.25)\]}</pre>
    <p>
    and for data cost storage:
    <p>
    <pre>{@code \[width\_step \cdot height \cdot ndisp \cdot (1 + 0.25 + 0.0625 +  \dotsm + \frac{1}{4^{levels}})\]}</pre>
    <p>
    width_step is the number of bytes in a line including padding.
<p>
StereoBeliefPropagation uses a truncated linear model for the data cost and discontinuity terms:
<p>
<pre>{@code \[DataCost = data \_ weight  \cdot \min ( \lvert Img_Left(x,y)-Img_Right(x-d,y)  \rvert , max \_ data \_ term)\]}</pre>
<p>
<pre>{@code \[DiscTerm =  \min (disc \_ single \_ jump  \cdot \lvert f_1-f_2  \rvert , max \_ disc \_ term)\]}</pre>
<p>
For more details, see \cite Felzenszwalb2006 .
<p>
By default, StereoBeliefPropagation uses floating-point arithmetics and the CV_32FC1 type for
messages. But it can also use fixed-point arithmetics and the CV_16SC1 message type for better
performance. To avoid an overflow in this case, the parameters must satisfy the following
requirement:
<p>
<pre>{@code \[10  \cdot 2^{levels-1}  \cdot max \_ data \_ term < SHRT \_ MAX\]}</pre>
<p>
@see StereoMatcher
 */
@Namespace("cv::cuda") @Properties(inherit = org.bytedeco.opencv.presets.opencv_cudastereo.class)
public class StereoBeliefPropagation extends StereoMatcher {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StereoBeliefPropagation(Pointer p) { super(p); }


    /** \overload */
    public native void compute(@ByVal Mat left, @ByVal Mat right, @ByVal Mat disparity, @ByRef Stream stream);
    public native void compute(@ByVal UMat left, @ByVal UMat right, @ByVal UMat disparity, @ByRef Stream stream);
    public native void compute(@ByVal GpuMat left, @ByVal GpuMat right, @ByVal GpuMat disparity, @ByRef Stream stream);

    /** \brief Enables the stereo correspondence operator that finds the disparity for the specified data cost.
    <p>
    @param data User-specified data cost, a matrix of msg_type type and
    Size(\<image columns\>\*ndisp, \<image rows\>) size.
    @param disparity Output disparity map. If disparity is empty, the output type is CV_16SC1 .
    Otherwise, the type is retained. In 16-bit signed format, the disparity values do not have
    fractional bits.
    @param stream Stream for the asynchronous version.
     */
    public native void compute(@ByVal Mat data, @ByVal Mat disparity, @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal Mat data, @ByVal Mat disparity);
    public native void compute(@ByVal UMat data, @ByVal UMat disparity, @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal UMat data, @ByVal UMat disparity);
    public native void compute(@ByVal GpuMat data, @ByVal GpuMat disparity, @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal GpuMat data, @ByVal GpuMat disparity);

    /** number of BP iterations on each level */
    public native int getNumIters();
    public native void setNumIters(int iters);

    /** number of levels */
    public native int getNumLevels();
    public native void setNumLevels(int levels);

    /** truncation of data cost */
    public native double getMaxDataTerm();
    public native void setMaxDataTerm(double max_data_term);

    /** data weight */
    public native double getDataWeight();
    public native void setDataWeight(double data_weight);

    /** truncation of discontinuity cost */
    public native double getMaxDiscTerm();
    public native void setMaxDiscTerm(double max_disc_term);

    /** discontinuity single jump */
    public native double getDiscSingleJump();
    public native void setDiscSingleJump(double disc_single_jump);

    /** type for messages (CV_16SC1 or CV_32FC1) */
    public native int getMsgType();
    public native void setMsgType(int msg_type);

    /** \brief Uses a heuristic method to compute the recommended parameters ( ndisp, iters and levels ) for the
    specified image size ( width and height ).
     */
    public static native void estimateRecommendedParams(int width, int height, @ByRef IntPointer ndisp, @ByRef IntPointer iters, @ByRef IntPointer levels);
    public static native void estimateRecommendedParams(int width, int height, @ByRef IntBuffer ndisp, @ByRef IntBuffer iters, @ByRef IntBuffer levels);
    public static native void estimateRecommendedParams(int width, int height, @ByRef int[] ndisp, @ByRef int[] iters, @ByRef int[] levels);
}
