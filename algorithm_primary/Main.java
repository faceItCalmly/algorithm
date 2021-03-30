import java.util.ArrayList;

//题目：迷宫
//X星球的一处迷宫游乐场建在某个小山坡上。
//它是由10x10相互连通的小房间组成的。
//房间的地板上写着一个很大的字母。
//我们假设玩家是面朝上坡的方向站立，则：
//L表示走到左边的房间，
//R表示走到右边的房间，
//U表示走到上坡方向的房间，
//D表示走到下坡方向的房间。
//
//X星球的居民有点懒，不愿意费力思考。
//他们更喜欢玩运气类的游戏。这个游戏也是如此！
//
//开始的时候，直升机把100名玩家放入一个个小房间内。
//玩家一定要按照地上的字母移动。
//
//迷宫地图如下：
//------------
//UDDLUULRUL
//UURLLLRRRU
//RRUURLDLRD
//RUDDDDUUUU
//URUDLLRRUU
//DURLRLDLRL
//ULLURLLRDU
//RDLULLRDDD
//UUDDUDUDLL
//ULRDLUURRR
//------------
//请你计算一下，最后，有多少玩家会走出迷宫?
//而不是在里边兜圈子。

//我这里用的是递归的方法，递归函数：从一点出发根据房间的字母决定走哪个方向，如果走出去（或者是走到已经为1的房间）就把刚才走过的房间都置为1表示可以走出去，如果走到之前就走过的房间
//（或者已经置为2的房间）就把刚才的路径都置为2表示走不出去。（没有走过的房间默认是3表示未探索）最后便利完之后根据房间为1的个数决定有几个人可以走出去

public class Main{
	static String[] data = new String[10];

	static int[][] result = new int[10][10];//用2表示这里走不出去，1表示这里可以走出去，3表示这里未知
	
	public static void main(String args[]){
		
		int n = 0;
	    data[0] = "UDDLUULRUL";
	    data[1] = "UURLLLRRRU";
	    data[2] = "RRUURLDLRD";
	    data[3] = "RUDDDDUUUU";
	    data[4] = "URUDLLRRUU";
	    data[5] = "DURLRLDLRL";
	    data[6] = "ULLURLLRDU";
	    data[7] = "RDLULLRDDD";
	    data[8] = "UUDDUDUDLL";
	    data[9] = "ULRDLUURRR";
		

		
		for (int i = 0;i < 10;i ++) {
			for(int j = 0;j < 10;j++) {
				result[i][j] = 3;
			}
		}
		
		for (int i = 0;i < 10;i ++) {
			for(int j = 0;j < 10;j++) {
				ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
				f(i,j,path);
			}
		}
		
		for(int i = 0 ;i < 10;i ++) {
			for(int j = 0;j < 10;j++) {
				if(result[i][j] == 1) {
					n++;
				}
			}
		}
		System.out.println(n);

	}
	
static void f(int i,int j,ArrayList<ArrayList<Integer>> path) {
	
	if(data[i].charAt(j) == 'U') {
		if(i != 0 ) {
			if(result[i][j] == 1) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 1;
				}
				return;
			}else if (result[i][j] == 2) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 2;
				}
				return;
			}else {
				for(int a = 0;a < path.size();a++) {
					if(path.get(a).get(0) == i && path.get(a).get(1) == j) {
						for(int k = 0;k < path.size();k++) {
							result[path.get(k).get(0)][path.get(k).get(1)] = 2;
						}
						return;
					}	
				}
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(j);
				path.add(list);
				f(i - 1, j, path);
			}
		}else {
			for(int k = 0;k < path.size();k++) {
				result[path.get(k).get(0)][path.get(k).get(1)] = 1;
			}
			result[i][j] = 1;
			return;
		}
		
	}else if (data[i].charAt(j) == 'D') {
		if(i != 9 ) {
			if(result[i][j] == 1) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 1;
				}
				return;
			}else if (result[i][j] == 2) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 2;
				}
				return;
			}else {
				for(int a = 0;a < path.size();a++) {
					if(path.get(a).get(0) == i && path.get(a).get(1) == j) {
						for(int k = 0;k < path.size();k++) {
							result[path.get(k).get(0)][path.get(k).get(1)] = 2;
						}
						return;
					}	
				}
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(j);
				path.add(list);
				f(i + 1, j, path);
			}
		}else {
			for(int k = 0;k < path.size();k++) {
				result[path.get(k).get(0)][path.get(k).get(1)] = 1;
			}
			result[i][j] = 1;
			return;
		}
		
	}else if (data[i].charAt(j) == 'L') {
		if(j != 0 ) {
			if(result[i][j] == 1) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 1;
				}
				return;
			}else if (result[i][j] == 2) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 2;
				}
				return;
			}else {
				for(int a = 0;a < path.size();a++) {
					if(path.get(a).get(0) == i && path.get(a).get(1) == j) {
						for(int k = 0;k < path.size();k++) {
							result[path.get(k).get(0)][path.get(k).get(1)] = 2;
						}
						return;
					}	
				}
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(j);
				path.add(list);
				f(i, j - 1, path);
			}
		}else {
			for(int k = 0;k < path.size();k++) {
				result[path.get(k).get(0)][path.get(k).get(1)] = 1;
			}
			result[i][j] = 1;
			return;
		}
		
	}else {
		if(j != 9 ) {
			if(result[i][j] == 1) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 1;
				}
				return;
			}else if (result[i][j] == 2) {
				for(int k = 0;k < path.size();k++) {
					result[path.get(k).get(0)][path.get(k).get(1)] = 2;
				}
				return;
			}else {
				for(int a = 0;a < path.size();a++) {
					if(path.get(a).get(0) == i && path.get(a).get(1) == j) {
						for(int k = 0;k < path.size();k++) {
							result[path.get(k).get(0)][path.get(k).get(1)] = 2;
						}
						return;
					}	
				}
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(j);
				path.add(list);
				f(i, j + 1, path);
			}
		}else {
			for(int k = 0;k < path.size();k++) {
				result[path.get(k).get(0)][path.get(k).get(1)] = 1;
			}
			result[i][j] = 1;
			return;
		}
		
	}
	
	
	
	
}
	
}


























