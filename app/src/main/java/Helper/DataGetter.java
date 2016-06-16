package Helper;

import java.util.ArrayList;

import Model.Answer;
import Model.Question;
import Model.QuestionLevel;

/**
 * Created by SONY on 5/20/2016.
 */
public class DataGetter {

    DatabaseHelper data;

   public DataGetter(DatabaseHelper databaseHelper)
   {
       data=databaseHelper;
       dsch=data.layCauHoi();
       dsda=data.layCauTL();
       questionClassify();
   }
    public ArrayList<Question> dsch = new ArrayList<Question>();//lay toan bo cau hoi
   public   ArrayList<Answer> dsda = new ArrayList<Answer>();// lay toan bo cau tra loi

   public ArrayList<QuestionLevel>mucDe= new ArrayList<QuestionLevel>();
   public ArrayList<QuestionLevel>mucTB= new ArrayList<QuestionLevel>();
   public ArrayList<QuestionLevel>mucKho= new ArrayList<QuestionLevel>();

    public ArrayList<Question>getQuestionList()
    {
        return dsch;
    }


    public ArrayList<Answer>getAnswerList()
    {
        return dsda;
    }

    public void questionClassify()
    {
        ArrayList<Question> dscauhoi=getQuestionList();
        ArrayList<Answer>dscautraloi=getAnswerList();

        int made,hoanvi;
        String cauhoi, cauA,cauB,cauC,cauD,cauTL;
        for (int i =0; i<dscauhoi.size();i++)
        {
            String tmp=dscauhoi.get(i).Muc.toString().trim();
            switch (tmp) {
                case "Dễ": {
                    cauhoi=dscauhoi.get(i).Cauhoi;
                    cauTL=dscauhoi.get(i).CauTL;
                    made=dscauhoi.get(i).Ma;
                    hoanvi=dscauhoi.get(i).Hoanvi;
                    cauA=dscautraloi.get(made-1).CauA;
                    cauB=dscautraloi.get(made-1).CauB;
                    cauC=dscautraloi.get(made-1).CauC;
                    cauD=dscautraloi.get(made-1).CauD;
                    QuestionLevel de= new QuestionLevel(made,cauhoi,cauTL,cauA,cauB,cauC,cauD,hoanvi);
                    mucDe.add(de);
                    break;
                }
                case "Khó":
                {
                    cauhoi=dscauhoi.get(i).Cauhoi;
                    cauTL=dscauhoi.get(i).CauTL;
                    made=dscauhoi.get(i).Ma;
                    hoanvi=dscauhoi.get(i).Hoanvi;
                    cauA=dscautraloi.get(made-1).CauA;
                    cauB=dscautraloi.get(made-1).CauB;
                    cauC=dscautraloi.get(made-1).CauC;
                    cauD=dscautraloi.get(made-1).CauD;
                    QuestionLevel kho= new QuestionLevel(made,cauhoi,cauTL,cauA,cauB,cauC,cauD,hoanvi);
                    mucKho.add(kho);
                    break;
                }

                case "Trung bình":
                {
                    cauhoi=dscauhoi.get(i).Cauhoi;
                    cauTL=dscauhoi.get(i).CauTL;
                    made=dscauhoi.get(i).Ma;
                    hoanvi=dscauhoi.get(i).Hoanvi;
                    cauA=dscautraloi.get(made-1).CauA;
                    cauB=dscautraloi.get(made-1).CauB;
                    cauC=dscautraloi.get(made-1).CauC;
                    cauD=dscautraloi.get(made-1).CauD;
                    QuestionLevel trungbinh= new QuestionLevel(made,cauhoi,cauTL,cauA,cauB,cauC,cauD,hoanvi);
                    mucTB.add(trungbinh);
                    break;
                }
            }
        }
    }




}
