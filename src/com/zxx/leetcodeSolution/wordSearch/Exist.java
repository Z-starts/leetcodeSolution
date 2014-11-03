/**
 *
 */
package com.zxx.leetcodeSolution.wordSearch;

/**
*----------Dragon be here!----------/
* 　　　┏┓　　　┏┓
* 　　┏┛┻━━━┛┻┓
* 　　┃　　　　　　　┃
* 　　┃　　　━　　　┃
* 　　┃　┳┛　┗┳　┃
* 　　┃　　　　　　　┃
* 　　┃　　　┻　　　┃
* 　　┃　　　　　　　┃
* 　　┗━┓　　　┏━┛
* 　　　　┃　　　┃神兽保佑
* 　　　　┃　　　┃代码无BUG！
* 　　　　┃　　　┗━━━┓
* 　　　　┃　　　　　　　┣┓
* 　　　　┃　　　　　　　┏┛
* 　　　　┗┓┓┏━┳┓┏┛
* 　　　　　┃┫┫　┃┫┫
* 　　　　　┗┻┛　┗┻┛
* ━━━━━━神兽出没━━━━━━
* @date 2014年11月3日
*/
public class Exist {
	/**
	 * Given a 2D board and a word, find if the word exists in the grid.
		The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
		The same letter cell may not be used more than once.
		For example,
		Given board =
		[
		  ["ABCE"],
		  ["SFCS"],
		  ["ADEE"]
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.
	 * @param board
	 * @param word
	 * @author https://oj.leetcode.com/discuss/14723/my-accepted-dfs-java-solution
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		int lenX = board.length;
		int lenY = board[0].length;
		boolean result = false;
		boolean[][] used = new boolean[lenX][lenY];

		for (int i = 0; i < lenX; i++) {
			for (int j = 0; j < lenY; j++) {
				if (board[i][j] == word.charAt(0)) {
					result = searchNext(board, used, 0, word, i, j);
					if (result == true) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @author https://oj.leetcode.com/discuss/14723/my-accepted-dfs-java-solution
	 * @param board
	 * @param used
	 * @param chAt
	 * @param word
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean searchNext(char[][] board, boolean[][] used, int chAt, String word, int x, int y) {
		if (chAt == word.length()) {
			return true;
		}
		if (y < 0 || x < 0 || y >= board[0].length || x >= board.length) {
			return false;
		}

		if (!used[x][y] && board[x][y] == word.charAt(chAt)) {
			used[x][y] = true;
			if (searchNext(board, used, chAt + 1, word, x, y - 1)) {
				return true;
			}
			if (searchNext(board, used, chAt + 1, word, x, y + 1)) {
				return true;
			}
			if (searchNext(board, used, chAt + 1, word, x - 1, y)) {
				return true;
			}
			if (searchNext(board, used, chAt + 1, word, x + 1, y)) {
				return true;
			}
			used[x][y] = false;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] b = new char[3][4];
		String[] testStr = new String[] { "ABCE", "SFCS", "ADEE" };
		for (int i = 0; i < testStr.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = testStr[i].charAt(j);
			}
		}

		Exist ex = new Exist();
		System.out.println("word = \"ABCCED\", -> returns " + ex.exist(b, "ABCCED"));
		System.out.println("word = \"SEE\", -> returns " + ex.exist(b, "SEE"));
		System.out.println("word = \"ABCB\", -> returns " + ex.exist(b, "ABCB"));
	}
}
