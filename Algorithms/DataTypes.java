import java.util.*;



class Solution{
    public static void main(String []argh)
    {



        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        long myNumber = 9223372036854775807L;


        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                //Complete the code
                if(x>= -32768 && x<=32767)
                System.out.println("* short");
                if(x>= -2147483648 &&  x<=2147483647)
                System.out.println("* int");
                if(x>=  -myNumber && x<= myNumber) 
                System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}



