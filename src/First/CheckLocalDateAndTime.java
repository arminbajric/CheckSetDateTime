package First;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class CheckLocalDateAndTime {

	public static int getMonth(String month)
	{
		int MM = 0;
		switch(month)
		{
		case "Jan":
			MM=1;
			break;
		case "Feb":
			MM=2;
			break;
		case "Mar":
			MM=3;
			break;
		case "Apr":
			MM=4;
			break;
		case "May":
			MM=5;
		case "Jun":
			MM=6;
			break;
		case "Jul":
			MM=7;
			break;
		case "Aug":
			MM=8;
			break;
		case "Sep":
			MM=9;
			break;
		case "Oct":
			MM=10;
			break;
		case "Nov":
			MM=11;
			break;
		case "Dec":
			MM=12;
		}
		return MM;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   
    URL adresa=new URL("http://www.pool.ntp.org");
    URLConnection con=adresa.openConnection();
    long d=con.getDate();
    
    Date datum=new Date(d);
    char[] date=new char[35];
    String hours=datum.toString();
    date=hours.toCharArray();
    String hh=String.valueOf(date[11])+date[12];
    String mm=String.valueOf(date[14])+date[15];
    String ss=String.valueOf(date[17])+date[18];
    String yy=String.valueOf(date[25])+date[26]+date[27]+date[28];
    String MMString=String.valueOf(date[4])+date[5]+date[6];
    String dd=String.valueOf(date[8])+date[9];
    int MM=getMonth(MMString);
    String strDateToSet=dd+"-"+MM+"-"+yy;
    String strTimeToSet=hh+":"+mm+":"+ss;
    
    Runtime.getRuntime().exec("cmd /C date " + strDateToSet + "& time " + strTimeToSet);

    System.out.println(dd+"-"+MM+"-"+yy);
	}

}
