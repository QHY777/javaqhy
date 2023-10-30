import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    static int ans; //瀛樺偍鏈�灏戦渶瑕佺殑閾佽建
    static SortedSet<Integer> solution = new TreeSet<Integer>(); //瀛樺偍鏈�浼樿В涓悇涓搧杞ㄧ殑浣嶇疆
    public static void solve(int n, int n_rail, SortedSet<Integer> position, int[] rails){
        /**
         * 鍥炴函娉曟眰瑙ｉ棶棰�
         * n: 闂瑙勬ā
         * n_rail锛氬綋鍓嶅凡鐢ㄩ搧杞�
         * position: 褰撳墠宸茬敤閾佽建鐨勪綅缃�
         * rails锛氶渶瑕侀摵璁剧殑鍚勭被閾佽建
         */
        if(n_rail >= ans) return; //鏃犳晥瑙�
        boolean flag = true; //鏍囪锛岀敤浜庡垽瀹氭槸鍚﹀凡缁忚�冭檻浜嗗叏閮ㄧ殑閾佽建
        for(int i=1;i<n;i++){
            if(rails[i]==0) continue; //濡傛灉璇ラ搧杞ㄨ窛绂昏�冭檻杩囦簡锛屽氨璺宠繃
            flag = false; //濡傛灉涓婇潰娌¤烦杩囷紝璇存槑杩樻病鑰冭檻褰撳墠杩欎釜璺濈锛� 鎵�浠ユ爣璁扮疆涓篺alse
            int cur =rails[i]; 
            for(int x : position){ //閬嶅巻宸茬粡瀹夋帓濂界殑閾佽建浣嶇疆
                if(position.contains(x+cur) || position.contains(x-cur)){ //濡傛灉cur鑳借涔嬪墠鐨勯搧杞ㄥ噾鍑烘潵锛� 閭ｅ氨涓嶉渶瑕侀噸澶嶆坊鍔�
                    rails[i] = 0; 
                    solve(n, n_rail, position, rails);
                    rails[i] = cur;
                    return;
                }
            }
        }

        if(flag){ //濡傛灉鎵惧埌涓�涓В锛岃褰曚竴涓�
            ans = n_rail;
//            System.out.println("!!!!!!!");
            solution.clear();
            solution.addAll(position);
            return;
        }

        for(int i=1;i<n;i++){ //绫讳技涓婇潰鐨勫惊鐜紝涓婇潰鐨勬槸鑰冭檻涓嶆斁缃紝鐢ㄤ互鍓嶇殑鍑戝嚭鏉ワ紝 杩欓噷鏄�冭檻鏀剧疆
            if(rails[i]==0) continue;
            int cur =rails[i];
            rails[i] = 0;
            Iterator iter = position.iterator();
//            while(iter.hasNext()){
//                int x = (int)iter.next();
//                iter.
//            }
            Object[] position_array = position.toArray();

            for(Object e : position_array){ //瀵规瘡涓摵濂界殑閾佽建锛� 灏濊瘯鏀惧湪鍏跺彸渚ф垨鑰呭叾宸︿晶锛岀户缁悳绱�
                int x = (Integer)e;
                position.add(x+cur);  //鍙充晶
                solve(n, n_rail + 1, position, rails);
                position.remove(x+cur);

                position.add(x-cur); //宸︿晶
                solve(n, n_rail+1, position, rails);
                position.remove(x-cur);
            }

            rails[i] = cur;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution.clear();
        int n = sc.nextInt();

        int[] rails = new int[10];

        solution.add(0);
        for(int i=0;i<n;i++){
            rails[i] = sc.nextInt();
            solution.add(rails[i]); //榛樿瑙�
        }

        SortedSet<Integer> position = new TreeSet<Integer>();
        position.add(0); //鏈�宸︿晶閾佽建
        position.add(rails[0]); //绗竴鏍归搧杞�
        rails[0] = 0;
        ans = n+1; //榛樿瑙�

        solve(n, 2, position, rails);
        System.out.print(ans);






    }
}
