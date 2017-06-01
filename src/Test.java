import org.opencv.core.Core;

import com.reharu.opencv.OpencvImage;

public class Test {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		TemplateMaching maching = new TemplateMaching("imgs/homePage/") ;
//		maching.setSource("bai_lian.png");
//		maching.setDst("bai_lianA.png");
//		maching.process();
		OpencvImage src = new OpencvImage("imgs/homePage/fei_hong_b.png") ;
		OpencvImage dst = new OpencvImage("imgs/characters/fei_hong.png") ;
		System.out.println(src.getArea(dst));
	}
}
