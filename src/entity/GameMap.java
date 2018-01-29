package entity;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * @author uncleYiba
 * @describe 地图
 * @date 2018/01/25
 */
public class GameMap {
	public static String TWO_NOTHING="1";
	public static String TWO_GRASS="2";
	public static String TWO_HOME="3";
	public static String TWO_ICE="4";
	public static String TWO_MAP_EDIT="5";
	public static String TWO_RIVER="6";
	public static String TWO_STEEL="7";
	public static String TWO_WODDEN="8";
	public static String TWO_WELCOME="9";
	public static String TWO_SELECT1="10";
	public static String TWO_SELECT2="11";
	public static String TWO_HOME_AROUND="12";
	
	//一级地图，用于地图编辑
	private String[][] mapTypeOne=new String[13][13];
	//二级地图，用于地图编辑实际展示
	private String[][] mapTypeTwo=new String[26][26];
	//三级地图，用于实际作战地图
	private String[][] mapTypeThree=new String[26][52];
	
	//编辑MapOne用index
	private int index=0;
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String[][] getMapTypeTwo() {
		return mapTypeTwo;
	}
	public void setMapTypeTwo(String[][] mapTypeTwo) {
		this.mapTypeTwo = mapTypeTwo;
	}
	public String[][] getMapTypeThree() {
		return mapTypeThree;
	}
	public void setMapTypeThree(String[][] mapTypeThree) {
		this.mapTypeThree = mapTypeThree;
	}
	public GameMap() {
		for (int i=0;i<26;i++){
			for (int j=0;j<26;j++){
				mapTypeTwo[i][j]="1";
			}
		}
		for (int i=0;i<13;i++){
			for (int j=0;j<13;j++){
				mapTypeOne[i][j]="0";
			}
		}
		mapTypeOne[12][6]="14";
		createHome();
		index=0;
	}
	public void createHome(){
		mapTypeTwo[23][11]=GameMap.TWO_WODDEN;
		mapTypeTwo[23][12]=GameMap.TWO_WODDEN;
		mapTypeTwo[23][13]=GameMap.TWO_WODDEN;
		mapTypeTwo[23][14]=GameMap.TWO_WODDEN;
		mapTypeTwo[24][11]=GameMap.TWO_WODDEN;
		mapTypeTwo[25][11]=GameMap.TWO_WODDEN;
		mapTypeTwo[24][14]=GameMap.TWO_WODDEN;
		mapTypeTwo[25][14]=GameMap.TWO_WODDEN;
		mapTypeTwo[24][12]=GameMap.TWO_HOME;
		mapTypeTwo[24][13]=GameMap.TWO_HOME_AROUND;
		mapTypeTwo[25][12]=GameMap.TWO_HOME_AROUND;
		mapTypeTwo[25][13]=GameMap.TWO_HOME_AROUND;
	}
	public void setMapOneTerrain(int xLoca,int yLoca,int index){
		//System.out.println("x="+xLoca+",y="+yLoca+",index="+index);
		
		if (xLoca==12 && yLoca==6){
			xLoca=xLoca*2;yLoca=yLoca*2;
			mapTypeTwo[xLoca][yLoca]=GameMap.TWO_HOME;
			mapTypeTwo[xLoca+1][yLoca]=GameMap.TWO_HOME_AROUND;
			mapTypeTwo[xLoca][yLoca+1]=GameMap.TWO_HOME_AROUND;
			mapTypeTwo[xLoca+1][yLoca+1]=GameMap.TWO_HOME_AROUND;
		}else{
			mapTypeOne[xLoca][yLoca]=index+"";
			xLoca=xLoca*2;yLoca=yLoca*2;
			String[] terrain=Terrain.getmapTwoTreeainByMapOneIndex(index);
			mapTypeTwo[xLoca][yLoca]=terrain[0];
			mapTypeTwo[xLoca][yLoca+1]=terrain[1];
			mapTypeTwo[xLoca+1][yLoca]=terrain[2];
			mapTypeTwo[xLoca+1][yLoca+1]=terrain[3];
		}
	}
	public int getMapOneIndex(int xLoca,int yLoca){
		int n=Integer.parseInt(mapTypeOne[xLoca][yLoca]);
		//System.out.println("("+xLoca+","+yLoca+")位置的mapOne为"+n);
		
		
		
		return n;
	}
	
	
}
