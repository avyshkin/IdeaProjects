import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class mergeHull {
    private static ArrayList<myPoint> list = new ArrayList<myPoint>();
    private int magicMergeConst = 3;
    private void merge(){

    }
    private static int findPlace(long x,int place){
        if (place < 0){
            return 0;
        }
        if (place == 0){
            if(x > list.get(place).getX()){
                return 1;
            }else{
                return 0;
            }
        }
        if (place == list.size() - 1){
            if(x > list.get(place).getX()){
                return place+1;
            }else{
                return findPlace(x,place/2);
            }
        }else{
            if (x > list.get(place -1).getX()){
                if(x< list.get(place).getX()){
                    return place;
                }else{
                    return findPlace(x,place+(list.size()-place)/2+1);
                }
            }else{
                return findPlace(x,place/2);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("points.in"));

        while (file.hasNext()){
            myPoint p =new myPoint(Long.parseLong(file.next()),Long.parseLong(file.next()));
            list.add(findPlace(p.getX(),list.size()-1),p);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).x+"+"+list.get(i).y);
        }
    }
}
