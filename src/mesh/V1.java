package mesh;


class Piece{
	
	private String word;
	private int x;
	private int y;
	
	public Piece(String word, int x, int y) {
		this.word = word;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Piece [word=" + word + ", x=" + x + ", y=" + y + "]";
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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
	
	
}

public class V1 {
	public static int solution(String word, String[] cards) {
		// TODO Auto-generated method stub
		
		final int LENGTH = cards.length;
		if(word.length() > LENGTH) {
			return 0;
		}
		
		int answer = -1;
		
		char[][] wordArray = new char[LENGTH][LENGTH];
		boolean[][] wordArraySelect = new boolean[LENGTH][LENGTH];
        
        for(int i = 0; i < LENGTH; i ++){
        	for(int j = 0; j < LENGTH; j++) {
        		wordArray[i][j] = cards[i].charAt(j);
        	}
        }
        for(int i = 0; i < LENGTH; i ++){
        	for(int j = 0; j < LENGTH; j++) {
        		System.out.print(wordArray[i][j] + "\t" );
        	}
        	System.out.println();
        }
        
        
        for(int i = 0; i < word.length(); i ++){
        	System.out.println("check : " + word.charAt(i));
        	for(int j = 0; j < LENGTH; j++) {
        		for(int k = 0; k < LENGTH; k++) {
        			if(wordArray[j][k] == word.charAt(i)) {
        				if(wordArraySelect[j][k] == false) {
        					if(check(wordArray[j][k],j,k)) {
        						
        					}
        				}
        				wordArraySelect[j][k] = true;
        			}else {
        				continue;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < LENGTH; i ++){
        	for(int j = 0; j < LENGTH; j++) {
        		System.out.print(wordArraySelect[i][j] + "\t");
        	}
        	System.out.println();
        }
		return answer;
	}
	public static boolean check(char word, int j, int k) {
		return true;
		
	}
}
