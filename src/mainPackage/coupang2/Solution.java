package mainPackage.coupang2;

public class Solution {
	static int[][] boardArray;
	static boolean[][] visited;
	static int answer = 0;
	static int currentX = 0;
	static int currentY = 0;
	public static void main(String[] args) {
		int[][] board = {{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}};
		int answer = solutionTest(board);
		System.out.println(answer);

	}
	
	public static int solutionTest(int[][] board) {
		int maxAnswer = -1;
		boardArray = board;
		for(int i = 0; i< board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				visited = new boolean[4][4];
				answer = 0;
				dfs(i, j);
				if(answer > 0 && answer > maxAnswer) {
					maxAnswer = answer;
				}
				System.out.println();
			}
		}
		
		return maxAnswer;
	}
	static void dfs(int x, int y) {
		// 방문 처리
		visited[x][y] = true;
		// 방문 노드 출력
		System.out.print(boardArray[x][y] + "(" + x + ","+ y + ") -> ");
		// 방문한 노드에 인접한 동일 값의 노드 찾기
		for (int i = 0; i < boardArray.length; i++) {
			for(int j = 0; j < boardArray[i].length; j++) {
				if((Math.abs(x-i) + Math.abs(y-j)) <= 1
						&& boardArray[x][y] == boardArray[i][j]) {
					if(!visited[i][j]) {
						answer += 1;
						dfs(i, j);
					}
				}
			}
		}
	}
	
	
}