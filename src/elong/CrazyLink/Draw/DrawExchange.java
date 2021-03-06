/**********************************************************
 * 项目名称：山寨“爱消除”游戏7日教程
 * 作          者：郑敏新
 * 腾讯微博：SuperCube3D
 * 日          期：2013年10月
 * 声          明：版权所有   侵权必究
 * 本源代码供网友研究学习OpenGL ES开发Android应用用，
 * 请勿全部或部分用于商业用途
 ********************************************************/

package elong.CrazyLink.Draw;

import javax.microedition.khronos.opengles.GL10;
import elong.CrazyLink.CrazyLinkConstent;
import elong.CrazyLink.Control.CtlExchange;

public class DrawExchange {

	DrawAnimal drawAnimal;
	int mWitch1 = 0;
	int mWitch2 = 0;
	
	int mCol1 = 0;
	int mCol2 = 0;
	int mRow1 = 0;
	int mRow2 = 0;
	
	public CtlExchange control;			//动态控制效果
	
	public DrawExchange(DrawAnimal drawAnimal)
	{
		this.drawAnimal = drawAnimal;
		mWitch1 = 0;
		mWitch2 = 0;
		mCol1 = 0;
		mCol2 = 0;
		mRow1 = 0;
		mRow2 = 0;		
		control = new CtlExchange();
	}
	
	public void init(int witch1, int col1, int row1, int witch2, int col2, int row2)
	{
		mWitch1 = witch1;
		mWitch2 = witch2;
		mCol1 = col1;
		mCol2 = col2;
		mRow1 = row1;
		mRow2 = row2;		
		control.init(col1, row1, col2, row2);
	}
	
	public void draw(GL10 gl)
	{
		if(!control.isRun()) return;
		gl.glPushMatrix();		
		gl.glTranslatef(control.getX1()*CrazyLinkConstent.translateRatio, control.getY1()*CrazyLinkConstent.translateRatio, 0f);
		drawAnimal.draw(gl, mWitch1, mCol1, mRow1);
		gl.glPopMatrix();
		gl.glPushMatrix();		
		gl.glTranslatef(control.getX2()*CrazyLinkConstent.translateRatio, control.getY2()*CrazyLinkConstent.translateRatio, 0f);
		drawAnimal.draw(gl, mWitch2, mCol2, mRow2);
		gl.glPopMatrix();		
	}
}
