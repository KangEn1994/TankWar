package version1.entity;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;


/*
 * @author uncleYiba
 * @describe 图片管理
 * @date 2018/01/25
 */
public class PicManager {
	//关联图片路径的map
	public static Map<String,String> terrainMap=new HashMap<String,String>();
	//关联编号的map
	public static Map<String,String> terrainMap2=new HashMap<String,String>();
	static{
		terrainMap.put("nothing","blackEach.jpg");//1
		terrainMap.put("grass","grassEach.jpg");//2
		terrainMap.put("home","home.jpg");//3
		terrainMap.put("ice","iceEach.jpg");//4
		terrainMap.put("mapEdit","mapEdit.png");//5
		terrainMap.put("river","riverEach.jpg");//6
		terrainMap.put("steel","steelEach.jpg");//7
		terrainMap.put("wodden","woddenEach.jpg");//8
		terrainMap.put("welcome","front.jpg");//9
		terrainMap.put("select1","selectTank.jpg");//10
		terrainMap.put("select2","selectTank2.jpg");//11
		terrainMap.put("homeAround","");//12
		
		terrainMap2.put("1","nothing");
		terrainMap2.put("2","grass");
		terrainMap2.put("3","home");
		terrainMap2.put("4","ice");
		terrainMap2.put("5","mapEdit");
		terrainMap2.put("6","river");
		terrainMap2.put("7","steel");
		terrainMap2.put("8","wodden");
		terrainMap2.put("9","welcome");
		terrainMap2.put("10","select1");
		terrainMap2.put("11","select2");
		terrainMap2.put("12","homeAround");
	}
	//地图编译器的地形展示顺序
	/* 00.黑        01.右木      02.下木     03.左木
	 * 04.上木    05.全木      06.右钢     07.下钢
	 * 08.左钢    09.上钢      10.全钢     11.河
	 * 12.草        13.冰
	 */
	//给某一个位置赋值某一种地形展示
	/*public static String[] getmapTwoTreeainByMapOneIndex(int index){
		String[] treeain=new String[4];
		switch (index){
			case 0://黑
				treeain[0]=GameMap.TWO_NOTHING;treeain[1]=GameMap.TWO_NOTHING;
				treeain[2]=GameMap.TWO_NOTHING;treeain[3]=GameMap.TWO_NOTHING;
				break;
			case 1://右木
				treeain[0]=GameMap.TWO_NOTHING;treeain[1]=GameMap.TWO_WODDEN;
				treeain[2]=GameMap.TWO_NOTHING;treeain[3]=GameMap.TWO_WODDEN;
				break;
			case 2://下木
				treeain[0]=GameMap.TWO_NOTHING;treeain[1]=GameMap.TWO_NOTHING;
				treeain[2]=GameMap.TWO_WODDEN;treeain[3]=GameMap.TWO_WODDEN;
				break;
			case 3://左木
				treeain[0]=GameMap.TWO_WODDEN;treeain[1]=GameMap.TWO_NOTHING;
				treeain[2]=GameMap.TWO_WODDEN;treeain[3]=GameMap.TWO_NOTHING;
				break;
			case 4://上木
				treeain[0]=GameMap.TWO_WODDEN;treeain[1]=GameMap.TWO_WODDEN;
				treeain[2]=GameMap.TWO_NOTHING;treeain[3]=GameMap.TWO_NOTHING;
				break;
			case 5://全木
				treeain[0]=GameMap.TWO_WODDEN;treeain[1]=GameMap.TWO_WODDEN;
				treeain[2]=GameMap.TWO_WODDEN;treeain[3]=GameMap.TWO_WODDEN;
				break;
			case 6://右钢
				treeain[0]=GameMap.TWO_NOTHING;treeain[1]=GameMap.TWO_STEEL;
				treeain[2]=GameMap.TWO_NOTHING;treeain[3]=GameMap.TWO_STEEL;
				break;
			case 7://下钢
				treeain[0]=GameMap.TWO_NOTHING;treeain[1]=GameMap.TWO_NOTHING;
				treeain[2]=GameMap.TWO_STEEL;treeain[3]=GameMap.TWO_STEEL;
				break;
			case 8://左钢
				treeain[0]=GameMap.TWO_STEEL;treeain[1]=GameMap.TWO_NOTHING;
				treeain[2]=GameMap.TWO_STEEL;treeain[3]=GameMap.TWO_NOTHING;
				break;
			case 9://上钢
				treeain[0]=GameMap.TWO_STEEL;treeain[1]=GameMap.TWO_STEEL;
				treeain[2]=GameMap.TWO_NOTHING;treeain[3]=GameMap.TWO_NOTHING;
				break;
			case 10://全钢
				treeain[0]=GameMap.TWO_STEEL;treeain[1]=GameMap.TWO_STEEL;
				treeain[2]=GameMap.TWO_STEEL;treeain[3]=GameMap.TWO_STEEL;
				break;
			case 11://河
				treeain[0]=GameMap.TWO_RIVER;treeain[1]=GameMap.TWO_RIVER;
				treeain[2]=GameMap.TWO_RIVER;treeain[3]=GameMap.TWO_RIVER;
				break;
			case 12://草
				treeain[0]=GameMap.TWO_GRASS;treeain[1]=GameMap.TWO_GRASS;
				treeain[2]=GameMap.TWO_GRASS;treeain[3]=GameMap.TWO_GRASS;
				break;
			case 13://冰
				treeain[0]=GameMap.TWO_ICE;treeain[1]=GameMap.TWO_ICE;
				treeain[2]=GameMap.TWO_ICE;treeain[3]=GameMap.TWO_ICE;
				break;
		}
		return treeain;
	}*/
	public static int getNextMapOneIndex(int index){
		index++;
		if (index==14){
			index=0;
		}
		return index;
	}
}
