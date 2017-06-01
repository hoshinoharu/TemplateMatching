package com.reharu.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class OpencvImage {

	private String src;

	private Mat realImg;

	public OpencvImage(String src) {
		super();
		this.src = src;
		this.realImg = Imgcodecs.imread(src);
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Mat getRealImg() {
		return realImg;
	}

	public void setRealImg(Mat realImg) {
		this.realImg = realImg;
	}

	public int getRows() {
		return realImg == null ? -1 : realImg.rows();
	}

	public int getCols() {
		return realImg == null ? -1 : realImg.cols();
	}

	public double correlativeCompareTo(OpencvImage dstImg) {
		try {
			Mat src = this.realImg;
			Mat dst = dstImg.getRealImg();

			int rows = Math.max(this.getRows(), dstImg.getRows());
			int cols = Math.max(this.getCols(), dstImg.getCols());

			Mat tempSrc = new Mat();
			Mat tempDst = new Mat();

			// 去掉颜色只留下明暗 CV_GRAY2RGB
			Imgproc.cvtColor(src, tempSrc, Imgproc.COLOR_BGR2GRAY);
			Imgproc.cvtColor(dst, tempDst, Imgproc.COLOR_BGR2GRAY);

			// 转成32位深
			tempSrc.convertTo(tempSrc, CvType.CV_32F);
			tempDst.convertTo(tempDst, CvType.CV_32F);
			// 将对比目标放大缩小成源目标大小
			 Imgproc.resize(tempDst, tempDst, tempSrc.size());

			// 相关性比较
			return Imgproc.compareHist(tempSrc, tempDst, Imgproc.CV_COMP_CORREL);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Rect getArea(OpencvImage dstImg) {
		Rect rect = new Rect(-1, -1, dstImg.getCols(), dstImg.getRows());
		try {
			Mat src = this.realImg;
			Mat dst = dstImg.getRealImg();
			
			Mat tempSrc = new Mat();
			Mat tempDst = new Mat();
			
			// 去掉颜色只留下明暗 CV_GRAY2RGB CV_RGB2GRAY
			Imgproc.cvtColor(src, tempSrc, Imgproc.COLOR_RGB2GRAY);
			Imgproc.cvtColor(dst, tempDst, Imgproc.COLOR_BGR2GRAY);
			
			// 创建于原图相同的大小，储存匹配度
			Mat result = Mat.zeros(src.rows(), src.cols(), CvType.CV_32F);

			
			// 调用模板匹配
			Imgproc.matchTemplate(tempSrc, tempDst, result, Imgproc.TM_SQDIFF);
			
			// 规格化
//			Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1);

			// 获得最可能点，MinMaxLocResult是其数据格式，包括了最大、最小点的位置x、y
			MinMaxLocResult mlr = Core.minMaxLoc(result) ;
			Point matchLoc = mlr.minLoc;
			rect.x = (int) matchLoc.x ;
			rect.y = (int) matchLoc.y ;
//			 rectangle(img,matchLoc,Point(matchLoc.x+tmpl.cols,matchLoc.y+tmpl.rows),Scalar::all(0),2,8,0);  
//			    rectangle( result, matchLoc, Point( matchLoc.x + tmpl.cols , matchLoc.y + tmpl.rows ), Scalar::all(0), 2, 8, 0 );  
			// 在原图上的对应模板可能位置画一个绿色矩形
			Imgproc.rectangle(tempSrc, matchLoc, new Point(matchLoc.x + tempDst.cols(), matchLoc.y + tempDst.rows()),
					new Scalar(0, 255, 0));
			Imgproc.rectangle(result, matchLoc, new Point(matchLoc.x + tempDst.cols(), matchLoc.y + tempDst.rows()),
					new Scalar(0, 255, 0));
			// 将结果输出到对应位置
			Imgcodecs.imwrite("src.png", tempSrc);
			Imgcodecs.imwrite("res.png", result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rect;
	}
	

}
