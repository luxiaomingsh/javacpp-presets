// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_cudaoptflow;

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
import org.bytedeco.opencv.opencv_objdetect.*;
import static org.bytedeco.opencv.global.opencv_objdetect.*;
import org.bytedeco.opencv.opencv_ximgproc.*;
import static org.bytedeco.opencv.global.opencv_ximgproc.*;
import org.bytedeco.opencv.opencv_video.*;
import static org.bytedeco.opencv.global.opencv_video.*;
import org.bytedeco.opencv.opencv_optflow.*;
import static org.bytedeco.opencv.global.opencv_optflow.*;
import org.bytedeco.opencv.opencv_cudaarithm.*;
import static org.bytedeco.opencv.global.opencv_cudaarithm.*;
import org.bytedeco.opencv.opencv_cudafilters.*;
import static org.bytedeco.opencv.global.opencv_cudafilters.*;
import org.bytedeco.opencv.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudawarping.*;

import static org.bytedeco.opencv.global.opencv_cudaoptflow.*;


//
// NvidiaOpticalFlow
//

/** \brief Class for computing the optical flow vectors between two images using NVIDIA Optical Flow hardware and Optical Flow SDK 1.0.
\note
- A sample application demonstrating the use of NVIDIA Optical Flow can be found at
opencv_source_code/samples/gpu/nvidia_optical_flow.cpp
- An example application comparing accuracy and performance of NVIDIA Optical Flow with other optical flow algorithms in OpenCV can be found at
opencv_source_code/samples/gpu/optical_flow.cpp
*/

@Namespace("cv::cuda") @Properties(inherit = org.bytedeco.opencv.presets.opencv_cudaoptflow.class)
public class NvidiaOpticalFlow_1_0 extends NvidiaHWOpticalFlow {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NvidiaOpticalFlow_1_0(Pointer p) { super(p); }

    /**
    * Supported optical flow performance levels.
    */
    /** enum cv::cuda::NvidiaOpticalFlow_1_0::NVIDIA_OF_PERF_LEVEL */
    public static final int
        NV_OF_PERF_LEVEL_UNDEFINED = 0,
        /** Slow perf level results in lowest performance and best quality */
        NV_OF_PERF_LEVEL_SLOW = 5,
        /** Medium perf level results in low performance and medium quality */
        NV_OF_PERF_LEVEL_MEDIUM = 10,
        /** Fast perf level results in high performance and low quality */
        NV_OF_PERF_LEVEL_FAST = 20,
        NV_OF_PERF_LEVEL_MAX = 21;

    /** \brief The NVIDIA optical flow hardware generates flow vectors at granularity gridSize, which can be queried via function getGridSize().
    * Upsampler() helper function converts the hardware-generated flow vectors to dense representation (1 flow vector for each pixel)
    * using nearest neighbour upsampling method.
    <p>
    @param flow Buffer of type CV_16FC2 containing flow vectors generated by calc().
    @param width Width of the input image in pixels for which these flow vectors were generated.
    @param height Height of the input image in pixels for which these flow vectors were generated.
    @param gridSize Granularity of the optical flow vectors returned by calc() function. Can be queried using getGridSize().
    @param upsampledFlow Buffer of type CV_32FC2, containing upsampled flow vectors, each flow vector for 1 pixel, in the pitch-linear layout.
    */
    public native void upSampler(@ByVal Mat flow, int width, int height,
            int gridSize, @ByVal Mat upsampledFlow);
    public native void upSampler(@ByVal UMat flow, int width, int height,
            int gridSize, @ByVal UMat upsampledFlow);
    public native void upSampler(@ByVal GpuMat flow, int width, int height,
            int gridSize, @ByVal GpuMat upsampledFlow);

    /** \brief Instantiate NVIDIA Optical Flow
    <p>
    @param width Width of input image in pixels.
    @param height Height of input image in pixels.
    @param perfPreset Optional parameter. Refer [NV OF SDK documentation](https://developer.nvidia.com/opticalflow-sdk) for details about presets.
                      Defaults to NV_OF_PERF_LEVEL_SLOW.
    @param enableTemporalHints Optional parameter. Flag to enable temporal hints. When set to true, the hardware uses the flow vectors
                               generated in previous call to calc() as internal hints for the current call to calc().
                               Useful when computing flow vectors between successive video frames. Defaults to false.
    @param enableExternalHints Optional Parameter. Flag to enable passing external hints buffer to calc(). Defaults to false.
    @param enableCostBuffer Optional Parameter. Flag to enable cost buffer output from calc(). Defaults to false.
    @param gpuId Optional parameter to select the GPU ID on which the optical flow should be computed. Useful in multi-GPU systems. Defaults to 0.
    */
    public static native @Ptr NvidiaOpticalFlow_1_0 create(
            int width,
            int height,
            @Cast("cv::cuda::NvidiaOpticalFlow_1_0::NVIDIA_OF_PERF_LEVEL") int perfPreset/*=cv::cuda::NvidiaOpticalFlow_1_0::NVIDIA_OF_PERF_LEVEL::NV_OF_PERF_LEVEL_SLOW*/,
            @Cast("bool") boolean enableTemporalHints/*=false*/,
            @Cast("bool") boolean enableExternalHints/*=false*/,
            @Cast("bool") boolean enableCostBuffer/*=false*/,
            int gpuId/*=0*/);
    public static native @Ptr NvidiaOpticalFlow_1_0 create(
            int width,
            int height);
}
