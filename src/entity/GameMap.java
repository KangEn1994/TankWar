package entity;

/*
 * @author uncleYiba
 * @describe 地图
 * @date 2018/01/25
 */
public class GameMap {
	public static String NOTHING="1";
	public static String GRASS="2";
	public static String HOME="3";
	public static String ICE="4";
	public static String MAP_EDIT="5";
	public static String RIVER="6";
	public static String STEEL="7";
	public static String WODDEN="8";
	public static String WELCOME="9";
	public static String SELECT1="10";
	public static String SELECT2="11";
	public static String HOME_AROUND="12";
	
	private String[][] mapType=new String[26][26];

	public String[][] getMapType() {
		return mapType;
	}

	public void setMapType(String[][] mapType) {
		this.mapType = mapType;
	}

	public GameMap() {
		for (int i=0;i<26;i++){
			for (int j=0;j<26;j++){
				mapType[i][j]="1";
			}
		}
		createHome();
	}
	public void createHome(){
		mapType[23][11]=GameMap.WODDEN;
		mapType[23][12]=GameMap.WODDEN;
		mapType[23][13]=GameMap.WODDEN;
		mapType[23][14]=GameMap.WODDEN;
		mapType[24][11]=GameMap.WODDEN;
		mapType[25][11]=GameMap.WODDEN;
		mapType[24][14]=GameMap.WODDEN;
		mapType[25][14]=GameMap.WODDEN;
		mapType[24][12]=GameMap.HOME;
		mapType[24][13]=GameMap.HOME_AROUND;
		mapType[25][12]=GameMap.HOME_AROUND;
		mapType[25][13]=GameMap.HOME_AROUND;
	}
	
	
}
