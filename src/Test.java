import org.opencv.core.Core;

import com.reharu.robitic.robot.Robot;
import com.reharu.robitic.robot.task.HomepageTask;
import com.reharu.robitic.robot.task.Task;
import com.reharu.robotic.opencv.OpencvImage;
import com.reharu.robotic.vo.Role;
import com.reharu.robotic.vo.Scene;

public class Test {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Robot robot = new Robot() ;
		robot.homepageTrain(
				new HomepageTask(new Scene("白练主页","imgs/scenes/bailian.png"),new Role("白练主页人物", "imgs/widgets/bailian.png"))
				,new HomepageTask(new Scene("绯红主页","imgs/scenes/feihong.png"),new Role("绯红主页人物", "imgs/widgets/feihong.png"))
				,new HomepageTask(new Scene("鬼铠主页","imgs/scenes/guikai.png"),new Role("鬼铠主页人物", "imgs/widgets/guikai.png"))
				,new HomepageTask(new Scene("疾风主页","imgs/scenes/jifeng.png"),new Role("疾风主页人物", "imgs/widgets/jifeng.png"))
				,new HomepageTask(new Scene("凯旋主页","imgs/scenes/kaixuan.png"),new Role("凯旋主页人物", "imgs/widgets/kaixuan.png"))
				,new HomepageTask(new Scene("强袭主页","imgs/scenes/qiangxi.png"),new Role("强袭主页人物", "imgs/widgets/qiangxi.png"))
				,new HomepageTask(new Scene("圣女主页","imgs/scenes/shengnu.png"),new Role("圣女主页人物", "imgs/widgets/shengnu.png"))
				,new HomepageTask(new Scene("影舞主页","imgs/scenes/yingwu.png"),new Role("影舞主页人物", "imgs/widgets/yingwu.png"))
				,new HomepageTask(new Scene("战车主页","imgs/scenes/zhanche.png"),new Role("战车主页人物", "imgs/widgets/zhanche.png"))
				,new HomepageTask(new Scene("游侠主页","imgs/scenes/youxia.png"),new Role("游侠主页人物", "imgs/widgets/youxia.png"))
				,new HomepageTask(new Scene("深红主页","imgs/scenes/shenhong.png"),new Role("深红主页人物", "imgs/widgets/shenhong.png"))
				,new HomepageTask(new Scene("山吹主页","imgs/scenes/shanchui.png"),new Role("山吹主页人物", "imgs/widgets/shanchui.png"))
							);
	}
}
