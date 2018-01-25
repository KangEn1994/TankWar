package entity;

import java.util.HashMap;
import java.util.Map;


/*
 * @author uncleYiba
 * @describe 地形
 * @date 2018/01/25
 */
public class Terrain {
	//关联图片路径的map
	public static Map<String,String> terrainMap=new HashMap<String,String>();
	//关联编号的map
	public static Map<String,String> terrainMap2=new HashMap<String,String>();
	static{
		terrainMap.put("nothing","blackEach.jpg");//1
		terrainMap.put("grass","grassEach.jpg");//2
		terrainMap.put("home","home.jpg");//3
		terrainMap.put("ice","iceEach.jpg");//4
		terrainMap.put("mapEdit","mapEdit.jpg");//5
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
}
