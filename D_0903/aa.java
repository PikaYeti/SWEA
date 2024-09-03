package SWEA.D_0903;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class aa
{

    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int highest;
    static int answer;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public static void dfs(int x, int y, int len, boolean cut){
        //최대 길이 갱신
        answer = Math.max(len,answer);
        //방문처리
        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isIn(nx,ny)&&!visited[nx][ny]){
                if(map[nx][ny]<map[x][y]){
                    //원래 갈 수 있는 길이면
                    dfs(nx,ny,len+1,cut); //가본다.
                }
                else{
                    if(!cut && map[nx][ny]-K<map[x][y]){
                        int tmp = map[nx][ny];
                        map[nx][ny] = map[x][y]-1;
                        dfs(nx,ny,len+1,true);
                        map[nx][ny] = tmp;
                    }
                }
            }
        }
        visited[x][y] = false;
    }

    public static boolean isIn(int x, int y){
        if(x<0||x>=N||y<0||y>=N) return false;
        return true;
    }

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T;
        T=Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            highest = Integer.MIN_VALUE;
            answer = Integer.MIN_VALUE;
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    highest = Math.max(highest,map[i][j]);
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==highest){
                        dfs(i,j,1,false);
                    }
                }
            }
            sb.append(answer).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    }
}
