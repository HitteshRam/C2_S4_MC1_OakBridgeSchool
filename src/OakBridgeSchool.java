public class OakBridgeSchool {

    public static void main(String[] args) {
        OakBridgeSchool obj1= new OakBridgeSchool();
        int len=6;

        int science[]= {50,60,75,98,65,86};
        int english[]= {85,56,70,91,68,80};
        int maths[]= {87,75,90,85,45,75};

        int [] totalMarks= new int[maths.length];
        totalMarks=obj1.calculateTotalMarks(maths, science, english );

        System.out.println("Maximum score" + obj1.findTopScore(totalMarks,len));
        System.out.println("Average Science score" + obj1.calculateAverageScienceMarks(science, len));
        System.out.println("Average English score" + obj1.calculateAverageEnglishMarks(english, len));
        System.out.println("Average Maths score" + obj1.calculateAverageMathsMarks(maths, len));
    }

    public int[] calculateTotalMarks(int [] math,int[] science,int[] social)
    {
        if(math.length==0 || science.length==0 || social.length==0 )
        {
            return null;
        }

        int[] totalMarks= new int[math.length];
        for(int i=0; i<math.length; i++)
            totalMarks[i]= math[i] + science[i] + social[i];

        return totalMarks;
    }

    public double calculateAverageScienceMarks(int[] science, int len)
    {
        double m=science.length;
        if (len==0)
            return 0;

        else
            return (science[len-1]/m) + calculateAverageScienceMarks(science,len-1);

    }

    public double calculateAverageMathsMarks(int[] maths, int len)
    {
        double m=maths.length;
        if (len==0)
            return 0;

        else
            return (maths[len-1]/m) + calculateAverageMathsMarks(maths,len-1);
    }

    public double calculateAverageEnglishMarks(int[] english, int len)
    {
        double m=english.length;
        if (len==0)
            return 0;

        else
            return (english[len-1]/m) + calculateAverageEnglishMarks(english,len-1);
    }

    public int findTopScore(int [] totalMarks, int len)
    {
        if (len<=0)
            return totalMarks[0];

        else if (totalMarks[len-1] > findTopScore(totalMarks, len - 1))
            return totalMarks[len-1];

        else return findTopScore(totalMarks, len - 1);
    }
}

