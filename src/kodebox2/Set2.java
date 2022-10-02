package kodebox2;

import java.util.*;
import java.io.*;

public class Set2 {

	// 반환할 값을 선언한다.
	static int returnValue = 0;
	static int[] parent;
	static ArrayList<Tunel> tunelList = new ArrayList<Tunel>();
	static ArrayList<Planet> planetList = new ArrayList<Planet>();

	public static void main(String[] args) throws Exception {
		// 파라매터를 읽어온다.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// 첫번째 파라매터를 가져온다(행성 개수)
		int intInputPlanetSize = Integer.parseInt(bufferedReader.readLine());
		// 두번째 파라매터를 가져온다(행성 원소)
		StringTokenizer stringTokenizer;
		for (int i = 0; i < intInputPlanetSize; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());
			int z = Integer.parseInt(stringTokenizer.nextToken());
			planetList.add(new Planet(i, x, y, z));
		}
		// 전체 순회하면서 비용 종합

		// 완전 탐색하면 안되므로, 각 평면좌표별로 비용 구하여 가중치 적용
		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.getX() - p2.getX();
			}
		});
		for (int i = 0; i < intInputPlanetSize - 1; i++) {
			int cost = Math.abs(planetList.get(i).getX() - planetList.get(i + 1).getX());
			tunelList.add(new Tunel(planetList.get(i).getNumber(), planetList.get(i + 1).getNumber(), cost));
		}

		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.getY() - p2.getY();
			}
		});
		for (int i = 0; i < intInputPlanetSize - 1; i++) {
			int cost = Math.abs(planetList.get(i).getY() - planetList.get(i + 1).getY());
			tunelList.add(new Tunel(planetList.get(i).getNumber(), planetList.get(i + 1).getNumber(), cost));
		}

		Collections.sort(planetList, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p1.getZ() - p2.getZ();
			}
		});
		for (int i = 0; i < intInputPlanetSize - 1; i++) {
			int cost = Math.abs(planetList.get(i).getZ() - planetList.get(i + 1).getZ());
			tunelList.add(new Tunel(planetList.get(i).getNumber(), planetList.get(i + 1).getNumber(), cost));
		}

		// 평가할 행성 배열 생성
		parent = new int[intInputPlanetSize];
		for (int i = 0; i < intInputPlanetSize; i++) {
			parent[i] = i;
		}

		Collections.sort(tunelList);

		for (int i = 0; i < tunelList.size(); i++) {
			Tunel tunel = tunelList.get(i);

			// 다시 돌아오는 값은 선택 안함
			if (find(tunel.from) != find(tunel.to)) {
				returnValue += tunel.cost;
				union(tunel.from, tunel.to);
			}
		}
		System.out.println(returnValue);
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}

class Tunel implements Comparable<Tunel> {
	int from;
	int to;
	int cost;

	Tunel(int from, int to, int cost) {
		setFrom(from);
		setTo(to);
		setCost(cost);
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getFrom() {
		return this.from;
	}

	public int getTo() {
		return this.to;
	}

	public int getCost() {
		return this.cost;
	}

	@Override
	public int compareTo(Tunel o) {
		// TODO Auto-generated method stub
		return cost - o.cost;
	}

}

class Planet {
	private int number;
	private int x;
	private int y;
	private int z;

	Planet(int number, int x, int y, int z) {
		setNumber(number);
		setX(x);
		setY(y);
		setZ(z);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}