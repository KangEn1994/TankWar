package entity;

import java.util.HashMap;
import java.util.Map;


/*
 * @author uncleYiba
 * @describe 地形
 * @date 2018/01/25
 */
public class Terrain {
	public static Map<String,String> terrainMap=new HashMap<String,String>();
	static{
		terrainMap.put("nothing","blackEach.jpg");
		terrainMap.put("grass","grassEach.jpg");
		terrainMap.put("home","home.jpg");
		terrainMap.put("ice","iceEach.jpg");
		terrainMap.put("mapEdit","mapEdit.jpg");
		terrainMap.put("river","riverEach.jpg");
		terrainMap.put("steel","steelEach.jpg");
		terrainMap.put("wodden","woddenEach.jpg");
		terrainMap.put("welcome","front.jpg");
		terrainMap.put("select1","selectTank.jpg");
		terrainMap.put("select2","selectTank2.jpg");
	}
}
