import java.util.*;

public class cmap{

    public static boolean allDigits(String s){
        for(int i =0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static String [] adrs(String address){
        String p[]= new String [3];

        if(address==null||address.length()==0){
            p=new String[0];
            return p;

        }
        int n_p=0;
        Scanner sc = new Scanner(address);
        while(sc.hasNext()){
            if(n_p>3){
                p=Arrays.copyOf(p,p.length+1);
            }
            p[n_p]=sc.next();
            n_p++;

        }
        if(n_p<3){
            p=Arrays.copyOf(p,n_p);
        }

        return p ;

    }
    public static boolean validAddress(String address){
        String p []= adrs(address);
        if(p.length!=3)return false;
        if(!(allDigits(p[0])||p[0].length()==2)){
            return false;
        }
        String sp= p[1].toLowerCase();
         if(!(sp.equals("1st")||
        sp.equals("2nd")||
        sp.equals("3rd")||
        sp.length()==3&&
        sp.charAt(1)=='t'&&
        sp.charAt(2)=='h'&&
        Character.isDigit(sp.charAt(0))&&
        sp.charAt(0)!='0')){
            return false;

        }
        String tp =p[2].toLowerCase();
        if(!(tp.equals("street")||tp.equals("avenue"))){
            return false;
        }


        return true;

    }
    public static int [] getCordinates(String address){
       int b []={-1,-1};
       String p []= adrs(address);
       if(p.length!=3){
        return b;
       }
       int fd= Character.getNumericValue(p[0].charAt(0));
       int sd= Character.getNumericValue(p[1].charAt(0));

       String sp= p[1].toLowerCase();
         if(!(sp.equals("1st")||
        sp.equals("2nd")||
        sp.equals("3rd")||
        sp.length()==3&&
        sp.charAt(1)=='t'&&
        sp.charAt(2)=='h'&&
        Character.isDigit(sp.charAt(0))&&
        sp.charAt(0)!='0')){
            return b;

        }

       if(p[2].toLowerCase().equals("street")){

        b[0]=fd;
        b[1]=sd;
        
       }else{
        
        b[0]=sd;
        b[1]=fd;
       }
       return b;
    }
    public static int distance(String from,String to){
        if(!(validAddress(from)||validAddress(to))){
            return -1;
        }
        int fb[]=getCordinates(from);
        int tb[]=getCordinates(to);
        int distance = Math.abs(fb[0]-tb[0])+Math.abs(fb[1]-tb[1]);
        return distance;
    }


    public static void main(String args[]){
      /*   String s ="1234";
        System.out.println(allDigits(s));
        String address= "34 4th street";
       System.out.println(validAddress(address));
       int arr[]=getCordinates(address);
       System.out.println(arr[0]);
       System.out.println(arr[1]);*/
    
      
       String address1 = "34 4th Street";
       String address2 = "51 7th Avenue";
       String address3 = "25 3rd Street";
       String address4 = "99 9th Avenue";
       System.err.println(distance(address1, address2));
       System.err.println(distance(address3, address4));
       


       
        
      


    }
}