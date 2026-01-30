package stepdefinitionpackage;

public class PyramidPattern
{
    public static void main(String[] args) {

        int n=7;

        for(int r=0;r<=n;r++)
        {
            for(int c=0; c<=n*2;c++)
            {
                if ((r+c)>=n && (c-r)<=n && (c+r)%2!=0)
                {


                    System.out.print(" *");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
