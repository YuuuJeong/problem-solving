

import java.io.*;
import java.util.*;



public class BOJ17143 {
	static class Fish{
		int r;
		int c;
		int speed;
		int direction;
		int size;
	}
	

	static int R;
	static int C;
	static int N;
	static int count = 0;
	static int time = 0;
	static int isEatenCount = 0;
	static Fish[] fishes;
	static int[][] fishesGrid;
	static boolean[] isEaten;

	static int[] changeDirection = {0, 2, 1, 4, 3};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		fishesGrid= new int[R+1][C+1];

		fishes = new Fish[N];
		isEaten = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			Fish f = new Fish();
			f.r = Integer.parseInt(st.nextToken());
			f.c = Integer.parseInt(st.nextToken());
			f.speed = Integer.parseInt(st.nextToken());
			f.direction = Integer.parseInt(st.nextToken());
			f.size = Integer.parseInt(st.nextToken()); 
			fishes[i] = f;
		}
		
		fishing();
		sb.append(count);
		System.out.println(sb.toString());
	}
	
	
	public static void fishing() {
		while(time <= C && isEatenCount < N) {
			time += 1;
			findNearFishAndEat();
			fishMove();
		}
	}
	
	public static void findNearFishAndEat() {
		int target = -1;
		int minR = Integer.MAX_VALUE;
		for(int i = 0 ; i < N; i++) {
			if(isEaten[i] == false && fishes[i].c == time) {
				if(fishes[i].r < minR) {
					target = i;
					minR = fishes[i].r;
				}
			}
		}
		
		if(target >= 0) {
			isEaten[target] = true;
			count += fishes[target].size;
			isEatenCount += 1;
		}
	}
	
	public static void fishMove() {
		
		for(int r = 1; r <= R; r++) 
			Arrays.fill(fishesGrid[r], -1);
		
		for(int i = 0 ; i < N ; i++) {
			if(isEaten[i] == false) {
				int speed = fishes[i].speed;
				int direction = fishes[i].direction;
				int curR = fishes[i].r;
				int curC = fishes[i].c;
				while(speed > 0) {
					direction = fishes[i].direction;
					if(direction == 1) {

						if(speed >= curR) {
							speed -= curR  - 1;
							curR = 1;
			 
						}else {
							curR -= speed;
							speed = 0;
						}
						

					}else if(direction == 3) {
						if(curC + speed > C) {
							speed -= C - curC;
							curC = C;

						} else {
							curC += speed;
							speed = 0;
						}

					} else if(direction == 2) {

						if(curR + speed > R) {
							speed -= R - curR;
							curR = R;
					
						} else {
							curR += speed;
							speed = 0;
						}
	
					}else {
						if(speed >= curC) {
							speed -= curC-1;
							curC = 1;
						}else {
							curC -= speed;
							speed = 0;
						}
					}
					
					if(speed > 0) {
						fishes[i].direction = changeDirection[direction];
					}
				}

				if(fishesGrid[curR][curC] != -1) {
					int index = fishesGrid[curR][curC];
					
					if(fishes[index].size < fishes[i].size) {
						isEaten[index] = true;
						fishesGrid[curR][curC] = i;
					}
					
					else isEaten[i] = true;

					
					isEatenCount++;
				}
				
				else fishesGrid[curR][curC] = i;
				fishes[i].r = curR;
				fishes[i].c = curC;
			}
		}
		

		}
		
}



