import org.opencv.core.Core;

public class Test {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		TemplateMaching maching = new TemplateMaching() ;
		maching.setSource("timg.jpg");
		maching.setDst("timgA.jpg");
		maching.process();
	}
}
